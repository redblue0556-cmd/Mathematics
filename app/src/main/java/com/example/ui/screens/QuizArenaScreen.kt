package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ChapterId
import com.example.model.MathQuestion
import com.example.model.StepByStepExplanation
import com.example.model.UserProgress
import com.example.ui.QuizSessionState
import com.example.ui.components.CircleDiagramCanvas
import com.example.ui.components.HalftonePaperBackground
import com.example.ui.components.MangaButton
import com.example.ui.components.MangaPanel
import com.example.ui.components.MangaTagBadge
import com.example.ui.components.MathRichText
import com.example.ui.components.SfxCalloutStamp
import com.example.ui.theme.BangersFontFamily
import com.example.ui.theme.JetBrainsMonoFontFamily
import com.example.ui.theme.MangaCrimson
import com.example.ui.theme.MangaCrimsonLight
import com.example.ui.theme.MangaGoldLight
import com.example.ui.theme.MangaInk
import com.example.ui.theme.MangaInkSoft
import com.example.ui.theme.MangaPaper
import com.example.ui.theme.MangaPaperAlt
import com.example.ui.theme.MangaSuccess
import com.example.ui.theme.MangaSuccessLight
import com.example.ui.theme.MangaWhite

@Composable
fun QuizArenaScreen(
  quizState: QuizSessionState,
  userProgress: UserProgress,
  onSelectOption: (Int) -> Unit,
  onNextQuestion: () -> Unit,
  onGenerateNewAiQuestion: () -> Unit,
  onChangeAiFilter: (ChapterId?) -> Unit,
  onReplayChapter: () -> Unit,
  onBackToLobby: () -> Unit,
) {
  BackHandler { onBackToLobby() }

  val scrollState = rememberScrollState()
  val question = quizState.currentQuestion

  LaunchedEffect(quizState.currentIndex, quizState.questions.size) {
    scrollState.scrollTo(0)
  }

  Box(modifier = Modifier.fillMaxSize()) {
    HalftonePaperBackground()

    Column(
      modifier =
        Modifier.fillMaxSize()
          .safeDrawingPadding()
          .verticalScroll(scrollState)
          .padding(horizontal = 16.dp, vertical = 12.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Column(
        modifier = Modifier.widthIn(max = 720.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
      ) {
        // Top Manga Navigation Header
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          MangaButton(
            onClick = onBackToLobby,
            backgroundColor = MangaWhite,
            contentColor = MangaInk,
            shadowOffset = 3.dp,
            testTag = "back_to_lobby_button",
          ) {
            Icon(
              imageVector = Icons.Default.Home,
              contentDescription = "Kembali ke Lobi",
              modifier = Modifier.size(18.dp),
            )
            Spacer(modifier = Modifier.size(6.dp))
            Text(
              text = "Lobi",
              style = MaterialTheme.typography.labelLarge,
              fontWeight = FontWeight.ExtraBold,
            )
          }

          Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            MangaTagBadge(
              text =
                if (quizState.isAiMode) "AI GENERATOR #${quizState.currentIndex + 1}"
                else "SOAL ${quizState.currentIndex + 1} / ${quizState.questions.size}",
              backgroundColor = if (quizState.isAiMode) MangaCrimson else MangaInk,
              textColor = MangaWhite,
            )
            MangaTagBadge(
              text = "${userProgress.xp} XP",
              backgroundColor = MangaGoldLight,
              textColor = MangaInk,
            )
          }
        }

        // AI Generator Filter Bar + Instant Regenerate CTA
        if (quizState.isAiMode) {
          AiGeneratorToolbar(
            selectedFilter = quizState.aiFilterChapter,
            onSelectFilter = onChangeAiFilter,
            onGenerateNow = onGenerateNewAiQuestion,
          )
        }

        if (quizState.isSessionCompleted) {
          ChapterSummaryPanel(
            chapter = quizState.activeChapter,
            correct = quizState.sessionCorrect,
            total = quizState.questions.size,
            onReplay = onReplayChapter,
            onBackToLobby = onBackToLobby,
          )
        } else if (question != null) {
          // Question Card
          QuestionComicPanel(question = question)

          // 5 Options A-E
          val letters = listOf("A", "B", "C", "D", "E")
          Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            question.options.forEachIndexed { idx, optionText ->
              val isSelected = quizState.selectedOptionIndex == idx
              val isCorrectOption = idx == question.correctIndex
              OptionPanelItem(
                letter = letters.getOrElse(idx) { "${idx + 1}" },
                text = optionText,
                isAnswered = quizState.isAnswered,
                isSelected = isSelected,
                isCorrectOption = isCorrectOption,
                onClick = { onSelectOption(idx) },
                testTag = "option_$idx",
              )
            }
          }

          // Always-Explain Step-by-Step Panel
          AnimatedVisibility(
            visible = quizState.isAnswered,
            enter =
              fadeIn() +
                expandVertically(
                  animationSpec = spring(dampingRatio = 0.78f, stiffness = 360f)
                ),
          ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
              if (quizState.isCorrect) {
                SfxCalloutStamp(
                  sfxText = "SUKSES!",
                  subtitle = "BENAR! (+100 XP)",
                  accentColor = MangaSuccess,
                  modifier = Modifier.fillMaxWidth(),
                )
              } else {
                SfxCalloutStamp(
                  sfxText = "GANBARU!",
                  subtitle = "Belum Tepat! Mari kita bedah panel penyelesaiannya:",
                  accentColor = MangaCrimson,
                  modifier = Modifier.fillMaxWidth(),
                )
              }

              AlwaysExplainPanel(explanation = question.explanation)

              MangaButton(
                onClick = onNextQuestion,
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MangaCrimson,
                contentColor = MangaWhite,
                testTag = "next_question_button",
              ) {
                val label =
                  when {
                    quizState.isAiMode -> "Buat Soal Baru Lagi"
                    quizState.currentIndex + 1 < quizState.questions.size -> "Soal Berikutnya"
                    else -> "Lihat Hasil Chapter"
                  }
                Text(
                  text = label,
                  fontFamily = BangersFontFamily,
                  fontSize = 22.sp,
                  letterSpacing = 1.2.sp,
                )
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                  contentDescription = label,
                )
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(16.dp))
      }
    }
  }
}

@Composable
private fun AiGeneratorToolbar(
  selectedFilter: ChapterId?,
  onSelectFilter: (ChapterId?) -> Unit,
  onGenerateNow: () -> Unit,
) {
  MangaPanel(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = MangaPaperAlt,
    contentPadding = PaddingValues(12.dp),
  ) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = "AI Smart Question Generator",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            color = MangaInk,
          )
          Text(
            text = "Pilih topik atau acak soal baru instan",
            style = MaterialTheme.typography.bodyMedium,
            color = MangaInkSoft,
          )
        }
        MangaButton(
          onClick = onGenerateNow,
          backgroundColor = MangaInk,
          contentColor = MangaWhite,
          shadowOffset = 3.dp,
          testTag = "regenerate_ai_question_button",
        ) {
          Icon(
            imageVector = Icons.Default.AutoAwesome,
            contentDescription = "Buat soal baru",
            modifier = Modifier.size(16.dp),
          )
          Spacer(modifier = Modifier.size(6.dp))
          Text(text = "Acak Baru", style = MaterialTheme.typography.labelLarge)
        }
      }

      Row(
        modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        FilterChipManga(
          label = "Semua Bab",
          selected = selectedFilter == null,
          onClick = { onSelectFilter(null) },
        )
        ChapterId.entries.forEach { chapter ->
          FilterChipManga(
            label = "Bab ${chapter.number}",
            selected = selectedFilter == chapter,
            onClick = { onSelectFilter(chapter) },
          )
        }
      }
    }
  }
}

@Composable
private fun FilterChipManga(
  label: String,
  selected: Boolean,
  onClick: () -> Unit,
) {
  Box(
    modifier =
      Modifier.minimumInteractiveComponentSize()
        .clip(RoundedCornerShape(3.dp))
        .background(if (selected) MangaCrimson else MangaWhite)
        .border(2.dp, MangaInk, RoundedCornerShape(3.dp))
        .clickable(onClick = onClick)
        .padding(horizontal = 12.dp, vertical = 8.dp),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = label,
      style = MaterialTheme.typography.labelLarge,
      color = if (selected) MangaWhite else MangaInk,
    )
  }
}

@Composable
private fun QuestionComicPanel(question: MathQuestion) {
  MangaPanel(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = MangaWhite,
    contentPadding = PaddingValues(16.dp),
    testTag = "question_panel",
  ) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        MangaTagBadge(
          text = "${question.chapter.code} • ${question.chapter.title}",
          backgroundColor = MangaPaperAlt,
          textColor = MangaInk,
        )
        if (question.isAiGenerated) {
          MangaTagBadge(
            text = "AI GENERATED",
            backgroundColor = MangaCrimson,
            textColor = MangaWhite,
          )
        }
      }

      MathRichText(
        text = question.questionText,
        textStyle = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        color = MangaInk,
      )

      if (question.circleDiagram != null) {
        CircleDiagramCanvas(spec = question.circleDiagram)
      }
    }
  }
}

@Composable
private fun OptionPanelItem(
  letter: String,
  text: String,
  isAnswered: Boolean,
  isSelected: Boolean,
  isCorrectOption: Boolean,
  onClick: () -> Unit,
  testTag: String,
) {
  val bgColor: Color
  val borderColor: Color
  val badgeBg: Color
  val badgeText: Color

  when {
    !isAnswered -> {
      bgColor = MangaWhite
      borderColor = MangaInk
      badgeBg = MangaPaperAlt
      badgeText = MangaInk
    }
    isCorrectOption -> {
      bgColor = MangaSuccessLight
      borderColor = MangaSuccess
      badgeBg = MangaSuccess
      badgeText = MangaWhite
    }
    isSelected -> {
      bgColor = MangaCrimsonLight
      borderColor = MangaCrimson
      badgeBg = MangaCrimson
      badgeText = MangaWhite
    }
    else -> {
      bgColor = MangaPaperAlt
      borderColor = MangaInk.copy(alpha = 0.45f)
      badgeBg = MangaPaper
      badgeText = MangaInkSoft
    }
  }

  MangaPanel(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = bgColor,
    borderColor = borderColor,
    shadowOffset = if (isAnswered && !isCorrectOption && !isSelected) 2.dp else 3.dp,
    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
    onClick = if (isAnswered) null else onClick,
    testTag = testTag,
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Box(
        modifier =
          Modifier.size(34.dp)
            .background(badgeBg, RoundedCornerShape(3.dp))
            .border(2.dp, MangaInk, RoundedCornerShape(3.dp)),
        contentAlignment = Alignment.Center,
      ) {
        Text(
          text = letter,
          fontFamily = JetBrainsMonoFontFamily,
          fontWeight = FontWeight.ExtraBold,
          color = badgeText,
        )
      }

      Box(modifier = Modifier.weight(1f)) {
        MathRichText(
          text = text,
          textStyle = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
          color = MangaInk,
        )
      }

      if (isAnswered && isCorrectOption) {
        Icon(
          imageVector = Icons.Default.CheckCircle,
          contentDescription = "Jawaban benar",
          tint = MangaSuccess,
        )
      } else if (isAnswered && isSelected && !isCorrectOption) {
        Icon(
          imageVector = Icons.Default.Close,
          contentDescription = "Pilihan kurang tepat",
          tint = MangaCrimson,
        )
      }
    }
  }
}

@Composable
private fun AlwaysExplainPanel(explanation: StepByStepExplanation) {
  MangaPanel(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = MangaWhite,
    contentPadding = PaddingValues(16.dp),
    testTag = "always_explain_panel",
  ) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Text(
          text = "PANEL PEMBAHASAN STEP-BY-STEP",
          fontFamily = BangersFontFamily,
          fontSize = 22.sp,
          letterSpacing = 1.sp,
          color = MangaInk,
        )
        MangaTagBadge(
          text = "AI TUTOR",
          backgroundColor = MangaInk,
          textColor = MangaWhite,
        )
      }

      // 1. Diketahui
      ExplanationSubBlock(
        stepTitle = "1. Diketahui",
        accent = MangaInk,
        bgColor = MangaPaper,
      ) {
        MathRichText(
          text = explanation.diketahui,
          textStyle = MaterialTheme.typography.bodyMedium,
          isFormulaMono = true,
        )
      }

      // 2. Rumus Utama
      ExplanationSubBlock(
        stepTitle = "2. Rumus Utama",
        accent = MangaCrimson,
        bgColor = MangaCrimsonLight.copy(alpha = 0.45f),
      ) {
        MathRichText(
          text = explanation.rumusUtama,
          textStyle = MaterialTheme.typography.titleMedium,
          isFormulaMono = true,
        )
      }

      // 3. Langkah Pengerjaan
      ExplanationSubBlock(
        stepTitle = "3. Langkah Pengerjaan",
        accent = MangaInk,
        bgColor = MangaPaperAlt,
      ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          explanation.langkahLangkah.forEach { step ->
            MathRichText(
              text = step,
              textStyle = MaterialTheme.typography.bodyMedium,
              color = MangaInk,
            )
          }
        }
      }

      // 4. Catatan / Tips Manga
      Row(
        modifier =
          Modifier.fillMaxWidth()
            .background(MangaGoldLight.copy(alpha = 0.6f), RoundedCornerShape(4.dp))
            .border(2.dp, MangaInk, RoundedCornerShape(4.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.Top,
      ) {
        Icon(
          imageVector = Icons.Default.Lightbulb,
          contentDescription = "Tips Manga",
          tint = MangaCrimson,
        )
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
          Text(
            text = "4. Catatan / Tips Manga",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MangaInk,
          )
          MathRichText(
            text = explanation.tipsManga,
            textStyle = MaterialTheme.typography.bodyMedium,
            color = MangaInk,
          )
        }
      }
    }
  }
}

@Composable
private fun ExplanationSubBlock(
  stepTitle: String,
  accent: Color,
  bgColor: Color,
  content: @Composable () -> Unit,
) {
  Column(
    modifier =
      Modifier.fillMaxWidth()
        .background(bgColor, RoundedCornerShape(4.dp))
        .border(1.5.dp, MangaInk, RoundedCornerShape(4.dp))
        .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(6.dp),
  ) {
    Text(
      text = stepTitle,
      style = MaterialTheme.typography.labelLarge,
      fontWeight = FontWeight.ExtraBold,
      color = accent,
    )
    content()
  }
}

@Composable
private fun ChapterSummaryPanel(
  chapter: ChapterId?,
  correct: Int,
  total: Int,
  onReplay: () -> Unit,
  onBackToLobby: () -> Unit,
) {
  val pct = if (total > 0) (correct * 100) / total else 0
  MangaPanel(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = MangaWhite,
    contentPadding = PaddingValues(20.dp),
    testTag = "chapter_summary_panel",
  ) {
    Column(
      modifier = Modifier.fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
      MangaTagBadge(
        text = "CHAPTER CLEAR!!",
        backgroundColor = MangaSuccess,
        textColor = MangaWhite,
        tiltDegrees = -3f,
      )
      Text(
        text = chapter?.title ?: "Latihan Selesai",
        fontFamily = BangersFontFamily,
        fontSize = 30.sp,
        letterSpacing = 1.2.sp,
        color = MangaInk,
      )
      Text(
        text = "Skor: $correct / $total Benar ($pct%)",
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.ExtraBold,
        color = MangaCrimson,
      )
      Text(
        text = "Mantap! Setiap pembahasan yang kamu baca memperkuat insting aljabar & geometrimu.",
        style = MaterialTheme.typography.bodyMedium,
        color = MangaInkSoft,
      )

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
      ) {
        MangaButton(
          onClick = onReplay,
          modifier = Modifier.weight(1f),
          backgroundColor = MangaPaperAlt,
          contentColor = MangaInk,
        ) {
          Text(text = "Ulangi Chapter", style = MaterialTheme.typography.labelLarge)
        }
        MangaButton(
          onClick = onBackToLobby,
          modifier = Modifier.weight(1f),
          backgroundColor = MangaCrimson,
          contentColor = MangaWhite,
        ) {
          Text(text = "Ke Lobi", style = MaterialTheme.typography.labelLarge)
        }
      }
    }
  }
}
