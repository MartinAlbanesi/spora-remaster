package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getStarWithOxygen
import com.gg.spora.gameResultUI.components.ChampyWithRewards
import com.gg.spora.gameResultUI.components.StarWithOxygenGroup

@Composable
fun ChampyDialog(
    modifier: Modifier = Modifier,
    backgroundImage: Int,
    champyImage: Int,
    title: String,
    isVisible: Boolean,
    starsState: StarState,
    rewards: List<Int>,
    textPrimaryButton: String,
    textSecondaryButton: String,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: () -> Unit,
    content: @Composable () -> Unit
) {
//    val (localRewards, totalOxygen) = getStarsRewards(starsState, rewards)

    val localRewards = getStarWithOxygen(starsState, rewards)

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
                        title = title,
                        body = {
                            content()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SporaPrimaryInverseButton(
                            text = textSecondaryButton,
                            onClick = onClickSecondaryButton,
                            modifier = Modifier
                                .padding(8.dp)
                        )

                        SporaPrimaryButton(
                            text = textPrimaryButton, //if (starsState.starCount != 0) "Siguiente" else "Volver",
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