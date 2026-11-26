package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CuratedQuestionBank
import com.example.data.OfflineAiQuestionGenerator
import com.example.data.UserProgressRepository
import com.example.model.ChapterId
import com.example.model.MathQuestion
import com.example.model.UserProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class QuizSessionState(
  val isAiMode: Boolean = false,
  val activeChapter: ChapterId? = null,
  val questions: List<MathQuestion> = emptyList(),
  val currentIndex: Int = 0,
  val selectedOptionIndex: Int? = null,
  val sessionCorrect: Int = 0,
  val sessionAnswered: Int = 0,
  val isSessionCompleted: Boolean = false,
  val aiFilterChapter: ChapterId? = null,
) {
  val currentQuestion: MathQuestion?
    get() = questions.getOrNull(currentIndex)

  val isAnswered: Boolean
    get() = selectedOptionIndex != null

  val isCorrect: Boolean
    get() =
      selectedOptionIndex != null &&
        currentQuestion != null &&
        selectedOptionIndex == currentQuestion?.correctIndex
}

data class FormulaLabState(
  val radiusCm: Float = 14f,
  val angleDeg: Float = 90f,
  val usePiFraction: Boolean = true,
  val useDiameterInput: Boolean = false,
  val isQuadraticFn: Boolean = false,
  val coeffA: Int = 3,
  val coeffB: Int = 5,
  val coeffC: Int = 1,
  val inputX: Int = 4,
)

class MathMasterViewModel(application: Application) : AndroidViewModel(application) {
  private val progressRepository = UserProgressRepository(application.applicationContext)

  val userProgress: StateFlow<UserProgress> =
    progressRepository.progressFlow.stateIn(
      scope = viewModelScope,
      started = SharingStarted.WhileSubscribed(5_000),
      initialValue = UserProgress(),
    )

  private val _quizState = MutableStateFlow(QuizSessionState())
  val quizState: StateFlow<QuizSessionState> = _quizState.asStateFlow()

  private val _formulaLabState = MutableStateFlow(FormulaLabState())
  val formulaLabState: StateFlow<FormulaLabState> = _formulaLabState.asStateFlow()

  fun startChapterQuiz(chapter: ChapterId) {
    val questions = CuratedQuestionBank.questionsForChapter(chapter)
    _quizState.value =
      QuizSessionState(
        isAiMode = false,
        activeChapter = chapter,
        questions = questions,
        currentIndex = 0,
        selectedOptionIndex = null,
        sessionCorrect = 0,
        sessionAnswered = 0,
        isSessionCompleted = false,
      )
  }

  fun startAiGenerator(filterChapter: ChapterId? = null) {
    val generated = OfflineAiQuestionGenerator.generateQuestion(filterChapter)
    _quizState.value =
      QuizSessionState(
        isAiMode = true,
        activeChapter = filterChapter,
        aiFilterChapter = filterChapter,
        questions = listOf(generated),
        currentIndex = 0,
        selectedOptionIndex = null,
        sessionCorrect = 0,
        sessionAnswered = 0,
        isSessionCompleted = false,
      )
  }

  fun setAiFilterChapter(filterChapter: ChapterId?) {
    val generated = OfflineAiQuestionGenerator.generateQuestion(filterChapter)
    _quizState.update { state ->
      state.copy(
        activeChapter = filterChapter,
        aiFilterChapter = filterChapter,
        questions = state.questions + generated,
        currentIndex = state.questions.size,
        selectedOptionIndex = null,
      )
    }
  }

  fun generateNextAiQuestion() {
    val current = _quizState.value
    val nextQ = OfflineAiQuestionGenerator.generateQuestion(current.aiFilterChapter)
    _quizState.update { state ->
      state.copy(
        questions = state.questions + nextQ,
        currentIndex = state.questions.size,
        selectedOptionIndex = null,
      )
    }
  }

  fun selectOption(optionIndex: Int) {
    val state = _quizState.value
    val question = state.currentQuestion ?: return
    if (state.selectedOptionIndex != null) return

    val correct = optionIndex == question.correctIndex
    _quizState.update {
      it.copy(
        selectedOptionIndex = optionIndex,
        sessionAnswered = it.sessionAnswered + 1,
        sessionCorrect = it.sessionCorrect + if (correct) 1 else 0,
      )
    }

    viewModelScope.launch {
      progressRepository.recordAnswer(
        questionId = question.id,
        isCorrect = correct,
        isAiGenerated = question.isAiGenerated,
      )
    }
  }

  fun nextQuestion() {
    val state = _quizState.value
    if (state.isAiMode) {
      generateNextAiQuestion()
    } else if (state.currentIndex + 1 < state.questions.size) {
      _quizState.update {
        it.copy(currentIndex = it.currentIndex + 1, selectedOptionIndex = null)
      }
    } else {
      _quizState.update { it.copy(isSessionCompleted = true) }
    }
  }

  fun updateLabRadius(radius: Float) {
    _formulaLabState.update { it.copy(radiusCm = radius.coerceIn(7f, 70f)) }
  }

  fun updateLabAngle(angle: Float) {
    _formulaLabState.update { it.copy(angleDeg = angle.coerceIn(15f, 360f)) }
  }

  fun toggleLabPiMode(useFraction: Boolean) {
    _formulaLabState.update { it.copy(usePiFraction = useFraction) }
  }

  fun toggleLabDiameterMode(useDiameter: Boolean) {
    _formulaLabState.update { it.copy(useDiameterInput = useDiameter) }
  }

  fun updateFunctionLab(
    isQuadratic: Boolean = _formulaLabState.value.isQuadraticFn,
    a: Int = _formulaLabState.value.coeffA,
    b: Int = _formulaLabState.value.coeffB,
    c: Int = _formulaLabState.value.coeffC,
    x: Int = _formulaLabState.value.inputX,
  ) {
    _formulaLabState.update {
      it.copy(
        isQuadraticFn = isQuadratic,
        coeffA = a.coerceIn(-9, 9),
        coeffB = b.coerceIn(-15, 15),
        coeffC = c.coerceIn(-15, 15),
        inputX = x.coerceIn(-10, 10),
      )
    }
  }

  fun resetAllProgress() {
    viewModelScope.launch { progressRepository.resetProgress() }
  }
}
