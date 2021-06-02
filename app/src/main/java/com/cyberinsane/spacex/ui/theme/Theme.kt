package com.cyberinsane.spacex.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CyberSpaceXColors = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.Black

    /* Other default colors to override

    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CyberSpaceXTheme(
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = CyberSpaceXColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
