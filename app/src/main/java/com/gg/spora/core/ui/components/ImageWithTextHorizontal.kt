package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable function to display an icon with text next to it.
 * @param image The [Int] representing the icon.
 * @param text The text to be displayed next to the icon.
 */

@Composable
fun ImageWithTextHorizontal(
    image: Int,
    text: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 32.sp
        )
    }
}