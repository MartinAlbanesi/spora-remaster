package com.gg.spora.minigameQuizImage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gg.spora.R
import com.gg.spora.core.ui.components.OptionItemButton
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.SporaWithCard
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon
import com.gg.spora.minigameQuizImage.domain.model.model.AnswerImage

@Composable
fun MinigameQuizImageScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    questionTitle: String,
    questionImageResId: Int,
    answerOptions: List<AnswerImage>,
    onAnswerSelected: (String) -> Unit,
    onNextQuestion: () -> Unit,
) {

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
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TopBarWithTitleExitAndIcon(
                title = "Bosque - 2",
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


            }
        }
    }
}

@Composable
fun QuizImageScreen(
    modifier: Modifier = Modifier,
    questionTitle: String,
    isCorrect: Boolean? = null,
    answerOptions: List<AnswerImage>,
    currentImageResIdState: Int,
    onAnswerSelected: (String) -> Unit,
    onNextQuestion: () -> Unit,
    areOptionsEnabled: Boolean
) {

    var isAnswerSelected by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.50f)
                .aspectRatio(1.2f)
                .weight(0.1f)
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
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Text(
            text = questionTitle,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        answerOptions.forEach { answer ->
            OptionItemButton(
                textItem = answer.answer,
                isCorrect = answer.isCorrect,
                //enabled =  true,
                enabled = areOptionsEnabled, //BORRAR SI NO FUNCIONA
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clip(MaterialTheme.shapes.large)
                    .height(50.dp)
                    .clickable {

                        isAnswerSelected = true

                    }
            )
            {
                onAnswerSelected(answer.id)
            }
        }
        Spacer(modifier = Modifier.weight(0.05f))
        if (isAnswerSelected) {
            SporaPrimaryButton(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                text = "Continue",
                onClick = {
                    onNextQuestion()
                    isAnswerSelected = false

                }
            )
        } else {
        }

    }
}
