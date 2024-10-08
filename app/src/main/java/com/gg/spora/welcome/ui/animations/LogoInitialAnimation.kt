package com.gg.spora.welcome.ui.animations

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LogoInitialAnimation(modifier: Modifier, image: Int) {

    var scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = false) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }

    Image(
        painter = painterResource(id = image),
        contentDescription = "Logo",
        modifier = modifier
            .size(350.dp)
            .offset(y = (-50).dp)
            .scale(scale.value)
    )
}