package com.gg.spora.minigameQuiz.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun MinigameQuizScreen(
    modifier: Modifier = Modifier,
    questionTitle: String,
    answerOptions: Map<String,Boolean?>,
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
        answerOptions.forEach {
            AnswerItem(
                answer = it.key,
                isCorrect = it.value,
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = MaterialTheme.shapes.large,
                        ambientColor = DefaultShadowColor
                    )
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large)
                    .height(60.dp)
                    .clickable {
                        isSelectedAnswer = true
                    }
            )
        }
        Button(
            enabled = isSelectedAnswer,
            onClick = {

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

@Composable
fun AnswerItem(
    modifier: Modifier = Modifier,
    answer: String,
    isCorrect: Boolean?,
) {

    val backgroundColor by remember {
        mutableStateOf(
            when (isCorrect) {
                true -> Color(0xff538c21)
                false -> Color(0xffb3261e)
                else -> Color(0xFFffeacc)
            }
        )
    }

    val textColor by remember {
        mutableStateOf(
            when (isCorrect) {
                true -> Color.White
                false -> Color.White
                else -> Color(0xff442801)
            }
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(backgroundColor)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = answer,
            color = textColor,
        )
        Icon(
            imageVector = Icons.Default.CheckCircle,
            tint = textColor,
            modifier = Modifier.size(40.dp),
            contentDescription = Icons.Default.CheckCircle.name,
        )

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
            MinigameQuizScreen(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                questionTitle = "¿Cuál es la capital de España?",
                answerOptions = mapOf(
                    "Madrid" to true,
                    "Barcelona" to null,
                    "Sevilla" to null,
                    "Valencia" to null,
                )
            )
        }
    }
}