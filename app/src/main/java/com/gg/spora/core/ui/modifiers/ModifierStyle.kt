package com.gg.spora.core.ui.modifiers

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object ModifierStyle {
    val brush = Modifier
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(Color.Black, Color.Transparent)
            )
        )
}