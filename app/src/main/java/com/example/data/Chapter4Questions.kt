package com.example.data

import com.example.model.ChapterId
import com.example.model.MathQuestion
import com.example.model.StepByStepExplanation

object Chapter4Questions {
  val questions: List<MathQuestion> =
    listOf(
      MathQuestion(
        id = "ch4_01",
        chapter = ChapterId.CHAPTER_4,
        questionText = "Diketahui f(x) = x + 7. Invers dari fungsi tersebut, f⁻¹(x), adalah...",
        options = listOf("x + 7", "x - 7", "7 - x", "[[frac:x|7]]", "-x - 7"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "y = f(x) = x + 7",
            rumusUtama = "Tukar posisi dan selesaikan x dalam y",
            langkahLangkah =
              listOf(
                "Step 1: Misalkan y = x + 7.",
                "Step 2: Pindahkan +7 ke ruas kiri → x = y - 7.",
                "Step 3: Ganti y menjadi x → f⁻¹(x) = x - 7.",
              ),
            tipsManga = "Invers adalah kebalikan operasi: lawan tambah 7 adalah kurang 7!",
          ),
      ),
      MathQuestion(
        id = "ch4_02",
        chapter = ChapterId.CHAPTER_4,
        questionText = "Diketahui f(x) = 3x - 6. Invers fungsi f⁻¹(x) adalah...",
        options =
          listOf(
            "[[frac:x + 6|3]]",
            "[[frac:x - 6|3]]",
            "3x + 6",
            "[[frac:x + 2|3]]",
            "[[frac:6 - x|3]]",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "y = 3x - 6",
            rumusUtama = "3x = y + 6 → x = [[frac:y + 6|3]]",
            langkahLangkah =
              listOf(
                "Step 1: Tulis y = 3x - 6, lalu pindahkan -6 → y + 6 = 3x.",
                "Step 2: Bagi kedua sisi dengan 3 → x = [[frac:y + 6|3]].",
                "Step 3: Ganti y menjadi x → f⁻¹(x) = [[frac:x + 6|3]].",
              ),
            tipsManga = "Trik cepat invers ax + b: f⁻¹(x) = (x - b)/a.",
          ),
      ),
      MathQuestion(
        id = "ch4_03",
        chapter = ChapterId.CHAPTER_4,
        questionText = "Diketahui f(x) = 2x + 5. Nilai dari f⁻¹(13) adalah...",
        options = listOf("3", "4", "5", "6", "9"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x + 5\nDitanya f⁻¹(13)",
            rumusUtama = "f⁻¹(k) = a artinya f(a) = k",
            langkahLangkah =
              listOf(
                "Step 1: Cari f⁻¹(x) = [[frac:x - 5|2]] atau langsung selesaikan 2a + 5 = 13.",
                "Step 2: 2a = 13 - 5 = 8.",
                "Step 3: a = [[frac:8|2]] = 4, jadi f⁻¹(13) = 4.",
              ),
            tipsManga = "Mencari f⁻¹(13) sama dengan mencari x yang menghasilkan 13! Lebih cepat tanpa menyusun rumus invers.",
          ),
      ),
      MathQuestion(
        id = "ch4_04",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui fungsi pecahan f(x) = [[frac:2x + 3|x - 4]] dengan x ≠ 4. Invers fungsi f⁻¹(x) adalah...",
        options =
          listOf(
            "[[frac:4x + 3|x - 2]]",
            "[[frac:4x - 3|x - 2]]",
            "[[frac:2x + 3|x + 4]]",
            "[[frac:4x + 3|x + 2]]",
            "[[frac:-4x + 3|x - 2]]",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:2x + 3|x - 4]] (a = 2, b = 3, c = 1, d = -4)",
            rumusUtama = "Jika f(x) = [[frac:ax + b|cx + d]] maka f⁻¹(x) = [[frac:-dx + b|cx - a]]",
            langkahLangkah =
              listOf(
                "Step 1: Tukar posisi a = 2 dan d = -4 lalu ubah tandanya menjadi berlawanan.",
                "Step 2: -d menjadi -(-4) = +4 di depan x pembilang, dan -a menjadi -2 di penyebut.",
                "Step 3: Diperoleh f⁻¹(x) = [[frac:4x + 3|x - 2]] (x ≠ 2).",
              ),
            tipsManga = "Jurus Ninja Invers Pecahan: a dan d tukar tempat + ganti tanda! b dan c diam di tempat.",
          ),
      ),
      MathQuestion(
        id = "ch4_05",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = [[frac:3x - 5|2x + 1]] dengan x ≠ -[[frac:1|2]]. Invers fungsi f⁻¹(x) adalah...",
        options =
          listOf(
            "[[frac:-x - 5|2x - 3]]",
            "[[frac:x - 5|2x - 3]]",
            "[[frac:-x + 5|2x - 3]]",
            "[[frac:-x - 5|2x + 3]]",
            "[[frac:3x - 5|2x - 1]]",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:3x - 5|2x + 1]] → a = 3, b = -5, c = 2, d = 1",
            rumusUtama = "f⁻¹(x) = [[frac:-dx + b|cx - a]]",
            langkahLangkah =
              listOf(
                "Step 1: Tukar a = 3 dan d = 1 serta ubah tandanya menjadi -1 dan -3.",
                "Step 2: Pembilang menjadi -1x - 5 = -x - 5.",
                "Step 3: Penyebut menjadi 2x - 3, sehingga f⁻¹(x) = [[frac:-x - 5|2x - 3]].",
              ),
            tipsManga = "Pastikan posisi cx dan b tidak ikut berubah tandanya!",
          ),
      ),
      MathQuestion(
        id = "ch4_06",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = [[frac:x + 6|x - 2]] dengan x ≠ 2. Nilai dari f⁻¹(3) adalah...",
        options = listOf("4", "5", "6", "7", "8"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:x + 6|x - 2]]\nDitanya f⁻¹(3)",
            rumusUtama = "[[frac:a + 6|a - 2]] = 3",
            langkahLangkah =
              listOf(
                "Step 1: Gunakan sifat f(a) = 3 → [[frac:a + 6|a - 2]] = 3.",
                "Step 2: Kalikan silang: a + 6 = 3(a - 2) = 3a - 6.",
                "Step 3: 6 + 6 = 3a - a → 12 = 2a → a = 6.",
              ),
            tipsManga = "Kalikan silang langsung tanpa perlu mencari rumus f⁻¹(x) lebih dulu.",
          ),
      ),
      MathQuestion(
        id = "ch4_07",
        chapter = ChapterId.CHAPTER_4,
        questionText = "Diketahui f(x) = [[frac:4x - 2|3]]. Invers fungsi f⁻¹(x) adalah...",
        options =
          listOf(
            "[[frac:3x + 2|4]]",
            "[[frac:3x - 2|4]]",
            "[[frac:4x + 2|3]]",
            "[[frac:3x + 4|2]]",
            "[[frac:2x + 3|4]]",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "y = [[frac:4x - 2|3]]",
            rumusUtama = "3y = 4x - 2",
            langkahLangkah =
              listOf(
                "Step 1: Kalikan kedua ruas dengan 3 → 3y = 4x - 2.",
                "Step 2: Pindahkan -2 ke kiri → 4x = 3y + 2.",
                "Step 3: Bagi 4 dan ubah y menjadi x → f⁻¹(x) = [[frac:3x + 2|4]].",
              ),
            tipsManga = "Hilangkan penyebut 3 dulu dengan mengalikan ke y.",
          ),
      ),
      MathQuestion(
        id = "ch4_08",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = [[frac:5x + 4|2x - 3]] (x ≠ [[frac:3|2]]). Nilai f⁻¹(4) adalah...",
        options =
          listOf("[[frac:16|3]]", "[[frac:14|3]]", "4", "5", "[[frac:17|3]]"),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:5x + 4|2x - 3]]\nf⁻¹(4) = ?",
            rumusUtama = "f⁻¹(x) = [[frac:3x + 4|2x - 5]]",
            langkahLangkah =
              listOf(
                "Step 1: Gunakan trik tukar a = 5 dan d = -3 + balik tanda → f⁻¹(x) = [[frac:3x + 4|2x - 5]].",
                "Step 2: Masukkan x = 4 pada pembilang: 3(4) + 4 = 16.",
                "Step 3: Masukkan x = 4 pada penyebut: 2(4) - 5 = 3 → hasil [[frac:16|3]].",
              ),
            tipsManga = "Cek kembali: jika x = 16/3 dimasukkan ke f(x), hasilnya tepat 4!",
          ),
      ),
      MathQuestion(
        id = "ch4_09",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Suatu mesin mengubah masukan x dengan aturan f(x) = 5x + 10. Jika keluarannya 45, berapakah masukan awal x (atau nilai f⁻¹(45))?",
        options = listOf("5", "6", "7", "8", "9"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 5x + 10\nf(x) = 45",
            rumusUtama = "f⁻¹(x) = [[frac:x - 10|5]]",
            langkahLangkah =
              listOf(
                "Step 1: Susun invers: f⁻¹(x) = [[frac:x - 10|5]].",
                "Step 2: Masukkan keluaran 45 → [[frac:45 - 10|5]] = [[frac:35|5]].",
                "Step 3: Bagi 35 dengan 5 → 7.",
              ),
            tipsManga = "Mencari masukan dari keluaran yang sudah diketahui adalah makna nyata fungsi invers!",
          ),
      ),
      MathQuestion(
        id = "ch4_10",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = 4x - 1 dan g(x) = x + 3. Nilai dari (f ∘ g)⁻¹(15) adalah...",
        options = listOf("1", "2", "3", "4", "5"),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 4x - 1\ng(x) = x + 3\n(f ∘ g)⁻¹(15)",
            rumusUtama = "(f ∘ g)(a) = 15",
            langkahLangkah =
              listOf(
                "Step 1: Cari (f ∘ g)(x) = 4(x + 3) - 1 = 4x + 11.",
                "Step 2: Samakan dengan 15 → 4a + 11 = 15 → 4a = 4.",
                "Step 3: a = 1, jadi (f ∘ g)⁻¹(15) = 1.",
              ),
            tipsManga = "Untuk mencari (f ∘ g)⁻¹(k), cari dulu (f ∘ g)(x) lalu samakan dengan k!",
          ),
      ),
      MathQuestion(
        id = "ch4_11",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = [[frac:7 - 2x|x + 3]] dengan x ≠ -3. Invers fungsi f⁻¹(x) adalah...",
        options =
          listOf(
            "[[frac:-3x + 7|x + 2]]",
            "[[frac:3x + 7|x + 2]]",
            "[[frac:-3x + 7|x - 2]]",
            "[[frac:-3x - 7|x + 2]]",
            "[[frac:2x + 7|x - 3]]",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:-2x + 7|1x + 3]] → a = -2, b = 7, c = 1, d = 3",
            rumusUtama = "f⁻¹(x) = [[frac:-dx + b|cx - a]]",
            langkahLangkah =
              listOf(
                "Step 1: Urutkan dulu pembilang menjadi -2x + 7 agar tidak keliru menentukan a!",
                "Step 2: a = -2 dan d = 3 ditukar + ubah tanda → -3 di atas, -(-2) = +2 di bawah.",
                "Step 3: Hasilnya f⁻¹(x) = [[frac:-3x + 7|x + 2]].",
              ),
            tipsManga = "Jebakan klasik! Jika bentuknya 7 - 2x, tulis ulang jadi -2x + 7 dulu sebelum memakai rumus cepat!",
          ),
      ),
      MathQuestion(
        id = "ch4_12",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = 2x - 3 dan g(x) = 3x + 1. Rumus dari (f ∘ g)⁻¹(x) adalah...",
        options =
          listOf(
            "[[frac:x + 1|6]]",
            "[[frac:x - 1|6]]",
            "[[frac:x + 5|6]]",
            "[[frac:x - 5|6]]",
            "[[frac:6x + 1|5]]",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x - 3\ng(x) = 3x + 1",
            rumusUtama = "(f ∘ g)(x) = 2(3x + 1) - 3 = 6x - 1",
            langkahLangkah =
              listOf(
                "Step 1: Hitung komposisinya: (f ∘ g)(x) = 6x + 2 - 3 = 6x - 1.",
                "Step 2: Misalkan y = 6x - 1 → 6x = y + 1.",
                "Step 3: Bagi 6 → (f ∘ g)⁻¹(x) = [[frac:x + 1|6]].",
              ),
            tipsManga = "Komposisikan f dan g lebih dahulu baru diinverskan biasanya paling minim kesalahan.",
          ),
      ),
      MathQuestion(
        id = "ch4_13",
        chapter = ChapterId.CHAPTER_4,
        questionText = "Diketahui f(x) = x² + 1 untuk x ≥ 0. Invers fungsi f⁻¹(x) untuk x ≥ 1 adalah...",
        options =
          listOf(
            "√(x - 1)",
            "√(x + 1)",
            "√x - 1",
            "x² - 1",
            "√(1 - x)",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "y = x² + 1 dengan x ≥ 0",
            rumusUtama = "x² = y - 1 → x = √(y - 1)",
            langkahLangkah =
              listOf(
                "Step 1: Pindahkan +1 ke kiri → x² = y - 1.",
                "Step 2: Tarik akar di kedua sisi (pilih positif karena x ≥ 0) → x = √(y - 1).",
                "Step 3: Ubah y ke x → f⁻¹(x) = √(x - 1).",
              ),
            tipsManga = "Lawan dari kuadrat adalah akar kuadrat (√).",
          ),
      ),
      MathQuestion(
        id = "ch4_14",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f⁻¹(x) = 2x - 5. Jika f(a) = 9, maka nilai a adalah...",
        options = listOf("9", "11", "13", "15", "17"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f⁻¹(x) = 2x - 5\nf(a) = 9",
            rumusUtama = "f(a) = 9 ⟺ a = f⁻¹(9)",
            langkahLangkah =
              listOf(
                "Step 1: Gunakan sifat dasar invers: jika f(a) = 9, maka a = f⁻¹(9).",
                "Step 2: Substitusi x = 9 ke rumus f⁻¹(x): 2(9) - 5.",
                "Step 3: 18 - 5 = 13.",
              ),
            tipsManga = "Tidak perlu membalik f⁻¹ menjadi f! Pakai langsung hubungan f(a) = b ⟺ a = f⁻¹(b).",
          ),
      ),
      MathQuestion(
        id = "ch4_15",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = [[frac:x|x + 2]] dengan x ≠ -2. Invers fungsi f⁻¹(x) adalah...",
        options =
          listOf(
            "[[frac:-2x|x - 1]]",
            "[[frac:2x|x - 1]]",
            "[[frac:-2x|x + 1]]",
            "[[frac:2x|x + 1]]",
            "[[frac:x|x - 2]]",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:1x + 0|1x + 2]] → a = 1, b = 0, c = 1, d = 2",
            rumusUtama = "f⁻¹(x) = [[frac:-dx + b|cx - a]]",
            langkahLangkah =
              listOf(
                "Step 1: Kenali b = 0 pada pembilang x + 0.",
                "Step 2: Tukar a = 1 dan d = 2 serta balik tanda → pembilang -2x + 0 = -2x.",
                "Step 3: Penyebut menjadi 1x - 1 = x - 1 → f⁻¹(x) = [[frac:-2x|x - 1]].",
              ),
            tipsManga = "Jika tidak ada konstanta di pembilang, berarti nilai b = 0.",
          ),
      ),
      MathQuestion(
        id = "ch4_16",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Konversi suhu Celcius C ke Reamur R dirumuskan R(C) = [[frac:4|5]]C. Invers fungsi C(R) untuk mengubah Reamur kembali ke Celcius adalah...",
        options =
          listOf(
            "[[frac:5|4]]R",
            "[[frac:4|5]]R",
            "[[frac:9|5]]R",
            "[[frac:5|9]]R",
            "R + [[frac:4|5]]",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "R = [[frac:4|5]]C",
            rumusUtama = "C = [[frac:5|4]]R",
            langkahLangkah =
              listOf(
                "Step 1: Kalikan kedua ruas dengan 5 → 5R = 4C.",
                "Step 2: Bagi kedua ruas dengan 4 → C = [[frac:5|4]]R.",
                "Step 3: Diperoleh fungsi invers C(R) = [[frac:5|4]]R.",
              ),
            tipsManga = "Invers perkalian pecahan a/b cukup dibalik menjadi b/a!",
          ),
      ),
      MathQuestion(
        id = "ch4_17",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = 3x + 4 dan g(x) = x - 2. Nilai dari (g⁻¹ ∘ f⁻¹)(10) adalah...",
        options = listOf("2", "3", "4", "5", "6"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x + 4\ng(x) = x - 2\nx = 10",
            rumusUtama = "(g⁻¹ ∘ f⁻¹)(10) = g⁻¹(f⁻¹(10))",
            langkahLangkah =
              listOf(
                "Step 1: Cari f⁻¹(10): 3a + 4 = 10 → 3a = 6 → a = 2.",
                "Step 2: Masukkan hasil 2 ke g⁻¹: g⁻¹(2) → b - 2 = 2 → b = 4.",
                "Step 3: Jadi (g⁻¹ ∘ f⁻¹)(10) = 4.",
              ),
            tipsManga = "Ingat juga sifat (f ∘ g)⁻¹ = g⁻¹ ∘ f⁻¹ (urutan dibalik saat diinverskan)!",
          ),
      ),
      MathQuestion(
        id = "ch4_18",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x) = [[frac:x - 4|2x + 6]] dengan x ≠ -3. Nilai x yang dilarang (asimtot tegak/pembatas domain) pada invers f⁻¹(x) adalah...",
        options =
          listOf(
            "x ≠ [[frac:1|2]]",
            "x ≠ -[[frac:1|2]]",
            "x ≠ 3",
            "x ≠ -3",
            "x ≠ 2",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:1x - 4|2x + 6]]",
            rumusUtama = "f⁻¹(x) = [[frac:-6x - 4|2x - 1]]",
            langkahLangkah =
              listOf(
                "Step 1: Cari inversnya: f⁻¹(x) = [[frac:-6x - 4|2x - 1]].",
                "Step 2: Syarat pecahan adalah penyebut tidak boleh nol: 2x - 1 ≠ 0.",
                "Step 3: 2x ≠ 1 → x ≠ [[frac:1|2]].",
              ),
            tipsManga = "Penyebut pecahan tidak pernah boleh bernilai nol!",
          ),
      ),
      MathQuestion(
        id = "ch4_19",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Diketahui f(x + 1) = 3x - 2. Nilai dari f⁻¹(7) adalah...",
        options = listOf("2", "3", "4", "5", "6"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x + 1) = 3x - 2\nDitanya f⁻¹(7)",
            rumusUtama = "f(x + 1) = 7 → f⁻¹(7) = x + 1",
            langkahLangkah =
              listOf(
                "Step 1: Samakan hasil fungsi dengan 7 → 3x - 2 = 7.",
                "Step 2: Selesaikan untuk x: 3x = 9 → x = 3.",
                "Step 3: Karena masukannya adalah (x + 1), maka f⁻¹(7) = 3 + 1 = 4.",
              ),
            tipsManga = "Hati-hati! Nilai x = 3 belum selesai, karena di dalam tanda kurung f adalah (x + 1)!",
          ),
      ),
      MathQuestion(
        id = "ch4_20",
        chapter = ChapterId.CHAPTER_4,
        questionText =
          "Jika f(x) = [[frac:ax + 2|x - 3]] dan f⁻¹(6) = 4, maka nilai a adalah...",
        options = listOf("1", "2", "3", "4", "5"),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:ax + 2|x - 3]]\nf⁻¹(6) = 4 ⟺ f(4) = 6",
            rumusUtama = "f(4) = [[frac:4a + 2|4 - 3]] = 6",
            langkahLangkah =
              listOf(
                "Step 1: Ubah f⁻¹(6) = 4 menjadi f(4) = 6.",
                "Step 2: Substitusi x = 4 → [[frac:4a + 2|1]] = 6.",
                "Step 3: 4a + 2 = 6 → 4a = 4 → a = 1.",
              ),
            tipsManga = "Hubungan f⁻¹(b) = a selalu sama dengan f(a) = b.",
          ),
      ),
    )
}
