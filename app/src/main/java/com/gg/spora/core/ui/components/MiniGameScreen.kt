package com.gg.spora.core.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.utils.functions.getStarState
import com.gg.spora.core.utils.functions.scalarNumber
import com.gg.spora.gameResultUI.GameResultPopUp
import com.gg.spora.quiz.ui.QuizScreen
import com.gg.spora.ui.theme.SporaTheme

/**
 * Screen for mini games with Spora and progress bar
 * @param modifier: Modifier
 * @param imageBackground: Background image
 * @param onBackClick: Click listener for back button
 * @param content: Content of the screen in the champy card
 */
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
    onNextQuestion: () -> Unit,
    onResetGame: () -> Unit,
    onBackForestStage: () -> Unit,
    content: @Composable () -> Unit,
) {
    val champyImage = when (isCorrect) {
        true -> R.drawable.champy_celebrando_brazoslevantados
        false -> R.drawable.champy_triste_brazosalcuerpo
        else -> R.drawable.champy_curioso_brazo_izquierdo_en_la_mejilla
    }

    val progressIndicator by animateFloatAsState(
        targetValue = scalarNumber(valor = counterQuestion, maxOriginal = questionSize),
        label = "progressIndicator",
    )

    var showDialogConfirm by rememberSaveable { mutableStateOf(false) }

    if (isFinished) {
        GameResultPopUp(
            isVisible = true,
            backgroundImage = R.drawable.fondo_minijuegos_crop,
            starsState = getStarState(lives = lives),
            rewards = listOf(10, 20, 30),
            onClickPrimaryButton = {
                onBackForestStage()
            },
            onClickSecondaryButton = {
                onResetGame()
            },
        )
    }

    BackHandler {
        showDialogConfirm = true
    }

    ChampyDialogConfirm(
        backgroundImage = R.drawable.fondo_minijuegos_crop,
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
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-360).dp)
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
            )
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
            ChampyWithCard(
                modifier = Modifier.fillMaxSize(),
                champyImage = champyImage,
                isCorrect = isCorrect,
            ) {
                content()
            }
        }
        Button(
            enabled = isCorrect != null,
            onClick = {
                onNextQuestion()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFFf58c0a),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .height(60.dp)
        ) {
            Text(
                text = "Continuar",
                color = Color.White,
            )
        }
    }
}

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
                imageBackground = R.drawable.fondo_minijuegos,
                questionSize = 5,
                lives = 5,
                counterQuestion = 0,
                onNextQuestion = {},
                onResetGame = {},
                onBackForestStage = {},
                content = {
                    QuizScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        questionTitle = "¿Qué tipo de residuo debe depositarse en el contenedor verde?",
                        answerOptions = FakeQuizModels.fakeAnswers.shuffled().take(4),
                        onAnswerSelected = { },
                    )

                }
            )
        }
    }
}