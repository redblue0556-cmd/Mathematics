package com.example.model

enum class ChapterId(
  val number: Int,
  val code: String,
  val title: String,
  val subtitle: String,
  val totalQuestions: Int = 20,
) {
  CHAPTER_1(
    number = 1,
    code = "CH.01",
    title = "Aljabar & Nilai Fungsi Dasar",
    subtitle = "Fungsi linear, kuadrat, nilai x, domain/range, toko buku & ojek online",
  ),
  CHAPTER_2(
    number = 2,
    code = "CH.02",
    title = "Operasi Aljabar Fungsi",
    subtitle = "Penjumlahan, pengurangan, perkalian & pembagian dua fungsi",
  ),
  CHAPTER_3(
    number = 3,
    code = "CH.03",
    title = "Fungsi Komposisi",
    subtitle = "Komposisi dua & tiga fungsi (f ∘ g)(x) serta nilai komposisi",
  ),
  CHAPTER_4(
    number = 4,
    code = "CH.04",
    title = "Fungsi Invers & Pecahan",
    subtitle = "Invers fungsi linear f⁻¹(x) dan fungsi pecahan rasional",
  ),
  CHAPTER_5(
    number = 5,
    code = "CH.05",
    title = "Geometri Lingkaran & Busur",
    subtitle = "Keliling roda, luas taman, sudut pizza, dan panjang busur lingkaran",
  ),
}

enum class CircleHighlightMode {
  ARC,
  CIRCUMFERENCE,
  AREA,
  SECTOR,
}

data class CircleDiagramSpec(
  val radiusValue: Double,
  val isDiameterGiven: Boolean = false,
  val centralAngleDeg: Double = 360.0,
  val unit: String = "cm",
  val highlightMode: CircleHighlightMode = CircleHighlightMode.ARC,
)

data class StepByStepExplanation(
  val diketahui: String,
  val rumusUtama: String,
  val langkahLangkah: List<String>,
  val tipsManga: String,
)

data class MathQuestion(
  val id: String,
  val chapter: ChapterId,
  val questionText: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: StepByStepExplanation,
  val circleDiagram: CircleDiagramSpec? = null,
  val isAiGenerated: Boolean = false,
)

data class UserProgress(
  val xp: Int = 0,
  val stars: Int = 0,
  val coins: Int = 0,
  val totalAnswered: Int = 0,
  val totalCorrect: Int = 0,
  val streak: Int = 0,
  val bestStreak: Int = 0,
  val solvedQuestionIds: Set<String> = emptySet(),
  val aiGeneratedSolvedCount: Int = 0,
) {
  val level: Int
    get() = (xp / 300) + 1

  val xpIntoLevel: Int
    get() = xp % 300

  val xpForNextLevel: Int
    get() = 300

  val rankCode: String
    get() =
      when {
        xp >= 7500 -> "S"
        xp >= 4500 -> "A"
        xp >= 2500 -> "B"
        xp >= 1200 -> "C"
        xp >= 500 -> "D"
        else -> "E"
      }

  val rankTitle: String
    get() =
      when (rankCode) {
        "S" -> "Rank S — Grandmaster Matematika"
        "A" -> "Rank A — Ahli Busur Lingkaran"
        "B" -> "Rank B — Master Invers"
        "C" -> "Rank C — Ksatria Komposisi"
        "D" -> "Rank D — Penjelajah Fungsi"
        else -> "Rank E — Novice Aljabar"
      }

  fun solvedCountForChapter(chapter: ChapterId): Int {
    val prefix = "ch${chapter.number}_"
    return solvedQuestionIds.count { it.startsWith(prefix) }
  }
}
