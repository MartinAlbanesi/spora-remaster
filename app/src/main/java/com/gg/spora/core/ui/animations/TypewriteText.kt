package com.gg.spora.core.ui.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gg.spora.R
import kotlinx.coroutines.delay

@Composable
fun TypewriteText(
    text: String,
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    textAlign: TextAlign = TextAlign.Left,
    spec: AnimationSpec<Int> = tween(text.length * 25, easing = LinearEasing),
    style: TextStyle = LocalTextStyle.current,
    preoccupySpace: Boolean = true,
    fontSize: Int = 16,
    textDelay: Long = 0,
    showNextIcon: Boolean = true
){
    // State that keeps the text that is currently animated
    var textToAnimate by remember { mutableStateOf("") }

    // Animatable index to control the progress of the animation
    val index = remember {
        Animatable(initialValue = 0, typeConverter = Int.VectorConverter)
    }

    val lottie = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.next))

    // Effect to handle animation when visibility changes
    LaunchedEffect(isVisible) {
        delay(textDelay)
        if (isVisible) {
            // Start animation if visible
            textToAnimate = text
            index.animateTo(text.length, spec)
        } else {
            // Snap to the beginning if not visible
            index.snapTo(0)
        }
    }

    // Effect to handle animation when text content changes
    LaunchedEffect(text) {
        delay(textDelay)
        if (isVisible) {
            // Reset animation and update text if visible
            index.snapTo(0)
            textToAnimate = text
            index.animateTo(text.length, spec)
        }
    }

    // Box composable to contain the animated and static text
    Box(modifier = modifier) {
        if (preoccupySpace && index.isRunning) {
            // Display invisible text when preoccupation is turned on
            // and the animation is in progress.
            // Plays the role of a placeholder to occupy the space
            // that will be filled with text.
            Text(
                text = text,
                style = style,
                textAlign = textAlign,
                fontSize = fontSize.sp,
                modifier = Modifier.alpha(0f)
            )
        }

        // Display animated text based on the current index value
        Text(
            text = textToAnimate.substring(0, index.value),
            style = style,
            textAlign = textAlign,
            fontSize = fontSize.sp
        )
        if (showNextIcon && !index.isRunning){
            LottieAnimation(
                composition = lottie.value,
                speed = 2.0f,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = (16).dp, y = (16).dp)
            )
        }
    }
}