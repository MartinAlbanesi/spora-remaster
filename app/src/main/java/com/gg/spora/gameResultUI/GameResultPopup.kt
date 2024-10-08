package com.gg.spora.gameResultUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.SporaPrimaryInverseButton
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getStarsRewards
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
) {

    val (localRewards, totalOxygen) = getStarsRewards(starsState, rewards)

    val champyImage = when (starsState) {
        StarState.STAR_ZERO -> R.drawable.champy_derrotado_brazosalcuerpo
        StarState.STAR_ONE -> R.drawable.champy_serio_idle
        StarState.STAR_TWO -> R.drawable.champy_sonriente_idle
        StarState.STAR_THREE -> R.drawable.champy_celebrando_brazoslevantados
    }

    if (isVisible) {

        Dialog(
            onDismissRequest = onClickPrimaryButton,
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                dismissOnClickOutside = false,
                dismissOnBackPress = false
            )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(24.dp)
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
                        champyImage = champyImage,
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
                                text = if (starsState.starCount != 0) "Siguiente" else "Volver",
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
                starsState = StarState.STAR_ZERO,
                rewards = listOf(10, 20, 60),
                onClickPrimaryButton = {},
                onClickSecondaryButton = {},
            )
        }

    }
}