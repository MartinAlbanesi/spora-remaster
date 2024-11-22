package com.gg.spora.core.ui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gg.spora.R
import com.gg.spora.grove.domain.models.GrowthStage

@Composable
fun TreeGrowthAnimation(
    modifier: Modifier = Modifier,
    growthStage: GrowthStage,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            when (growthStage) {
                GrowthStage.SPROUT -> R.raw.growth_animation // Replace with your animation resource
                GrowthStage.MEDIUM -> R.raw.growth_animation // Replace with your animation resource
                GrowthStage.ADULT -> R.raw.growth_animation // Replace with your animation resource
            }
        )
    )
    LottieAnimation(
        composition = composition,
        iterations = 1, // Play animation once
        modifier = modifier // Adjust size as needed
    )
}