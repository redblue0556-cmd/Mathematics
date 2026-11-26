package com.example.data

import com.example.model.ChapterId
import com.example.model.MathQuestion

object CuratedQuestionBank {
  val allQuestions: List<MathQuestion> by lazy {
    Chapter1Questions.questions +
      Chapter2Questions.questions +
      Chapter3Questions.questions +
      Chapter4Questions.questions +
      Chapter5Questions.questions
  }

  fun questionsForChapter(chapter: ChapterId): List<MathQuestion> =
    when (chapter) {
      ChapterId.CHAPTER_1 -> Chapter1Questions.questions
      ChapterId.CHAPTER_2 -> Chapter2Questions.questions
      ChapterId.CHAPTER_3 -> Chapter3Questions.questions
      ChapterId.CHAPTER_4 -> Chapter4Questions.questions
      ChapterId.CHAPTER_5 -> Chapter5Questions.questions
    }
}
