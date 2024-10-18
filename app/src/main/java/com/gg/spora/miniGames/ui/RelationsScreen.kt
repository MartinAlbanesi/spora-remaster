package com.gg.spora.miniGames.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.ui.components.OptionItemButton
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.ui.theme.SporaTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RelationsScreen(
    modifier: Modifier = Modifier,
    objectName: String,
    answers: List<Answer>,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Seleciona 3 conceptos relacionados",
            color = Color.Black
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .height(44.dp)
                .width(200.dp)
                .background(colorResource(R.color.tertiary))
        ){
            Text(
                text = objectName,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            answers.forEach { answer ->
                OptionItemButton(
                    textItem = answer.answer,
                    isCorrect = answer.isCorrect,
                    enabled = true,
                    onAnswerSelected = {},
                    hasIcon = false,
                    modifier = Modifier
                        .width(180.dp)
                        .height(60.dp)
                )
            }
        }

    }
}

@PreviewLightDark
//@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun RelationsScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                title = "Titi",
                imageBackground = R.drawable.fondo_minijuegos,
                isCorrect = null,
                questionSize = SporaConstant.MAX_QUESTIONS,
                isFinished = false,
                lives = 5,
                counterQuestion = 0,
                onNextQuestion = {},
                onResetGame = {},
                onBackForestStage = { },
                content = {
                    RelationsScreen(
                        objectName = "Botella",
                        answers = FakeQuizModels.fakeAnswers.filter { it.id.toInt() > 55 },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 16.dp)
                    )
                }
            )

        }
    }
}