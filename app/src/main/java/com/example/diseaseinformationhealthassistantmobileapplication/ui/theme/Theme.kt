package com.example.diseaseinformationhealthassistantmobileapplication.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = TealPrimary,
    onPrimary = OnPrimary,
    secondary = CyanAccent,
    tertiary = TealLight,
    background = Color(0xFF0F172A),
    surface = Color(0xFF1E293B),
    onBackground = Color(0xFFF8FAFC),
    onSurface = Color(0xFFF8FAFC)
)

private val LightColorScheme = lightColorScheme(
    primary = TealPrimary,
    onPrimary = OnPrimary,
    secondary = CyanAccent,
    tertiary = TealLight,
    background = BackgroundColor,
    surface = SurfaceColor,
    onBackground = OnSurface,
    onSurface = OnSurface,
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = TextSecondary
)

/**
 * Applies the chosen background on top of the base light/dark palette.
 * Users can pick a solid black or solid white background independently of dark mode.
 */
private fun ColorScheme.withBackground(blackBackground: Boolean): ColorScheme =
    if (blackBackground) {
        copy(
            background = Color.Black,
            onBackground = Color.White,
            surface = Color(0xFF121212),
            onSurface = Color.White,
            surfaceVariant = Color(0xFF1E1E1E),
            onSurfaceVariant = Color(0xFFD0D0D0)
        )
    } else {
        copy(
            background = Color.White,
            onBackground = Color.Black,
            surface = Color.White,
            onSurface = Color.Black,
            surfaceVariant = Color(0xFFF1F5F9),
            onSurfaceVariant = TextSecondary
        )
    }

@Composable
fun DiseaseInformationHealthAssistantMobileApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    blackBackground: Boolean = darkTheme,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val baseScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = baseScheme.withBackground(blackBackground),
        typography = Typography,
        content = content
    )
}
