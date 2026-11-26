package com.example.data

import com.example.model.ChapterId
import com.example.model.MathQuestion
import com.example.model.StepByStepExplanation

object Chapter3Questions {
  val questions: List<MathQuestion> =
    listOf(
      MathQuestion(
        id = "ch3_01",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui fungsi f(x) = 2x + 3 dan g(x) = x - 1. Nilai (f ∘ g)(4) adalah...",
        options = listOf("7", "8", "9", "10", "11"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x + 3\ng(x) = x - 1\nx = 4",
            rumusUtama = "(f ∘ g)(4) = f(g(4))",
            langkahLangkah =
              listOf(
                "Step 1: Kerjakan fungsi yang paling kanan terlebih dahulu: g(4) = 4 - 1 = 3.",
                "Step 2: Masukkan hasil 3 ke fungsi f: f(3) = 2(3) + 3.",
                "Step 3: Hitung hasilnya: 6 + 3 = 9.",
              ),
            tipsManga = "Komposisi (f ∘ g)(4) artinya g bekerja dulu pada 4, baru hasilnya masuk ke f!",
          ),
      ),
      MathQuestion(
        id = "ch3_02",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = 3x + 2 dan g(x) = x + 4. Rumus fungsi komposisi (f ∘ g)(x) adalah...",
        options = listOf("3x + 6", "3x + 12", "3x + 14", "4x + 6", "3x + 8"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x + 2\ng(x) = x + 4",
            rumusUtama = "(f ∘ g)(x) = f(g(x)) = 3(g(x)) + 2",
            langkahLangkah =
              listOf(
                "Step 1: Substitusi g(x) = x + 4 ke dalam x milik f(x): 3(x + 4) + 2.",
                "Step 2: Kalikan masuk kurung: 3x + 12 + 2.",
                "Step 3: Sederhanakan menjadi 3x + 14.",
              ),
            tipsManga = "Jangan lupa mengalikan 3 ke angka 4 di dalam kurung, bukan hanya ke x!",
          ),
      ),
      MathQuestion(
        id = "ch3_03",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = 2x - 1 dan g(x) = 4x + 5. Rumus fungsi komposisi (g ∘ f)(x) adalah...",
        options = listOf("8x + 1", "8x + 9", "8x - 1", "8x + 4", "6x + 4"),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x - 1\ng(x) = 4x + 5",
            rumusUtama = "(g ∘ f)(x) = g(f(x)) = 4(f(x)) + 5",
            langkahLangkah =
              listOf(
                "Step 1: Masukkan f(x) = 2x - 1 ke dalam x milik g(x): 4(2x - 1) + 5.",
                "Step 2: Jabarkan: 8x - 4 + 5.",
                "Step 3: Sederhanakan: 8x + 1.",
              ),
            tipsManga = "Perhatikan urutan huruf: (g ∘ f)(x) berarti f dimasukkan ke dalam g.",
          ),
      ),
      MathQuestion(
        id = "ch3_04",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = x² + 1 dan g(x) = 3x - 2. Nilai dari (f ∘ g)(2) adalah...",
        options = listOf("13", "15", "17", "19", "21"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² + 1\ng(x) = 3x - 2\nx = 2",
            rumusUtama = "(f ∘ g)(2) = f(g(2))",
            langkahLangkah =
              listOf(
                "Step 1: Hitung g(2) = 3(2) - 2 = 6 - 2 = 4.",
                "Step 2: Masukkan 4 ke fungsi f: f(4) = 4² + 1.",
                "Step 3: Hitung 16 + 1 = 17.",
              ),
            tipsManga = "Untuk nilai angka, langsung hitung dari fungsi dalam ke luar—jauh lebih cepat!",
          ),
      ),
      MathQuestion(
        id = "ch3_05",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = 2x - 1 dan g(x) = x² + 2. Nilai dari (g ∘ f)(3) adalah...",
        options = listOf("19", "23", "25", "27", "29"),
        correctIndex = 3,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x - 1\ng(x) = x² + 2\nx = 3",
            rumusUtama = "(g ∘ f)(3) = g(f(3))",
            langkahLangkah =
              listOf(
                "Step 1: Hitung f(3) = 2(3) - 1 = 6 - 1 = 5.",
                "Step 2: Masukkan hasil 5 ke g: g(5) = 5² + 2.",
                "Step 3: 25 + 2 = 27.",
              ),
            tipsManga = "Arah panah selalu dari kanan ke kiri: 3 → f → 5 → g → 27.",
          ),
      ),
      MathQuestion(
        id = "ch3_06",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = x + 4, g(x) = 2x, dan h(x) = x + 1. Nilai (f ∘ g ∘ h)(2) adalah...",
        options = listOf("8", "9", "10", "11", "12"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x + 4, g(x) = 2x, h(x) = x + 1\nx = 2",
            rumusUtama = "(f ∘ g ∘ h)(2) = f(g(h(2)))",
            langkahLangkah =
              listOf(
                "Step 1: Mulai dari paling kanan: h(2) = 2 + 1 = 3.",
                "Step 2: Lanjut ke tengah: g(3) = 2(3) = 6.",
                "Step 3: Terakhir ke kiri: f(6) = 6 + 4 = 10.",
              ),
            tipsManga = "Komposisi 3 fungsi seperti estafet lari 3 pelari: h → g → f!",
          ),
      ),
      MathQuestion(
        id = "ch3_07",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = 3x - 2, g(x) = x², dan h(x) = x + 2. Nilai (f ∘ g ∘ h)(1) adalah...",
        options = listOf("21", "23", "25", "27", "29"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x - 2, g(x) = x², h(x) = x + 2\nx = 1",
            rumusUtama = "(f ∘ g ∘ h)(1) = f(g(h(1)))",
            langkahLangkah =
              listOf(
                "Step 1: Hitung h(1) = 1 + 2 = 3.",
                "Step 2: Hitung g(3) = 3² = 9.",
                "Step 3: Hitung f(9) = 3(9) - 2 = 27 - 2 = 25.",
              ),
            tipsManga = "Kerjakan bertahap satu per satu agar tidak tertukar operasi kuadrat dan kalinya.",
          ),
      ),
      MathQuestion(
        id = "ch3_08",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = x² dan g(x) = x - 3. Rumus dari (f ∘ g)(x) adalah...",
        options =
          listOf(
            "x² - 9",
            "x² - 3",
            "x² - 6x + 9",
            "x² + 6x + 9",
            "x² - 3x + 9",
          ),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x²\ng(x) = x - 3",
            rumusUtama = "(f ∘ g)(x) = (x - 3)²",
            langkahLangkah =
              listOf(
                "Step 1: Substitusi g(x) = x - 3 ke f(x) = x² → (x - 3)².",
                "Step 2: Jabarkan (x - 3)(x - 3) = x² - 3x - 3x + 9.",
                "Step 3: Sederhanakan menjadi x² - 6x + 9.",
              ),
            tipsManga = "Awas! (x - 3)² bukan x² - 9. Selalu ada suku tengah -2ab = -6x!",
          ),
      ),
      MathQuestion(
        id = "ch3_09",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Pabrik kertas memproses x ton bahan melalui mesin I dengan fungsi f(x) = 2x - 1, lalu hasilnya masuk ke mesin II dengan fungsi g(x) = x² + 3. Jika masuk 4 ton bahan, keluaran akhirnya adalah...",
        options = listOf("48", "50", "52", "54", "56"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "Mesin I: f(x) = 2x - 1\nMesin II: g(x) = x² + 3\nBahan x = 4",
            rumusUtama = "(g ∘ f)(4) = g(f(4))",
            langkahLangkah =
              listOf(
                "Step 1: Proses di Mesin I: f(4) = 2(4) - 1 = 7.",
                "Step 2: Hasil 7 diteruskan ke Mesin II: g(7) = 7² + 3.",
                "Step 3: Hitung 49 + 3 = 52.",
              ),
            tipsManga = "Pada soal cerita dua mesin berurutan, pastikan urutan mesin I → mesin II sesuai!",
          ),
      ),
      MathQuestion(
        id = "ch3_10",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = 2x + 1 dan (f ∘ g)(x) = 6x - 5. Rumus fungsi g(x) adalah...",
        options = listOf("3x - 3", "3x - 2", "3x + 3", "6x - 6", "3x - 6"),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x + 1\n(f ∘ g)(x) = 6x - 5",
            rumusUtama = "f(g(x)) = 2·g(x) + 1 = 6x - 5",
            langkahLangkah =
              listOf(
                "Step 1: Ganti x pada f(x) menjadi g(x) → 2·g(x) + 1 = 6x - 5.",
                "Step 2: Kurangi 1 di kedua sisi → 2·g(x) = 6x - 6.",
                "Step 3: Bagi kedua sisi dengan 2 → g(x) = 3x - 3.",
              ),
            tipsManga = "Jika fungsi yang di DALAM (g) ditanya, langsung susun persamaan aljabarnya!",
          ),
      ),
      MathQuestion(
        id = "ch3_11",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui g(x) = x + 2 dan (f ∘ g)(x) = 3x + 10. Rumus fungsi f(x) adalah...",
        options = listOf("3x + 2", "3x + 4", "3x + 6", "3x + 8", "3x + 12"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "g(x) = x + 2\nf(g(x)) = 3x + 10",
            rumusUtama = "Misalkan u = x + 2 → x = u - 2",
            langkahLangkah =
              listOf(
                "Step 1: Tuliskan f(x + 2) = 3x + 10 dan misalkan u = x + 2 sehingga x = u - 2.",
                "Step 2: Substitusi x = u - 2 → f(u) = 3(u - 2) + 10 = 3u - 6 + 10 = 3u + 4.",
                "Step 3: Ubah kembali u menjadi x → f(x) = 3x + 4.",
              ),
            tipsManga = "Teknik pemisalan u adalah senjata pamungkas mencari fungsi yang di LUAR!",
          ),
      ),
      MathQuestion(
        id = "ch3_12",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = 3x + 1 dan g(x) = 2x - 4. Jika (f ∘ g)(a) = 19, maka nilai a adalah...",
        options = listOf("3", "4", "5", "6", "7"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x + 1\ng(x) = 2x - 4\n(f ∘ g)(a) = 19",
            rumusUtama = "f(g(a)) = 3(2a - 4) + 1 = 19",
            langkahLangkah =
              listOf(
                "Step 1: Susun (f ∘ g)(a) = 3(2a - 4) + 1 = 6a - 12 + 1 = 6a - 11.",
                "Step 2: Samakan dengan 19 → 6a - 11 = 19 → 6a = 30.",
                "Step 3: Bagi 6 → a = [[frac:30|6]] = 5.",
              ),
            tipsManga = "Cek balik: g(5) = 6, lalu f(6) = 3(6) + 1 = 19. Tepat!",
          ),
      ),
      MathQuestion(
        id = "ch3_13",
        chapter = ChapterId.CHAPTER_3,
        questionText = "Diketahui f(x) = 2x - 1. Nilai dari (f ∘ f)(3) adalah...",
        options = listOf("5", "7", "9", "11", "13"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x - 1\nx = 3",
            rumusUtama = "(f ∘ f)(3) = f(f(3))",
            langkahLangkah =
              listOf(
                "Step 1: Hitung bagian dalam: f(3) = 2(3) - 1 = 5.",
                "Step 2: Masukkan hasil 5 kembali ke f: f(5) = 2(5) - 1.",
                "Step 3: Hitung 10 - 1 = 9.",
              ),
            tipsManga = "(f ∘ f) artinya fungsi f dipakai dua kali berturut-turut!",
          ),
      ),
      MathQuestion(
        id = "ch3_14",
        chapter = ChapterId.CHAPTER_3,
        questionText = "Diketahui g(x) = x² + 1. Nilai dari (g ∘ g)(2) adalah...",
        options = listOf("10", "17", "24", "26", "28"),
        correctIndex = 3,
        explanation =
          StepByStepExplanation(
            diketahui = "g(x) = x² + 1\nx = 2",
            rumusUtama = "(g ∘ g)(2) = g(g(2))",
            langkahLangkah =
              listOf(
                "Step 1: Hitung g(2) = 2² + 1 = 4 + 1 = 5.",
                "Step 2: Masukkan hasil 5 ke g lagi: g(5) = 5² + 1.",
                "Step 3: Hitung 25 + 1 = 26.",
              ),
            tipsManga = "Selalu selesaikan g(2) menjadi satu angka dulu baru kuadratkan lagi.",
          ),
      ),
      MathQuestion(
        id = "ch3_15",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = [[frac:x + 4|2]] dan g(x) = 2x - 6. Rumus (f ∘ g)(x) adalah...",
        options = listOf("x - 1", "x + 1", "x - 2", "2x - 1", "x - 5"),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:x + 4|2]]\ng(x) = 2x - 6",
            rumusUtama = "(f ∘ g)(x) = [[frac:g(x) + 4|2]]",
            langkahLangkah =
              listOf(
                "Step 1: Masukkan g(x) = 2x - 6 ke pembilang: [[frac:(2x - 6) + 4|2]].",
                "Step 2: Sederhanakan pembilang: [[frac:2x - 2|2]].",
                "Step 3: Bagi masing-masing suku dengan 2 → x - 1.",
              ),
            tipsManga = "Pembagian pecahan berlaku untuk SEMUA suku di pembilang, bukan hanya 2x-nya saja.",
          ),
      ),
      MathQuestion(
        id = "ch3_16",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Toko manga memberi potongan harga Rp10.000,00 lewat f(x) = x - 10.000, lalu diskon tambahan 20% lewat g(x) = 0,8x. Jika harga komik awalnya Rp100.000,00, harga setelah (g ∘ f)(100.000) adalah...",
        options =
          listOf("Rp70.000", "Rp72.000", "Rp75.000", "Rp78.000", "Rp80.000"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x - 10.000\ng(x) = 0,8x\nHarga awal x = 100.000",
            rumusUtama = "(g ∘ f)(100.000) = g(f(100.000))",
            langkahLangkah =
              listOf(
                "Step 1: Terapkan f dulu: f(100.000) = 100.000 - 10.000 = 90.000.",
                "Step 2: Terapkan g pada 90.000: g(90.000) = 0,8 × 90.000.",
                "Step 3: 0,8 × 90.000 = Rp72.000.",
              ),
            tipsManga = "Diskon 20% berarti kamu membayar 80% (0,8) dari harga setelah potongan pertama.",
          ),
      ),
      MathQuestion(
        id = "ch3_17",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = 2x, g(x) = x + 3, dan h(x) = x - 1. Rumus fungsi komposisi (f ∘ g ∘ h)(x) adalah...",
        options = listOf("2x + 2", "2x + 4", "2x + 5", "2x + 6", "2x - 2"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x, g(x) = x + 3, h(x) = x - 1",
            rumusUtama = "(f ∘ g ∘ h)(x) = f(g(h(x)))",
            langkahLangkah =
              listOf(
                "Step 1: Cari g(h(x)) = (x - 1) + 3 = x + 2.",
                "Step 2: Masukkan hasil ke f: f(x + 2) = 2(x + 2).",
                "Step 3: Kalikan masuk → 2x + 4.",
              ),
            tipsManga = "Gabungkan dua fungsi dari kanan dulu, baru masukkan ke fungsi paling kiri.",
          ),
      ),
      MathQuestion(
        id = "ch3_18",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = x² - 1 dan g(x) = x + 2. Nilai dari (g ∘ f)(-3) adalah...",
        options = listOf("6", "8", "10", "12", "14"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² - 1\ng(x) = x + 2\nx = -3",
            rumusUtama = "(g ∘ f)(-3) = g(f(-3))",
            langkahLangkah =
              listOf(
                "Step 1: Hitung f(-3) = (-3)² - 1 = 9 - 1 = 8.",
                "Step 2: Masukkan 8 ke g: g(8) = 8 + 2.",
                "Step 3: Hasilnya = 10.",
              ),
            tipsManga = "Hati-hati dengan (-3)² = +9, bukan -9!",
          ),
      ),
      MathQuestion(
        id = "ch3_19",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = [[frac:6|x + 1]] dan g(x) = 2x + 2. Nilai dari (f ∘ g)(0) adalah...",
        options = listOf("1", "2", "3", "4", "6"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = [[frac:6|x + 1]]\ng(x) = 2x + 2\nx = 0",
            rumusUtama = "(f ∘ g)(0) = f(g(0))",
            langkahLangkah =
              listOf(
                "Step 1: Hitung g(0) = 2(0) + 2 = 2.",
                "Step 2: Masukkan 2 ke f: f(2) = [[frac:6|2 + 1]] = [[frac:6|3]].",
                "Step 3: Bagi 6 dengan 3 → 2.",
              ),
            tipsManga = "Pastikan penyebut x + 1 tidak bernilai nol saat menghitung!",
          ),
      ),
      MathQuestion(
        id = "ch3_20",
        chapter = ChapterId.CHAPTER_3,
        questionText =
          "Diketahui f(x) = 2x + 5 dan g(x) = x² + 1. Jika (f ∘ g)(k) = 25 dengan k > 0, nilai k adalah...",
        options = listOf("1", "2", "3", "4", "5"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x + 5\ng(x) = x² + 1\n(f ∘ g)(k) = 25, k > 0",
            rumusUtama = "2(k² + 1) + 5 = 25",
            langkahLangkah =
              listOf(
                "Step 1: Jabarkan: 2k² + 2 + 5 = 25 → 2k² + 7 = 25.",
                "Step 2: Kurangi 7: 2k² = 18 → k² = 9.",
                "Step 3: Karena k > 0, maka k = 3.",
              ),
            tipsManga = "Jika ada syarat k > 0, pilih akar positif dari k² = 9 yaitu 3.",
          ),
      ),
    )
}
