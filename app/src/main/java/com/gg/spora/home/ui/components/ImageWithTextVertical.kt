package com.gg.spora.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme


/**
 * Composable function to display an icon with text under it.
 * @param image The [Int] representing the icon.
 * @param text The text to be displayed under the icon.
 */
@Composable
fun ImageWithTextVertical(
    modifier: Modifier = Modifier,
    image: Int,
    text: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            colorFilter = ColorFilter.lighting(add = Color.Black, multiply = Color(0xFF444444)),
            modifier = Modifier
                .size(64.dp)
                /*
                .drawWithContent {
                    drawContent()
                    // Clip the darkening rectangle to the image bounds
                    clipRect {
                        drawRect(Color.Black.copy(alpha = 0.5f)) // Adjust alpha for desired darkness
                    }
                }
                 */
        )
        OutlinedText(text = text)
    }
}

@Preview
@Composable
fun IconWithTextPreview() {
    SporaTheme {
        Surface(
            color = Color.Black
        ) {
            ImageWithTextVertical(
                image = R.drawable.trees_icon,
                text = "12",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}