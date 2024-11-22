package com.gg.spora.core.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.animations.TypewriteText
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyBubbleText(
    modifier: Modifier = Modifier,
    champyOffset: IntOffset,
    champyImage: Int,
    showChampyHelp: Boolean = false,
    champyHelpingText: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(champyImage),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
//                .wrapContentWidth(align = Alignment.Start)
                .offset {
                    champyOffset
                }
        )
        AnimatedVisibility(
            visible = showChampyHelp,
            enter = scaleIn() + expandHorizontally(expandFrom = Alignment.CenterHorizontally),
            exit = scaleOut() + shrinkHorizontally(shrinkTowards = Alignment.CenterHorizontally),
            modifier = Modifier
                .weight(1.5f)
                .padding(end = 16.dp)
        ){
            Box(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(R.drawable.text_bubble_v2),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
//                        .offset(x = (-20).dp)
                )

                TypewriteText(
                    text = champyHelpingText,
                    textAlign = TextAlign.Start,
                    textDelay = 100,
                    modifier = Modifier
//                        .clip(MaterialTheme.shapes.medium)
//                        .align(Alignment.CenterStart)
//                        .background(colorResource(R.color.cream))
                        .padding(
                            start = 32.dp,
                            end = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        )
                )
            }
        }
    }
}

//@PreviewLightDark
@Preview
@Preview(device = "spec:width=1080px,height=2340px,dpi=640")
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun ChampyBubbleTextPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampyBubbleText(
                modifier = Modifier.fillMaxWidth(),
                champyImage = R.drawable.champy_serious_idle,
                champyOffset = IntOffset(0, 0),
                showChampyHelp = true,
                champyHelpingText = "La respuesta a la pregunta de la vida, el universo y todo lo demás es 42"
            )
        }
    }
}