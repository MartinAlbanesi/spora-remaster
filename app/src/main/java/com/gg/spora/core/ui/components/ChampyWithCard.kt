package com.gg.spora.core.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

/**
 * Champy with card
 * @param modifier: Modifier
 * @param champyImage: Image of Champy
 * @param content: Content of the card to be displayed
 */
@Composable
fun ChampyWithCard(
    modifier: Modifier = Modifier,
    champyImage: Int,
    isCorrect: Boolean? = null,
    content: @Composable () -> Unit
) {

    val champyAnimation by animateDpAsState(
        targetValue = if (isCorrect == true) 40.dp else 0.dp,
        animationSpec = keyframes {
            durationMillis = 1200
            -40.dp at 200
            40.dp at 400
            -40.dp at 600
            40.dp at 800
            -40.dp at 1000
        },
        label = "champyAnimation"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(champyImage),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .size(200.dp)
                .offset{
                    if (isCorrect == true) {
                        IntOffset(0, champyAnimation.value.toInt())
                    }else{
                        IntOffset(0, 40)
                    }
                }
        )
        Card(
            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxSize()
                .weight(3.5f)
        ) {
            content()
        }

    }

}

@Preview(
    heightDp = 640,
    widthDp = 360,
)
@Preview
//@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun SporaWithCardPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampyWithCard(
                modifier = Modifier.fillMaxSize(),
                champyImage = R.drawable.champy_celebrando_brazoslevantados,
            ) {}
        }
    }
}