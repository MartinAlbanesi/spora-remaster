package com.gg.spora.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Immutable
data class ExtendedColorScheme(
    val primary30: ColorFamily,
    val primary20: ColorFamily,
    val primary10: ColorFamily,
    val secondary30: ColorFamily,
    val tertiary20: ColorFamily,
    val tertiary10: ColorFamily,
    val primaryStrong: ColorFamily,
    val mushyDialog: ColorFamily,
)

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

val extendedLight = ExtendedColorScheme(
    primary30 = ColorFamily(
        primary30Light,
        onPrimary30Light,
        primary30ContainerLight,
        onPrimary30ContainerLight,
    ),
    primary20 = ColorFamily(
        primary20Light,
        onPrimary20Light,
        primary20ContainerLight,
        onPrimary20ContainerLight,
    ),
    primary10 = ColorFamily(
        primary10Light,
        onPrimary10Light,
        primary10ContainerLight,
        onPrimary10ContainerLight,
    ),
    secondary30 = ColorFamily(
        secondary30Light,
        onSecondary30Light,
        secondary30ContainerLight,
        onSecondary30ContainerLight,
    ),
    tertiary20 = ColorFamily(
        tertiary20Light,
        onTertiary20Light,
        tertiary20ContainerLight,
        onTertiary20ContainerLight,
    ),
    tertiary10 = ColorFamily(
        tertiary10Light,
        onTertiary10Light,
        tertiary10ContainerLight,
        onTertiary10ContainerLight,
    ),
    primaryStrong = ColorFamily(
        primaryStrongLight,
        onPrimaryStrongLight,
        primaryStrongContainerLight,
        onPrimaryStrongContainerLight,
    ),
    mushyDialog = ColorFamily(
        mushyDialogLight,
        onMushyDialogLight,
        mushyDialogContainerLight,
        onMushyDialogContainerLight,
    ),
)

val extendedDark = ExtendedColorScheme(
    primary30 = ColorFamily(
        primary30Dark,
        onPrimary30Dark,
        primary30ContainerDark,
        onPrimary30ContainerDark,
    ),
    primary20 = ColorFamily(
        primary20Dark,
        onPrimary20Dark,
        primary20ContainerDark,
        onPrimary20ContainerDark,
    ),
    primary10 = ColorFamily(
        primary10Dark,
        onPrimary10Dark,
        primary10ContainerDark,
        onPrimary10ContainerDark,
    ),
    secondary30 = ColorFamily(
        secondary30Dark,
        onSecondary30Dark,
        secondary30ContainerDark,
        onSecondary30ContainerDark,
    ),
    tertiary20 = ColorFamily(
        tertiary20Dark,
        onTertiary20Dark,
        tertiary20ContainerDark,
        onTertiary20ContainerDark,
    ),
    tertiary10 = ColorFamily(
        tertiary10Dark,
        onTertiary10Dark,
        tertiary10ContainerDark,
        onTertiary10ContainerDark,
    ),
    primaryStrong = ColorFamily(
        primaryStrongDark,
        onPrimaryStrongDark,
        primaryStrongContainerDark,
        onPrimaryStrongContainerDark,
    ),
    mushyDialog = ColorFamily(
        mushyDialogDark,
        onMushyDialogDark,
        mushyDialogContainerDark,
        onMushyDialogContainerDark,
    ),
)

val extendedLightMediumContrast = ExtendedColorScheme(
    primary30 = ColorFamily(
        primary30LightMediumContrast,
        onPrimary30LightMediumContrast,
        primary30ContainerLightMediumContrast,
        onPrimary30ContainerLightMediumContrast,
    ),
    primary20 = ColorFamily(
        primary20LightMediumContrast,
        onPrimary20LightMediumContrast,
        primary20ContainerLightMediumContrast,
        onPrimary20ContainerLightMediumContrast,
    ),
    primary10 = ColorFamily(
        primary10LightMediumContrast,
        onPrimary10LightMediumContrast,
        primary10ContainerLightMediumContrast,
        onPrimary10ContainerLightMediumContrast,
    ),
    secondary30 = ColorFamily(
        secondary30LightMediumContrast,
        onSecondary30LightMediumContrast,
        secondary30ContainerLightMediumContrast,
        onSecondary30ContainerLightMediumContrast,
    ),
    tertiary20 = ColorFamily(
        tertiary20LightMediumContrast,
        onTertiary20LightMediumContrast,
        tertiary20ContainerLightMediumContrast,
        onTertiary20ContainerLightMediumContrast,
    ),
    tertiary10 = ColorFamily(
        tertiary10LightMediumContrast,
        onTertiary10LightMediumContrast,
        tertiary10ContainerLightMediumContrast,
        onTertiary10ContainerLightMediumContrast,
    ),
    primaryStrong = ColorFamily(
        primaryStrongLightMediumContrast,
        onPrimaryStrongLightMediumContrast,
        primaryStrongContainerLightMediumContrast,
        onPrimaryStrongContainerLightMediumContrast,
    ),
    mushyDialog = ColorFamily(
        mushyDialogLightMediumContrast,
        onMushyDialogLightMediumContrast,
        mushyDialogContainerLightMediumContrast,
        onMushyDialogContainerLightMediumContrast,
    ),
)

val extendedLightHighContrast = ExtendedColorScheme(
    primary30 = ColorFamily(
        primary30LightHighContrast,
        onPrimary30LightHighContrast,
        primary30ContainerLightHighContrast,
        onPrimary30ContainerLightHighContrast,
    ),
    primary20 = ColorFamily(
        primary20LightHighContrast,
        onPrimary20LightHighContrast,
        primary20ContainerLightHighContrast,
        onPrimary20ContainerLightHighContrast,
    ),
    primary10 = ColorFamily(
        primary10LightHighContrast,
        onPrimary10LightHighContrast,
        primary10ContainerLightHighContrast,
        onPrimary10ContainerLightHighContrast,
    ),
    secondary30 = ColorFamily(
        secondary30LightHighContrast,
        onSecondary30LightHighContrast,
        secondary30ContainerLightHighContrast,
        onSecondary30ContainerLightHighContrast,
    ),
    tertiary20 = ColorFamily(
        tertiary20LightHighContrast,
        onTertiary20LightHighContrast,
        tertiary20ContainerLightHighContrast,
        onTertiary20ContainerLightHighContrast,
    ),
    tertiary10 = ColorFamily(
        tertiary10LightHighContrast,
        onTertiary10LightHighContrast,
        tertiary10ContainerLightHighContrast,
        onTertiary10ContainerLightHighContrast,
    ),
    primaryStrong = ColorFamily(
        primaryStrongLightHighContrast,
        onPrimaryStrongLightHighContrast,
        primaryStrongContainerLightHighContrast,
        onPrimaryStrongContainerLightHighContrast,
    ),
    mushyDialog = ColorFamily(
        mushyDialogLightHighContrast,
        onMushyDialogLightHighContrast,
        mushyDialogContainerLightHighContrast,
        onMushyDialogContainerLightHighContrast,
    ),
)

val extendedDarkMediumContrast = ExtendedColorScheme(
    primary30 = ColorFamily(
        primary30DarkMediumContrast,
        onPrimary30DarkMediumContrast,
        primary30ContainerDarkMediumContrast,
        onPrimary30ContainerDarkMediumContrast,
    ),
    primary20 = ColorFamily(
        primary20DarkMediumContrast,
        onPrimary20DarkMediumContrast,
        primary20ContainerDarkMediumContrast,
        onPrimary20ContainerDarkMediumContrast,
    ),
    primary10 = ColorFamily(
        primary10DarkMediumContrast,
        onPrimary10DarkMediumContrast,
        primary10ContainerDarkMediumContrast,
        onPrimary10ContainerDarkMediumContrast,
    ),
    secondary30 = ColorFamily(
        secondary30DarkMediumContrast,
        onSecondary30DarkMediumContrast,
        secondary30ContainerDarkMediumContrast,
        onSecondary30ContainerDarkMediumContrast,
    ),
    tertiary20 = ColorFamily(
        tertiary20DarkMediumContrast,
        onTertiary20DarkMediumContrast,
        tertiary20ContainerDarkMediumContrast,
        onTertiary20ContainerDarkMediumContrast,
    ),
    tertiary10 = ColorFamily(
        tertiary10DarkMediumContrast,
        onTertiary10DarkMediumContrast,
        tertiary10ContainerDarkMediumContrast,
        onTertiary10ContainerDarkMediumContrast,
    ),
    primaryStrong = ColorFamily(
        primaryStrongDarkMediumContrast,
        onPrimaryStrongDarkMediumContrast,
        primaryStrongContainerDarkMediumContrast,
        onPrimaryStrongContainerDarkMediumContrast,
    ),
    mushyDialog = ColorFamily(
        mushyDialogDarkMediumContrast,
        onMushyDialogDarkMediumContrast,
        mushyDialogContainerDarkMediumContrast,
        onMushyDialogContainerDarkMediumContrast,
    ),
)

val extendedDarkHighContrast = ExtendedColorScheme(
    primary30 = ColorFamily(
        primary30DarkHighContrast,
        onPrimary30DarkHighContrast,
        primary30ContainerDarkHighContrast,
        onPrimary30ContainerDarkHighContrast,
    ),
    primary20 = ColorFamily(
        primary20DarkHighContrast,
        onPrimary20DarkHighContrast,
        primary20ContainerDarkHighContrast,
        onPrimary20ContainerDarkHighContrast,
    ),
    primary10 = ColorFamily(
        primary10DarkHighContrast,
        onPrimary10DarkHighContrast,
        primary10ContainerDarkHighContrast,
        onPrimary10ContainerDarkHighContrast,
    ),
    secondary30 = ColorFamily(
        secondary30DarkHighContrast,
        onSecondary30DarkHighContrast,
        secondary30ContainerDarkHighContrast,
        onSecondary30ContainerDarkHighContrast,
    ),
    tertiary20 = ColorFamily(
        tertiary20DarkHighContrast,
        onTertiary20DarkHighContrast,
        tertiary20ContainerDarkHighContrast,
        onTertiary20ContainerDarkHighContrast,
    ),
    tertiary10 = ColorFamily(
        tertiary10DarkHighContrast,
        onTertiary10DarkHighContrast,
        tertiary10ContainerDarkHighContrast,
        onTertiary10ContainerDarkHighContrast,
    ),
    primaryStrong = ColorFamily(
        primaryStrongDarkHighContrast,
        onPrimaryStrongDarkHighContrast,
        primaryStrongContainerDarkHighContrast,
        onPrimaryStrongContainerDarkHighContrast,
    ),
    mushyDialog = ColorFamily(
        mushyDialogDarkHighContrast,
        onMushyDialogDarkHighContrast,
        mushyDialogContainerDarkHighContrast,
        onMushyDialogContainerDarkHighContrast,
    ),
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun SporaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

