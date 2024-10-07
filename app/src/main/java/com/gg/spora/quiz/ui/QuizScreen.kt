package com.gg.spora.quiz.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.ui.components.OptionItemButton
import com.gg.spora.quiz.domain.model.Answer
import com.gg.spora.ui.theme.SporaTheme


@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    questionTitle: String,
    isCorrect: Boolean? = null,
    answerOptions: List<Answer>,
    onAnswerSelected: (String) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = questionTitle,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        answerOptions.forEach { answer ->
            OptionItemButton(
                textItem = answer.answer,
                isCorrect = answer.isCorrect,
                enabled = isCorrect == null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large)
                    .height(60.dp)
            ){
                onAnswerSelected(answer.id)
            }
        }
    }
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MinigameQuizScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            QuizScreen(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                questionTitle = "¿Cuál es la capital de España?",
                answerOptions = FakeQuizModels.fakeAnswers.shuffled().take(4),
                onAnswerSelected =  {},
            )
        }
    }
}