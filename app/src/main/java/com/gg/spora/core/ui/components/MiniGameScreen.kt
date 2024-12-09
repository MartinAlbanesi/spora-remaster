package com.gg.spora.core.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.utils.functions.calculateProgress
import com.gg.spora.core.utils.functions.getRewardsStarState
import com.gg.spora.miniGames.domain.functions.getChampyImageMiniGame
import com.gg.spora.miniGames.ui.components.GameRewardsPopUp
import com.gg.spora.miniGames.ui.components.LivesCounter
import com.gg.spora.miniGames.ui.models.ChampyHelping
import com.gg.spora.ui.theme.SporaTheme


@Suppress("LongMethod")
@Composable
fun MiniGameScreen(
    modifier: Modifier = Modifier,
    title: String = "Mini Juego",
    isRewardsLoading: Boolean = false,
    imageBackground: Int,
    isCorrect: Boolean? = null,
    questionSize: Int,
    lives: Int,
    livesLost: Int = 0,
    counterQuestion: Int,
    totalOxygen: Int,
    isFinished: Boolean = false,
    showIcon: Boolean = true,
    showButtonContinue: Boolean = true,
    showProgressBar: Boolean = true,
    showChampyHelp: Boolean = false,
    rewards: List<Int> = emptyList(),
    champyHelpingText: ChampyHelping? = null,
    onNextQuestion: () -> Unit,
    onResetGame: () -> Unit,
    onBackForestStage: () -> Unit,
    onNavigateNextLevel: () -> Unit,
    content: @Composable () -> Unit,
) {

    val textColor by animateColorAsState(
        when (isCorrect) {
            true -> Color.White
            false -> Color.White
            null -> colorResource(R.color.primary_10)
        }, label = "textColor"
    )

    val backgroundColor by animateColorAsState(
        when (isCorrect) {
            true -> colorResource(R.color.secondary)
            false -> colorResource(R.color.error)
            null -> colorResource(R.color.cream)
        },
        label = "backgroundColor"
    )

    val champyImage = getChampyImageMiniGame(isCorrect)

    val progressIndicator by animateFloatAsState(
        targetValue = calculateProgress(valor = counterQuestion, maxOriginal = questionSize),
        label = "progressIndicator",
    )

    var showDialogConfirm by rememberSaveable { mutableStateOf(false) }

    BackHandler {
        showDialogConfirm = true
    }

    ChampyDialogConfirm(
        backgroundImage = R.drawable.minigame_background_crop,
        isVisible = showDialogConfirm,
        onConfirmRequest = {
            showDialogConfirm = false
            onBackForestStage()
        },
        onDismissRequest = {
            showDialogConfirm = false
        }
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(imageBackground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = modifier
        ) {
            TopBarWithLeadingAndTrailingIcon(
                title = title,
                onClickLeadingIcon = {
                    showDialogConfirm = true
                },
                trailingContent = {
                    LivesCounter(
                        lives = lives.toString(),
                    )
                },
            )
            if (showProgressBar) {
                LinearProgressIndicator(
                    progress = { progressIndicator },
                    gapSize = 0.dp,
                    strokeCap = StrokeCap.Butt,
                    color = Color(0xFFf58c0a),
                    trackColor = Color(0xFFffeacc),
                    modifier = Modifier
                        .height(24.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(MaterialTheme.shapes.large)
                )
            }
            ChampyWithCard(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                champyImage = champyImage,
                isCorrect = isCorrect,
                showChampyHelp = showChampyHelp,
                champyHelpingText = champyHelpingText,
            ) {
                content()
            }
        }
        if (showButtonContinue) {
            Button(
                enabled = isCorrect != null,
                onClick = {
                    onNextQuestion()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = textColor,
                    containerColor = backgroundColor,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .heightIn(min = 48.dp, max = 60.dp)
            ) {
                Text(
                    text = "Continuar",
                    color = Color.White,
                )
            }
        }
    }

    if (isFinished) {

        AnimatedVisibility(isRewardsLoading) {
            ShowCircularProgressIndicator(true)
        }

        GameRewardsPopUp(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x66000000))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { },
            backgroundImage = R.drawable.minigame_background_crop,
            starsState = getRewardsStarState(livesLost = livesLost),
            totalOxygen = totalOxygen,
            rewards = rewards,
            isFinished = !isRewardsLoading,
            onBackStage = onBackForestStage,
            onResetGame = onResetGame,
            onNavigateNextLevel = onNavigateNextLevel
        )
    }
}

@Preview(device = "spec:width=1080px,height=2340px,dpi=640")
@Preview
//@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MiniGameScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                imageBackground = R.drawable.minigame_background_crop,
                questionSize = 5,
                lives = 5,
                counterQuestion = 0,
                champyHelpingText = null,
                isCorrect = true,
                isFinished = true,
                totalOxygen = 0,
                rewards = listOf(12, 22, 33),
                onNextQuestion = {},
                onResetGame = {},
                onBackForestStage = {},
                onNavigateNextLevel = {},
                content = {
                }
            )
        }
    }
}