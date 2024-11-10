package com.gg.spora.core.ui.animations

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.gg.spora.core.utils.enums.MushyStates
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun MushyBlinkAnimation(modifier: Modifier) {

    val initialFrame: Int = MushyStates.SERIOUS.image
    val finalFrame: Int = MushyStates.IDLE.image
    var isTimePassed by remember { mutableStateOf(false) }
    rememberCoroutineScope()


    LaunchedEffect(Unit) {

        while (true) {

            delay(Random.nextLong(3000, 5000))
            isTimePassed = true


            delay(200)
            isTimePassed = false
        }
    }

    Image(
        painter = painterResource(id = if (isTimePassed) finalFrame else initialFrame),
        contentDescription = "Mushy Blink",
        modifier = modifier
    )
}