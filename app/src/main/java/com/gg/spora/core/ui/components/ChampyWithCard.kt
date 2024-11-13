package com.gg.spora.core.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    showChampyHelp: Boolean,
    content: @Composable () -> Unit
) {

    val champyAnimation by animateDpAsState(
        targetValue = if (isCorrect == true) 40.dp else 0.dp,
        animationSpec = keyframes {
            durationMillis = 1200
            (-40).dp at 200
            40.dp at 400
            (-40).dp at 600
            40.dp at 800
            (-40).dp at 1000
        },
        label = "champyAnimation"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ChampyBubbleText(
            champyImage = champyImage,
            showChampyHelp = showChampyHelp,
            champyOffset = if (isCorrect == true) {
                IntOffset(0, champyAnimation.value.toInt())
            }else{
                IntOffset(0, 40)
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .size(200.dp)
                .wrapContentWidth(Alignment.Start)
        )
        Card(
            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxSize()
                .weight(4f)
        ) {
            content()
        }

    }

}

@Preview(device = "spec:width=1080px,height=2340px,dpi=640")
@Preview
//@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun SporaWithCardPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF981E1E)
        ) {
            ChampyWithCard(
                modifier = Modifier.fillMaxSize(),
                champyImage = R.drawable.champy_celebrating_raised_arms,
                showChampyHelp = false
            ) {}
        }
    }
}