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
    title: String = "¿Estás seguro?",
    body: String = "Al salir perderás tu progreso",
    champyImage: Int = R.drawable.champy_serious_idle,
    primaryButtonText: String = "Salir",
    showSecondaryButton: Boolean = true,
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
                    .padding(horizontal = 8.dp)
            ) {

                Image(
                    painter = painterResource(id = backgroundImage),
                    contentDescription = "Fondo minijuegos",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp)
                        .clip(MaterialTheme.shapes.extraLarge)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 32.sp,
                            shadow = Shadow(
                                color = Color.Black, offset = Offset(5f, 5f), blurRadius = 5f
                            )
                        ),
                    )

                    ChampyWithRewards(
                        champyImage = champyImage,
                        title = body,
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

                        if (showSecondaryButton){
                            SporaPrimaryInverseButton(
                                text = "Cancelar",
                                onClick = onDismissRequest,
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                        }

                        SporaPrimaryButton(
                            text = primaryButtonText,
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
                backgroundImage = R.drawable.minigame_background_crop,
                isVisible = true,
                showSecondaryButton = false,
                title = "!Nueva Actualizacion!",
                body = "Para continuar usando la app, actualiza a la última versión con mejoras y nuevas funciones.",
                champyImage = R.drawable.champy_smiling_idle,
                primaryButtonText = "Actualizar",
                onConfirmRequest = {},
                onDismissRequest = {}
            )
        }
    }
}