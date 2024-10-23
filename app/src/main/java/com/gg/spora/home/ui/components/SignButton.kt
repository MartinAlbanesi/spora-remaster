package com.gg.spora.home.ui.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Forest Sign Button
@Composable
fun SignButton(
    modifier: Modifier = Modifier,
    image: Int,
    cornerRadius: Dp = 16.dp // Adjust corner radius as needed
) {
    val infiniteTransition = rememberInfiniteTransition()
    val backgroundColor = infiniteTransition.animateColor(
        initialValue = Color.Transparent,
        targetValue = Color.White.copy(alpha = 0.2f),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    ).value

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "Wood Sign",
            modifier = modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(cornerRadius)) // Clip to rounded corners
                .background(backgroundColor),
        )
    }
}