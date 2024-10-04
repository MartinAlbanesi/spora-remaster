package com.gg.spora.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
    imageBackground: Int,
    champyImage: Int,
    onBackClick: () -> Unit,
    content: @Composable () -> Unit,
) {
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
            TopBarWithProgressBar(
                title = "Mini Game",
                onBackClick = onBackClick,
            )
            LinearProgressIndicator(
                progress = { 0.4f },
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
            ) {
                content()
            }
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
                champyImage = R.drawable.champy_celebrando_brazoslevantados,
                onBackClick = { },
                content = {
                    QuizScreen(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        questionTitle = "¿Qué tipo de residuo debe depositarse en el contenedor verde?",
                        answerOptions = FakeQuizModels.fakeAnswers.shuffled().take(4),
                        answerQuestionId = "1",
                        onAnswerSelected = { },
                        onNextQuestion = { }
                    )

                }
            )
        }
    }
}