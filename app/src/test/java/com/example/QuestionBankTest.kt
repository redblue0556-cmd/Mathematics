package com.example

import com.example.data.CuratedQuestionBank
import com.example.data.OfflineAiQuestionGenerator
import com.example.model.ChapterId
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class QuestionBankTest {
  @Test
  fun curatedBankHasExactly100QuestionsWith20PerChapter() {
    assertEquals(100, CuratedQuestionBank.allQuestions.size)
    val uniqueIds = CuratedQuestionBank.allQuestions.map { it.id }.toSet()
    assertEquals(100, uniqueIds.size)

    ChapterId.entries.forEach { chapter ->
      val chapterQuestions = CuratedQuestionBank.questionsForChapter(chapter)
      assertEquals(20, chapterQuestions.size)
      chapterQuestions.forEach { q ->
        assertEquals(5, q.options.size)
        assertTrue(q.correctIndex in 0..4)
        assertEquals(5, q.options.toSet().size)
        assertTrue(q.explanation.langkahLangkah.isNotEmpty())
      }
    }
  }

  @Test
  fun offlineAiGeneratorProducesValidUniqueOptionsAcrossAllChapters() {
    ChapterId.entries.forEach { chapter ->
      repeat(10) {
        val q = OfflineAiQuestionGenerator.generateQuestion(chapter)
        assertEquals(chapter, q.chapter)
        assertTrue(q.isAiGenerated)
        assertEquals(5, q.options.size)
        assertEquals(5, q.options.toSet().size)
        assertTrue(q.correctIndex in 0..4)
        assertTrue(q.explanation.langkahLangkah.isNotEmpty())
      }
    }
  }
}
