package com.gg.spora.core.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.utils.functions.getStarState
import com.gg.spora.core.utils.functions.scalarNumber
import com.gg.spora.gameResultUI.GameResultPopUp
import com.gg.spora.miniGames.domain.functions.getChampyImageMiniGame
import com.gg.spora.ui.theme.SporaTheme


@Suppress("LongMethod")
@Composable
fun MiniGameScreen(
    modifier: Modifier = Modifier,
    title: String = "Mini Juego",
    imageBackground: Int,
    isCorrect: Boolean? = null,
    questionSize: Int,
    lives: Int,
    counterQuestion: Int,
    isFinished: Boolean = false,
    showIcon: Boolean = true,
    showButtonContinue: Boolean = true,
    showProgressBar: Boolean = true,
    onNextQuestion: () -> Unit,
    onResetGame: () -> Unit,
    onBackForestStage: () -> Unit,
    onNavigateNextLevel: () -> Unit,
    content: @Composable () -> Unit,
) {
    val champyImage = getChampyImageMiniGame(isCorrect)

    val progressIndicator by animateFloatAsState(
        targetValue = scalarNumber(valor = counterQuestion, maxOriginal = questionSize),
        label = "progressIndicator",
    )

    var showDialogConfirm by rememberSaveable { mutableStateOf(false) }

    if (isFinished) {
        GameResultPopUp(
            isVisible = true,
            backgroundImage = R.drawable.minigame_background_crop,
            starsState = getStarState(lives = lives),
            rewards = listOf(10, 20, 30),
            onBackStage = {
                onBackForestStage()
            },
            onResetGame = {
                onResetGame()
            },
            onNavigateNextLevel = {
                onNavigateNextLevel()
            }
        )
    }

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
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = modifier
        ) {
            TopBarWithTitleExitAndIcon(
                title = title,
                onBackClick = {
                    showDialogConfirm = true
                },
                lives = lives,
                showIcon = showIcon
            )
            if(showProgressBar){
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
                modifier = Modifier.fillMaxSize(),
                champyImage = champyImage,
                isCorrect = isCorrect,
            ) {
                content()
            }
        }
        if(showButtonContinue){
            Button(
                enabled = isCorrect != null,
                onClick = {
                    onNextQuestion()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = colorResource(id = R.color.primary),
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
}

@Preview(
    heightDp = 640,
    widthDp = 360,
)
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