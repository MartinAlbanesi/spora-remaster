package com.gg.spora.minigameQuizImageUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R // Assuming this is the correct path to your resources
import com.gg.spora.core.components.SporaWithCard
import com.gg.spora.core.components.TopBarWithProgressBar
import com.gg.spora.ui.theme.SporaTheme
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
                .offset(y = (-260).dp)
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
                sporaImage = R.drawable.champy_sonriente_idle,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .aspectRatio(1.2f)
                            .padding(16.dp)
                            .background(Color(0xFFF3D3A6)),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.champy_sonriente_idle), // Reemplaza con tu imagen
                            contentDescription = "Imagen",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}
*/
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
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .width(165.dp),
                            onClick = { /* Acción del botón 1 */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.surface),
                                contentColor = colorResource(id = R.color.black)
                            )
                        ) {
                            Text("Asesino")
                        }
                        Button(
                            modifier = Modifier
                                .width(165.dp)
                                .height(50.dp),
                            onClick = { /* Acción del botón 2 */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.surface),
                                contentColor = colorResource(id = R.color.black)
                            )
                        ) {
                            Text("Come Plastico")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .width(165.dp),
                            onClick = { /* Acción del botón 3 */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.surface),
                                contentColor = colorResource(id = R.color.black)
                            )
                        ) {
                            Text("Comestible")
                        }
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .width(165.dp),
                            onClick = { /* Acción del botón 4 */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.surface),
                                contentColor = colorResource(id = R.color.black)
                            )
                        ) {
                            Text("Alucinogeno")
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(0.9f),
                        onClick = { /* Acción del botón final */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.grey_700),
                            contentColor = colorResource(id = R.color.white)
                        )
                    ) {
                        Text(
                            text = "Continuar",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 18.sp, // Tamaño de fuente más grande
                                fontWeight = FontWeight.Bold // Negrita
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun MyButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}

    @Preview
    @Composable
    fun MinigameQuizImageScreenPreview() {
        MinigameQuizImageScreen(onBackClick = {})
    }
