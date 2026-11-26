package com.example.data

import com.example.model.ChapterId
import com.example.model.MathQuestion
import com.example.model.StepByStepExplanation

object Chapter1Questions {
  val questions: List<MathQuestion> =
    listOf(
      MathQuestion(
        id = "ch1_01",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Sebuah toko alat tulis menjual buku tulis dengan harga Rp5.000,00 per buah. Jika banyak buku yang dibeli dinyatakan dengan x dan total harga dinyatakan dengan f(x), fungsi yang tepat untuk menggambarkan hubungan tersebut adalah...",
        options =
          listOf(
            "f(x) = x + 5.000",
            "f(x) = 5.000x",
            "f(x) = 5.000 - x",
            "f(x) = x - 5.000",
            "f(x) = 5.000 + x²",
          ),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "Harga 1 buku tulis = Rp5.000,00\nBanyak buku = x\nTotal harga = f(x)",
            rumusUtama = "Total Harga = Harga per Buah × Banyak Buku",
            langkahLangkah =
              listOf(
                "Step 1: Setiap pembelian 1 buku membayar Rp5.000, jika 2 buku membayar 5.000 × 2.",
                "Step 2: Untuk x buku, total harga adalah 5.000 dikalikan x.",
                "Step 3: Diperoleh fungsi f(x) = 5.000x.",
              ),
            tipsManga = "Kata 'per buah' menandakan perkalian langsung terhadap variabel x!",
          ),
      ),
      MathQuestion(
        id = "ch1_02",
        chapter = ChapterId.CHAPTER_1,
        questionText = "Diketahui fungsi f(x) = 3x + 5. Nilai f(4) adalah...",
        options = listOf("12", "15", "17", "19", "20"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x + 5\nx = 4",
            rumusUtama = "f(4) = 3(4) + 5",
            langkahLangkah =
              listOf(
                "Step 1: Ganti setiap huruf x pada rumus f(x) dengan angka 4.",
                "Step 2: Hitung perkalian terlebih dahulu: 3 × 4 = 12.",
                "Step 3: Jumlahkan dengan konstanta: 12 + 5 = 17.",
              ),
            tipsManga = "Selalu dahulukan perkalian sebelum penjumlahan saat substitusi nilai x.",
          ),
      ),
      MathQuestion(
        id = "ch1_03",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Sebuah ojek online menetapkan tarif awal Rp7.000,00 dan tarif tambahan Rp3.000,00 setiap kilometer. Jika jarak perjalanan adalah x kilometer, fungsi biaya perjalanan adalah...",
        options =
          listOf(
            "f(x) = 7.000x + 3.000",
            "f(x) = 3.000x + 7.000",
            "f(x) = 10.000x",
            "f(x) = 7.000 - 3.000x",
            "f(x) = 3.000 - 7.000x",
          ),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "Tarif awal (tetap) = Rp7.000,00\nTarif per km = Rp3.000,00\nJarak = x km",
            rumusUtama = "f(x) = (Tarif per km × x) + Tarif Awal",
            langkahLangkah =
              listOf(
                "Step 1: Tarif awal Rp7.000,00 dibayar satu kali (menjadi konstanta tanpa x).",
                "Step 2: Tarif tambahan Rp3.000,00 dikalikan jarak x menjadi 3.000x.",
                "Step 3: Gabungkan menjadi f(x) = 3.000x + 7.000.",
              ),
            tipsManga = "Jangan tertukar! Biaya yang bergantung pada jarak (per km) selalu menempel pada x.",
          ),
      ),
      MathQuestion(
        id = "ch1_04",
        chapter = ChapterId.CHAPTER_1,
        questionText = "Diketahui f(x) = 2x² - 3x + 1. Nilai f(2) adalah...",
        options = listOf("1", "2", "3", "4", "5"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x² - 3x + 1\nx = 2",
            rumusUtama = "f(2) = 2(2)² - 3(2) + 1",
            langkahLangkah =
              listOf(
                "Step 1: Hitung pangkat lebih dulu: 2² = 4, lalu kalikan 2 → 2 × 4 = 8.",
                "Step 2: Hitung suku tengah: 3 × 2 = 6.",
                "Step 3: Gabungkan seluruhnya: 8 - 6 + 1 = 3.",
              ),
            tipsManga = "Ingat urutan sakti: Kuadratkan dulu x-nya, baru dikali koefisien di depannya!",
          ),
      ),
      MathQuestion(
        id = "ch1_05",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Suatu mesin mengubah bilangan masukan dengan aturan setiap bilangan dikalikan 4 kemudian dikurang 2. Jika masukan mesin adalah 6, hasil keluarannya adalah...",
        options = listOf("18", "20", "22", "24", "26"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "Aturan mesin: f(x) = 4x - 2\nMasukan x = 6",
            rumusUtama = "f(6) = 4(6) - 2",
            langkahLangkah =
              listOf(
                "Step 1: Ubah kalimat aturan mesin ke bentuk aljabar: f(x) = 4x - 2.",
                "Step 2: Masukkan nilai x = 6 → 4 × 6 = 24.",
                "Step 3: Kurangkan dengan 2 → 24 - 2 = 22.",
              ),
            tipsManga = "Ikuti alur mesin dari kiri ke kanan: kali 4 dulu, lalu kurangi 2.",
          ),
      ),
      MathQuestion(
        id = "ch1_06",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Sebuah perusahaan mencatat keuntungan dengan fungsi f(x) = 50.000x - 200.000, dengan x menyatakan jumlah produk yang terjual. Jika perusahaan berhasil menjual 10 produk, keuntungan yang diperoleh adalah...",
        options =
          listOf(
            "Rp200.000,00",
            "Rp250.000,00",
            "Rp300.000,00",
            "Rp350.000,00",
            "Rp400.000,00",
          ),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 50.000x - 200.000\nJumlah produk terjual x = 10",
            rumusUtama = "f(10) = 50.000(10) - 200.000",
            langkahLangkah =
              listOf(
                "Step 1: Substitusi x = 10 ke fungsi keuntungan.",
                "Step 2: Hitung hasil penjualan: 50.000 × 10 = 500.000.",
                "Step 3: Kurangi biaya tetap 200.000 → 500.000 - 200.000 = Rp300.000,00.",
              ),
            tipsManga = "Cek jumlah nol dengan teliti: 50 ribu × 10 = 500 ribu.",
          ),
      ),
      MathQuestion(
        id = "ch1_07",
        chapter = ChapterId.CHAPTER_1,
        questionText = "Diketahui fungsi f(x) = 3x - 6. Jika f(a) = 18, nilai a adalah...",
        options = listOf("4", "5", "6", "7", "8"),
        correctIndex = 4,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 3x - 6\nf(a) = 18",
            rumusUtama = "3a - 6 = 18",
            langkahLangkah =
              listOf(
                "Step 1: Ganti x menjadi a sehingga f(a) = 3a - 6 = 18.",
                "Step 2: Pindah ruaskan -6 ke kanan menjadi +6 → 3a = 18 + 6 = 24.",
                "Step 3: Bagi kedua ruas dengan 3 → a = [[frac:24|3]] = 8.",
              ),
            tipsManga = "Jika hasil f(a) sudah diketahui, tugas kita membalik persamaan untuk mencari a!",
          ),
      ),
      MathQuestion(
        id = "ch1_08",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Sebuah fungsi dinyatakan dengan f(x) = x² + 2x. Jika domain fungsi adalah {4}, range fungsi tersebut adalah...",
        options = listOf("{16}", "{12}", "{24}", "{8}", "{4}"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² + 2x\nDomain = {4}",
            rumusUtama = "Range = {f(4)} = 4² + 2(4)",
            langkahLangkah =
              listOf(
                "Step 1: Masukkan anggota domain x = 4 ke dalam fungsi.",
                "Step 2: Hitung 4² = 16 dan 2 × 4 = 8.",
                "Step 3: Jumlahkan hasilnya: 16 + 8 = 24, sehingga rangenya {24}.",
              ),
            tipsManga = "Domain adalah himpunan masukan (x), sedangkan Range adalah himpunan hasil f(x).",
          ),
      ),
      MathQuestion(
        id = "ch1_09",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Dalam suatu kegiatan praktikum, suhu air setelah dipanaskan dimodelkan dengan fungsi f(t) = 25 + 5t, dengan t adalah waktu dalam menit dan f(t) suhu dalam derajat Celcius. Suhu air setelah 8 menit adalah...",
        options = listOf("55°C", "60°C", "65°C", "70°C", "75°C"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(t) = 25 + 5t\nWaktu t = 8 menit",
            rumusUtama = "f(8) = 25 + 5(8)",
            langkahLangkah =
              listOf(
                "Step 1: Substitusi t = 8 ke fungsi suhu f(t).",
                "Step 2: Kalikan laju kenaikan suhu: 5 × 8 = 40°C.",
                "Step 3: Tambahkan suhu awal 25°C → 25 + 40 = 65°C.",
              ),
            tipsManga = "Angka 25 berarti suhu awal air sebelum dipanaskan (saat t = 0).",
          ),
      ),
      MathQuestion(
        id = "ch1_10",
        chapter = ChapterId.CHAPTER_1,
        questionText = "Diketahui fungsi kuadrat f(x) = x² - 4x + 3. Nilai f(5) adalah...",
        options = listOf("2", "4", "6", "8", "10"),
        correctIndex = 3,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² - 4x + 3\nx = 5",
            rumusUtama = "f(5) = 5² - 4(5) + 3",
            langkahLangkah =
              listOf(
                "Step 1: Hitung 5² = 25.",
                "Step 2: Hitung 4 × 5 = 20.",
                "Step 3: Kurangkan lalu tambah: 25 - 20 + 3 = 8.",
              ),
            tipsManga = "Perhatikan tanda negatif di depan 4x agar tidak salah menjumlahkan.",
          ),
      ),
      MathQuestion(
        id = "ch1_11",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Sebuah toko kue menjual donat seharga Rp4.500,00 per buah dengan biaya kotak kemasan Rp3.000,00. Jika seseorang membeli x buah donat dalam satu kotak, fungsi total harganya adalah...",
        options =
          listOf(
            "f(x) = 4.500x + 3.000",
            "f(x) = 3.000x + 4.500",
            "f(x) = 7.500x",
            "f(x) = 4.500x - 3.000",
            "f(x) = 4.500 + 3.000",
          ),
        correctIndex = 0,
        explanation =
          StepByStepExplanation(
            diketahui = "Harga 1 donat = Rp4.500\nBiaya 1 kotak = Rp3.000\nJumlah donat = x",
            rumusUtama = "f(x) = Harga Satuan × x + Biaya Kotak",
            langkahLangkah =
              listOf(
                "Step 1: Harga x buah donat adalah 4.500x.",
                "Step 2: Tambahan biaya 1 kotak kemasan adalah +3.000.",
                "Step 3: Jadi f(x) = 4.500x + 3.000.",
              ),
            tipsManga = "Biaya sekali bayar seperti kemasan atau ongkir tetap menjadi konstanta.",
          ),
      ),
      MathQuestion(
        id = "ch1_12",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Tarif taksi bandara mematok biaya buka pintu Rp10.000,00 ditambah Rp4.000,00 tiap kilometer. Total biaya untuk perjalanan sejauh 12 km adalah...",
        options =
          listOf("Rp46.000", "Rp48.000", "Rp54.000", "Rp58.000", "Rp62.000"),
        correctIndex = 3,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 4.000x + 10.000\nJarak x = 12 km",
            rumusUtama = "f(12) = 4.000(12) + 10.000",
            langkahLangkah =
              listOf(
                "Step 1: Susun model tarif: f(x) = 4.000x + 10.000.",
                "Step 2: Hitung tarif jarak: 4.000 × 12 = 48.000.",
                "Step 3: Tambah biaya buka pintu: 48.000 + 10.000 = Rp58.000.",
              ),
            tipsManga = "Selalu hitung biaya per km dulu sebelum menambahkan tarif buka pintu.",
          ),
      ),
      MathQuestion(
        id = "ch1_13",
        chapter = ChapterId.CHAPTER_1,
        questionText = "Diketahui f(x) = 5x + 7. Jika f(k) = 32, maka nilai k adalah...",
        options = listOf("4", "5", "6", "7", "8"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 5x + 7\nf(k) = 32",
            rumusUtama = "5k + 7 = 32",
            langkahLangkah =
              listOf(
                "Step 1: Ubah x menjadi k → 5k + 7 = 32.",
                "Step 2: Kurangi 7 di kedua sisi → 5k = 32 - 7 = 25.",
                "Step 3: Bagi dengan 5 → k = [[frac:25|5]] = 5.",
              ),
            tipsManga = "Uji balik jawabanmu: 5(5) + 7 = 25 + 7 = 32. Cocok!",
          ),
      ),
      MathQuestion(
        id = "ch1_14",
        chapter = ChapterId.CHAPTER_1,
        questionText = "Jika f(x) = x² - 5x + 6, maka nilai f(-2) adalah...",
        options = listOf("0", "4", "12", "16", "20"),
        correctIndex = 4,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = x² - 5x + 6\nx = -2",
            rumusUtama = "f(-2) = (-2)² - 5(-2) + 6",
            langkahLangkah =
              listOf(
                "Step 1: Kuadrat bilangan negatif menjadi positif: (-2)² = 4.",
                "Step 2: Negatif dikali negatif menjadi positif: -5 × (-2) = +10.",
                "Step 3: Jumlahkan semua suku: 4 + 10 + 6 = 20.",
              ),
            tipsManga = "Gunakan tanda kurung (-2)² saat memasukkan bilangan negatif agar tidak salah tanda!",
          ),
      ),
      MathQuestion(
        id = "ch1_15",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Diketahui fungsi f(x) = 2x - 1 dengan domain {1, 2, 3}. Range dari fungsi tersebut adalah...",
        options = listOf("{0, 2, 4}", "{1, 2, 3}", "{1, 3, 5}", "{2, 4, 6}", "{3, 5, 7}"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = 2x - 1\nDomain = {1, 2, 3}",
            rumusUtama = "Range = {f(1), f(2), f(3)}",
            langkahLangkah =
              listOf(
                "Step 1: Untuk x = 1 → f(1) = 2(1) - 1 = 1.",
                "Step 2: Untuk x = 2 → f(2) = 2(2) - 1 = 3.",
                "Step 3: Untuk x = 3 → f(3) = 2(3) - 1 = 5. Jadi range = {1, 3, 5}.",
              ),
            tipsManga = "Hitung satu per satu anggota domain secara berurutan.",
          ),
      ),
      MathQuestion(
        id = "ch1_16",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Suatu mesin bilangan mengkuadratkan bilangan masukan lalu menambahkannya dengan 5. Jika masukannya -3, hasilnya adalah...",
        options = listOf("-4", "14", "11", "4", "-14"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "Aturan mesin: f(x) = x² + 5\nMasukan x = -3",
            rumusUtama = "f(-3) = (-3)² + 5",
            langkahLangkah =
              listOf(
                "Step 1: Ubah aturan menjadi f(x) = x² + 5.",
                "Step 2: Kuadratkan masukan -3 → (-3)² = 9.",
                "Step 3: Tambahkan 5 → 9 + 5 = 14.",
              ),
            tipsManga = "Bilangan negatif yang dikuadratkan hasilnya selalu positif!",
          ),
      ),
      MathQuestion(
        id = "ch1_17",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Paket internet pascabayar mengenakan biaya langganan Rp20.000,00 per bulan dan Rp2.000,00 per GB pemakaian. Jika bulan ini terpakai 15 GB, total tagihannya adalah...",
        options =
          listOf("Rp35.000", "Rp40.000", "Rp45.000", "Rp50.000", "Rp55.000"),
        correctIndex = 3,
        explanation =
          StepByStepExplanation(
            diketahui = "Biaya tetap = Rp20.000\nTarif per GB = Rp2.000\nPemakaian x = 15 GB",
            rumusUtama = "f(15) = 2.000(15) + 20.000",
            langkahLangkah =
              listOf(
                "Step 1: Hitung biaya kuota: 2.000 × 15 = 30.000.",
                "Step 2: Tambahkan biaya langganan tetap: 30.000 + 20.000.",
                "Step 3: Total tagihan bulan ini = Rp50.000.",
              ),
            tipsManga = "Model fungsi linear sangat sering dipakai pada soal tagihan listrik, air, dan internet.",
          ),
      ),
      MathQuestion(
        id = "ch1_18",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Diketahui fungsi linear f(x) = ax + b. Jika f(1) = 7 dan f(3) = 13, maka nilai f(5) adalah...",
        options = listOf("15", "17", "19", "21", "23"),
        correctIndex = 2,
        explanation =
          StepByStepExplanation(
            diketahui = "f(x) = ax + b\nf(1) = 7 → a + b = 7\nf(3) = 13 → 3a + b = 13",
            rumusUtama = "Eliminasi: (3a + b) - (a + b) = 13 - 7",
            langkahLangkah =
              listOf(
                "Step 1: Kurangkan kedua persamaan: 2a = 6 → a = 3.",
                "Step 2: Substitusi a = 3 ke a + b = 7 → 3 + b = 7 → b = 4.",
                "Step 3: Jadi f(x) = 3x + 4, sehingga f(5) = 3(5) + 4 = 19.",
              ),
            tipsManga = "Trik cepat fungsi linear: selisih x adalah 2 dan selisih y adalah 6, jadi setiap x naik 2, hasil naik 6!",
          ),
      ),
      MathQuestion(
        id = "ch1_19",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Tinggi roket air setelah t detik dirumuskan h(t) = 20t - 5t² (dalam meter). Tinggi roket saat t = 2 detik adalah...",
        options = listOf("15 m", "20 m", "25 m", "30 m", "35 m"),
        correctIndex = 1,
        explanation =
          StepByStepExplanation(
            diketahui = "h(t) = 20t - 5t²\nWaktu t = 2 detik",
            rumusUtama = "h(2) = 20(2) - 5(2)²",
            langkahLangkah =
              listOf(
                "Step 1: Hitung suku pertama: 20 × 2 = 40.",
                "Step 2: Hitung suku kedua: 5 × 2² = 5 × 4 = 20.",
                "Step 3: Kurangkan hasilnya: 40 - 20 = 20 meter.",
              ),
            tipsManga = "Jangan kalikan 5 × 2 lalu dikuadratkan! Kuadratkan 2 terlebih dahulu menjadi 4.",
          ),
      ),
      MathQuestion(
        id = "ch1_20",
        chapter = ChapterId.CHAPTER_1,
        questionText =
          "Tempat sewa komik manga mengenakan biaya anggota Rp15.000,00 ditambah biaya sewa Rp2.500,00 per volume. Jika Raka menyewa 6 volume komik, total biaya yang dibayar adalah...",
        options =
          listOf("Rp25.000", "Rp27.500", "Rp29.000", "Rp30.000", "Rp32.500"),
        correctIndex = 3,
        explanation =
          StepByStepExplanation(
            diketahui = "Biaya anggota = Rp15.000\nSewa per volume = Rp2.500\nBanyak volume x = 6",
            rumusUtama = "f(6) = 2.500(6) + 15.000",
            langkahLangkah =
              listOf(
                "Step 1: Hitung biaya sewa 6 volume: 2.500 × 6 = 15.000.",
                "Step 2: Tambahkan biaya anggota Rp15.000.",
                "Step 3: Total biaya = 15.000 + 15.000 = Rp30.000.",
              ),
            tipsManga = "Total biaya selalu penjumlahan dari biaya tetap dan biaya variabel.",
          ),
      ),
    )
}
