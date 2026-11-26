package com.example.ui.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.components.HalftonePaperBackground
import com.example.ui.components.MangaButton
import com.example.ui.components.MangaPanel
import com.example.ui.components.MangaSpeedLinesOverlay
import com.example.ui.components.MangaTagBadge
import com.example.ui.theme.BangersFontFamily
import com.example.ui.theme.JetBrainsMonoFontFamily
import com.example.ui.theme.MangaCrimson
import com.example.ui.theme.MangaInk
import com.example.ui.theme.MangaInkSoft
import com.example.ui.theme.MangaPaperAlt
import com.example.ui.theme.MangaWhite
import kotlinx.coroutines.delay

@Composable
fun CoverLoadingScreen(onStartClick: () -> Unit) {
  var targetProgress by remember { mutableFloatStateOf(0.08f) }
  val animatedProgress by
    animateFloatAsState(
      targetValue = targetProgress,
      animationSpec = tween(durationMillis = 450, easing = LinearEasing),
      label = "cover_loading_progress",
    )

  LaunchedEffect(Unit) {
    delay(250)
    targetProgress = 0.42f
    delay(450)
    targetProgress = 0.78f
    delay(450)
    targetProgress = 1.0f
  }

  val statusText =
    when {
      animatedProgress < 0.40f -> "Memuat Chapter Soal..."
      animatedProgress < 0.75f -> "Mengasah Logika Aljabar..."
      animatedProgress < 0.99f -> "Menyiapkan Lab Busur & Invers..."
      else -> "SUKSES! Chapter Siap Dibaca!"
    }

  Box(modifier = Modifier.fillMaxSize()) {
    HalftonePaperBackground()
    MangaSpeedLinesOverlay()

    Column(
      modifier =
        Modifier.fillMaxSize()
          .safeDrawingPadding()
          .verticalScroll(rememberScrollState())
          .padding(horizontal = 20.dp, vertical = 18.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
    ) {
      Column(
        modifier = Modifier.widthIn(max = 560.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          MangaTagBadge(
            text = "SHONEN MATH EDITION",
            backgroundColor = MangaInk,
            textColor = MangaWhite,
          )
          MangaTagBadge(
            text = "VOL. 01 • 100 SOAL",
            backgroundColor = MangaCrimson,
            textColor = MangaWhite,
            tiltDegrees = 2f,
          )
        }

        // Title Masthead Panel
        MangaPanel(
          modifier = Modifier.fillMaxWidth(),
          backgroundColor = MangaWhite,
          contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
        ) {
          Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
          ) {
            Text(
              text = "MATHMASTER PRO",
              fontFamily = BangersFontFamily,
              fontSize = 42.sp,
              letterSpacing = 2.sp,
              color = MangaInk,
              textAlign = TextAlign.Center,
            )
            Box(
              modifier =
                Modifier.background(MangaCrimson, RoundedCornerShape(3.dp))
                  .border(2.dp, MangaInk, RoundedCornerShape(3.dp))
                  .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
              Text(
                text = "CHAPTER: FUNGSI & LINGKARAN",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MangaWhite,
                letterSpacing = 1.sp,
              )
            }
          }
        }

        // Cover Art Frame
        MangaPanel(
          modifier = Modifier.fillMaxWidth(),
          backgroundColor = MangaPaperAlt,
          contentPadding = PaddingValues(8.dp),
        ) {
          Box(
            modifier =
              Modifier.fillMaxWidth()
                .aspectRatio(4f / 3f)
                .clip(RoundedCornerShape(2.dp))
                .border(2.dp, MangaInk, RoundedCornerShape(2.dp))
          ) {
            Image(
              painter = painterResource(id = R.drawable.img_manga_cover_1795686924659),
              contentDescription = "Ilustrasi sampul bab manga MathMaster Pro",
              contentScale = ContentScale.Crop,
              modifier = Modifier.fillMaxSize(),
            )
            MangaTagBadge(
              text = "BAM!!",
              backgroundColor = MangaCrimson,
              textColor = MangaWhite,
              tiltDegrees = -6f,
              modifier = Modifier.align(Alignment.TopStart).padding(10.dp),
            )
          }
        }

        // Comic Progress Bar + Dynamic Status
        MangaPanel(
          modifier = Modifier.fillMaxWidth(),
          backgroundColor = MangaWhite,
          contentPadding = PaddingValues(14.dp),
        ) {
          Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically,
            ) {
              Text(
                text = statusText,
                style = MaterialTheme.typography.labelLarge,
                color = if (animatedProgress >= 0.99f) MangaCrimson else MangaInk,
              )
              Text(
                text = "${(animatedProgress * 100).toInt()}%",
                fontFamily = JetBrainsMonoFontFamily,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelLarge,
                color = MangaInk,
              )
            }
            Box(
              modifier =
                Modifier.fillMaxWidth()
                  .height(18.dp)
                  .background(MangaPaperAlt, RoundedCornerShape(2.dp))
                  .border(2.dp, MangaInk, RoundedCornerShape(2.dp))
                  .padding(2.dp)
            ) {
              Box(
                modifier =
                  Modifier.fillMaxWidth(animatedProgress.coerceIn(0.05f, 1f))
                    .fillMaxHeight()
                    .background(MangaCrimson, RoundedCornerShape(1.dp))
              )
            }
            Text(
              text = "Aljabar Fungsi, Komposisi, Invers, & Geometri Panjang Busur",
              style = MaterialTheme.typography.bodyMedium,
              color = MangaInkSoft,
            )
          }
        }

        Spacer(modifier = Modifier.height(2.dp))

        MangaButton(
          onClick = onStartClick,
          modifier = Modifier.fillMaxWidth(),
          backgroundColor = MangaCrimson,
          contentColor = MangaWhite,
          testTag = "start_learning_button",
        ) {
          Text(
            text = "MULAI BELAJAR",
            fontFamily = BangersFontFamily,
            fontSize = 24.sp,
            letterSpacing = 1.5.sp,
          )
          Spacer(modifier = Modifier.padding(horizontal = 4.dp))
          Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Mulai belajar",
          )
        }
      }
    }
  }
}
