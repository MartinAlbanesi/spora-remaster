package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.ui.theme.SporaTheme

/**
 * Icon for levels with image and number
 * @param number: level number of the stage
 * @param stars: stars of the stage
 * @param blocked: Boolean to show or not the level
 * @param stage: Stage of the level
 * @param modifier: Modifier
 * @param onClick: Lambda to be executed when the level is clicked
 */

@Composable
fun LevelStageItem(
    modifier: Modifier = Modifier,
    itemNumber: String,
    starsState: StarState,
    stage: StageType,
    isChallenge: Boolean,
//    rewards: List<Int>
) {

    val stageImage = when (stage) {
        StageType.FOREST -> R.drawable.stage_forest_minigames
        StageType.DESERT -> 1
        StageType.RIVER -> 2
        else -> R.drawable.stage_forest_minigames
    }

    val challengeImage = when (stage) {
        StageType.FOREST -> R.drawable.chanllenger_icon
        StageType.DESERT -> 1
        StageType.RIVER -> 2
        else -> R.drawable.nivel_desafio
    }

    val levelImageSelected = if (isChallenge) challengeImage else stageImage

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(levelImageSelected),
            contentDescription = "Level Item",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(100.dp)
        )
        if (!isChallenge) {
            Text(
                text = itemNumber,
                color = Color.Black,
                fontWeight = FontWeight.Black,
                fontSize = 44.sp,
            )
        } else {
            Image(
                painter = painterResource(R.drawable.crown_icon),
                contentDescription = "Challenge Icon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(64.dp)
            )
        }
        if (!isChallenge) {
            StarsGroup(
                starState = starsState,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun LevelStageItemPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LevelStageItem(
                modifier = Modifier,
                itemNumber = "1",
                starsState = StarState.ZERO,
                stage = StageType.FOREST,
                isChallenge = false,
//                rewards = listOf(10, 20, 30)
            )
        }
    }
}