package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui.MathMasterViewModel
import com.example.ui.screens.CoverLoadingScreen
import com.example.ui.screens.FormulaLabScreen
import com.example.ui.screens.MangaLobbyScreen
import com.example.ui.screens.QuizArenaScreen
import com.example.ui.theme.MathMasterTheme

private object AppRoutes {
  const val COVER = "cover"
  const val LOBBY = "lobby"
  const val QUIZ = "quiz"
  const val LAB = "lab"
}

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MathMasterTheme {
        val navController = rememberNavController()
        val viewModel: MathMasterViewModel = viewModel()
        val userProgress by viewModel.userProgress.collectAsStateWithLifecycle()
        val quizState by viewModel.quizState.collectAsStateWithLifecycle()
        val formulaLabState by viewModel.formulaLabState.collectAsStateWithLifecycle()

        NavHost(
          navController = navController,
          startDestination = AppRoutes.COVER,
        ) {
          composable(AppRoutes.COVER) {
            CoverLoadingScreen(
              onStartClick = {
                navController.navigate(AppRoutes.LOBBY) {
                  popUpTo(AppRoutes.COVER) { inclusive = true }
                }
              }
            )
          }

          composable(AppRoutes.LOBBY) {
            MangaLobbyScreen(
              progress = userProgress,
              onSelectChapter = { chapter ->
                viewModel.startChapterQuiz(chapter)
                navController.navigate(AppRoutes.QUIZ)
              },
              onOpenAiGenerator = {
                viewModel.startAiGenerator(null)
                navController.navigate(AppRoutes.QUIZ)
              },
              onOpenFormulaLab = { navController.navigate(AppRoutes.LAB) },
              onResetProgress = { viewModel.resetAllProgress() },
            )
          }

          composable(AppRoutes.QUIZ) {
            QuizArenaScreen(
              quizState = quizState,
              userProgress = userProgress,
              onSelectOption = { idx -> viewModel.selectOption(idx) },
              onNextQuestion = { viewModel.nextQuestion() },
              onGenerateNewAiQuestion = { viewModel.generateNextAiQuestion() },
              onChangeAiFilter = { chapter -> viewModel.setAiFilterChapter(chapter) },
              onReplayChapter = {
                quizState.activeChapter?.let { viewModel.startChapterQuiz(it) }
              },
              onBackToLobby = {
                navController.popBackStack(AppRoutes.LOBBY, inclusive = false)
              },
            )
          }

          composable(AppRoutes.LAB) {
            FormulaLabScreen(
              labState = formulaLabState,
              onRadiusChange = { viewModel.updateLabRadius(it) },
              onAngleChange = { viewModel.updateLabAngle(it) },
              onTogglePiFraction = { viewModel.toggleLabPiMode(it) },
              onUpdateFunctionLab = { isQuad, a, b, c, x ->
                viewModel.updateFunctionLab(isQuad, a, b, c, x)
              },
              onBackToLobby = {
                navController.popBackStack(AppRoutes.LOBBY, inclusive = false)
              },
            )
          }
        }
      }
    }
  }
}
