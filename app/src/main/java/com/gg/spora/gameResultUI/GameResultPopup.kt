package com.gg.spora.gameResultUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.gg.spora.R

@Composable
fun StarWithOxygen(
    modifier: Modifier = Modifier,
    starImage: Int,
    oxygenAmount: Int,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = starImage),
            contentDescription = "Estrella gris",
            modifier = Modifier.size(88.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.o2),
                contentDescription = "Oxígeno",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = oxygenAmount.toString(),
                fontSize = 16.sp,
            )
        }
    }
}


@Composable
private fun StarWithOxygenGroup() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().height(100.dp)
    ) {
        StarWithOxygen(
            oxygenAmount = 10,
            starImage = R.drawable.estrella,
            modifier = Modifier.rotate(-25f)
        )
        StarWithOxygen(
            oxygenAmount = 10,
            starImage = R.drawable.estrella_gris,
            modifier = Modifier.offset(y = (-16).dp)
        )
        StarWithOxygen(
            oxygenAmount = 10,
            starImage = R.drawable.estrella,
            modifier = Modifier.rotate(25f)
        )
    }
}

@Composable
fun GameResultPopUp(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    backgroundImage: Int,
    primaryButtonText: String,
    secondaryButtonText: String,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: () -> Unit,
    onDismissRequest: () -> Unit
) {
    if(isVisible){
        Dialog(
            onDismissRequest = onDismissRequest,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                Column {
                    StarWithOxygenGroup()
                    Row {

                    }
                    Row {

                    }
                }
            }
        }
    }
//    val hasWon = true //la uso para saber si ganó o perdió
//    if (isVisible) {
//        Box(
//            modifier = modifier
//                .fillMaxSize()
//                .background(Color.Black.copy(alpha = 0.5f))
//        ) {
//
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight(0.3f)
//                    .padding(horizontal = 16.dp)
//                    .align(Alignment.Center)
//                    .shadow(
//                        elevation = 8.dp,
//                        shape = RoundedCornerShape(60.dp)
//                    )
//                    .clip(RoundedCornerShape(8.dp))
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.fondo_minijuegos),
//                    contentDescription = "Fondo",
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .clip(RoundedCornerShape(8.dp)),
//                    contentScale = ContentScale.FillBounds,
//                    colorFilter = ColorFilter.colorMatrix(
//                        ColorMatrix().apply {
//                            setToScale(0.7f, 0.7f, 0.7f, 1f) // Ajusta los valores para controlar el oscurecimiento
//                        }
//                    )
//                )
//                Column(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceAround
//                ) {
//                    Spacer(modifier = Modifier.height(24.dp))
//
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.champy_sonriente_idle),
//                            contentDescription = "Resultado",
//                            modifier = Modifier.size(100.dp)
//                        )
//                        Spacer(modifier = Modifier.width(16.dp))
//                        Column {
//                            Text(
//                                text = if (hasWon) "Recompensa" else "Perdiste",
//                                style = MaterialTheme.typography.bodyLarge.copy(
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold,
//                                    color = MaterialTheme.colorScheme.onPrimary
//                                )
//                            )
//                            Row(verticalAlignment = Alignment.CenterVertically) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.o2), // Reemplaza con tu imagen
//                                    contentDescription = "Imagen de recompensa",
//                                    modifier = Modifier
//                                        .size(50.dp)
//                                        .align(Alignment.CenterVertically)
//                                )
//                                Spacer(modifier = Modifier.width(8.dp))
//                                val rewardText = "+20"
//                                Text(
//                                    text = rewardText, // Parámetro recibido
//                                    style = MaterialTheme.typography.bodyMedium.copy(
//                                        fontSize = 40.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        color = MaterialTheme.colorScheme.onPrimary
//                                    )
//                                )
//                            }
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceAround
//                    ) {
//                        Button(
//                            modifier = Modifier
//                                .height(50.dp)
//                                .width(150.dp),
//                            onClick = onRetryClick,
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = colorResource(id = R.color.surface),
//                                contentColor = colorResource(id = R.color.primary)
//                            )
//                        ) {
//                            Text(
//                                text = "Reiniciar",
//                                style = MaterialTheme.typography.bodyLarge.copy(
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold
//                                )
//                            )
//                        }
//                        Button(
//                            modifier = Modifier
//                                .height(50.dp)
//                                .width(150.dp),
//                            onClick = onContinueClick,
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = colorResource(id = R.color.primary),
//                                contentColor = colorResource(id = R.color.surface)
//                            )
//                        ) {
//                            Text(
//                                text = "Siguiente",
//                                style = MaterialTheme.typography.bodyLarge.copy(
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold
//                                )
//                            )
//                        }
//                    }
//                }
//
//            }
//        }
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(80.dp)
//                .offset(y = (250).dp)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 16.dp)
//                    .align(Alignment.BottomCenter),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Box {
//                    var starImageSize by remember { mutableStateOf(IntSize.Zero) }
//                    Image(
//                        painter = painterResource(id = R.drawable.estrella_gris),
//                        contentDescription = "Estrella gris 1",
//                        modifier = Modifier
//                            .size(60.dp)
//                            .onGloballyPositioned { coordinates ->
//                                starImageSize = coordinates.size
//                            }
//                    )
//
//                    // Row con la imagen de O2 y el texto
//                    Row(
//                        modifier = Modifier
//                            .layout { measurable, constraints ->
//                                val placeable = measurable.measure(constraints)
//                                // Calcula la posición del Row dentro de la estrella
//                                val x = (starImageSize.width - placeable.width) / 2
//                                val y = (starImageSize.height - placeable.height) / 2
//                                layout(placeable.width, placeable.height) {
//                                    placeable.placeRelative(x, y)
//                                }
//                            },
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.o2),
//                            contentDescription = "Imagen de recompensa",
//                            modifier = Modifier.size(16.dp) // Ajusta el tamaño según sea necesario
//                        )
//
//                        val rewardText = "10"
//                        Text(
//                            text = rewardText,
//                            style = MaterialTheme.typography.bodyMedium.copy(
//                                fontSize = 12.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = MaterialTheme.colorScheme.onPrimary
//                            )
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.width(8.dp))
//                Box {
//                    var starImageSize by remember { mutableStateOf(IntSize.Zero) }
//                    Image(
//                        painter = painterResource(id = R.drawable.estrella_gris),
//                        contentDescription = "Estrella gris 2",
//                        modifier = Modifier
//                            .size(70.dp)
//                            .onGloballyPositioned { coordinates ->
//                                starImageSize = coordinates.size
//                            }
//                    )
//                    // Row con la imagen de O2 y el texto
//                    Row(
//                        modifier = Modifier
//                            .layout { measurable, constraints ->
//                                val placeable = measurable.measure(constraints)
//                                // Calcula la posición del Row dentro de la estrella
//                                val x = (starImageSize.width - placeable.width) / 2
//                                val y = (starImageSize.height - placeable.height) / 2
//                                layout(placeable.width, placeable.height) {
//                                    placeable.placeRelative(x, y)
//                                }
//                            },
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.o2),
//                            contentDescription = "Imagen de recompensa",
//                            modifier = Modifier.size(16.dp) // Ajusta el tamaño según sea necesario
//                        )
//
//                        val rewardText = "20"
//                        Text(
//                            text = rewardText,
//                            style = MaterialTheme.typography.bodyMedium.copy(
//                                fontSize = 12.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = MaterialTheme.colorScheme.onPrimary
//                            )
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.width(8.dp))
//                Box {
//                    var starImageSize by remember { mutableStateOf(IntSize.Zero) }
//                    Image(
//                        painter = painterResource(id = R.drawable.estrella_gris),
//                        contentDescription = "Estrella gris 3",
//                        modifier = Modifier
//                            .size(60.dp)
//                            .onGloballyPositioned { coordinates ->
//                                starImageSize = coordinates.size
//                            }
//                    )
//
//                    // Row con la imagen de O2 y el texto
//                    Row(
//                        modifier = Modifier
//                            .layout { measurable, constraints ->
//                                val placeable = measurable.measure(constraints)
//                                // Calcula la posición del Row dentro de la estrella
//                                val x = (starImageSize.width - placeable.width) / 2
//                                val y = (starImageSize.height - placeable.height) / 2
//                                layout(placeable.width, placeable.height) {
//                                    placeable.placeRelative(x, y)
//                                }
//                            },
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.o2),
//                            contentDescription = "Imagen de recompensa",
//                            modifier = Modifier.size(16.dp)
//                        )
//
//                        val rewardText = "30"
//                        Text(
//                            text = rewardText,
//                            style = MaterialTheme.typography.bodyMedium.copy(
//                                fontSize = 12.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = MaterialTheme.colorScheme.onPrimary
//                            )
//                        )
//                    }
//                }
//            }
            /*Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.o2), // Reemplaza con tu imagen
                    contentDescription = "Imagen de recompensa",
                    modifier = Modifier
                        .size(15.dp)
                        .align(Alignment.CenterVertically)
                )

                val rewardText = "+20"
                Text(
                    text = rewardText, // Parámetro recibido
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }*/
//        }
//    }
}


@Preview(showBackground = true)
@Composable
fun GameResultPopupPreview() {
    GameResultPopUp(
        isVisible = true,
        backgroundImage = R.drawable.fondo_minijuegos,
        primaryButtonText = "Reiniciar",
        secondaryButtonText = "Siguiente",
        onClickPrimaryButton = {},
        onClickSecondaryButton = {},
        onDismissRequest = {}
    )
}