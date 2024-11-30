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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.animations.TypewriteText
import com.gg.spora.miniGames.ui.models.ChampyHelping
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyBubbleText(
    modifier: Modifier = Modifier,
    champyOffset: IntOffset,
    champyImage: Int,
    showChampyHelp: Boolean = false,
    champyHelpingText: ChampyHelping?
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
                .offset {
                    champyOffset
                }
        )
        champyHelpingText?.let {
            AnimatedVisibility(
                visible = showChampyHelp,
                enter = scaleIn() + expandHorizontally(expandFrom = Alignment.CenterHorizontally),
                exit = scaleOut() + shrinkHorizontally(shrinkTowards = Alignment.CenterHorizontally),
                modifier = Modifier
                    .weight(2.5f)
                    .offset(x = (-10).dp)
            ){
                Box(
                    modifier = Modifier
                ) {
                    Image(
                        painter = painterResource(R.drawable.text_bubble_v2),
                        contentDescription = "bubble text for champy",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxHeight(0.9f)
                            .fillMaxWidth()
                    )

                    TypewriteText(
                        text = champyHelpingText.text,
                        textAlign = champyHelpingText.textAlign,
                        textDelay = 100,
                        fontSize = champyHelpingText.fontSize,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                start = 40.dp,
                                top = 8.dp,
                                bottom = 2.dp
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Preview(device = "spec:width=1080px,height=2340px,dpi=640")
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
                champyHelpingText = ChampyHelping(
                    text = "Hola, soy Champy",
                    fontSize = 20,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}