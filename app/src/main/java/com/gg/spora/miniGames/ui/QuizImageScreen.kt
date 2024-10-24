package com.gg.spora.miniGames.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fullscreen
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.R
import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.ui.components.OptionItemButton
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun QuizImageScreen(
    modifier: Modifier = Modifier,
    questionTitle: String,
    isCorrect: Boolean? = null,
    answerOptions: List<Answer>,
    currentImageResIdState: Int,
    onAnswerSelected: (String) -> Unit,
) {

    var isAnswerSelected by remember { mutableStateOf(false) }

    var showImageFullScreen by remember { mutableStateOf(false) }

    if (showImageFullScreen) {
        Dialog(
            onDismissRequest = { showImageFullScreen = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ),
            content = {
                Image(
                    painter = painterResource(id = currentImageResIdState),
                    contentDescription = "Imagen",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .clip(MaterialTheme.shapes.large)
                        .clickable {
                            showImageFullScreen = false
                        }
                )
            }
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    showImageFullScreen = true
                }
        ) {
            Image(
                painter = painterResource(id = currentImageResIdState),
                contentDescription = "Imagen",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(4.dp)
                    .size(130.dp)
            )
            Icon(
                Icons.Default.Fullscreen,
                contentDescription = "Fullscreen",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = (8).dp, y = (8).dp)
                    .size(24.dp)
            )
        }
        Text(
            text = questionTitle,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
//                .weight(1f)
//                .heightIn(min = 50.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {
            items(answerOptions) { answer ->
                OptionItemButton(
                    textItem = answer.answer,
                    isCorrect = answer.isCorrect,
                    enabled = isCorrect == null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clip(MaterialTheme.shapes.large)
                        .fillMaxWidth(0.4f)
//                        .heightIn(max = 60.dp),
                        .fillMaxHeight(0.1f)
                        .clickable {
                            isAnswerSelected = true
                        }
                )
                {
                    onAnswerSelected(answer.id)
                }
            }

        }
//        answerOptions.forEach { answer ->
//            OptionItemButton(
//                textItem = answer.answer,
//                isCorrect = answer.isCorrect,
//                enabled = isCorrect == null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//                    .clip(MaterialTheme.shapes.large)
//                    .height(50.dp)
//                    .clickable {
//                        isAnswerSelected = true
//                    }
//            )
//            {
//                onAnswerSelected(answer.id)
//            }
    }

}

@Preview(
    heightDp = 640,
    widthDp = 360,
)
@Preview
@Composable
private fun QuizImageScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                title = "Titi",
                imageBackground = R.drawable.fondo_minijuegos_crop,
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
                    QuizImageScreen(
                        modifier = Modifier,
                        questionTitle = "Titi",
                        answerOptions = FakeQuizModels.fakeAnswers.take(4).shuffled(),
                        currentImageResIdState = FakeQuizModels.fakeQuizQuestions.random().image!!,
                        onAnswerSelected = {},
                    )
                }
            )
        }
    }
}
