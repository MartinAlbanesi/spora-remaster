package com.gg.spora.minigameQuizImage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gg.spora.R
import com.gg.spora.core.ui.components.ButtonQuizImage
import com.gg.spora.core.ui.components.OptionItemButton
import com.gg.spora.core.ui.components.SporaDisableButton
import com.gg.spora.core.ui.components.SporaWithCard
import com.gg.spora.core.ui.components.TopBarWithProgressBar
import com.gg.spora.minigameQuizImage.domain.model.model.AnswerImage
import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.quiz.domain.model.Answer

@Composable
fun MinigameQuizImageScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    questionTitle: String,
    questionImageResId: Int,
    answerOptions: List<AnswerImage>,
    onAnswerSelected: (String) -> Unit,
    onNextQuestion: () -> Unit,
    quizImageViewModel: QuizImageViewModel = hiltViewModel()
) {
    var isSelectedAnswer by remember { mutableStateOf(false) }
    val currentImageResIdState by quizImageViewModel.currentImageResId.collectAsState()
    Box(
        modifier =
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(R.drawable.fondo_minijuegos),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-360).dp)
        )
        Column(
            modifier = modifier
                .padding(vertical = 16.dp)
                .fillMaxSize()
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

            SporaWithCard(
                modifier = Modifier
                    .fillMaxSize(),
                sporaImage = R.drawable.champy_sonriente_idle
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.50f)
                            .aspectRatio(1.2f)
                            .weight(0.15f)
                            .shadow(
                                elevation = 4.dp,
                                shape = MaterialTheme.shapes.large,
                            )
                            .background(
                                color = colorResource(id = R.color.surface),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Image(
                            painter = painterResource(id = currentImageResIdState),
                            contentDescription = "Imagen",
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                    Text(
                        text = questionTitle,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 8.dp)
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
                                .padding(vertical = 8.dp)
                                .clip(MaterialTheme.shapes.large)
                                .height(50.dp)
                                .clickable {
                                    isSelectedAnswer = true
                                    onAnswerSelected(answer.id)
                                }
                        )
                    }
                    SporaDisableButton(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        text = "Continue",
                        onClick = { onNextQuestion() }
                    )
                }

            }
        }
    }
}





