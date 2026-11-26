package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.model.UserProgress
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.mathMasterDataStore: DataStore<Preferences> by
  preferencesDataStore(name = "mathmaster_manga_prefs")

class UserProgressRepository(private val context: Context) {
  private object Keys {
    val XP = intPreferencesKey("xp")
    val STARS = intPreferencesKey("stars")
    val COINS = intPreferencesKey("coins")
    val TOTAL_ANSWERED = intPreferencesKey("total_answered")
    val TOTAL_CORRECT = intPreferencesKey("total_correct")
    val STREAK = intPreferencesKey("streak")
    val BEST_STREAK = intPreferencesKey("best_streak")
    val SOLVED_IDS = stringSetPreferencesKey("solved_question_ids")
    val AI_SOLVED_COUNT = intPreferencesKey("ai_solved_count")
  }

  val progressFlow: Flow<UserProgress> =
    context.mathMasterDataStore.data.map { prefs ->
      UserProgress(
        xp = prefs[Keys.XP] ?: 0,
        stars = prefs[Keys.STARS] ?: 0,
        coins = prefs[Keys.COINS] ?: 0,
        totalAnswered = prefs[Keys.TOTAL_ANSWERED] ?: 0,
        totalCorrect = prefs[Keys.TOTAL_CORRECT] ?: 0,
        streak = prefs[Keys.STREAK] ?: 0,
        bestStreak = prefs[Keys.BEST_STREAK] ?: 0,
        solvedQuestionIds = prefs[Keys.SOLVED_IDS] ?: emptySet(),
        aiGeneratedSolvedCount = prefs[Keys.AI_SOLVED_COUNT] ?: 0,
      )
    }

  suspend fun recordAnswer(questionId: String, isCorrect: Boolean, isAiGenerated: Boolean) {
    context.mathMasterDataStore.edit { prefs ->
      val currentXp = prefs[Keys.XP] ?: 0
      val currentStars = prefs[Keys.STARS] ?: 0
      val currentCoins = prefs[Keys.COINS] ?: 0
      val currentAnswered = prefs[Keys.TOTAL_ANSWERED] ?: 0
      val currentCorrect = prefs[Keys.TOTAL_CORRECT] ?: 0
      val currentStreak = prefs[Keys.STREAK] ?: 0
      val currentBestStreak = prefs[Keys.BEST_STREAK] ?: 0
      val currentSolved = prefs[Keys.SOLVED_IDS] ?: emptySet()
      val currentAiSolved = prefs[Keys.AI_SOLVED_COUNT] ?: 0

      prefs[Keys.TOTAL_ANSWERED] = currentAnswered + 1

      if (isCorrect) {
        val nextStreak = currentStreak + 1
        val alreadySolved = questionId in currentSolved
        prefs[Keys.XP] = currentXp + 100
        prefs[Keys.COINS] = currentCoins + if (alreadySolved) 15 else 30
        prefs[Keys.STARS] = currentStars + if (alreadySolved) 0 else 1
        prefs[Keys.TOTAL_CORRECT] = currentCorrect + 1
        prefs[Keys.STREAK] = nextStreak
        if (nextStreak > currentBestStreak) {
          prefs[Keys.BEST_STREAK] = nextStreak
        }
        if (isAiGenerated) {
          prefs[Keys.AI_SOLVED_COUNT] = currentAiSolved + 1
        } else {
          prefs[Keys.SOLVED_IDS] = currentSolved + questionId
        }
      } else {
        prefs[Keys.STREAK] = 0
        prefs[Keys.XP] = currentXp + 10 // effort XP for reviewing step-by-step
      }
    }
  }

  suspend fun resetProgress() {
    context.mathMasterDataStore.edit { it.clear() }
  }
}
