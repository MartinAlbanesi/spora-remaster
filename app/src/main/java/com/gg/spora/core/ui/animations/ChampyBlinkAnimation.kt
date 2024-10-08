package com.gg.spora.core.ui.animations

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay

@Composable
fun ChampyBlinkAnimation(modifier: Modifier, delay: Long) {

    val initialFrame: Int = ChampyStates.SMILING.image
    val finalFrame: Int = ChampyStates.BLINK.image

    var isTimePassed by remember { mutableStateOf(false) }
    var coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {

        while (true) {

            delay(delay)
            isTimePassed = true


            delay(200)
            isTimePassed = false
        }
    }

    Image(
        painter = painterResource(id = if (isTimePassed) finalFrame else initialFrame),
        contentDescription = "Champy Blink",
        modifier = modifier
    )


}