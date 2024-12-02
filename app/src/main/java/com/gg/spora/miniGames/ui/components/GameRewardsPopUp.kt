package com.gg.spora.miniGames.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.SporaPrimaryInverseButton
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getStarWithOxygen
import com.gg.spora.gameResultUI.components.ChampyWithRewards
import com.gg.spora.gameResultUI.components.StarWithOxygen
import com.gg.spora.miniGames.domain.functions.getChampyImageReward
import com.gg.spora.ui.theme.SporaTheme
import com.google.android.play.integrity.internal.i
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun GameRewardsPopUp(
    modifier: Modifier = Modifier,
    title: String = "Recompensa",
    @DrawableRes backgroundImage: Int,
    starsState: StarState,
    totalOxygen: Int,
    rewards: List<Int>,
    isFinished: Boolean = true,
    onNavigateNextLevel: () -> Unit,
    onResetGame: () -> Unit,
    onBackStage: () -> Unit,
) {

    val textPrimaryButton = if (starsState.starCount != 0) "Siguiente" else "Reiniciar"
    val textSecondaryButton = "Volver"

    val champyImage = getChampyImageReward(starsState)

    val localRewards = getStarWithOxygen(starsState, rewards)

    val rotateItems = SporaConstant.ROTATE_ITEMS_REWARDS

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            isFinished,
            enter = scaleIn(animationSpec = tween(800)),
            exit = scaleOut()
        ) {
            Image(
                painter = painterResource(id = backgroundImage),
                contentDescription = "Fondo minijuegos",
                contentScale = ContentScale.Crop,
//            colorFilter = colorFilter, // Pass the ColorFilter object
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(MaterialTheme.shapes.extraLarge)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .offset(y = (-16).dp)
                ) {
                    localRewards.forEachIndexed { index, entry ->
                        StarWithOxygen(
                            oxygenAmount = entry.first,
                            starImage = entry.second,
                            modifier = Modifier
                                .animateContentSize()
                                .rotate(rotateItems.keys.elementAt(index))
                                .offset(y = rotateItems.values.elementAt(index).dp)
                        )
                    }
                }

                ChampyWithRewards(
                    champyImage = champyImage,
                    title = title,
                    body = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.oxygen_icon),
                                contentDescription = "Oxígeno",
                                modifier = Modifier.size(48.dp)
                            )
                            Text(
                                text = "+ $totalOxygen",
                                fontSize = 24.sp,
                                color = Color.White,
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color.Black,
                                        offset = Offset(5f, 5f),
                                        blurRadius = 5f
                                    )
                                ),
                            )
                        }
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
                        onClick = if (starsState.starCount != 0) onNavigateNextLevel else onResetGame,
                        modifier = Modifier
                            .padding(8.dp)
                    )

                    SporaPrimaryButton(
                        text = textPrimaryButton,
                        onClick = onBackStage,
                        modifier = Modifier
                            .padding(8.dp)
                    )

                }
            }
        }
    }
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun GameRewardsPopUpPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GameRewardsPopUp(
                modifier = Modifier,
                backgroundImage = R.drawable.minigame_background,
                title = "Titi",
                starsState = StarState.THREE,
                rewards = listOf(0, 0, 0),
                totalOxygen = 100,
                onNavigateNextLevel = { },
                onResetGame = { },
                onBackStage = { },
            )
        }
    }
}