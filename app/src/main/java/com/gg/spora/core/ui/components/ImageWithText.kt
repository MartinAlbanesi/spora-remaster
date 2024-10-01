package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

/**
 * Composable function to display an icon with text next to it.
 * @param icon The [ImageVector] representing the icon.
 * @param text The text to be displayed next to the icon.
 */

@Composable
fun ImageWithText(
    image: Int,
    text: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text)
    }
}

@Preview
@Composable
fun IconWithTextPreview() {
    SporaTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ImageWithText(
                image = R.drawable.trees_icon,
                text = "12"
            )
        }
    }
}