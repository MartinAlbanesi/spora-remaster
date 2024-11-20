package com.gg.spora.miniGames.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.ui.components.OptionItemButton
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.ui.theme.SporaTheme


@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    questionTitle: String,
    isCorrect: Boolean? = null,
    answerOptions: List<Answer>,
    onAnswerSelected: (String) -> Unit,
    onConfirmAnswer: (String) -> Unit
) {

    var selectedAnswerId by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = modifier,
        ) {
            Text(
                text = questionTitle,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .weight(1f)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(4f)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    answerOptions.forEach { answer ->
                        OptionItemButton(
                            textItem = answer.answer,
                            isCorrect = answer.isCorrect,
                            enabled = isCorrect == null,
                            hasIcon = false,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(MaterialTheme.shapes.large)
                                .fillMaxWidth(0.4f)
                                .heightIn(min = 54.dp)
                                .fillMaxHeight(0.1f),
                        ) {
                            onAnswerSelected(answer.id)
                            selectedAnswerId = answer.id
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        if (answerOptions.filter { it.isCorrect == null }.size != 4) {
            Button(
                onClick = { onConfirmAnswer(selectedAnswerId) },
                modifier = Modifier
                    .padding(16.dp)
                    .heightIn(min = 48.dp, max = 60.dp)
//                    .fillMaxHeight(0.15f)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Text(text = "Confirmar")
            }
        }
    }
}

@Preview
@Preview(device = "spec:width=1080px,height=2340px,dpi=640")
//@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MinigameQuizScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                title = "Titi",
                imageBackground = R.drawable.minigame_background_crop,
                isCorrect = null,
                questionSize = SporaConstant.MAX_QUESTIONS,
                isFinished = false,
                lives = 5,
                showButtonContinue = true,
                counterQuestion = 0,
                onNextQuestion = {},
                onResetGame = {},
                onBackForestStage = { },
                onNavigateNextLevel = { },
                content = {
                    QuizScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        questionTitle = "¿Cuál es la capital de España?",
                        answerOptions = FakeQuizModels.fakeAnswers.shuffled().take(4),
                        onAnswerSelected = {},
                        onConfirmAnswer = { }
                    )
                }
            )

        }
    }
}