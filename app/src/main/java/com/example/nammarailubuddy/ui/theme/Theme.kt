package com.example.nammarailubuddy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = NeonCyan,
    secondary = PremiumNavyLight,
    tertiary = AccentRed,
    background = PremiumNavy,
    surface = PremiumNavyLight,
    onPrimary = PremiumNavy,
    onSecondary = TextLight,
    onBackground = TextLight,
    onSurface = TextLight
)

private val LightColorScheme = lightColorScheme(
    primary = NeonCyan,
    secondary = PremiumNavy,
    tertiary = AccentRed,
    background = BackgroundLight,
    surface = CardWhite,
    onPrimary = PremiumNavy,
    onSecondary = TextLight,
    onBackground = TextDark,
    onSurface = TextDark
)

@Composable
fun NammaRailuBuddyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // We are going to force a mixed theme based on the screen, but default to light base with dark accents
    val colorScheme = LightColorScheme 

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
