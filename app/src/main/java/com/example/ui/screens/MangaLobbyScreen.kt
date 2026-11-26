package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.ChapterId
import com.example.model.UserProgress
import com.example.ui.components.HalftonePaperBackground
import com.example.ui.components.MangaButton
import com.example.ui.components.MangaPanel
import com.example.ui.components.MangaTagBadge
import com.example.ui.theme.BangersFontFamily
import com.example.ui.theme.JetBrainsMonoFontFamily
import com.example.ui.theme.MangaCrimson
import com.example.ui.theme.MangaGold
import com.example.ui.theme.MangaGoldLight
import com.example.ui.theme.MangaInk
import com.example.ui.theme.MangaInkSoft
import com.example.ui.theme.MangaPaperAlt
import com.example.ui.theme.MangaSuccess
import com.example.ui.theme.MangaWhite

@Composable
fun MangaLobbyScreen(
  progress: UserProgress,
  onSelectChapter: (ChapterId) -> Unit,
  onOpenAiGenerator: () -> Unit,
  onOpenFormulaLab: () -> Unit,
  onResetProgress: () -> Unit,
) {
  var showResetDialog by remember { mutableStateOf(false) }

  Box(modifier = Modifier.fillMaxSize()) {
    HalftonePaperBackground()

    Column(
      modifier =
        Modifier.fillMaxSize()
          .safeDrawingPadding()
          .verticalScroll(rememberScrollState())
          .padding(horizontal = 16.dp, vertical = 14.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Column(
        modifier = Modifier.widthIn(max = 720.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
      ) {
        // Masthead Banner
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Column {
            Text(
              text = "MATHMASTER PRO",
              fontFamily = BangersFontFamily,
              fontSize = 32.sp,
              letterSpacing = 1.5.sp,
              color = MangaInk,
            )
            Text(
              text = "Lobi Utama • Pilih Bab Petualangan",
              style = MaterialTheme.typography.bodyMedium,
              color = MangaInkSoft,
            )
          }
          IconButton(
            onClick = { showResetDialog = true },
            modifier =
              Modifier.testTag("reset_progress_button")
                .background(MangaWhite, RoundedCornerShape(4.dp))
                .border(2.dp, MangaInk, RoundedCornerShape(4.dp)),
          ) {
            Icon(
              imageVector = Icons.Default.Refresh,
              contentDescription = "Atur ulang progres",
              tint = MangaInk,
            )
          }
        }

        // User Profile Manga Panel
        ProfileMangaPanel(progress = progress)

        // Special Modes: AI Generator + Formula Lab
        MangaPanel(
          modifier = Modifier.fillMaxWidth(),
          backgroundColor = MangaCrimson,
          contentPadding = PaddingValues(16.dp),
          onClick = onOpenAiGenerator,
          testTag = "ai_generator_card",
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
          ) {
            Box(
              modifier =
                Modifier.size(48.dp)
                  .background(MangaWhite, RoundedCornerShape(4.dp))
                  .border(2.dp, MangaInk, RoundedCornerShape(4.dp)),
              contentAlignment = Alignment.Center,
            ) {
              Icon(
                imageVector = Icons.Default.AutoAwesome,
                contentDescription = "Ikon AI Generator",
                tint = MangaCrimson,
                modifier = Modifier.size(28.dp),
              )
            }
            Column(modifier = Modifier.weight(1f)) {
              MangaTagBadge(
                text = "UNLIMITED OFFLINE",
                backgroundColor = MangaInk,
                textColor = MangaWhite,
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "AI Smart Question Generator",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MangaWhite,
              )
              Text(
                text = "Racik soal cerita & busur baru otomatis dengan pembahasan lengkap!",
                style = MaterialTheme.typography.bodyMedium,
                color = MangaWhite.copy(alpha = 0.92f),
              )
            }
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowForward,
              contentDescription = "Buka AI Generator",
              tint = MangaWhite,
            )
          }
        }

        // Lab Rumus & Kalkulator Interaktif
        MangaButton(
          onClick = onOpenFormulaLab,
          modifier = Modifier.fillMaxWidth(),
          backgroundColor = MangaPaperAlt,
          contentColor = MangaInk,
          testTag = "formula_lab_button",
        ) {
          Icon(
            imageVector = Icons.Default.Calculate,
            contentDescription = "Ikon Lab Rumus",
            tint = MangaCrimson,
          )
          Spacer(modifier = Modifier.size(10.dp))
          Text(
            text = "Lab Rumus & Kalkulator Lingkaran Interaktif",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
          )
        }

        // Section Header: 5 Chapters
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(
            text = "DAFTAR CHAPTER (100 SOAL)",
            fontFamily = BangersFontFamily,
            fontSize = 24.sp,
            letterSpacing = 1.2.sp,
            color = MangaInk,
          )
          val totalCuratedSolved = progress.solvedQuestionIds.size
          MangaTagBadge(
            text = "$totalCuratedSolved / 100 TUNTAS",
            backgroundColor = MangaInk,
            textColor = MangaWhite,
          )
        }

        // 5 Chapter Cards
        ChapterId.entries.forEach { chapter ->
          val solvedCount = progress.solvedCountForChapter(chapter)
          ChapterCardPanel(
            chapter = chapter,
            solvedCount = solvedCount,
            onClick = { onSelectChapter(chapter) },
          )
        }

        Spacer(modifier = Modifier.height(12.dp))
      }
    }
  }

  if (showResetDialog) {
    AlertDialog(
      onDismissRequest = { showResetDialog = false },
      title = { Text("Reset Progres Belajar?") },
      text = {
        Text("Semua XP, Bintang, Koin, dan tanda soal selesai di perangkat ini akan dihapus.")
      },
      confirmButton = {
        TextButton(
          onClick = {
            onResetProgress()
            showResetDialog = false
          }
        ) {
          Text("Reset", color = MangaCrimson, fontWeight = FontWeight.Bold)
        }
      },
      dismissButton = {
        TextButton(onClick = { showResetDialog = false }) { Text("Batal") }
      },
    )
  }
}

@Composable
private fun ProfileMangaPanel(progress: UserProgress) {
  MangaPanel(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = MangaWhite,
    contentPadding = PaddingValues(14.dp),
    testTag = "profile_panel",
  ) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Image(
          painter = painterResource(id = R.drawable.img_manga_avatar_1795686926184),
          contentDescription = "Avatar karakter manga siswa",
          contentScale = ContentScale.Crop,
          modifier =
            Modifier.size(72.dp)
              .clip(RoundedCornerShape(4.dp))
              .border(2.5.dp, MangaInk, RoundedCornerShape(4.dp)),
        )
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            MangaTagBadge(
              text = "LV. ${progress.level}",
              backgroundColor = MangaCrimson,
              textColor = MangaWhite,
            )
            MangaTagBadge(
              text = "RANK ${progress.rankCode}",
              backgroundColor = MangaInk,
              textColor = MangaWhite,
            )
          }
          Text(
            text = progress.rankTitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            color = MangaInk,
          )
          // XP Bar
          Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(
                text = "XP: ${progress.xp}",
                fontFamily = JetBrainsMonoFontFamily,
                style = MaterialTheme.typography.labelSmall,
                color = MangaInkSoft,
              )
              Text(
                text = "${progress.xpIntoLevel}/${progress.xpForNextLevel} ke Lv.${progress.level + 1}",
                fontFamily = JetBrainsMonoFontFamily,
                style = MaterialTheme.typography.labelSmall,
                color = MangaInkSoft,
              )
            }
            Box(
              modifier =
                Modifier.fillMaxWidth()
                  .height(10.dp)
                  .background(MangaPaperAlt, RoundedCornerShape(2.dp))
                  .border(1.5.dp, MangaInk, RoundedCornerShape(2.dp))
                  .padding(1.dp)
            ) {
              val fraction =
                (progress.xpIntoLevel.toFloat() / progress.xpForNextLevel.toFloat()).coerceIn(
                  0.04f,
                  1f,
                )
              Box(
                modifier =
                  Modifier.fillMaxWidth(fraction).fillMaxHeight().background(MangaCrimson)
              )
            }
          }
        }
      }

      // Stars, Coins, Streak Stats Row
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        StatPill(
          icon = Icons.Default.Star,
          label = "${progress.stars} Bintang",
          tint = MangaGold,
          modifier = Modifier.weight(1f),
        )
        StatPill(
          icon = Icons.Default.MonetizationOn,
          label = "${progress.coins} Koin",
          tint = MangaGold,
          modifier = Modifier.weight(1f),
        )
        StatPill(
          icon = Icons.Default.LocalFireDepartment,
          label = "${progress.streak} Streak",
          tint = MangaCrimson,
          modifier = Modifier.weight(1f),
        )
      }
    }
  }
}

@Composable
private fun StatPill(
  icon: androidx.compose.ui.graphics.vector.ImageVector,
  label: String,
  tint: androidx.compose.ui.graphics.Color,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier =
      modifier
        .background(MangaGoldLight.copy(alpha = 0.45f), RoundedCornerShape(3.dp))
        .border(1.5.dp, MangaInk, RoundedCornerShape(3.dp))
        .padding(horizontal = 8.dp, vertical = 6.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center,
  ) {
    Icon(
      imageVector = icon,
      contentDescription = label,
      tint = tint,
      modifier = Modifier.size(16.dp),
    )
    Spacer(modifier = Modifier.size(4.dp))
    Text(
      text = label,
      style = MaterialTheme.typography.labelLarge,
      fontSize = 12.sp,
      color = MangaInk,
    )
  }
}

@Composable
private fun ChapterCardPanel(
  chapter: ChapterId,
  solvedCount: Int,
  onClick: () -> Unit,
) {
  val completed = solvedCount >= chapter.totalQuestions
  MangaPanel(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = MangaWhite,
    onClick = onClick,
    testTag = "chapter_card_${chapter.number}",
  ) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Row(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.CenterVertically,
        ) {
          MangaTagBadge(
            text = chapter.code,
            backgroundColor = if (completed) MangaSuccess else MangaCrimson,
            textColor = MangaWhite,
          )
          Text(
            text = "$solvedCount / ${chapter.totalQuestions} Soal",
            fontFamily = JetBrainsMonoFontFamily,
            style = MaterialTheme.typography.labelLarge,
            color = MangaInkSoft,
          )
        }
        Icon(
          imageVector = Icons.AutoMirrored.Filled.ArrowForward,
          contentDescription = "Buka ${chapter.title}",
          tint = MangaInk,
        )
      }

      Text(
        text = chapter.title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.ExtraBold,
        color = MangaInk,
      )
      Text(
        text = chapter.subtitle,
        style = MaterialTheme.typography.bodyMedium,
        color = MangaInkSoft,
      )

      Box(
        modifier =
          Modifier.fillMaxWidth()
            .height(8.dp)
            .background(MangaPaperAlt, RoundedCornerShape(2.dp))
            .border(1.5.dp, MangaInk, RoundedCornerShape(2.dp))
      ) {
        val ratio =
          (solvedCount.toFloat() / chapter.totalQuestions.toFloat()).coerceIn(0f, 1f)
        if (ratio > 0f) {
          Box(
            modifier =
              Modifier.fillMaxWidth(ratio)
                .fillMaxHeight()
                .background(if (completed) MangaSuccess else MangaCrimson)
          )
        }
      }
    }
  }
}
