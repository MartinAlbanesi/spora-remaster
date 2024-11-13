package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        StageType.FOREST -> R.drawable.challenge_icon
        StageType.DESERT -> 1
        StageType.RIVER -> 2
        StageType.EXPO -> R.drawable.challenge_icon
    }

    val currentImage = if (isBlocked) R.drawable.locked_level else challengeImage

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(currentImage),
            contentDescription = "Level Item",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(100.dp)
        )
        if (!isBlocked) {
            Image(
                painter = painterResource(R.drawable.crown_icon),
                contentDescription = "Challenge Icon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(64.dp)
            )
        }
    }
}