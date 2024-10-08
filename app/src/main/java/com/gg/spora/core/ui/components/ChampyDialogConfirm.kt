package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.R
import com.gg.spora.gameResultUI.components.ChampyWithRewards
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyDialogConfirm(
    modifier: Modifier = Modifier,
    backgroundImage: Int,
    isVisible: Boolean,
    onConfirmRequest: () -> Unit,
    onDismissRequest: () -> Unit
) {
    if (isVisible) {

        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                dismissOnClickOutside = true,
                dismissOnBackPress = false
            )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                Image(
                    painter = painterResource(id = backgroundImage),
                    contentDescription = "Fondo minijuegos",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(MaterialTheme.shapes.extraLarge)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "¿Estás seguro?",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 45.sp,
                            shadow = Shadow(
                                color = Color.Black, offset = Offset(5f, 5f), blurRadius = 5f
                            )
                        ),
                    )

                    ChampyWithRewards(
                        champyImage = R.drawable.champy_serio_idle,
                        title = "Al salir perderás tu progreso",
                        body = {},
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SporaPrimaryInverseButton(
                            text = "Cancelar",
                            onClick = onDismissRequest,
                            modifier = Modifier
                                .padding(8.dp)
                        )

                        SporaPrimaryButton(
                            text = "Salir", //if (starsState.starCount != 0) "Siguiente" else "Volver",
                            onClick = onConfirmRequest,
                            modifier = Modifier
                                .padding(8.dp)
                        )

                    }

                }
            }
        }
    }
}

@Preview
@Composable
private fun ChampyDialogConfirmPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampyDialogConfirm(
                backgroundImage = R.drawable.fondo_minijuegos_crop,
                isVisible = true,
                onConfirmRequest = {},
                onDismissRequest = {}
            )
        }
    }
}