package com.gg.spora.minigameQuizImage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.gg.spora.R
import com.gg.spora.core.ui.components.ButtonQuizImage
import com.gg.spora.core.ui.components.SporaDisableButton
import com.gg.spora.core.ui.components.SporaWithCard
import com.gg.spora.core.ui.components.TopBarWithProgressBar

@Composable
fun MinigameQuizImageScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
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
            modifier = modifier
                .padding(vertical = 16.dp) // Padding vertical general
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
                modifier = Modifier.fillMaxSize(),
                sporaImage = R.drawable.champy_sonriente_idle
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .aspectRatio(1.2f)
                            .weight(0.35f)
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
                            painter = painterResource(id = R.drawable.simbolo_reciclaje),
                            contentDescription = "Imagen",
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }

                    Text(
                        text = "Que tipo de hongo es Champy?",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 8.dp) // Padding superior
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp), // Padding vertical
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        ButtonQuizImage(text = "Asesino", onClick = { /* Acción del botón 1 */ })
                        ButtonQuizImage(text = "Come Plastico", onClick = { /* Acción del botón 2 */ })
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp), // Padding inferior
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        ButtonQuizImage(text = "Comestible", onClick = { /* Acción del botón 3 */ })
                        ButtonQuizImage(text = "Alucinogeno", onClick = { /* Acción del botón 4 */ })
                    }
                    SporaDisableButton(
                        modifier = Modifier.padding(top = 16.dp),
                        text = "Continue",
                        onClick = { /* Acción del botón */ }
                    )
                }
            }
        }
    }
}


/*
@Composable
fun MinigameQuizImageScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
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
                modifier = Modifier.fillMaxSize(),
                sporaImage = R.drawable.champy_sonriente_idle
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .aspectRatio(1.2f)
                            .weight(0.35f)
                            .background(
                                color = colorResource(id = R.color.surface),
                                shape = RoundedCornerShape(16.dp) // Bordes redondeados
                            ),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.champy_sonriente_idle), // Reemplaza con tu imagen
                            contentDescription = "Imagen",
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Que tipo de hongo es Champy?",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        ButtonQuizImage(text = "Asesino", onClick = { /* Acción del botón 1 */ })
                        ButtonQuizImage(text = "Come Plastico", onClick = { /* Acción del botón 2 */ })
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        ButtonQuizImage(text = "Comestible", onClick = { /* Acción del botón 3 */ })
                        ButtonQuizImage(text = "Alucinogeno", onClick = { /* Acción del botón 4 */ })
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

*/
    @Preview
    @Composable
    fun MinigameQuizImageScreenPreview() {
        MinigameQuizImageScreen(onBackClick = {})
    }



