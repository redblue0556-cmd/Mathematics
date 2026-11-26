package com.example.ui.screens

import androidx.activity.compose.BackHandler
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CircleDiagramSpec
import com.example.model.CircleHighlightMode
import com.example.ui.FormulaLabState
import com.example.ui.components.CircleDiagramCanvas
import com.example.ui.components.HalftonePaperBackground
import com.example.ui.components.MangaButton
import com.example.ui.components.MangaPanel
import com.example.ui.components.MangaTagBadge
import com.example.ui.components.MathRichText
import com.example.ui.theme.BangersFontFamily
import com.example.ui.theme.JetBrainsMonoFontFamily
import com.example.ui.theme.MangaCrimson
import com.example.ui.theme.MangaCrimsonLight
import com.example.ui.theme.MangaInk
import com.example.ui.theme.MangaInkSoft
import com.example.ui.theme.MangaPaper
import com.example.ui.theme.MangaPaperAlt
import com.example.ui.theme.MangaWhite
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun FormulaLabScreen(
  labState: FormulaLabState,
  onRadiusChange: (Float) -> Unit,
  onAngleChange: (Float) -> Unit,
  onTogglePiFraction: (Boolean) -> Unit,
  onUpdateFunctionLab: (Boolean, Int, Int, Int, Int) -> Unit,
  onBackToLobby: () -> Unit,
) {
  BackHandler { onBackToLobby() }
  var selectedTab by remember { mutableIntStateOf(0) }

  Box(modifier = Modifier.fillMaxSize()) {
    HalftonePaperBackground()

    Column(
      modifier =
        Modifier.fillMaxSize()
          .safeDrawingPadding()
          .verticalScroll(rememberScrollState())
          .padding(horizontal = 16.dp, vertical = 12.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Column(
        modifier = Modifier.widthIn(max = 720.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
      ) {
        // Header with Back to Lobby
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
            testTag = "lab_back_to_lobby_button",
          ) {
            Icon(
              imageVector = Icons.Default.Home,
              contentDescription = "Kembali ke Lobi",
              modifier = Modifier.size(18.dp),
            )
            Spacer(modifier = Modifier.size(6.dp))
            Text(text = "Lobi", style = MaterialTheme.typography.labelLarge)
          }

          MangaTagBadge(
            text = "LAB RUMUS INTERAKTIF",
            backgroundColor = MangaCrimson,
            textColor = MangaWhite,
          )
        }

        // Tab Switcher
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
          LabTabButton(
            label = "Lingkaran & Busur",
            selected = selectedTab == 0,
            onClick = { selectedTab = 0 },
            modifier = Modifier.weight(1f),
          )
          LabTabButton(
            label = "Evaluator Fungsi",
            selected = selectedTab == 1,
            onClick = { selectedTab = 1 },
            modifier = Modifier.weight(1f),
          )
        }

        if (selectedTab == 0) {
          CircleArcLabTab(
            labState = labState,
            onRadiusChange = onRadiusChange,
            onAngleChange = onAngleChange,
            onTogglePiFraction = onTogglePiFraction,
          )
        } else {
          FunctionEvaluatorLabTab(
            labState = labState,
            onUpdateFunctionLab = onUpdateFunctionLab,
          )
        }

        Spacer(modifier = Modifier.height(16.dp))
      }
    }
  }
}

@Composable
private fun LabTabButton(
  label: String,
  selected: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier =
      modifier
        .minimumInteractiveComponentSize()
        .clip(RoundedCornerShape(4.dp))
        .background(if (selected) MangaInk else MangaWhite)
        .border(2.5.dp, MangaInk, RoundedCornerShape(4.dp))
        .clickable(onClick = onClick)
        .padding(vertical = 12.dp, horizontal = 8.dp),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = label,
      style = MaterialTheme.typography.labelLarge,
      fontWeight = FontWeight.ExtraBold,
      color = if (selected) MangaWhite else MangaInk,
    )
  }
}

@Composable
private fun CircleArcLabTab(
  labState: FormulaLabState,
  onRadiusChange: (Float) -> Unit,
  onAngleChange: (Float) -> Unit,
  onTogglePiFraction: (Boolean) -> Unit,
) {
  val r = labState.radiusCm.roundToInt()
  val alpha = labState.angleDeg.roundToInt()
  val pi = if (labState.usePiFraction) 22.0 / 7.0 else 3.14

  val keliling = 2.0 * pi * r
  val luas = pi * r * r
  val panjangBusur = (alpha / 360.0) * keliling
  val luasJuring = (alpha / 360.0) * luas

  fun fmt(v: Double): String =
    if (kotlin.math.abs(v - v.roundToInt()) < 0.01) v.roundToInt().toString()
    else String.format(Locale("id", "ID"), "%.2f", v)

  Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
    // Live Circle Canvas
    CircleDiagramCanvas(
      spec =
        CircleDiagramSpec(
          radiusValue = r.toDouble(),
          isDiameterGiven = false,
          centralAngleDeg = alpha.toDouble(),
          unit = "cm",
          highlightMode = CircleHighlightMode.ARC,
        )
    )

    // Preset Chips from Handwritten Notes
    Row(
      modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      PresetChip("90°, r=14") {
        onAngleChange(90f)
        onRadiusChange(14f)
        onTogglePiFraction(true)
      }
      PresetChip("120°, r=21") {
        onAngleChange(120f)
        onRadiusChange(21f)
        onTogglePiFraction(true)
      }
      PresetChip("45°, r=14 (Pizza)") {
        onAngleChange(45f)
        onRadiusChange(14f)
        onTogglePiFraction(true)
      }
      PresetChip("360°, r=35 (Roda d=70)") {
        onAngleChange(360f)
        onRadiusChange(35f)
        onTogglePiFraction(true)
      }
    }

    // Sliders & Pi Selector
    MangaPanel(
      modifier = Modifier.fillMaxWidth(),
      backgroundColor = MangaWhite,
      contentPadding = PaddingValues(16.dp),
    ) {
      Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          Text(
            text = "Jari-jari (r) = $r cm (d = ${r * 2} cm)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
          )
        }
        Slider(
          value = labState.radiusCm,
          onValueChange = onRadiusChange,
          valueRange = 7f..70f,
          steps = 8, // 7, 14, 21, 28, 35, 42, 49, 56, 63, 70
          colors =
            SliderDefaults.colors(
              thumbColor = MangaCrimson,
              activeTrackColor = MangaCrimson,
              inactiveTrackColor = MangaPaperAlt,
            ),
          modifier = Modifier.testTag("radius_slider"),
        )

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          Text(
            text = "Sudut Pusat (α) = $alpha°",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
          )
        }
        Slider(
          value = labState.angleDeg,
          onValueChange = onAngleChange,
          valueRange = 15f..360f,
          colors =
            SliderDefaults.colors(
              thumbColor = MangaInk,
              activeTrackColor = MangaInk,
              inactiveTrackColor = MangaPaperAlt,
            ),
          modifier = Modifier.testTag("angle_slider"),
        )

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(
            text = "Nilai π:",
            style = MaterialTheme.typography.labelLarge,
            color = MangaInkSoft,
          )
          PresetChip(
            label = "π = 22/7",
            selected = labState.usePiFraction,
            onClick = { onTogglePiFraction(true) },
          )
          PresetChip(
            label = "π = 3,14",
            selected = !labState.usePiFraction,
            onClick = { onTogglePiFraction(false) },
          )
        }
      }
    }

    // Live Calculation Output
    MangaPanel(
      modifier = Modifier.fillMaxWidth(),
      backgroundColor = MangaPaperAlt,
      contentPadding = PaddingValues(16.dp),
    ) {
      val piToken = if (labState.usePiFraction) "[[frac:22|7]]" else "3,14"
      Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
          text = "HASIL HITUNGAN LANGSUNG",
          fontFamily = BangersFontFamily,
          fontSize = 22.sp,
          letterSpacing = 1.sp,
          color = MangaInk,
        )

        Box(
          modifier =
            Modifier.fillMaxWidth()
              .background(MangaCrimsonLight.copy(alpha = 0.55f), RoundedCornerShape(4.dp))
              .border(2.dp, MangaCrimson, RoundedCornerShape(4.dp))
              .padding(12.dp)
        ) {
          Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
              text = "Panjang Busur:",
              style = MaterialTheme.typography.labelLarge,
              color = MangaCrimson,
            )
            MathRichText(
              text =
                "[[frac:${alpha}°|360°]] × 2 × $piToken × $r = ${fmt(panjangBusur)} cm",
              textStyle = MaterialTheme.typography.titleMedium,
              isFormulaMono = true,
            )
          }
        }

        Box(
          modifier =
            Modifier.fillMaxWidth()
              .background(MangaWhite, RoundedCornerShape(4.dp))
              .border(1.5.dp, MangaInk, RoundedCornerShape(4.dp))
              .padding(12.dp)
        ) {
          Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            MathRichText(
              text = "Keliling Lingkaran = 2 × $piToken × $r = ${fmt(keliling)} cm",
              textStyle = MaterialTheme.typography.bodyMedium,
              isFormulaMono = true,
            )
            MathRichText(
              text = "Luas Lingkaran = $piToken × $r × $r = ${fmt(luas)} cm²",
              textStyle = MaterialTheme.typography.bodyMedium,
              isFormulaMono = true,
            )
            MathRichText(
              text = "Luas Juring = [[frac:${alpha}°|360°]] × ${fmt(luas)} = ${fmt(luasJuring)} cm²",
              textStyle = MaterialTheme.typography.bodyMedium,
              isFormulaMono = true,
            )
          }
        }
      }
    }
  }
}

@Composable
private fun PresetChip(
  label: String,
  selected: Boolean = false,
  onClick: () -> Unit,
) {
  Box(
    modifier =
      Modifier.minimumInteractiveComponentSize()
        .clip(RoundedCornerShape(3.dp))
        .background(if (selected) MangaCrimson else MangaWhite)
        .border(1.5.dp, MangaInk, RoundedCornerShape(3.dp))
        .clickable(onClick = onClick)
        .padding(horizontal = 10.dp, vertical = 6.dp),
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
private fun FunctionEvaluatorLabTab(
  labState: FormulaLabState,
  onUpdateFunctionLab: (Boolean, Int, Int, Int, Int) -> Unit,
) {
  val a = labState.coeffA
  val b = labState.coeffB
  val c = labState.coeffC
  val x = labState.inputX

  val result =
    if (labState.isQuadraticFn) {
      a * x * x + b * x + c
    } else {
      a * x + b
    }

  val formulaText =
    if (labState.isQuadraticFn) {
      "f(x) = ${a}x² ${if (b >= 0) "+ $b" else "- ${-b}"}x ${if (c >= 0) "+ $c" else "- ${-c}"}"
    } else {
      "f(x) = ${a}x ${if (b >= 0) "+ $b" else "- ${-b}"}"
    }

  Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      PresetChip("Linear: ax + b", selected = !labState.isQuadraticFn) {
        onUpdateFunctionLab(false, a, b, c, x)
      }
      PresetChip("Kuadrat: ax² + bx + c", selected = labState.isQuadraticFn) {
        onUpdateFunctionLab(true, a, b, c, x)
      }
    }

    MangaPanel(
      modifier = Modifier.fillMaxWidth(),
      backgroundColor = MangaWhite,
      contentPadding = PaddingValues(16.dp),
    ) {
      Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        NumberStepperRow("Koefisien a", a) { newA ->
          onUpdateFunctionLab(labState.isQuadraticFn, newA, b, c, x)
        }
        NumberStepperRow("Koefisien b", b) { newB ->
          onUpdateFunctionLab(labState.isQuadraticFn, a, newB, c, x)
        }
        if (labState.isQuadraticFn) {
          NumberStepperRow("Konstanta c", c) { newC ->
            onUpdateFunctionLab(labState.isQuadraticFn, a, b, newC, x)
          }
        }
        NumberStepperRow("Nilai x", x) { newX ->
          onUpdateFunctionLab(labState.isQuadraticFn, a, b, c, newX)
        }
      }
    }

    MangaPanel(
      modifier = Modifier.fillMaxWidth(),
      backgroundColor = MangaPaperAlt,
      contentPadding = PaddingValues(16.dp),
    ) {
      Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
          text = formulaText,
          fontFamily = JetBrainsMonoFontFamily,
          fontWeight = FontWeight.ExtraBold,
          style = MaterialTheme.typography.titleLarge,
          color = MangaInk,
        )
        if (labState.isQuadraticFn) {
          Text(
            text = "Step 1: f($x) = $a($x)² + $b($x) + $c",
            fontFamily = JetBrainsMonoFontFamily,
            style = MaterialTheme.typography.bodyMedium,
          )
          Text(
            text = "Step 2: = ${a * x * x} + ${b * x} + $c",
            fontFamily = JetBrainsMonoFontFamily,
            style = MaterialTheme.typography.bodyMedium,
          )
        } else {
          Text(
            text = "Step 1: f($x) = $a($x) + $b",
            fontFamily = JetBrainsMonoFontFamily,
            style = MaterialTheme.typography.bodyMedium,
          )
          Text(
            text = "Step 2: = ${a * x} + $b",
            fontFamily = JetBrainsMonoFontFamily,
            style = MaterialTheme.typography.bodyMedium,
          )
        }
        Box(
          modifier =
            Modifier.fillMaxWidth()
              .background(MangaCrimson, RoundedCornerShape(4.dp))
              .border(2.dp, MangaInk, RoundedCornerShape(4.dp))
              .padding(12.dp)
        ) {
          Text(
            text = "Hasil Akhir: f($x) = $result",
            fontFamily = JetBrainsMonoFontFamily,
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleMedium,
            color = MangaWhite,
          )
        }
      }
    }
  }
}

@Composable
private fun NumberStepperRow(
  label: String,
  value: Int,
  onValueChange: (Int) -> Unit,
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text = label,
      style = MaterialTheme.typography.titleMedium,
      color = MangaInk,
    )
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      IconButton(
        onClick = { onValueChange(value - 1) },
        modifier =
          Modifier.background(MangaPaper, RoundedCornerShape(4.dp))
            .border(1.5.dp, MangaInk, RoundedCornerShape(4.dp)),
      ) {
        Icon(Icons.Default.Remove, contentDescription = "Kurangi $label", tint = MangaInk)
      }
      Text(
        text = value.toString(),
        fontFamily = JetBrainsMonoFontFamily,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(horizontal = 8.dp),
      )
      IconButton(
        onClick = { onValueChange(value + 1) },
        modifier =
          Modifier.background(MangaPaper, RoundedCornerShape(4.dp))
            .border(1.5.dp, MangaInk, RoundedCornerShape(4.dp)),
      ) {
        Icon(Icons.Default.Add, contentDescription = "Tambah $label", tint = MangaInk)
      }
    }
  }
}
