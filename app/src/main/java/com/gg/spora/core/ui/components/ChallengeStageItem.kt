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
import com.gg.spora.core.utils.enums.TypeStage

@Composable
fun ChallengeStageItem(
    modifier: Modifier = Modifier,
    stage: TypeStage,
) {
    val challengeImage = when (stage) {
        TypeStage.FOREST -> R.drawable.chanllenger_icon
        TypeStage.DESERT -> 1
        TypeStage.RIVER -> 2
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
                .size(120.dp)
        )

        Image(
            painter = painterResource(R.drawable.crown_icon),
            contentDescription = "Challenge Icon",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(64.dp)
        )
    }
}