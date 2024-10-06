package com.gg.spora.gameResultUI

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.SporaPrimaryInverseButton
import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.gameResultUI.components.ChampyWithRewards
import com.gg.spora.gameResultUI.components.StarWithOxygen
import com.gg.spora.ui.theme.SporaTheme


@Composable
private fun StarWithOxygenGroup(
    modifier: Modifier = Modifier,
    rewards: Map<Int, Int>, // oxygenAmount to starImage
) {

    val rotateItem = mapOf(
        -25f to 0.dp,
        0f to (-16).dp,
        25f to 0.dp
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        rewards.entries.toList().forEachIndexed { index, entry ->
            StarWithOxygen(
                oxygenAmount = entry.key,
                starImage = entry.value,
                modifier = Modifier
                    .offset(y = rotateItem.values.elementAt(index))
                    .rotate(rotateItem.keys.elementAt(index))
            )
        }
    }
}

enum class StarState(val starCount: Int = 0) {
    STAR_ONE(1),
    STAR_TWO(2),
    STAR_THREE(3)
}

@Composable
fun GameResultPopUp(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    backgroundImage: Int,
    starsState: StarState,
    rewards: List<Int>,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    val localRewards: MutableMap<Int, Int> = mutableMapOf()

    var totalOxygen by remember {
        mutableIntStateOf(0)
    }

    for (i in 1..MAX_STAR){
        if(i <= starsState.starCount){
            localRewards[rewards[i-1]] = R.drawable.estrella
        }else{
            localRewards[rewards[i-1]] = R.drawable.estrella_gris
        }
    }

    if (isVisible) {

        Dialog (onDismissRequest = onDismissRequest) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    StarWithOxygenGroup(
                        rewards = localRewards,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )
                    ChampyWithRewards(
                        champyImage = R.drawable.champy_sonriente_idle,
                        oxygenAmount = 20,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SporaPrimaryInverseButton(
                            text = "Reiniciar",
                            onClick = onClickSecondaryButton,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                        SporaPrimaryButton(
                            text = "Siguiente",
                            onClick = onClickPrimaryButton,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GameResultPopupPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GameResultPopUp(
                isVisible = true,
                backgroundImage = R.drawable.fondo_minijuegos,
                starsState = StarState.STAR_THREE,
                rewards = listOf(10, 20, 30),
                onClickPrimaryButton = {},
                onClickSecondaryButton = {},
                onDismissRequest = {}
            )
        }

    }
}