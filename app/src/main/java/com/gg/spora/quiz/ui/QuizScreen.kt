package com.gg.spora.quiz.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
    answerOptions: List<Answer>,
    onAnswerSelected: (String) -> Unit,
    onNextQuestion: () -> Unit,
) {
    var isSelectedAnswer by remember { mutableStateOf(false) }

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
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = MaterialTheme.shapes.large,
                    )
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large)
                    .height(60.dp)
                    .clickable {
                        isSelectedAnswer = true
                        onAnswerSelected(answer.id)
                    }
            )
        }
        Button(
            enabled = isSelectedAnswer,
            onClick = {
                onNextQuestion()
                isSelectedAnswer = false
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFFf58c0a),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Continuar",
                color = Color.White,
            )
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
                onNextQuestion = {}
            )
        }
    }
}