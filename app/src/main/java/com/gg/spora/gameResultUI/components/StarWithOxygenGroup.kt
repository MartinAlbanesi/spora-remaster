package com.gg.spora.gameResultUI.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun StarWithOxygenGroup(
    modifier: Modifier = Modifier,
    rewards: List<Pair<Int, Int?>>, // oxygenAmount to starImage
    rotateItems: Map<Float, Int>,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        rewards.forEachIndexed { index, entry ->
            StarWithOxygen(
                oxygenAmount = entry.first,
                starImage = entry.second,
                modifier = Modifier
                    .rotate(rotateItems.keys.elementAt(index))
                    .offset(y = rotateItems.values.elementAt(index).dp)

            )
        }
    }
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun StarWithOxygenGroupPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StarWithOxygenGroup(
                modifier = Modifier,
                rewards = listOf(Pair(0, null),Pair(0, null),Pair(0, null),),
                rotateItems = mapOf(
                    -25f to 0,
                    0f to (-16),
                    25f to 0
                )
            )
        }
    }
}