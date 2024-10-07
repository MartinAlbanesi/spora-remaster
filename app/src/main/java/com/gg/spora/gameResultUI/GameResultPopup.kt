package com.gg.spora.gameResultUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.SporaPrimaryInverseButton
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.gameResultUI.components.ChampyWithRewards
import com.gg.spora.gameResultUI.components.StarWithOxygenGroup
import com.gg.spora.ui.theme.SporaTheme


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

    for (i in 1..MAX_STAR) {
        if (i <= starsState.starCount) {
            localRewards[rewards[i - 1]] = R.drawable.estrella
            totalOxygen += rewards[i - 1]
        } else {
            localRewards[rewards[i - 1]] = R.drawable.estrella_gris
        }
    }

    if (isVisible) {

        Dialog(onDismissRequest = onDismissRequest) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {

                Image(
                    painter = painterResource(id = backgroundImage),
                    contentDescription = "Fondo minijuegos",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(MaterialTheme.shapes.extraLarge)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    StarWithOxygenGroup(
                        rewards = localRewards,
                        rotateItems = SporaConstant.ROTATE_ITEMS_REWARDS,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .offset(y = -16.dp)
                    )
                    ChampyWithRewards(
                        champyImage = R.drawable.champy_sonriente_idle,
                        oxygenAmount = totalOxygen,
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
                backgroundImage = R.drawable.fondo_minijuegos_crop,
                starsState = StarState.STAR_TWO,
                rewards = listOf(10, 20, 30),
                onClickPrimaryButton = {},
                onClickSecondaryButton = {},
                onDismissRequest = {}
            )
        }

    }
}