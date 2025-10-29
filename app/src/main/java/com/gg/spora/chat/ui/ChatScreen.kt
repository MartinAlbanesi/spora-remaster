package com.gg.spora.chat.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import com.gg.spora.core.ui.animations.TypewriteText
import com.gg.spora.core.utils.enums.ChampyStates
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    champyResponses: ChatUiState,
    showTextField: Boolean = true,
    onClickNextText: () -> Unit,
    getResponseFromIA: (String) -> Unit
) {

    var textMessage by remember  { mutableStateOf("") }

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

        Box(
            modifier = Modifier
//                .scale(2.0f)
                .fillMaxSize()
                .align(Alignment.Center)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    if (champyResponses.showNextIcon) {
                        onClickNextText()
                    }
                }
        ){
            Image(
                painter = painterResource(id = champyResponses.response.state.image),
                contentDescription = champyResponses.response.state.name,
                modifier = modifier
                    .size(140.dp)
                    .align(Alignment.Center)
            )
            TypewriteText(
                text = champyResponses.response.message,
                preoccupySpace = false,
                showNextIcon = champyResponses.showNextIcon,
                modifier = Modifier
                    .scale(0.6f)
                    .offset(x = (-0).dp, y = (150).dp)
                    .clip(MaterialTheme.shapes.medium)
                    .align(Alignment.Center)
                    .background(colorResource(R.color.cream))
                    .fillMaxWidth(0.8f)
                    .padding(16.dp)
            )
        }
    }

    AnimatedVisibility(
        visible = showTextField,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(
            targetOffsetY = { it },
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            ChatTextField(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                value = textMessage,
                onValueChange = { textMessage = it},
                onSend = { getResponseFromIA(textMessage)},
            )
        }
    }

//    }
}

@Composable
@Preview
//@PreviewScreenSizes
private fun ChampyChatScreenPreview() {

//    val wea = mapOf(
//        ChampyStates.SMILING to "Hello! I'm Champy, your virtual fitness companion!",
//        ChampyStates.CURIOUS to "Did you know that regular exercise can boost your mood and energy levels? yuuuuuuuuuuu asd xcvcxvxcv",
//        ChampyStates.GREETING to "Let's get moving and achieve your fitness goals together!"
//    )

    var counter by remember { mutableIntStateOf(0) }

    val champyChat = ChatUiState.Success(
        ChampyResponseChat(
            ChampyStates.SMILING,
            "Hello! I'm Champy, your virtual fitness companion!"
        )
    )

    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChatScreen(
                champyResponses = champyChat,
                onClickNextText = {
                    counter++
                },
                getResponseFromIA = {}
            )
        }
    }
}
