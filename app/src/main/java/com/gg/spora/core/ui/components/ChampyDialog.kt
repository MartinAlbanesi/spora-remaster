package com.gg.spora.core.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.R
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getStarWithOxygen
import com.gg.spora.gameResultUI.components.ChampyWithRewards
import com.gg.spora.gameResultUI.components.StarWithOxygenGroup
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyDialog(
    modifier: Modifier = Modifier,
    backgroundImage: Int,
    champyImage: Int,
    title: String,
    isVisible: Boolean,
    starsState: StarState,
    rewards: List<Int> = emptyList(),
    isChallenge: Boolean = false,
    textPrimaryButton: String,
    textSecondaryButton: String,
    canAccess: Boolean = true,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: () -> Unit,
    content: @Composable () -> Unit
) {

    val colorFilter = if (backgroundImage == R.drawable.expo_background) {
        ColorFilter.lighting(
            add = Color.Black,
            multiply = Color(0xFF717171)
        )
    } else { null }

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
                    .padding(8.dp)
            ) {

                Image(
                    painter = painterResource(id = backgroundImage),
                    contentDescription = "Fondo minijuegos",
                    contentScale = ContentScale.Crop,
                    colorFilter = colorFilter, // Pass the ColorFilter object
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
                    if(!isChallenge){

                        val localRewards = getStarWithOxygen(starsState, rewards)
                        StarWithOxygenGroup(
                            rewards = localRewards,
                            rotateItems = SporaConstant.ROTATE_ITEMS_REWARDS,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally)
                                .offset(y = (-16).dp)
                        )
                    }
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
                            text = textPrimaryButton,
                            onClick = onClickPrimaryButton,
                            isEnable = canAccess,
                            modifier = Modifier
                                .padding(8.dp)
                        )

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ChampyDialogConfirmPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampyDialog(
                modifier = Modifier,
                backgroundImage = R.drawable.minigame_background,
                champyImage = R.drawable.champy_serious_idle,
                title = "Titi",
                isVisible = true,
                starsState = StarState.ZERO,
                rewards = listOf(0,0,0),
                canAccess = false,
                textPrimaryButton = "Jugar",
                textSecondaryButton = "Cancelar",
                onClickPrimaryButton = {},
                onClickSecondaryButton = { },
            ) {

            }
        }
    }
}