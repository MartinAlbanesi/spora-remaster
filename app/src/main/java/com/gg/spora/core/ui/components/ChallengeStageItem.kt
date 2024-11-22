package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.utils.enums.StageType

@Composable
fun ChallengeStageItem(
    modifier: Modifier = Modifier,
    stage: StageType,
    isBlocked: Boolean = false
) {
    val challengeImage = when (stage) {
        StageType.FOREST -> R.drawable.sunflower_challenge
        StageType.DESERT -> 1
        StageType.LAKE -> 2
        StageType.EXPO -> R.drawable.challenge_icon
    }

    val colorMatrix = remember { ColorMatrix() }

    if (isBlocked) {
        colorMatrix.setToSaturation(0f) // Set saturation to 0 for grayscale
    } else {
        colorMatrix.setToSaturation(1f)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(challengeImage),
            contentDescription = "Level Item",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(140.dp),
            colorFilter = ColorFilter.colorMatrix(colorMatrix)
        )
    }
}