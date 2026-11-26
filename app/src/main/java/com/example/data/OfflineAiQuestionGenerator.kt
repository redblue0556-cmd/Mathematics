package com.example.data

import com.example.model.ChapterId
import com.example.model.CircleDiagramSpec
import com.example.model.CircleHighlightMode
import com.example.model.MathQuestion
import com.example.model.StepByStepExplanation
import java.text.NumberFormat
import java.util.Locale
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

object OfflineAiQuestionGenerator {
  private val counter = AtomicInteger(1)
  private val idrFormat: NumberFormat = NumberFormat.getIntegerInstance(Locale("id", "ID"))

  fun generateQuestion(targetChapter: ChapterId? = null): MathQuestion {
    val chapter = targetChapter ?: ChapterId.entries.random()
    val seq = counter.getAndIncrement()
    val id = "ai_ch${chapter.number}_$seq"

    return when (chapter) {
      ChapterId.CHAPTER_1 -> generateChapter1(id)
      ChapterId.CHAPTER_2 -> generateChapter2(id)
      ChapterId.CHAPTER_3 -> generateChapter3(id)
      ChapterId.CHAPTER_4 -> generateChapter4(id)
      ChapterId.CHAPTER_5 -> generateChapter5(id)
    }
  }

  private fun generateChapter1(id: String): MathQuestion {
    return when (Random.nextInt(3)) {
      0 -> {
        val scenarios =
          listOf(
            Triple("ojek online", "tarif awal", "per kilometer"),
            Triple("kurir kilat", "biaya dasar", "per km jarak"),
            Triple("rental komik manga", "biaya member", "per volume"),
          )
        val (brand, baseLabel, rateLabel) = scenarios.random()
        val baseFee = listOf(4000, 5000, 6000, 7000, 8000, 10000).random()
        val perUnit = listOf(2000, 2500, 3000, 3500, 4000).random()
        val x = (4..12).random()
        val ans = perUnit * x + baseFee
        val distractors =
          listOf(
            baseFee * x + perUnit,
            (perUnit + baseFee) * x,
            perUnit * (x - 1) + baseFee,
            perUnit * (x + 1) + baseFee,
          )
        val (opts, idx) = buildUniqueOptions(ans, distractors) { "Rp${idrFormat.format(it)}" }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_1,
          questionText =
            "Layanan $brand menetapkan $baseLabel Rp${idrFormat.format(baseFee)} dan tambahan Rp${idrFormat.format(perUnit)} $rateLabel. Jika pemakaian/jarak adalah x = $x, total biayanya adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "Biaya tetap = Rp${idrFormat.format(baseFee)}\nTarif variabel = Rp${idrFormat.format(perUnit)}/unit\nx = $x",
              rumusUtama = "f(x) = ${idrFormat.format(perUnit)}x + ${idrFormat.format(baseFee)}",
              langkahLangkah =
                listOf(
                  "Step 1: Susun model fungsi linear f(x) = ${idrFormat.format(perUnit)}x + ${idrFormat.format(baseFee)}.",
                  "Step 2: Substitusi x = $x → ${idrFormat.format(perUnit)} × $x = Rp${idrFormat.format(perUnit * x)}.",
                  "Step 3: Tambahkan biaya tetap → Rp${idrFormat.format(perUnit * x)} + Rp${idrFormat.format(baseFee)} = Rp${idrFormat.format(ans)}.",
                ),
              tipsManga = "Kalikan tarif variabel dengan x lebih dulu sebelum menjumlahkan biaya tetap!",
            ),
        )
      }
      1 -> {
        val a = (2..4).random()
        val b = (1..6).random()
        val c = (1..9).random()
        val x = (2..5).random()
        val ans = a * x * x - b * x + c
        val distractors =
          listOf(
            a * x - b * x + c,
            a * x * x + b * x + c,
            (a * x) * (a * x) - b * x + c,
            ans + 4,
          )
        val (opts, idx) = buildUniqueOptions(ans, distractors) { it.toString() }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_1,
          questionText = "Diketahui fungsi kuadrat f(x) = ${a}x² - ${b}x + $c. Nilai f($x) adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "f(x) = ${a}x² - ${b}x + $c\nx = $x",
              rumusUtama = "f($x) = $a($x)² - $b($x) + $c",
              langkahLangkah =
                listOf(
                  "Step 1: Kuadratkan x dan kali koefisien: $a × ${x * x} = ${a * x * x}.",
                  "Step 2: Hitung suku tengah: $b × $x = ${b * x}.",
                  "Step 3: Gabungkan: ${a * x * x} - ${b * x} + $c = $ans.",
                ),
              tipsManga = "Selalu hitung pangkat ($x)² sebelum mengalikannya dengan koefisien $a.",
            ),
        )
      }
      else -> {
        val a = (2..6).random()
        val b = (2..12).random()
        val m = (3..11).random()
        val target = a * m - b
        val distractors = listOf(m - 2, m - 1, m + 1, m + 2)
        val (opts, idx) = buildUniqueOptions(m, distractors) { it.toString() }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_1,
          questionText = "Diketahui f(x) = ${a}x - $b. Jika f(a) = $target, maka nilai a adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "f(x) = ${a}x - $b\nf(a) = $target",
              rumusUtama = "${a}a - $b = $target",
              langkahLangkah =
                listOf(
                  "Step 1: Substitusi x = a → ${a}a - $b = $target.",
                  "Step 2: Pindahkan -$b ke kanan → ${a}a = $target + $b = ${target + b}.",
                  "Step 3: Bagi dengan $a → a = [[frac:${target + b}|$a]] = $m.",
                ),
              tipsManga = "Perhatikan perubahan tanda dari minus menjadi plus saat pindah ruas!",
            ),
        )
      }
    }
  }

  private fun generateChapter2(id: String): MathQuestion {
    val a1 = (2..5).random()
    val b1 = (1..8).random()
    val a2 = (1..4).random()
    val b2 = (1..7).random()
    val x = (2..6).random()
    val fx = a1 * x + b1
    val gx = a2 * x - b2
    return when (Random.nextInt(2)) {
      0 -> {
        val isAdd = Random.nextBoolean()
        val opSym = if (isAdd) "+" else "-"
        val ans = if (isAdd) fx + gx else fx - gx
        val distractors = listOf(fx + gx + 2, fx - gx - 3, ans + 4, ans - 2)
        val (opts, idx) = buildUniqueOptions(ans, distractors) { it.toString() }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_2,
          questionText =
            "Diketahui f(x) = ${a1}x + $b1 dan g(x) = ${a2}x - $b2. Nilai dari (f $opSym g)($x) adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "f(x) = ${a1}x + $b1\ng(x) = ${a2}x - $b2\nx = $x",
              rumusUtama = "(f $opSym g)($x) = f($x) $opSym g($x)",
              langkahLangkah =
                listOf(
                  "Step 1: Hitung f($x) = $a1($x) + $b1 = $fx.",
                  "Step 2: Hitung g($x) = $a2($x) - $b2 = $gx.",
                  "Step 3: Hitung $fx $opSym ($gx) = $ans.",
                ),
              tipsManga = "Menghitung f($x) dan g($x) secara terpisah mencegah kesalahan tanda kurung.",
            ),
        )
      }
      else -> {
        val ans = fx * gx
        val distractors = listOf(ans + fx, ans - gx, fx + gx, ans + 5)
        val (opts, idx) = buildUniqueOptions(ans, distractors) { it.toString() }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_2,
          questionText =
            "Diketahui f(x) = ${a1}x + $b1 dan g(x) = ${a2}x - $b2. Nilai dari (f · g)($x) adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "f(x) = ${a1}x + $b1\ng(x) = ${a2}x - $b2\nx = $x",
              rumusUtama = "(f · g)($x) = f($x) × g($x)",
              langkahLangkah =
                listOf(
                  "Step 1: Hitung f($x) = $a1($x) + $b1 = $fx.",
                  "Step 2: Hitung g($x) = $a2($x) - $b2 = $gx.",
                  "Step 3: Kalikan kedua hasil: $fx × ($gx) = $ans.",
                ),
              tipsManga = "Jika x berupa angka, kalikan langsung hasil angkanya tanpa menjabarkan aljabar!",
            ),
        )
      }
    }
  }

  private fun generateChapter3(id: String): MathQuestion {
    return when (Random.nextInt(2)) {
      0 -> {
        val a = (2..5).random()
        val b = (1..7).random()
        val c = (2..4).random()
        val d = (1..5).random()
        val x = (2..6).random()
        val gx = c * x - d
        val ans = a * gx + b
        val fxFirst = a * x + b
        val reverseAns = c * fxFirst - d
        val distractors = listOf(reverseAns, ans + 3, ans - 2, ans + a)
        val (opts, idx) = buildUniqueOptions(ans, distractors) { it.toString() }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_3,
          questionText =
            "Diketahui fungsi f(x) = ${a}x + $b dan g(x) = ${c}x - $d. Nilai dari (f ∘ g)($x) adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "f(x) = ${a}x + $b\ng(x) = ${c}x - $d\nx = $x",
              rumusUtama = "(f ∘ g)($x) = f(g($x))",
              langkahLangkah =
                listOf(
                  "Step 1: Kerjakan fungsi kanan dulu: g($x) = $c($x) - $d = $gx.",
                  "Step 2: Masukkan hasil $gx ke dalam f: f($gx) = $a($gx) + $b.",
                  "Step 3: Hitung ${a * gx} + $b = $ans.",
                ),
              tipsManga = "Ingat selalu: kerjakan dari huruf yang PALING KANAN (g terlebih dahulu)!",
            ),
        )
      }
      else -> {
        val a = (2..4).random()
        val b = (1..5).random()
        val c = (1..6).random()
        val x = (2..5).random()
        val hx = x + c
        val gx = 2 * hx
        val ans = a * gx - b
        val distractors = listOf(ans + 2, ans - 4, ans + 6, a * hx - b)
        val (opts, idx) = buildUniqueOptions(ans, distractors) { it.toString() }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_3,
          questionText =
            "Diketahui f(x) = ${a}x - $b, g(x) = 2x, dan h(x) = x + $c. Nilai dari (f ∘ g ∘ h)($x) adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "f(x) = ${a}x - $b, g(x) = 2x, h(x) = x + $c\nx = $x",
              rumusUtama = "(f ∘ g ∘ h)($x) = f(g(h($x)))",
              langkahLangkah =
                listOf(
                  "Step 1: Hitung h($x) = $x + $c = $hx.",
                  "Step 2: Hitung g($hx) = 2 × $hx = $gx.",
                  "Step 3: Hitung f($gx) = $a($gx) - $b = ${a * gx} - $b = $ans.",
                ),
              tipsManga = "Komposisi 3 fungsi dikerjakan berantai h → g → f!",
            ),
        )
      }
    }
  }

  private fun generateChapter4(id: String): MathQuestion {
    return when (Random.nextInt(2)) {
      0 -> {
        val a = (2..6).random()
        val b = (1..9).random()
        val m = (2..10).random()
        val yVal = a * m + b
        val distractors = listOf(m - 1, m + 1, m + 2, yVal - b)
        val (opts, idx) = buildUniqueOptions(m, distractors) { it.toString() }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_4,
          questionText =
            "Diketahui fungsi f(x) = ${a}x + $b. Nilai dari f⁻¹($yVal) adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "f(x) = ${a}x + $b\nDicari f⁻¹($yVal)",
              rumusUtama = "f⁻¹(x) = [[frac:x - $b|$a]]",
              langkahLangkah =
                listOf(
                  "Step 1: Gunakan hubungan f(m) = $yVal → ${a}m + $b = $yVal.",
                  "Step 2: Kurangkan $b → ${a}m = ${yVal - b}.",
                  "Step 3: Bagi dengan $a → m = [[frac:${yVal - b}|$a]] = $m.",
                ),
              tipsManga = "f⁻¹($yVal) berarti mencari masukan x yang menghasilkan $yVal.",
            ),
        )
      }
      else -> {
        var a = (2..6).random()
        val b = (1..7).random()
        val d = (2..8).random()
        if (a == d) a += 1
        val correctStr = "[[frac:${d}x + $b|x - $a]]"
        val optSet =
          linkedSetOf(
            correctStr,
            "[[frac:${d}x - $b|x - $a]]",
            "[[frac:${d}x + $b|x + $a]]",
            "[[frac:-${d}x + $b|x - $a]]",
            "[[frac:${a}x + $b|x + $d]]",
          )
        val optionsList = optSet.toList().shuffled()
        val idx = optionsList.indexOf(correctStr)
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_4,
          questionText =
            "Diketahui fungsi rasional f(x) = [[frac:${a}x + $b|x - $d]] untuk x ≠ $d. Invers fungsi f⁻¹(x) adalah...",
          options = optionsList,
          correctIndex = idx,
          isAiGenerated = true,
          explanation =
            StepByStepExplanation(
              diketahui = "f(x) = [[frac:${a}x + $b|1x - $d]] → a = $a, b = $b, c = 1, d = -$d",
              rumusUtama = "f⁻¹(x) = [[frac:-dx + b|cx - a]]",
              langkahLangkah =
                listOf(
                  "Step 1: Tukar posisi a = $a dan d = -$d sambil membalik tandanya.",
                  "Step 2: -d menjadi +$d di depan x pembilang; -a menjadi -$a di penyebut.",
                  "Step 3: Diperoleh f⁻¹(x) = [[frac:${d}x + $b|x - $a]] (x ≠ $a).",
                ),
              tipsManga = "Tukar diagonal utama (a dan d) + ganti tanda, sedangkan b dan c tetap!",
            ),
        )
      }
    }
  }

  private fun generateChapter5(id: String): MathQuestion {
    data class ArcCase(val angle: Int, val radius: Int, val ans: Int, val fracNum: Int, val fracDen: Int)

    return when (Random.nextInt(3)) {
      0 -> {
        val cases =
          listOf(
            ArcCase(45, 14, 11, 1, 8),
            ArcCase(45, 28, 22, 1, 8),
            ArcCase(60, 21, 22, 1, 6),
            ArcCase(60, 42, 44, 1, 6),
            ArcCase(90, 7, 11, 1, 4),
            ArcCase(90, 14, 22, 1, 4),
            ArcCase(90, 21, 33, 1, 4),
            ArcCase(90, 28, 44, 1, 4),
            ArcCase(120, 21, 44, 1, 3),
            ArcCase(120, 42, 88, 1, 3),
            ArcCase(72, 35, 44, 1, 5),
            ArcCase(180, 14, 44, 1, 2),
            ArcCase(270, 14, 66, 3, 4),
          )
        val c = cases.random()
        val rDiv7 = c.radius / 7
        val fullCirc = 2 * 22 * rDiv7
        val distractors = listOf(c.ans / 2 + 7, c.ans + 11, c.ans * 2, fullCirc)
        val (opts, idx) = buildUniqueOptions(c.ans, distractors) { "$it cm" }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_5,
          questionText =
            "Sebuah lingkaran berjari-jari ${c.radius} cm memiliki sudut pusat α = ${c.angle}°. Panjang busur lingkaran tersebut adalah... (π = [[frac:22|7]])",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          circleDiagram =
            CircleDiagramSpec(
              radiusValue = c.radius.toDouble(),
              isDiameterGiven = false,
              centralAngleDeg = c.angle.toDouble(),
              unit = "cm",
              highlightMode = CircleHighlightMode.ARC,
            ),
          explanation =
            StepByStepExplanation(
              diketahui = "α = ${c.angle}°\nr = ${c.radius} cm\nπ = [[frac:22|7]]",
              rumusUtama = "Panjang Busur = [[frac:α|360°]] × 2 × π × r",
              langkahLangkah =
                listOf(
                  "Step 1: Masukkan nilai: [[frac:${c.angle}°|360°]] × 2 × [[frac:22|7]] × ${c.radius}.",
                  "Step 2: Coret sudut [[frac:${c.angle}°|360°]] = [[frac:${c.fracNum}|${c.fracDen}]] dan coret jari-jari [[frac:${c.radius}|7]] = $rDiv7.",
                  "Step 3: Hitung [[frac:${c.fracNum}|${c.fracDen}]] × 2 × 22 × $rDiv7 = [[frac:${c.fracNum}|${c.fracDen}]] × $fullCirc = ${c.ans} cm.",
                ),
              tipsManga = "Selalu sederhanakan pecahan sudut dan coret jari-jari dengan 7 terlebih dahulu!",
            ),
        )
      }
      1 -> {
        val r = listOf(7, 14, 21, 28).random()
        val d = r * 2
        val isCirc = Random.nextBoolean()
        if (isCirc) {
          val ans = 22 * (d / 7)
          val distractors = listOf(ans + 22, ans - 22, ans / 2, ans + 14)
          val (opts, idx) = buildUniqueOptions(ans, distractors) { "$it m" }
          MathQuestion(
            id = id,
            chapter = ChapterId.CHAPTER_5,
            questionText =
              "Sebuah taman berbentuk lingkaran mempunyai diameter $d meter. Panjang pagar yang diperlukan untuk mengelilingi taman tersebut adalah... (π = [[frac:22|7]])",
            options = opts,
            correctIndex = idx,
            isAiGenerated = true,
            circleDiagram =
              CircleDiagramSpec(
                radiusValue = r.toDouble(),
                isDiameterGiven = true,
                centralAngleDeg = 360.0,
                unit = "m",
                highlightMode = CircleHighlightMode.CIRCUMFERENCE,
              ),
            explanation =
              StepByStepExplanation(
                diketahui = "Diameter d = $d m\nπ = [[frac:22|7]]",
                rumusUtama = "Keliling = π × d",
                langkahLangkah =
                  listOf(
                    "Step 1: Panjang pagar sama dengan keliling: K = [[frac:22|7]] × $d.",
                    "Step 2: Coret [[frac:$d|7]] = ${d / 7}.",
                    "Step 3: Kalikan 22 × ${d / 7} = $ans meter.",
                  ),
                tipsManga = "Pagar mengelilingi taman berarti menghitung keliling, gunakan π × d!",
              ),
          )
        } else {
          val rDiv7 = r / 7
          val ans = 22 * rDiv7 * r
          val distractors = listOf(ans - 44, ans + 44, 44 * rDiv7, ans + 22)
          val (opts, idx) = buildUniqueOptions(ans, distractors) { "$it cm²" }
          MathQuestion(
            id = id,
            chapter = ChapterId.CHAPTER_5,
            questionText =
              "Sebuah meja lingkaran memiliki jari-jari $r cm. Luas permukaan meja tersebut adalah... (π = [[frac:22|7]])",
            options = opts,
            correctIndex = idx,
            isAiGenerated = true,
            circleDiagram =
              CircleDiagramSpec(
                radiusValue = r.toDouble(),
                isDiameterGiven = false,
                centralAngleDeg = 360.0,
                unit = "cm",
                highlightMode = CircleHighlightMode.AREA,
              ),
            explanation =
              StepByStepExplanation(
                diketahui = "Jari-jari r = $r cm\nπ = [[frac:22|7]]",
                rumusUtama = "Luas = π × r × r",
                langkahLangkah =
                  listOf(
                    "Step 1: L = [[frac:22|7]] × $r × $r.",
                    "Step 2: Coret [[frac:$r|7]] = $rDiv7.",
                    "Step 3: Kalikan 22 × $rDiv7 × $r = $ans cm².",
                  ),
                tipsManga = "Jangan lupa mengkuadratkan r (dikalikan dua kali: r × r) untuk luas!",
              ),
          )
        }
      }
      else -> {
        val slices = listOf(4, 5, 6, 8, 9, 10, 12).random()
        val ans = 360 / slices
        val distractors = listOf(ans + 15, ans - 10, 180 / slices, ans + 30)
        val (opts, idx) = buildUniqueOptions(ans, distractors) { "$it°" }
        MathQuestion(
          id = id,
          chapter = ChapterId.CHAPTER_5,
          questionText =
            "Sebuah pizza berbentuk lingkaran dipotong menjadi $slices bagian sama besar. Besar sudut pusat setiap potongan pizza adalah...",
          options = opts,
          correctIndex = idx,
          isAiGenerated = true,
          circleDiagram =
            CircleDiagramSpec(
              radiusValue = 14.0,
              isDiameterGiven = false,
              centralAngleDeg = ans.toDouble(),
              unit = "cm",
              highlightMode = CircleHighlightMode.SECTOR,
            ),
          explanation =
            StepByStepExplanation(
              diketahui = "Sudut 1 lingkaran penuh = 360°\nBanyak potongan = $slices",
              rumusUtama = "Sudut Pusat = [[frac:360°|$slices]]",
              langkahLangkah =
                listOf(
                  "Step 1: Total sudut satu lingkaran penuh adalah 360°.",
                  "Step 2: Bagi rata untuk $slices potongan: [[frac:360°|$slices]].",
                  "Step 3: Hasil pembagiannya = $ans°.",
                ),
              tipsManga = "Satu lingkaran penuh selalu 360°, bukan 180°!",
            ),
        )
      }
    }
  }

  private fun buildUniqueOptions(
    correctValue: Int,
    candidateDistractors: List<Int>,
    formatter: (Int) -> String,
  ): Pair<List<String>, Int> {
    val values = linkedSetOf(correctValue)
    for (d in candidateDistractors) {
      if (values.size < 5 && d != correctValue && (d > 0 || correctValue <= 0)) {
        values.add(d)
      }
    }
    var offset = 1
    while (values.size < 5) {
      val candidate = correctValue + offset * 3
      if (candidate != correctValue) values.add(candidate)
      offset++
    }
    val correctFormatted = formatter(correctValue)
    val shuffled = values.map(formatter).shuffled()
    return shuffled to shuffled.indexOf(correctFormatted)
  }
}
