package com.example.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.BangersFontFamily
import com.example.ui.theme.MangaCrimson
import com.example.ui.theme.MangaInk
import com.example.ui.theme.MangaPaper
import com.example.ui.theme.MangaWhite
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun MangaPanel(
  modifier: Modifier = Modifier,
  backgroundColor: Color = MangaWhite,
  borderColor: Color = MangaInk,
  borderWidth: Dp = 2.5.dp,
  shadowOffset: Dp = 4.dp,
  cornerRadius: Dp = 4.dp,
  contentPadding: PaddingValues = PaddingValues(16.dp),
  onClick: (() -> Unit)? = null,
  testTag: String? = null,
  content: @Composable BoxScope.() -> Unit,
) {
  val shape = RoundedCornerShape(cornerRadius)
  val interactionSource = remember { MutableInteractionSource() }
  val isPressed by interactionSource.collectIsPressedAsState()
  val pressShift by
    animateDpAsState(
      targetValue = if (onClick != null && isPressed) shadowOffset else 0.dp,
      label = "manga_panel_shift",
    )

  Box(
    modifier =
      modifier
        .padding(end = shadowOffset, bottom = shadowOffset)
        .let { if (testTag != null) it.testTag(testTag) else it }
  ) {
    // Hard comic ink shadow
    Box(
      modifier =
        Modifier.matchParentSize()
          .offset(x = shadowOffset, y = shadowOffset)
          .clip(shape)
          .background(MangaInk)
    )
    // Main panel body
    Box(
      modifier =
        Modifier.offset(x = pressShift, y = pressShift)
          .clip(shape)
          .background(backgroundColor)
          .border(borderWidth, borderColor, shape)
          .let {
            if (onClick != null) {
              it.minimumInteractiveComponentSize().clickable(
                interactionSource = interactionSource,
                indication = androidx.compose.material3.ripple(),
                onClick = onClick,
              )
            } else {
              it
            }
          }
          .padding(contentPadding),
      content = content,
    )
  }
}

@Composable
fun MangaButton(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  backgroundColor: Color = MangaCrimson,
  contentColor: Color = MangaWhite,
  borderColor: Color = MangaInk,
  shadowOffset: Dp = 4.dp,
  enabled: Boolean = true,
  testTag: String? = null,
  content: @Composable RowScope.() -> Unit,
) {
  val shape = RoundedCornerShape(4.dp)
  val interactionSource = remember { MutableInteractionSource() }
  val isPressed by interactionSource.collectIsPressedAsState()
  val shift by
    animateDpAsState(
      targetValue = if (enabled && isPressed) shadowOffset else 0.dp,
      label = "manga_btn_shift",
    )

  val activeBg = if (enabled) backgroundColor else Color(0xFFD6D0C4)
  val activeFg = if (enabled) contentColor else Color(0xFF6B665C)

  Box(
    modifier =
      modifier
        .padding(end = shadowOffset, bottom = shadowOffset)
        .let { if (testTag != null) it.testTag(testTag) else it }
  ) {
    Box(
      modifier =
        Modifier.matchParentSize()
          .offset(x = shadowOffset, y = shadowOffset)
          .clip(shape)
          .background(MangaInk)
    )
    Surface(
      onClick = onClick,
      enabled = enabled,
      interactionSource = interactionSource,
      shape = shape,
      color = activeBg,
      contentColor = activeFg,
      border = BorderStroke(2.5.dp, borderColor),
      modifier = Modifier.offset(x = shift, y = shift).minimumInteractiveComponentSize(),
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        content = content,
      )
    }
  }
}

@Composable
fun MangaTagBadge(
  text: String,
  modifier: Modifier = Modifier,
  backgroundColor: Color = MangaInk,
  textColor: Color = MangaWhite,
  tiltDegrees: Float = 0f,
) {
  Box(
    modifier =
      modifier
        .rotate(tiltDegrees)
        .background(backgroundColor, RoundedCornerShape(2.dp))
        .border(1.5.dp, MangaInk, RoundedCornerShape(2.dp))
        .padding(horizontal = 10.dp, vertical = 4.dp)
  ) {
    Text(
      text = text,
      style = MaterialTheme.typography.labelLarge,
      fontWeight = FontWeight.ExtraBold,
      color = textColor,
      fontSize = 11.sp,
      letterSpacing = 0.8.sp,
    )
  }
}

@Composable
fun SfxCalloutStamp(
  sfxText: String,
  subtitle: String,
  accentColor: Color,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier =
      modifier
        .background(accentColor, RoundedCornerShape(4.dp))
        .border(2.5.dp, MangaInk, RoundedCornerShape(4.dp))
        .padding(horizontal = 14.dp, vertical = 10.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(10.dp),
  ) {
    Text(
      text = sfxText,
      fontFamily = BangersFontFamily,
      fontSize = 24.sp,
      letterSpacing = 1.5.sp,
      color = MangaWhite,
      modifier = Modifier.rotate(-4f),
    )
    Text(
      text = subtitle,
      style = MaterialTheme.typography.titleMedium,
      fontWeight = FontWeight.ExtraBold,
      color = MangaWhite,
    )
  }
}

@Composable
fun HalftonePaperBackground(
  modifier: Modifier = Modifier,
  paperColor: Color = MangaPaper,
  dotColor: Color = MangaInk.copy(alpha = 0.055f),
) {
  Canvas(modifier = modifier.fillMaxSize().background(paperColor)) {
    val spacing = 16.dp.toPx()
    val radius = 1.3.dp.toPx()
    var row = 0
    var y = spacing / 2f
    while (y < size.height) {
      val xOffset = if (row % 2 == 0) 0f else spacing / 2f
      var x = xOffset
      while (x < size.width) {
        drawCircle(color = dotColor, radius = radius, center = Offset(x, y))
        x += spacing
      }
      y += spacing
      row++
    }
  }
}

@Composable
fun MangaSpeedLinesOverlay(
  modifier: Modifier = Modifier,
  lineColor: Color = MangaInk.copy(alpha = 0.08f),
  accentColor: Color = MangaCrimson.copy(alpha = 0.12f),
) {
  Canvas(modifier = modifier.fillMaxSize()) {
    val center = Offset(size.width / 2f, size.height * 0.35f)
    val maxR = maxOf(size.width, size.height) * 0.9f
    val innerR = minOf(size.width, size.height) * 0.28f
    val count = 36
    for (i in 0 until count) {
      val angle = (i * (360f / count)) * (Math.PI / 180.0)
      val start =
        Offset(
          x = center.x + (innerR * cos(angle)).toFloat(),
          y = center.y + (innerR * sin(angle)).toFloat(),
        )
      val end =
        Offset(
          x = center.x + (maxR * cos(angle)).toFloat(),
          y = center.y + (maxR * sin(angle)).toFloat(),
        )
      drawLine(
        color = if (i % 5 == 0) accentColor else lineColor,
        start = start,
        end = end,
        strokeWidth = if (i % 5 == 0) 3.dp.toPx() else 1.5.dp.toPx(),
      )
    }
    // Subtle corner comic border frame
    val inset = 8.dp.toPx()
    val framePath =
      Path().apply {
        moveTo(inset, inset)
        lineTo(size.width - inset, inset)
        lineTo(size.width - inset, size.height - inset)
        lineTo(inset, size.height - inset)
        close()
      }
    drawPath(framePath, color = MangaInk.copy(alpha = 0.2f), style = Stroke(width = 1.5.dp.toPx()))
  }
}
