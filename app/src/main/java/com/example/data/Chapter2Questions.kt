package com.example.data

import com.example.model.ChapterId
import com.example.model.MathQuestion
import com.example.model.StepByStepExplanation

object Chapter2Questions {
  val questions: List<MathQuestion> =
    listOf(
      MathQuestion(
        id = "ch2_01",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 2x + 3 dan g(x) = 4x - 1. Hasil dari (f + g)(x) adalah...",
        options = listOf("6x + 2", "6x + 4", "2x + 2", "6x - 2", "8x + 2"),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x + 3\ng(x) = 4x - 1",
            rumusUtama = "(f + g)(x) = f(x) + g(x)",
            langkahLangkah =
              listOf(
                "Step 1: Tuliskan penjumlahan: (2x + 3) + (4x - 1).",
                "Step 2: Kelompokkan suku sejenis: (2x + 4x) + (3 - 1).",
                "Step 3: Sederhanakan menjadi 6x + 2.",
              ),
            tipsManga = "Penjumlahan fungsi hanya menggabungkan suku bervariabel x dengan x, dan angka dengan angka.",
          ),
      ),
      MathQuestion(
        id = "ch2_02",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 5x - 2 dan g(x) = 2x + 7. Hasil dari (f - g)(x) adalah...",
        options = listOf("3x + 5", "3x - 9", "3x + 9", "7x - 9", "3x - 5"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 5x - 2\ng(x) = 2x + 7",
            rumusUtama = "(f - g)(x) = f(x) - g(x)",
            langkahLangkah =
              listOf(
                "Step 1: Gunakan tanda kurung pada pengurang: (5x - 2) - (2x + 7).",
                "Step 2: Kalikan minus ke dalam kurung: 5x - 2 - 2x - 7.",
                "Step 3: Gabungkan suku sejenis: (5x - 2x) + (-2 - 7) = 3x - 9.",
              ),
            tipsManga = "Waspada jebakan! Tanda minus di depan g(x) mengubah +7 menjadi -7.",
          ),
      ),
      MathQuestion(
        id = "ch2_03",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = x + 3 dan g(x) = x - 2. Hasil dari (f · g)(x) adalah...",
        options =
          listOf(
            "x² + x - 6",
            "x² - x - 6",
            "x² + 5x - 6",
            "x² + x + 6",
            "x² - 6",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x + 3\ng(x) = x - 2",
            rumusUtama = "(f · g)(x) = f(x) × g(x)",
            langkahLangkah =
              listOf(
                "Step 1: Kalikan secara distributif: (x + 3)(x - 2).",
                "Step 2: Jabarkan: x² - 2x + 3x - 6.",
                "Step 3: Gabungkan suku tengah: x² + x - 6.",
              ),
            tipsManga = "Kalikan pelangi keempat pasangan suku agar tidak ada suku tengah yang tertinggal.",
          ),
      ),
      MathQuestion(
        id = "ch2_04",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = x² - 9 dan g(x) = x + 3. Hasil dari (f / g)(x) untuk x ≠ -3 adalah...",
        options = listOf("x + 3", "x - 9", "x - 3", "x + 9", "x² - 3"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² - 9\ng(x) = x + 3",
            rumusUtama = "(f / g)(x) = [[frac:x² - 9|x + 3]]",
            langkahLangkah =
              listOf(
                "Step 1: Faktorkan pembilang menggunakan selisih kuadrat: x² - 9 = (x - 3)(x + 3).",
                "Step 2: Bagi dengan penyebut (x + 3): [[frac:(x - 3)(x + 3)|x + 3]].",
                "Step 3: Coret faktor (x + 3) sehingga tersisa x - 3.",
              ),
            tipsManga = "Ingat rumus sakti selisih kuadrat: a² - b² = (a - b)(a + b)!",
          ),
      ),
      MathQuestion(
        id = "ch2_05",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 3x + 4 dan g(x) = 2x - 5. Nilai dari (f + g)(3) adalah...",
        options = listOf("10", "12", "14", "16", "18"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x + 4\ng(x) = 2x - 5\nx = 3",
            rumusUtama = "(f + g)(3) = f(3) + g(3)",
            langkahLangkah =
              listOf(
                "Step 1: Hitung f(3) = 3(3) + 4 = 9 + 4 = 13.",
                "Step 2: Hitung g(3) = 2(3) - 5 = 6 - 5 = 1.",
                "Step 3: Jumlahkan: 13 + 1 = 14.",
              ),
            tipsManga = "Jika ditanya angka tertentu, menghitung f(3) dan g(3) terpisah sering lebih cepat!",
          ),
      ),
      MathQuestion(
        id = "ch2_06",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = x² + 1 dan g(x) = 3x - 2. Nilai dari (f - g)(4) adalah...",
        options = listOf("5", "6", "7", "8", "9"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² + 1\ng(x) = 3x - 2\nx = 4",
            rumusUtama = "(f - g)(4) = f(4) - g(4)",
            langkahLangkah =
              listOf(
                "Step 1: Hitung f(4) = 4² + 1 = 16 + 1 = 17.",
                "Step 2: Hitung g(4) = 3(4) - 2 = 12 - 2 = 10.",
                "Step 3: Kurangkan: 17 - 10 = 7.",
              ),
            tipsManga = "Hitung nilai masing-masing fungsi dulu baru dikurangkan agar minim salah tanda.",
          ),
      ),
      MathQuestion(
        id = "ch2_07",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 2x + 1 dan g(x) = x - 3. Nilai dari (f · g)(5) adalah...",
        options = listOf("18", "20", "22", "24", "26"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x + 1\ng(x) = x - 3\nx = 5",
            rumusUtama = "(f · g)(5) = f(5) × g(5)",
            langkahLangkah =
              listOf(
                "Step 1: Hitung f(5) = 2(5) + 1 = 11.",
                "Step 2: Hitung g(5) = 5 - 3 = 2.",
                "Step 3: Kalikan kedua hasil: 11 × 2 = 22.",
              ),
            tipsManga = "Tidak perlu mengalikan polinomialnya dulu jika x sudah berupa angka!",
          ),
      ),
      MathQuestion(
        id = "ch2_08",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 4x² - 1 dan g(x) = 2x - 1. Bentuk sederhana (f / g)(x) untuk x ≠ [[frac:1|2]] adalah...",
        options = listOf("2x - 1", "2x + 1", "4x + 1", "2x + 2", "x + 1"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 4x² - 1 = (2x)² - 1²\ng(x) = 2x - 1",
            rumusUtama = "(f / g)(x) = [[frac:(2x - 1)(2x + 1)|2x - 1]]",
            langkahLangkah =
              listOf(
                "Step 1: Ubah 4x² - 1 menjadi bentuk selisih kuadrat (2x - 1)(2x + 1).",
                "Step 2: Bagi dengan (2x - 1).",
                "Step 3: Coret faktor yang sama (2x - 1) → hasilnya 2x + 1.",
              ),
            tipsManga = "Kenali 4x² sebagai (2x)² agar cepat memfaktorkan!",
          ),
      ),
      MathQuestion(
        id = "ch2_09",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Pendapatan toko komik dari penjualan x buku adalah P(x) = 15.000x, sedangkan biaya cetaknya B(x) = 9.000x + 60.000. Fungsi keuntungan bersih (P - B)(x) adalah...",
        options =
          listOf(
            "6.000x + 60.000",
            "6.000x - 60.000",
            "24.000x - 60.000",
            "9.000x - 60.000",
            "6.000x",
          ),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "P(x) = 15.000x\nB(x) = 9.000x + 60.000",
            rumusUtama = "(P - B)(x) = 15.000x - (9.000x + 60.000)",
            langkahLangkah =
              listOf(
                "Step 1: Kurangi pendapatan dengan seluruh biaya: 15.000x - 9.000x - 60.000.",
                "Step 2: Hitung 15.000x - 9.000x = 6.000x.",
                "Step 3: Diperoleh fungsi keuntungan 6.000x - 60.000.",
              ),
            tipsManga = "Biaya tetap 60.000 ikut dikurangkan sehingga bertanda minus!",
          ),
      ),
      MathQuestion(
        id = "ch2_10",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 2x² - 3x + 4 dan g(x) = x² + 5x - 1. Fungsi (f + g)(x) adalah...",
        options =
          listOf(
            "3x² + 2x + 3",
            "3x² - 2x + 3",
            "3x² + 8x + 3",
            "x² + 2x + 3",
            "3x² + 2x + 5",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x² - 3x + 4\ng(x) = x² + 5x - 1",
            rumusUtama = "(f + g)(x) = (2x² + x²) + (-3x + 5x) + (4 - 1)",
            langkahLangkah =
              listOf(
                "Step 1: Jumlahkan suku x²: 2x² + x² = 3x².",
                "Step 2: Jumlahkan suku x: -3x + 5x = +2x.",
                "Step 3: Jumlahkan konstanta: 4 - 1 = +3 → 3x² + 2x + 3.",
              ),
            tipsManga = "Susun per kolom pangkat (x², x, konstanta) supaya super rapi.",
          ),
      ),
      MathQuestion(
        id = "ch2_11",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 3x² + 2x - 5 dan g(x) = x² - 4x + 2. Fungsi (f - g)(x) adalah...",
        options =
          listOf(
            "2x² - 2x - 3",
            "2x² + 6x - 3",
            "2x² + 6x - 7",
            "4x² + 6x - 7",
            "2x² - 6x - 7",
          ),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x² + 2x - 5\ng(x) = x² - 4x + 2",
            rumusUtama = "(f - g)(x) = (3x² + 2x - 5) - (x² - 4x + 2)",
            langkahLangkah =
              listOf(
                "Step 1: Buka kurung belakang: -x² + 4x - 2.",
                "Step 2: Suku x² → 3x² - x² = 2x². Suku x → 2x + 4x = 6x.",
                "Step 3: Konstanta → -5 - 2 = -7. Hasilnya 2x² + 6x - 7.",
              ),
            tipsManga = "Ingat: mengurangi -4x sama artinya dengan menambah +4x!",
          ),
      ),
      MathQuestion(
        id = "ch2_12",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 2x - 4 dan g(x) = 3x + 1. Hasil dari (f · g)(x) adalah...",
        options =
          listOf(
            "6x² - 10x - 4",
            "6x² + 10x - 4",
            "6x² - 14x - 4",
            "6x² - 10x + 4",
            "5x² - 10x - 4",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x - 4\ng(x) = 3x + 1",
            rumusUtama = "(f · g)(x) = (2x - 4)(3x + 1)",
            langkahLangkah =
              listOf(
                "Step 1: Kalikan suku depan: 2x × 3x = 6x², 2x × 1 = 2x.",
                "Step 2: Kalikan suku belakang: -4 × 3x = -12x, -4 × 1 = -4.",
                "Step 3: Gabungkan: 6x² + (2x - 12x) - 4 = 6x² - 10x - 4.",
              ),
            tipsManga = "Periksa kembali koefisien tengah: +2x - 12x = -10x.",
          ),
      ),
      MathQuestion(
        id = "ch2_13",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = x² + 5x + 6 dan g(x) = x + 2. Nilai dari (f / g)(4) adalah...",
        options = listOf("5", "6", "7", "8", "9"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² + 5x + 6\ng(x) = x + 2\nx = 4",
            rumusUtama = "(f / g)(4) = [[frac:f(4)|g(4)]]",
            langkahLangkah =
              listOf(
                "Step 1: Hitung f(4) = 4² + 5(4) + 6 = 16 + 20 + 6 = 42.",
                "Step 2: Hitung g(4) = 4 + 2 = 6.",
                "Step 3: Bagi hasilnya: [[frac:42|6]] = 7.",
              ),
            tipsManga = "Atau faktorkan dulu: (x+2)(x+3)/(x+2) = x+3 → 4 + 3 = 7!",
          ),
      ),
      MathQuestion(
        id = "ch2_14",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 4x - 3 dan g(x) = 2x + 5. Jika (f + g)(a) = 20, nilai a adalah...",
        options = listOf("2", "3", "4", "5", "6"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 4x - 3\ng(x) = 2x + 5\n(f + g)(a) = 20",
            rumusUtama = "(4a - 3) + (2a + 5) = 20",
            langkahLangkah =
              listOf(
                "Step 1: Cari (f + g)(x) = 6x + 2.",
                "Step 2: Substitusi x = a → 6a + 2 = 20.",
                "Step 3: 6a = 18 → a = [[frac:18|6]] = 3.",
              ),
            tipsManga = "Gabungkan fungsi f dan g terlebih dahulu baru selesaikan persamaan a.",
          ),
      ),
      MathQuestion(
        id = "ch2_15",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 6x + 8 dan g(x) = 2x + 4. Nilai dari (f - g)(-2) adalah...",
        options = listOf("-8", "-4", "0", "4", "8"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 6x + 8\ng(x) = 2x + 4\nx = -2",
            rumusUtama = "(f - g)(-2) = f(-2) - g(-2)",
            langkahLangkah =
              listOf(
                "Step 1: Hitung f(-2) = 6(-2) + 8 = -12 + 8 = -4.",
                "Step 2: Hitung g(-2) = 2(-2) + 4 = -4 + 4 = 0.",
                "Step 3: Kurangkan: -4 - 0 = -4.",
              ),
            tipsManga = "Atau (f-g)(x) = 4x + 4 → 4(-2) + 4 = -8 + 4 = -4.",
          ),
      ),
      MathQuestion(
        id = "ch2_16",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Sebuah papan gambar manga berbentuk persegi panjang memiliki panjang p(x) = x + 5 cm dan lebar l(x) = x + 2 cm. Fungsi luas papan (p · l)(x) adalah...",
        options =
          listOf(
            "x² + 7x + 10",
            "x² + 3x + 10",
            "x² + 7x + 7",
            "2x + 7",
            "x² + 10",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "Panjang p(x) = x + 5\nLebar l(x) = x + 2",
            rumusUtama = "Luas = (p · l)(x) = (x + 5)(x + 2)",
            langkahLangkah =
              listOf(
                "Step 1: Kalikan (x + 5)(x + 2) secara distributif.",
                "Step 2: Diperoleh x² + 2x + 5x + 10.",
                "Step 3: Jumlahkan suku tengah → x² + 7x + 10.",
              ),
            tipsManga = "Untuk (x+a)(x+b), koefisien tengah adalah a+b dan ujungnya adalah a×b.",
          ),
      ),
      MathQuestion(
        id = "ch2_17",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = x² - 5x + 6 dan g(x) = x - 2. Nilai (f / g)(10) adalah...",
        options = listOf("5", "6", "7", "8", "9"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² - 5x + 6\ng(x) = x - 2\nx = 10",
            rumusUtama = "(f / g)(10) = [[frac:f(10)|g(10)]]",
            langkahLangkah =
              listOf(
                "Step 1: Faktorkan f(x) = (x - 2)(x - 3).",
                "Step 2: Bagi dengan (x - 2), tersisa x - 3.",
                "Step 3: Masukkan x = 10 → 10 - 3 = 7.",
              ),
            tipsManga = "Memfaktorkan pembilang dulu membuat hitungan angka besar jadi super ringan!",
          ),
      ),
      MathQuestion(
        id = "ch2_18",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui (f + g)(x) = 5x + 7 dan f(x) = 2x + 1. Rumus fungsi g(x) adalah...",
        options = listOf("3x + 6", "3x + 8", "7x + 8", "3x - 6", "2x + 6"),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "(f + g)(x) = 5x + 7\nf(x) = 2x + 1",
            rumusUtama = "g(x) = (f + g)(x) - f(x)",
            langkahLangkah =
              listOf(
                "Step 1: Kurangkan hasil jumlah dengan f(x): (5x + 7) - (2x + 1).",
                "Step 2: Hitung 5x - 2x = 3x.",
                "Step 3: Hitung 7 - 1 = 6 → g(x) = 3x + 6.",
              ),
            tipsManga = "Jika jumlah dua fungsi diketahui, cari pasangannya dengan pengurangan.",
          ),
      ),
      MathQuestion(
        id = "ch2_19",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Diketahui f(x) = 3x dan g(x) = x² - 4. Nilai dari (f · g)(3) adalah...",
        options = listOf("27", "36", "45", "54", "63"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x\ng(x) = x² - 4\nx = 3",
            rumusUtama = "(f · g)(3) = f(3) × g(3)",
            langkahLangkah =
              listOf(
                "Step 1: Hitung f(3) = 3(3) = 9.",
                "Step 2: Hitung g(3) = 3² - 4 = 9 - 4 = 5.",
                "Step 3: Kalikan: 9 × 5 = 45.",
              ),
            tipsManga = "Kerjakan f(3) dan g(3) secara terpisah lalu kalikan.",
          ),
      ),
      MathQuestion(
        id = "ch2_20",
        chapter = ChapterId.CHAPTER_2,
        questionText =
          "Bonus penjualan Tim A adalah A(x) = 20.000x + 50.000 dan Tim B adalah B(x) = 15.000x + 30.000. Jika keduanya mencapai x = 4 target, total bonus gabungan (A + B)(4) adalah...",
        options =
          listOf("Rp180.000", "Rp200.000", "Rp220.000", "Rp240.000", "Rp260.000"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "A(x) = 20.000x + 50.000\nB(x) = 15.000x + 30.000\nx = 4",
            rumusUtama = "(A + B)(x) = 35.000x + 80.000",
            langkahLangkah =
              listOf(
                "Step 1: Jumlahkan fungsi A(x) + B(x) = (20.000 + 15.000)x + (50.000 + 30.000) = 35.000x + 80.000.",
                "Step 2: Substitusi x = 4 → 35.000 × 4 = 140.000.",
                "Step 3: Tambahkan 80.000 → 140.000 + 80.000 = Rp220.000.",
              ),
            tipsManga = "Kamu bisa cek juga: A(4) = 130.000 dan B(4) = 90.000 → 130.000 + 90.000 = 220.000.",
          ),
      ),
    )
}
