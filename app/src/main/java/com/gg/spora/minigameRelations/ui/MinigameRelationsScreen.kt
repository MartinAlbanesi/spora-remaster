package com.gg.spora.minigameRelations.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.minigameRelations.domain.GameLogic


@Composable
fun MinigameRelationsScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {

    // Instancia de la lógica del juego
    val gameLogic = GameLogic()

    // Obtener respuestas aleatorias solo una vez al mostrar la pantalla
    val shuffledAnswers = remember { gameLogic.getAnswers().shuffled() }

    // Estado para rastrear la respuesta seleccionada y si se ha confirmado
    var selectedAnswers by remember { mutableStateOf<List<String>>(emptyList()) }
    var isConfirmed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Selecciona los conceptos relacionados",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.60f)
                .aspectRatio(4.0f)
                .background(
                    color = Color(0xFF004E5B),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "Botella",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                ),
                modifier = Modifier.padding(13.dp)
            )
        }

        Spacer(modifier = Modifier.height(48.dp))


        // Botones de respuestas generados dinámicamente
        shuffledAnswers.chunked(2).forEach { pairOfAnswers ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                pairOfAnswers.forEach { answer ->
                    AnswerButton(
                        text = answer.text,
                        isCorrect = answer.isCorrect,
                        isSelected = selectedAnswers.contains(answer.text),
                        isConfirmed = isConfirmed,
                        onClick = {
                            if (!isConfirmed) {
                                // Limitar la selección a 3 respuestas
                                if (selectedAnswers.contains(answer.text)) {
                                    // Si la respuesta ya estaba seleccionada, la quitamos
                                    selectedAnswers = selectedAnswers.filter { it != answer.text }
                                } else if (selectedAnswers.size < 3) {
                                    // Si no estaba seleccionada y hay menos de 3 seleccionadas, la añadimos
                                    selectedAnswers = selectedAnswers + answer.text
                                }
                            }
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(48.dp))


        val continueButtonColor = if (selectedAnswers.size == 3) {
            Color(0xFFFFA500)
        } else {
            Color.Gray
        }

        Button(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(1.0f),
            onClick = {
                if (selectedAnswers.isNotEmpty()) {
                    isConfirmed = true
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = continueButtonColor,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Continuar",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,

                    )
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}


@Composable
fun AnswerButton(
    text: String,
    isCorrect: Boolean,
    isSelected: Boolean,
    isConfirmed: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = when {
        isConfirmed && isCorrect && isSelected -> Color.Green
        isConfirmed && !isCorrect && isSelected -> Color.Red
        !isConfirmed && isSelected -> Color.DarkGray
        else -> colorResource(id = R.color.surface)
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .height(50.dp)
            .width(165.dp)
    ) {
        Text(text)
    }
}


@Preview
@Composable
fun MinigameRelationsScreenPreview() {
    MinigameRelationsScreen(onBackClick = {})
}
