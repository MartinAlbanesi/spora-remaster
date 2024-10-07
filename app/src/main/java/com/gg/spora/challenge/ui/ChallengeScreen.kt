package com.gg.spora.challenge.ui

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import android.widget.TextView
import androidx.compose.ui.platform.LocalContext
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gg.spora.R
import com.gg.spora.camera.CameraScreen
import com.gg.spora.camera.classifyImage
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.ui.components.ChampyWithCard
import com.gg.spora.core.ui.components.TopBarWithProgressBar
import com.gg.spora.ui.theme.SporaTheme
import java.nio.ByteOrder

val classes = arrayOf("Botella de plastico", "Caja de carton", "Nada")

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
    modifier : Modifier = Modifier,
    champyImage : Int,
    onBackClick : () -> Unit,
    recyclerOptions : Map<String, Boolean?>,
    challengeViewModel: ChallengeViewModel = viewModel()
) {


    var resultScan by remember { mutableStateOf(false) }
    var isSelectedAnswer by remember { mutableStateOf(false) }
    var showCamera by remember { mutableStateOf(false) }
    var selectedObject by remember { mutableStateOf("") }
    val context = LocalContext.current
    val navController = rememberNavController()

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
                title = stringResource(R.string.title_challenge),
                onBackClick = onBackClick,
                buttonLike = false
            )
            ChampyWithCard(
                modifier = Modifier.fillMaxSize(),
                champyImage = champyImage,
            ) {
                Column(
                    modifier = modifier.padding(15.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {

                    recyclerOptions.forEach {
                    val nameObject = it.key
                    ButtonObjectScannerChallenge(
                        textObject = nameObject,
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
                                challengeViewModel.selectObject(nameObject)
                                navController.navigate(NavigationRoutes.Camera)
                            },
                        isValidate = it.value
                    )
                }
                }
            }
        }
    }
}

@Composable
fun ChallengeListObject(
    modifier: Modifier = Modifier,
    recyclerOptions: Map<String, Boolean?>,
) {


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
            modifier = Modifier,
            champyImage = R.drawable.champy_sonriente_brazosalcuerpo,
            recyclerOptions = mapOf(
                "Botella de plastico" to true,
                "Residuos Orgánicos" to null,
                "Papel y Cartón" to null,
                "Envases de Plástico" to null,
            ),
            onBackClick = { },
            challengeViewModel = ChallengeViewModel()
        )
    }
}
}