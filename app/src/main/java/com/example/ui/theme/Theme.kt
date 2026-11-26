package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val MangaLightColorScheme =
  lightColorScheme(
    primary = MangaCrimson,
    onPrimary = MangaWhite,
    primaryContainer = MangaCrimsonLight,
    onPrimaryContainer = MangaCrimsonDark,
    secondary = MangaInk,
    onSecondary = MangaWhite,
    secondaryContainer = MangaPaperAlt,
    onSecondaryContainer = MangaInk,
    tertiary = MangaGold,
    onTertiary = MangaWhite,
    tertiaryContainer = MangaGoldLight,
    onTertiaryContainer = MangaInk,
    background = MangaPaper,
    onBackground = MangaInk,
    surface = MangaWhite,
    onSurface = MangaInk,
    surfaceVariant = MangaPaperAlt,
    onSurfaceVariant = MangaInkSoft,
    outline = MangaInk,
    outlineVariant = MangaPaperDark,
  )

@Composable
fun MathMasterTheme(content: @Composable () -> Unit) {
  MaterialTheme(
    colorScheme = MangaLightColorScheme,
    typography = MathMasterTypography,
    content = content,
  )
}
