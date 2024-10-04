package com.gg.spora.challenge.ui

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.core.components.ChampyWithCard
import com.gg.spora.core.components.TopBarWithProgressBar
import com.gg.spora.ui.theme.SporaTheme


/**
 * Screen for mini games with Spora and progress bar
 * @param modifier: Modifier
 * @param imageBackground: Background image
 * @param champyImage: Champy image
 * @param onBackClick: Click listener for back button
 * @param content: Content of the screen in the champy card
 */
@Composable
fun ChallengeScreen(
    modifier: Modifier = Modifier,
    imageBackground: Int,
    champyImage: Int,
    onBackClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(imageBackground),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-360).dp)
        )
        Column(
            modifier = modifier
        ) {
            TopBarWithProgressBar(
                title = stringResource(R.string.title_challenge),
                onBackClick = onBackClick,
                buttonLike = false
            )
            ChampyWithCard(
                modifier = Modifier.fillMaxSize(),
                champyImage = champyImage,
            ) {
                content()
            }
        }
    }
}

/**
 * Screen for objects to scan
 * @param modifier: Modifier
 * @param recyclerOptions: Objects in the list of challenge
 */
@Composable
fun ChallengeListObject(
    modifier: Modifier = Modifier,
    recyclerOptions: Map<String,Boolean?>,
) {
    var isSelectedAnswer by remember { mutableStateOf(false) }
    var showCamera by remember { mutableStateOf(false) }
    var selectedObject by remember { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        recyclerOptions.forEach {

            ButtonObjectScannerChallenge(
                textObject = it.key,
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
                        selectedObject = it.key
                        showCamera = true
                    },
                isValidate = it.value
            )
        }


    }
    if (showCamera) {
        CameraPreview(
            onImageCaptured = { bitmap: Bitmap ->
                classifyImage(bitmap, selectedObject)
                showCamera = false
            },
            onError = { error ->
                // Manejar error
                showCamera = false
            }
        )
    }
}

@Composable
fun CameraPreview(
    onImageCaptured: (Bitmap) -> Unit,
    onError: (Exception) -> Unit
) {
    // Implementación de la vista previa de la cámara usando CameraX
    // y captura de imágenes
}

fun classifyImage(bitmap: Bitmap, selectedObject: String) {
    // Implementar la lógica de clasificación usando TensorFlow
    // y mostrar los resultados en la UI
}

@Preview
//@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun ChallengeScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChallengeScreen(
                modifier = Modifier.fillMaxSize(),
                imageBackground = R.drawable.fondo_minijuegos,
                champyImage = R.drawable.champy_sonriente_brazosalcuerpo,
                onBackClick = { },
                content = {
                    ChallengeListObject(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        recyclerOptions = mapOf(
                            "Vidrio" to true,
                            "Residuos Orgánicos" to null,
                            "Papel y Cartón" to null,
                            "Envases de Plástico" to null,
                        )
                    )

                }
            )
        }
    }
}