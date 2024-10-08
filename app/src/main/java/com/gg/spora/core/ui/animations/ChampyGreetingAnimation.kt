package com.gg.spora.core.ui.animations

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay

@Composable
fun ChampyGreetingAnimation(modifier: Modifier) {

    var isClicked by remember { mutableStateOf(false) }

    Image(
        painter =
        if (isClicked) painterResource(id = ChampyStates.GREETING.image)
        else painterResource(id = ChampyStates.SMILING.image),
        contentDescription = "Champy Smiling",
        modifier = modifier.clickable(
            enabled = true,
            onClick = { isClicked = !isClicked },
            onClickLabel = "Champy Greeting",
            role = null,
            indication = null,
            interactionSource = null
        )
    )

    LaunchedEffect(isClicked) {
        if (isClicked) {
            delay(1000)
            isClicked = false
        }
    }
}