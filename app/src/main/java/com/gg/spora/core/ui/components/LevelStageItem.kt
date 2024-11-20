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

@Composable
fun LevelStageItem(
    modifier: Modifier = Modifier,
    itemNumber: String,
    starsState: StarState,
    stage: StageType,
    isBlocked: Boolean = false
) {

    val stageImage = when (stage) {
        StageType.FOREST -> R.drawable.stage_forest_minigames
        StageType.DESERT -> 1
        StageType.LAKE -> 2
        StageType.EXPO -> R.drawable.stage_forest_minigames
    }

    val currentImage = if (isBlocked) R.drawable.locked_level else stageImage

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
            Text(
                text = itemNumber,
                color = Color.Black,
                fontWeight = FontWeight.Black,
                fontSize = 44.sp,
            )
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
            )
        }
    }
}