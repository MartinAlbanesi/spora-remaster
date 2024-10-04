package com.gg.spora.home.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

/**
 * Composable function to display a text with stroke.
 * @param text The text to be displayed with stroke.
 */
@Composable
fun OutlinedText(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(
        contentAlignment = androidx.compose.ui.Alignment.Center,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = superLargeStyleOutline
        )

        Text(
            text = text,
            style = superLargeStyle
        )
    }

}

// Styles
// Text without outline
val superLargeStyle: TextStyle
    @Composable
    get() {
        return TextStyle(
            color = MaterialTheme.colorScheme.surfaceVariant,
            fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
            fontWeight = MaterialTheme.typography.displayMedium.fontWeight,
            fontSize = 20.sp,
            letterSpacing = 0.2.sp,
            textAlign = TextAlign.Center,
        )
    }

// Outlined text
val superLargeStyleOutline: TextStyle
    @Composable
    get() {
        return superLargeStyle.copy(
            color = MaterialTheme.colorScheme.onBackground,
            drawStyle = Stroke(
                miter = 7f,
                width = 7f,
                join = StrokeJoin.Miter
            ),
        )
    }