package com.gg.spora.chat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.animations.ChampyBlinkAnimation
import com.gg.spora.core.ui.animations.TypewriteText
import com.gg.spora.core.utils.enums.ChampyStates
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyChatScreen(
    modifier: Modifier = Modifier,
    champyResponses: Pair<ChampyStates, String>? = null,
    onClickNextText: () -> Unit
) {

    Box(
        modifier = modifier
            .scale(2.0f)
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.home_background_rework),
            contentDescription = "Home Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
        )

        if (champyResponses == null) {
            ChampyBlinkAnimation(
                modifier = Modifier
                    .size(140.dp)
                    .align(Alignment.Center)
//                    .offset(x = (-20).dp)
            )
        } else {
            Image(
                painter = painterResource(id = champyResponses.first.image),
                contentDescription = "Champy Blink",
                modifier = modifier
                    .size(140.dp)
                    .align(Alignment.Center)
            )

            TypewriteText(
                text = champyResponses.second,
                preoccupySpace = false,
                modifier = Modifier
                    .scale(0.6f)
                    .offset(x = (-0).dp, y = (150).dp)
                    .clip(MaterialTheme.shapes.medium)
                    .align(Alignment.Center)
                    .background(colorResource(R.color.cream))
                    .fillMaxWidth(0.8f)
                    .padding(16.dp)
                    .clickable { onClickNextText() }
            )
        }
    }
}

@Composable
@Preview
private fun ChampyChatScreenPreview() {

    val wea = mapOf(
        ChampyStates.SMILING to "Hello! I'm Champy, your virtual fitness companion!",
        ChampyStates.CURIOUS to "Did you know that regular exercise can boost your mood and energy levels? yuuuuuuuuuuu asd xcvcxvxcv",
        ChampyStates.GREETING to "Let's get moving and achieve your fitness goals together!"
    )

    var counter by remember { mutableIntStateOf(0) }

    val wea2 by remember {
        mutableStateOf<Pair<ChampyStates, String>?>(
            Pair(
                wea.keys.elementAt(counter),
                wea.values.elementAt(counter)
            )
        )
    }

    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampyChatScreen(
                champyResponses = wea2,
                onClickNextText = {
                    counter++
                }
            )
        }
    }
}