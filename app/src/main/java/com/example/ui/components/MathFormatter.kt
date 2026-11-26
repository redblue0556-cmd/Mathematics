package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.JetBrainsMonoFontFamily
import com.example.ui.theme.MangaInk

private sealed interface MathToken {
  data class TextSegment(val value: String) : MathToken

  data class Fraction(val numerator: String, val denominator: String) : MathToken
}

private fun parseMathLine(line: String): List<MathToken> {
  val regex = Regex("\\[\\[frac:([^|\\]]+)\\|([^\\]]+)\\]\\]")
  val tokens = mutableListOf<MathToken>()
  var lastIndex = 0
  for (match in regex.findAll(line)) {
    if (match.range.first > lastIndex) {
      val prefix = line.substring(lastIndex, match.range.first)
      prefix.split(" ").forEachIndexed { idx, word ->
        if (idx > 0) tokens.add(MathToken.TextSegment(" "))
        if (word.isNotEmpty()) tokens.add(MathToken.TextSegment(word))
      }
    }
    tokens.add(MathToken.Fraction(match.groupValues[1].trim(), match.groupValues[2].trim()))
    lastIndex = match.range.last + 1
  }
  if (lastIndex < line.length) {
    val suffix = line.substring(lastIndex)
    suffix.split(" ").forEachIndexed { idx, word ->
      if (idx > 0) tokens.add(MathToken.TextSegment(" "))
      if (word.isNotEmpty()) tokens.add(MathToken.TextSegment(word))
    }
  }
  return tokens
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MathRichText(
  text: String,
  modifier: Modifier = Modifier,
  textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
  color: Color = MangaInk,
  isFormulaMono: Boolean = false,
) {
  val lines = remember(text) { text.split("\n") }
  val resolvedStyle =
    if (isFormulaMono) {
      textStyle.copy(
        fontFamily = JetBrainsMonoFontFamily,
        fontWeight = FontWeight.SemiBold,
        color = color,
      )
    } else {
      textStyle.copy(color = color)
    }

  Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(6.dp)) {
    lines.forEach { line ->
      if (!line.contains("[[frac:")) {
        Text(text = line, style = resolvedStyle)
      } else {
        val tokens = remember(line) { parseMathLine(line) }
        // Group consecutive non-space words cleanly in FlowRow with center vertical alignment
        val displayChunks = remember(tokens) { buildDisplayChunks(tokens) }
        FlowRow(
          horizontalArrangement = Arrangement.spacedBy(4.dp),
          verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
        ) {
          displayChunks.forEach { chunk ->
            when (chunk) {
              is MathToken.TextSegment -> {
                if (chunk.value.isNotBlank()) {
                  Text(
                    text = chunk.value,
                    style = resolvedStyle,
                    modifier = Modifier.align(Alignment.CenterVertically),
                  )
                }
              }
              is MathToken.Fraction -> {
                StackedFraction(
                  numerator = chunk.numerator,
                  denominator = chunk.denominator,
                  baseSizeSp = resolvedStyle.fontSize.value,
                  color = color,
                )
              }
            }
          }
        }
      }
    }
  }
}

private fun buildDisplayChunks(tokens: List<MathToken>): List<MathToken> {
  val result = mutableListOf<MathToken>()
  val buffer = StringBuilder()
  for (token in tokens) {
    when (token) {
      is MathToken.TextSegment -> buffer.append(token.value)
      is MathToken.Fraction -> {
        val flushed = buffer.toString().trim()
        if (flushed.isNotEmpty()) {
          flushed.split(" ").forEach { w -> result.add(MathToken.TextSegment(w)) }
        }
        buffer.clear()
        result.add(token)
      }
    }
  }
  val remaining = buffer.toString().trim()
  if (remaining.isNotEmpty()) {
    remaining.split(" ").forEach { w -> result.add(MathToken.TextSegment(w)) }
  }
  return result
}

@Composable
private fun StackedFraction(
  numerator: String,
  denominator: String,
  baseSizeSp: Float,
  color: Color,
) {
  val fracFontSize = (baseSizeSp * 0.82f).coerceAtLeast(11f).sp
  val barWidth =
    maxOf(numerator.length, denominator.length).let { chars ->
      (chars * (baseSizeSp * 0.56f) + 10f).coerceIn(24f, 160f).dp
    }
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(horizontal = 2.dp),
  ) {
    Text(
      text = numerator,
      fontFamily = JetBrainsMonoFontFamily,
      fontWeight = FontWeight.Bold,
      fontSize = fracFontSize,
      lineHeight = (fracFontSize.value + 2f).sp,
      color = color,
      textAlign = TextAlign.Center,
    )
    Box(
      modifier =
        Modifier.padding(vertical = 2.dp)
          .widthIn(min = barWidth)
          .height(1.8.dp)
          .background(color)
    )
    Text(
      text = denominator,
      fontFamily = JetBrainsMonoFontFamily,
      fontWeight = FontWeight.Bold,
      fontSize = fracFontSize,
      lineHeight = (fracFontSize.value + 2f).sp,
      color = color,
      textAlign = TextAlign.Center,
    )
  }
}
