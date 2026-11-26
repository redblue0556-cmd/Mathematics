package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.model.CircleDiagramSpec
import com.example.model.CircleHighlightMode
import com.example.ui.theme.JetBrainsMonoFontFamily
import com.example.ui.theme.MangaCrimson
import com.example.ui.theme.MangaInk
import com.example.ui.theme.MangaPaper
import com.example.ui.theme.MangaPaperAlt
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CircleDiagramCanvas(
  spec: CircleDiagramSpec,
  modifier: Modifier = Modifier,
) {
  val radiusLabel =
    if (spec.isDiameterGiven) {
      val dVal = spec.radiusValue * 2.0
      val dStr = if (dVal % 1.0 == 0.0) dVal.toInt().toString() else String.format("%.1f", dVal)
      "d = $dStr ${spec.unit}"
    } else {
      val rStr =
        if (spec.radiusValue % 1.0 == 0.0) spec.radiusValue.toInt().toString()
        else String.format("%.1f", spec.radiusValue)
      "r = $rStr ${spec.unit}"
    }

  val angleStr =
    if (spec.centralAngleDeg % 1.0 == 0.0) "${spec.centralAngleDeg.toInt()}°"
    else String.format("%.1f°", spec.centralAngleDeg)

  Column(
    modifier =
      modifier
        .fillMaxWidth()
        .background(MangaPaper, RoundedCornerShape(4.dp))
        .border(2.dp, MangaInk, RoundedCornerShape(4.dp))
        .padding(12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    Box(
      modifier = Modifier.fillMaxWidth().height(170.dp),
      contentAlignment = Alignment.Center,
    ) {
      Canvas(modifier = Modifier.fillMaxWidth().height(170.dp)) {
        val radiusPx = (minOf(size.width, size.height) * 0.40f)
        val center = Offset(size.width / 2f, size.height / 2f)
        val topLeft = Offset(center.x - radiusPx, center.y - radiusPx)
        val arcSize = Size(radiusPx * 2f, radiusPx * 2f)

        // Base circle fill
        drawCircle(
          color =
            if (spec.highlightMode == CircleHighlightMode.AREA) MangaCrimson.copy(alpha = 0.16f)
            else MangaPaperAlt,
          radius = radiusPx,
          center = center,
        )

        // Shaded sector if central angle < 360
        val sweep = spec.centralAngleDeg.toFloat().coerceIn(1f, 360f)
        val startAngle = -90f
        if (sweep < 360f) {
          drawArc(
            color = MangaCrimson.copy(alpha = 0.22f),
            startAngle = startAngle,
            sweepAngle = sweep,
            useCenter = true,
            topLeft = topLeft,
            size = arcSize,
          )
        }

        // Base ink circle border
        drawCircle(
          color = MangaInk,
          radius = radiusPx,
          center = center,
          style = Stroke(width = 2.5.dp.toPx()),
        )

        // Highlight circumference or arc in Shonen Crimson
        if (spec.highlightMode == CircleHighlightMode.ARC ||
            spec.highlightMode == CircleHighlightMode.CIRCUMFERENCE ||
            spec.highlightMode == CircleHighlightMode.SECTOR
        ) {
          drawArc(
            color = MangaCrimson,
            startAngle = startAngle,
            sweepAngle = sweep,
            useCenter = false,
            topLeft = topLeft,
            size = arcSize,
            style = Stroke(width = 4.5.dp.toPx(), cap = StrokeCap.Round),
          )
        }

        // Radius or Diameter indicator
        if (spec.isDiameterGiven && sweep == 360f) {
          drawLine(
            color = MangaInk,
            start = Offset(center.x - radiusPx, center.y),
            end = Offset(center.x + radiusPx, center.y),
            strokeWidth = 2.2.dp.toPx(),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 6f), 0f),
          )
        } else {
          // Draw first ray at -90 deg (top)
          drawLine(
            color = MangaInk,
            start = center,
            end = Offset(center.x, center.y - radiusPx),
            strokeWidth = 2.dp.toPx(),
          )
          // Draw second ray at startAngle + sweep
          if (sweep < 360f) {
            val endRad = Math.toRadians((startAngle + sweep).toDouble())
            drawLine(
              color = MangaInk,
              start = center,
              end =
                Offset(
                  x = center.x + (radiusPx * cos(endRad)).toFloat(),
                  y = center.y + (radiusPx * sin(endRad)).toFloat(),
                ),
              strokeWidth = 2.dp.toPx(),
            )
            // Central angle indicator arc
            val angleArcR = radiusPx * 0.30f
            drawArc(
              color = MangaCrimson,
              startAngle = startAngle,
              sweepAngle = sweep,
              useCenter = false,
              topLeft = Offset(center.x - angleArcR, center.y - angleArcR),
              size = Size(angleArcR * 2f, angleArcR * 2f),
              style = Stroke(width = 2.dp.toPx()),
            )
          }
        }

        // Center point
        drawCircle(color = MangaInk, radius = 4.dp.toPx(), center = center)
      }
    }

    // Crisp Manga Dimension Badges below diagram
    Row(
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(
        text = radiusLabel,
        fontFamily = JetBrainsMonoFontFamily,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.labelLarge,
        color = MangaInk,
        modifier =
          Modifier.background(MangaPaperAlt, RoundedCornerShape(3.dp))
            .border(1.5.dp, MangaInk, RoundedCornerShape(3.dp))
            .padding(horizontal = 8.dp, vertical = 3.dp),
      )
      if (spec.centralAngleDeg < 360.0) {
        Text(
          text = "α = $angleStr",
          fontFamily = JetBrainsMonoFontFamily,
          fontWeight = FontWeight.Bold,
          style = MaterialTheme.typography.labelLarge,
          color = MangaCrimson,
          modifier =
            Modifier.background(MangaPaperAlt, RoundedCornerShape(3.dp))
              .border(1.5.dp, MangaCrimson, RoundedCornerShape(3.dp))
              .padding(horizontal = 8.dp, vertical = 3.dp),
        )
      }
    }
  }
}
