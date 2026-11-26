package com.example.data

import com.example.model.ChapterId
import com.example.model.CircleDiagramSpec
import com.example.model.CircleHighlightMode
import com.example.model.MathQuestion
import com.example.model.StepByStepExplanation

object Chapter5Questions {
  val questions: List<MathQuestion> =
    listOf(
      MathQuestion(
        id = "ch5_01",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah taman berbentuk lingkaran memiliki jari-jari 7 meter. Luas taman tersebut adalah... (gunakan π = [[frac:22|7]])",
        options = listOf("144 m²", "154 m²", "164 m²", "174 m²", "184 m²"),
        correctIndex = 1,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 7.0,
            isDiameterGiven = false,
            centralAngleDeg = 360.0,
            unit = "m",
            highlightMode = CircleHighlightMode.AREA,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "r = 7 meter\nπ = [[frac:22|7]]",
            rumusUtama = "Luas = π × r²",
            langkahLangkah =
              listOf(
                "Step 1: Masukkan nilai ke rumus: L = [[frac:22|7]] × 7 × 7.",
                "Step 2: Coret satu angka 7 dengan penyebut 7 → [[frac:7|7]] = 1.",
                "Step 3: Kalikan sisanya: 22 × 7 = 154 m².",
              ),
            tipsManga = "Jika jari-jari kelipatan 7, selalu gunakan π = 22/7 agar bisa dicoret bersih!",
          ),
      ),
      MathQuestion(
        id = "ch5_02",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah roda sepeda memiliki diameter 70 cm. Keliling roda tersebut adalah... (gunakan π = [[frac:22|7]])",
        options = listOf("110 cm", "120 cm", "210 cm", "220 cm", "240 cm"),
        correctIndex = 3,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 35.0,
            isDiameterGiven = true,
            centralAngleDeg = 360.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.CIRCUMFERENCE,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "Diameter d = 70 cm (atau r = 35 cm)\nπ = [[frac:22|7]]",
            rumusUtama = "Keliling = π × d",
            langkahLangkah =
              listOf(
                "Step 1: Substitusi d = 70 ke rumus keliling: K = [[frac:22|7]] × 70.",
                "Step 2: Coret 70 dengan 7 → [[frac:70|7]] = 10.",
                "Step 3: Kalikan sisanya: 22 × 10 = 220 cm.",
              ),
            tipsManga = "Jika yang diketahui DIAMETER, rumus K = π × d lebih praktis daripada 2 × π × r!",
          ),
      ),
      MathQuestion(
        id = "ch5_03",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah meja berbentuk lingkaran memiliki jari-jari 14 cm. Luas meja tersebut adalah... (Gunakan π = [[frac:22|7]])",
        options = listOf("308 cm²", "462 cm²", "616 cm²", "624 cm²", "716 cm²"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 14.0,
            isDiameterGiven = false,
            centralAngleDeg = 360.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.AREA,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "Jari-jari r = 14 cm\nπ = [[frac:22|7]]",
            rumusUtama = "Luas = π × r × r",
            langkahLangkah =
              listOf(
                "Step 1: Masukkan r = 14 → L = [[frac:22|7]] × 14 × 14.",
                "Step 2: Coret 14 dengan 7 → [[frac:14|7]] = 2.",
                "Step 3: Kalikan 22 × 2 × 14 = 44 × 14 = 616 cm².",
              ),
            tipsManga = "Hafalkan pasangan sakti: r = 7 → L = 154; r = 14 → L = 616 (4 kali lipat)!",
          ),
      ),
      MathQuestion(
        id = "ch5_04",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah pizza berbentuk lingkaran dipotong menjadi 8 bagian sama besar. Besar sudut pusat setiap potongan pizza adalah...",
        options = listOf("30°", "40°", "45°", "60°", "90°"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 14.0,
            isDiameterGiven = false,
            centralAngleDeg = 45.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.SECTOR,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "Sudut 1 lingkaran penuh = 360°\nBanyak potongan = 8 bagian sama besar",
            rumusUtama = "Sudut Pusat = [[frac:360°|Banyak Potongan]]",
            langkahLangkah =
              listOf(
                "Step 1: Satu lingkaran utuh memiliki sudut pusat total 360°.",
                "Step 2: Bagi 360° dengan 8 potongan: [[frac:360°|8]].",
                "Step 3: 360 ÷ 8 = 45°.",
              ),
            tipsManga = "1/4 pizza = 90°, maka 1/8 pizza adalah setengah dari 90° yaitu 45°!",
          ),
      ),
      MathQuestion(
        id = "ch5_05",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah taman berbentuk lingkaran mempunyai diameter 28 meter. Panjang pagar yang diperlukan untuk mengelilingi taman tersebut adalah... (Gunakan π = [[frac:22|7]])",
        options =
          listOf("66 meter", "77 meter", "88 meter", "98 meter", "112 meter"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 14.0,
            isDiameterGiven = true,
            centralAngleDeg = 360.0,
            unit = "m",
            highlightMode = CircleHighlightMode.CIRCUMFERENCE,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "Diameter d = 28 meter\nπ = [[frac:22|7]]",
            rumusUtama = "Panjang Pagar = Keliling = π × d",
            langkahLangkah =
              listOf(
                "Step 1: Panjang pagar mengelilingi taman sama dengan keliling lingkaran.",
                "Step 2: K = [[frac:22|7]] × 28, lalu coret [[frac:28|7]] = 4.",
                "Step 3: Kalikan 22 × 4 = 88 meter.",
              ),
            tipsManga = "Kata 'mengelilingi' atau 'pagar di tepi' adalah petunjuk mencari KELILING, bukan luas.",
          ),
      ),
      MathQuestion(
        id = "ch5_06",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Diketahui sebuah lingkaran berjari-jari 14 cm dengan sudut pusat α = 90°. Panjang busur lingkaran tersebut adalah... (π = [[frac:22|7]])",
        options = listOf("11 cm", "22 cm", "33 cm", "44 cm", "88 cm"),
        correctIndex = 1,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 14.0,
            isDiameterGiven = false,
            centralAngleDeg = 90.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "α = 90°\nr = 14 cm\nπ = [[frac:22|7]]",
            rumusUtama = "Panjang Busur = [[frac:α|360°]] × 2 × π × r",
            langkahLangkah =
              listOf(
                "Step 1: Susun pecahan: [[frac:90°|360°]] × 2 × [[frac:22|7]] × 14.",
                "Step 2: Coret sudut [[frac:90°|360°]] = [[frac:1|4]], dan coret jari-jari [[frac:14|7]] = 2.",
                "Step 3: Hitung sisanya: [[frac:1|4]] × 2 × 22 × 2 = [[frac:1|4]] × 88 = 22 cm.",
              ),
            tipsManga = "Coret sudut dengan 360° dan jari-jari dengan 7 sekaligus agar hitungan mengecil drastis!",
          ),
      ),
      MathQuestion(
        id = "ch5_07",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah juring lingkaran memiliki jari-jari 21 cm dan sudut pusat 120°. Panjang busur di depan sudut pusat tersebut adalah... (π = [[frac:22|7]])",
        options = listOf("22 cm", "33 cm", "44 cm", "55 cm", "66 cm"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 21.0,
            isDiameterGiven = false,
            centralAngleDeg = 120.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "α = 120°\nr = 21 cm\nπ = [[frac:22|7]]",
            rumusUtama = "Panjang Busur = [[frac:α|360°]] × 2 × π × r",
            langkahLangkah =
              listOf(
                "Step 1: Masukkan angka: [[frac:120°|360°]] × 2 × [[frac:22|7]] × 21.",
                "Step 2: Coret [[frac:120°|360°]] = [[frac:1|3]] dan [[frac:21|7]] = 3.",
                "Step 3: [[frac:1|3]] × 2 × 22 × 3 → coret 3 dengan 3, tersisa 2 × 22 = 44 cm.",
              ),
            tipsManga = "Perhatikan pencoretan silang 3 dari 1/3 dan 3 dari 21/7!",
          ),
      ),
      MathQuestion(
        id = "ch5_08",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah lingkaran memiliki diameter 28 cm dan sudut pusat 45°. Panjang busurnya adalah... (π = [[frac:22|7]])",
        options = listOf("11 cm", "14 cm", "22 cm", "33 cm", "44 cm"),
        correctIndex = 0,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 14.0,
            isDiameterGiven = true,
            centralAngleDeg = 45.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "d = 28 cm → r = 14 cm\nα = 45°\nπ = [[frac:22|7]]",
            rumusUtama = "Panjang Busur = [[frac:α|360°]] × π × d",
            langkahLangkah =
              listOf(
                "Step 1: Sederhanakan sudut [[frac:45°|360°]] = [[frac:1|8]].",
                "Step 2: Hitung keliling penuh: [[frac:22|7]] × 28 = 22 × 4 = 88 cm.",
                "Step 3: Kalikan [[frac:1|8]] × 88 = 11 cm.",
              ),
            tipsManga = "Jika diameter d yang diketahui, pakai langsung [[frac:α|360°]] × π × d!",
          ),
      ),
      MathQuestion(
        id = "ch5_09",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah lingkaran memiliki jari-jari 21 cm dan sudut pusat 60°. Panjang busurnya adalah... (π = [[frac:22|7]])",
        options = listOf("11 cm", "21 cm", "22 cm", "33 cm", "44 cm"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 21.0,
            isDiameterGiven = false,
            centralAngleDeg = 60.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "α = 60°, r = 21 cm, π = [[frac:22|7]]",
            rumusUtama = "Panjang Busur = [[frac:60°|360°]] × 2 × [[frac:22|7]] × 21",
            langkahLangkah =
              listOf(
                "Step 1: Coret [[frac:60°|360°]] = [[frac:1|6]].",
                "Step 2: Coret [[frac:21|7]] = 3.",
                "Step 3: Hitung [[frac:1|6]] × 2 × 22 × 3 = [[frac:1|6]] × 6 × 22 = 22 cm.",
              ),
            tipsManga = "2 × 3 = 6 langsung mencoret penyebut 6 dari 1/6!",
          ),
      ),
      MathQuestion(
        id = "ch5_10",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Panjang busur AB pada lingkaran berjari-jari 14 cm dengan sudut pusat 180° adalah... (π = [[frac:22|7]])",
        options = listOf("22 cm", "44 cm", "66 cm", "88 cm", "154 cm"),
        correctIndex = 1,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 14.0,
            isDiameterGiven = false,
            centralAngleDeg = 180.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "α = 180° (setengah lingkaran)\nr = 14 cm",
            rumusUtama = "Panjang Busur = [[frac:180°|360°]] × 2 × π × r",
            langkahLangkah =
              listOf(
                "Step 1: Coret [[frac:180°|360°]] = [[frac:1|2]].",
                "Step 2: Coret [[frac:14|7]] = 2.",
                "Step 3: [[frac:1|2]] × 2 × 22 × 2 = 44 cm.",
              ),
            tipsManga = "Sudut 180° berarti setengah keliling lingkaran penuh!",
          ),
      ),
      MathQuestion(
        id = "ch5_11",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Diketahui keliling sebuah lingkaran adalah 132 cm. Panjang jari-jari lingkaran tersebut adalah... (π = [[frac:22|7]])",
        options = listOf("7 cm", "14 cm", "21 cm", "28 cm", "42 cm"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 21.0,
            isDiameterGiven = false,
            centralAngleDeg = 360.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.CIRCUMFERENCE,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "Keliling K = 132 cm\nπ = [[frac:22|7]]",
            rumusUtama = "K = 2 × π × r",
            langkahLangkah =
              listOf(
                "Step 1: 132 = 2 × [[frac:22|7]] × r = [[frac:44|7]] × r.",
                "Step 2: r = 132 × [[frac:7|44]].",
                "Step 3: Coret [[frac:132|44]] = 3, sehingga r = 3 × 7 = 21 cm.",
              ),
            tipsManga = "Ingat 44 × 3 = 132! Sangat sering muncul di soal lingkaran.",
          ),
      ),
      MathQuestion(
        id = "ch5_12",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah roda berjari-jari 35 cm berputar penuh sebanyak 10 kali. Jarak tempuh roda tersebut adalah... (π = [[frac:22|7]])",
        options = listOf("11 meter", "22 meter", "33 meter", "44 meter", "220 meter"),
        correctIndex = 1,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 35.0,
            isDiameterGiven = false,
            centralAngleDeg = 360.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.CIRCUMFERENCE,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "r = 35 cm\nJumlah putaran n = 10\nπ = [[frac:22|7]]",
            rumusUtama = "Jarak = n × (2 × π × r)",
            langkahLangkah =
              listOf(
                "Step 1: Hitung keliling 1 putaran: K = 2 × [[frac:22|7]] × 35 = 2 × 22 × 5 = 220 cm.",
                "Step 2: Kalikan 10 putaran: 10 × 220 cm = 2.200 cm.",
                "Step 3: Ubah ke meter (bagi 100): 2.200 cm = 22 meter.",
              ),
            tipsManga = "Perhatikan satuan pada pilihan jawaban (cm atau meter) sebelum memilih!",
          ),
      ),
      MathQuestion(
        id = "ch5_13",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah lingkaran memiliki jari-jari 10 cm. Luas lingkaran tersebut adalah... (gunakan π = 3,14)",
        options = listOf("31,4 cm²", "62,8 cm²", "157 cm²", "314 cm²", "628 cm²"),
        correctIndex = 3,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 10.0,
            isDiameterGiven = false,
            centralAngleDeg = 360.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.AREA,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "r = 10 cm\nπ = 3,14",
            rumusUtama = "Luas = π × r²",
            langkahLangkah =
              listOf(
                "Step 1: Hitung r² = 10² = 100.",
                "Step 2: Kalikan dengan 3,14 → 3,14 × 100.",
                "Step 3: Geser koma 2 langkah ke kanan → 314 cm².",
              ),
            tipsManga = "Jika r kelipatan 10 (bukan 7), π = 3,14 membuat koma langsung hilang!",
          ),
      ),
      MathQuestion(
        id = "ch5_14",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Luas juring lingkaran dengan sudut pusat 90° dan jari-jari 14 cm adalah... (π = [[frac:22|7]])",
        options = listOf("77 cm²", "154 cm²", "308 cm²", "462 cm²", "616 cm²"),
        correctIndex = 1,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 14.0,
            isDiameterGiven = false,
            centralAngleDeg = 90.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.SECTOR,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "α = 90°\nr = 14 cm\nπ = [[frac:22|7]]",
            rumusUtama = "Luas Juring = [[frac:α|360°]] × π × r²",
            langkahLangkah =
              listOf(
                "Step 1: Coret [[frac:90°|360°]] = [[frac:1|4]].",
                "Step 2: Hitung luas penuh: [[frac:22|7]] × 14 × 14 = 44 × 14 = 616 cm².",
                "Step 3: Kalikan [[frac:1|4]] × 616 = 154 cm².",
              ),
            tipsManga = "Bedakan Panjang Busur (pakai keliling 2πr) vs Luas Juring (pakai luas πr²)!",
          ),
      ),
      MathQuestion(
        id = "ch5_15",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Panjang busur sebuah lingkaran adalah 22 cm. Jika sudut pusatnya 60°, maka jari-jari lingkaran tersebut adalah... (π = [[frac:22|7]])",
        options = listOf("7 cm", "14 cm", "21 cm", "28 cm", "35 cm"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 21.0,
            isDiameterGiven = false,
            centralAngleDeg = 60.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "Panjang Busur = 22 cm\nα = 60°\nπ = [[frac:22|7]]",
            rumusUtama = "22 = [[frac:60°|360°]] × 2 × [[frac:22|7]] × r",
            langkahLangkah =
              listOf(
                "Step 1: Coret [[frac:60°|360°]] = [[frac:1|6]], lalu [[frac:1|6]] × 2 = [[frac:1|3]].",
                "Step 2: Persamaan menjadi 22 = [[frac:1|3]] × [[frac:22|7]] × r = [[frac:22|21]] × r.",
                "Step 3: Coret 22 di kedua ruas → 1 = [[frac:r|21]] → r = 21 cm.",
              ),
            tipsManga = "Coret angka 22 di kiri dan kanan persamaan supaya langsung ketemu r!",
          ),
      ),
      MathQuestion(
        id = "ch5_16",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah kue tart lingkaran dipotong menjadi 6 bagian sama besar. Jika jari-jari kue 21 cm, panjang pinggiran busur tiap potongannya adalah... (π = [[frac:22|7]])",
        options = listOf("11 cm", "22 cm", "33 cm", "44 cm", "66 cm"),
        correctIndex = 1,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 21.0,
            isDiameterGiven = false,
            centralAngleDeg = 60.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "6 bagian sama besar → α = [[frac:360°|6]] = 60°\nr = 21 cm",
            rumusUtama = "Panjang Busur = [[frac:1|6]] × 2 × [[frac:22|7]] × 21",
            langkahLangkah =
              listOf(
                "Step 1: Bagian kue adalah [[frac:1|6]] lingkaran.",
                "Step 2: Hitung keliling penuh: 2 × [[frac:22|7]] × 21 = 2 × 22 × 3 = 132 cm.",
                "Step 3: Bagi 6 → [[frac:132|6]] = 22 cm.",
              ),
            tipsManga = "Jika sudah tahu pecahannya 1/6, bisa langsung 1/6 × Keliling tanpa hitung derajatnya!",
          ),
      ),
      MathQuestion(
        id = "ch5_17",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah jam dinding memiliki jarum menit sepanjang 14 cm. Panjang lintasan ujung jarum menit selama 15 menit (sudut 90°) adalah... (π = [[frac:22|7]])",
        options = listOf("11 cm", "22 cm", "33 cm", "44 cm", "88 cm"),
        correctIndex = 1,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 14.0,
            isDiameterGiven = false,
            centralAngleDeg = 90.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "r = panjang jarum = 14 cm\n15 menit = [[frac:15|60]] = [[frac:1|4]] putaran (α = 90°)",
            rumusUtama = "Lintasan = [[frac:90°|360°]] × 2 × [[frac:22|7]] × 14",
            langkahLangkah =
              listOf(
                "Step 1: Coret [[frac:90°|360°]] = [[frac:1|4]] dan [[frac:14|7]] = 2.",
                "Step 2: Hitung [[frac:1|4]] × 2 × 22 × 2.",
                "Step 3: [[frac:1|4]] × 88 = 22 cm.",
              ),
            tipsManga = "Pada soal jam: setiap 5 menit = 30°, jadi 15 menit = 90°!",
          ),
      ),
      MathQuestion(
        id = "ch5_18",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Diketahui panjang busur sebuah lingkaran adalah 44 cm dengan jari-jari 21 cm. Besar sudut pusat α busur tersebut adalah... (π = [[frac:22|7]])",
        options = listOf("60°", "90°", "120°", "135°", "150°"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 21.0,
            isDiameterGiven = false,
            centralAngleDeg = 120.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "Panjang Busur = 44 cm\nr = 21 cm",
            rumusUtama = "[[frac:α|360°]] = [[frac:Panjang Busur|Keliling Lingkaran]]",
            langkahLangkah =
              listOf(
                "Step 1: Hitung keliling penuh: K = 2 × [[frac:22|7]] × 21 = 132 cm.",
                "Step 2: Bandingkan busur dengan keliling: [[frac:44|132]] = [[frac:1|3]].",
                "Step 3: α = [[frac:1|3]] × 360° = 120°.",
              ),
            tipsManga = "Perbandingan busur/keliling selalu sama dengan perbandingan sudut/360°!",
          ),
      ),
      MathQuestion(
        id = "ch5_19",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Sebuah lapangan berbentuk setengah lingkaran memiliki diameter 14 meter. Keliling pagar lapangan tersebut (termasuk garis diameternya) adalah... (π = [[frac:22|7]])",
        options =
          listOf("22 meter", "29 meter", "36 meter", "44 meter", "58 meter"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 7.0,
            isDiameterGiven = true,
            centralAngleDeg = 180.0,
            unit = "m",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "Setengah lingkaran, d = 14 m\nπ = [[frac:22|7]]",
            rumusUtama = "Keliling Setengah Lingkaran = ([[frac:1|2]] × π × d) + d",
            langkahLangkah =
              listOf(
                "Step 1: Hitung panjang sisi lengkung: [[frac:1|2]] × [[frac:22|7]] × 14 = 22 meter.",
                "Step 2: Tambahkan garis lurus penutup (diameter) = 14 meter.",
                "Step 3: Total keliling = 22 + 14 = 36 meter.",
              ),
            tipsManga = "Jebakan klasik! Keliling setengah lingkaran tertutup wajib ditambah diameternya!",
          ),
      ),
      MathQuestion(
        id = "ch5_20",
        chapter = ChapterId.CHAPTER_5,
        questionText =
          "Diketahui panjang busur dengan sudut pusat 72° pada sebuah lingkaran berjari-jari 35 cm adalah... (π = [[frac:22|7]])",
        options = listOf("22 cm", "33 cm", "44 cm", "55 cm", "66 cm"),
        correctIndex = 2,
        circleDiagram =
          CircleDiagramSpec(
            radiusValue = 35.0,
            isDiameterGiven = false,
            centralAngleDeg = 72.0,
            unit = "cm",
            highlightMode = CircleHighlightMode.ARC,
          ),
        explanation =
          StepByStepExplanation(
            diketahui = "α = 72°\nr = 35 cm\nπ = [[frac:22|7]]",
            rumusUtama = "Panjang Busur = [[frac:72°|360°]] × 2 × [[frac:22|7]] × 35",
            langkahLangkah =
              listOf(
                "Step 1: Coret sudut [[frac:72°|360°]] = [[frac:1|5]].",
                "Step 2: Coret jari-jari [[frac:35|7]] = 5.",
                "Step 3: Hitung [[frac:1|5]] × 2 × 22 × 5 → coret 5 dengan 5, hasil = 2 × 22 = 44 cm.",
              ),
            tipsManga = "Ingat 72° × 5 = 360°, jadi 72° adalah tepat 1/5 lingkaran!",
          ),
      ),
    )
}
