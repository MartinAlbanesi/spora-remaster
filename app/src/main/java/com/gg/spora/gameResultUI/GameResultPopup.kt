package com.gg.spora.gameResultUI

import androidx.compose.animation.core.copy
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R

@Composable
fun GameResultPopup(
    isVisible: Boolean,
    onRetryClick: () -> Unit,
    onContinueClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val hasWon = true //la uso para saber si ganó o perdió
    if (isVisible) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(60.dp)
                    )
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fondo_minijuegos),
                    contentDescription = "Fondo",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.champy_sonriente_idle),
                            contentDescription = "Resultado",
                            modifier = Modifier.size(86.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = if (hasWon) "¡Ganaste!" else "Perdiste",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .width(150.dp),
                            onClick = onRetryClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.surface),
                                contentColor = colorResource(id = R.color.primary)
                            )
                        ) {
                            Text(
                                text = "Reiniciar",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .width(150.dp),
                            onClick = onContinueClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.primary),
                                contentColor = colorResource(id = R.color.surface)
                            )
                        ) {
                            Text(
                                text = "Siguiente",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}


/*
@Composable
fun GameResultPopup(
    isVisible: Boolean,
    onRetryClick: () -> Unit,
    onContinueClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val hasWon = true //la uso para saber si ganó o perdió
    if (isVisible) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(60.dp)
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        painter = painterResource(id = R.drawable.fondo_minijuegos), // Reemplaza con tu imagen
                        contentScale = ContentScale.Crop // Ajusta la escala de la imagen
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.champy_sonriente_idle),
                            contentDescription = "Resultado",
                            modifier = Modifier.size(86.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = if (hasWon) "¡Ganaste!" else "Perdiste",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .width(150.dp),
                            onClick = { /* Acción del botón 1 */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.surface),
                                contentColor = colorResource(id = R.color.primary)
                            )
                        )
                        { Text(
                            text = "Reiniciar",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold)) }
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .width(150.dp),
                            onClick = { /* Acción del botón 1 */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.primary),
                                contentColor = colorResource(id = R.color.surface)
                            )
                        )
                        { Text(
                            text ="Siguiente",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold)) }
                    }
                }
            }
        }
    }
}*/


@Preview(showBackground = true)
@Composable
fun GameResultPopupPreview() {
    GameResultPopup(
        isVisible = true,
        onRetryClick = { /* Acción al reintentar */ },
        onContinueClick = { /* Acción al continuar */ }
    )
}