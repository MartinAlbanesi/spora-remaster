package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

/**
 * Composable function to display an icon with text next to it.
 * @param imageResource The [Int] representing the icon.
 * @param text The text to be displayed next to the icon.
 */

@Composable
fun ImageWithTextHorizontal(
    modifier: Modifier = Modifier,
    imageResource: Int,
    text: String
) {
    val textStyle = TextStyle(
        fontSize = 30.sp,
        color = Color.White,
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "Icons of the user's currency",
            modifier = Modifier.size(46.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text,
            style = textStyle
        )
    }
}


@Preview
@Composable
fun IconWithTextPreview() {
    SporaTheme {
        Surface(
            color = Color.Black
        ) {
            ImageWithTextHorizontal(
                imageResource = R.drawable.trees_icon,
                text = "12",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}