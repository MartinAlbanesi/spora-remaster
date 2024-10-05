package com.gg.spora.challenge.ui

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.gg.spora.R
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.core.ui.components.ChampyWithCard
import com.gg.spora.core.ui.components.TopBarWithProgressBar
import com.gg.spora.ml.ModelUnquant
import com.gg.spora.ui.theme.SporaTheme
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

val classes = arrayOf("Botella de plastico", "Nada")
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

    var resultText by remember { mutableStateOf("") }
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

@Composable
fun ChallengeListObject(
    modifier: Modifier = Modifier,
    recyclerOptions: Map<String, Boolean?>,
) {

    var resultText by remember { mutableStateOf("") }
    var isSelectedAnswer by remember { mutableStateOf(false) }
    var showCamera by remember { mutableStateOf(false) }
    var selectedObject by remember { mutableStateOf("") }
    val context = LocalContext.current

    /*
        if (resultText.isNotEmpty()) {
            Text(
                text = resultText,
                modifier = Modifier.height(80.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        CameraPreview(
            onImageCaptured = { bitmap: Bitmap ->
                classifyImage(context, bitmap, selectedObject) { result ->
                    resultText = result
                }
                showCamera = true
            },
            onError = { error ->
                // Manejar error
                showCamera = false
            }
        )

     */

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
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CameraPreview(
                onImageCaptured = { bitmap: Bitmap ->
                    classifyImage(context, bitmap, selectedObject)
                    showCamera = false
                },
                onError = { error ->
                    // Manejar error
                    showCamera = false
                }
            )
        }
    }


}

@Composable
fun CameraPreview(
    onImageCaptured: (Bitmap) -> Unit,
    onError: (Exception) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    if (cameraPermissionState.hasPermission) {
        AndroidView(
            factory = { previewView },
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f) // Asegura que la vista de la cámara tenga prioridad
        )

        LaunchedEffect(Unit) {
            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()
                val preview = androidx.camera.core.Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }
                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview,
                        imageCapture
                    )
                } catch (exc: Exception) {
                    onError(exc)
                }

                // Capturar imágenes automáticamente cada 5 segundos
                val handler = Handler(Looper.getMainLooper())
                val runnable = object : Runnable {
                    override fun run() {
                        imageCapture.takePicture(
                            ContextCompat.getMainExecutor(context),
                            object : ImageCapture.OnImageCapturedCallback() {
                                override fun onCaptureSuccess(imageProxy: ImageProxy) {
                                    val bitmap = imageProxy.toBitmap()
                                    onImageCaptured(bitmap)
                                    imageProxy.close()
                                }

                                override fun onError(exception: ImageCaptureException) {
                                    onError(exception)
                                }
                            }
                        )
                        handler.postDelayed(this, 1000) // 5000 ms = 5 segundos
                    }
                }
                handler.post(runnable)
            }, ContextCompat.getMainExecutor(context))
        }
    } else {
        // Solicitar permiso de cámara
        LaunchedEffect(Unit) {
            cameraPermissionState.launchPermissionRequest()
        }
    }
}

@Composable
fun rememberPermissionState(permission: String): PermissionState {
    val context = LocalContext.current
    val permissionState = remember { mutableStateOf(false) }

    val permissionRequestLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionState.value = isGranted
    }

    DisposableEffect(permission) {
        val permissionResult = ContextCompat.checkSelfPermission(context, permission)
        permissionState.value = permissionResult == PackageManager.PERMISSION_GRANTED

        onDispose {
            // Cleanup if needed
        }
    }

    return PermissionState(permissionState.value) {
        permissionRequestLauncher.launch(permission)
    }
}

data class PermissionState(
    val hasPermission: Boolean,
    val launchPermissionRequest: () -> Unit
)

fun ImageProxy.toBitmap(): Bitmap {
    val buffer = planes[0].buffer
    val bytes = ByteArray(buffer.remaining())
    buffer.get(bytes)
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size, null)
}

fun classifyImage(context: Context, bitmap: Bitmap, selectedObject: String/*, onResult: (String) -> Unit*/) {
    // Cargar el modelo de TensorFlow Lite
    val model = ModelUnquant.newInstance(context)

    // Preprocesar la imagen
    val inputImage = preprocessImage(bitmap)

    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
    inputFeature0.loadBuffer(inputImage.buffer)

    val outputs = model.process(inputFeature0)
    val outputFeature0 = outputs.outputFeature0AsTensorBuffer

    val outputArray = outputFeature0.floatArray
    val maxConfidenceIndex = outputArray.indices.maxByOrNull { outputArray[it] } ?: -1

    val resultText = "Nada ${outputArray[0]} \n Botella de plastico ${outputArray[1]} "

    model.close()

    //onResult(resultText)
}

fun preprocessImage(bitmap: Bitmap): TensorImage {
    val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, false)
    val tensorImage = TensorImage(DataType.FLOAT32)
    tensorImage.load(resizedBitmap)
    return tensorImage
}

private fun Float.decimal(): String {
    return "%.2f".format(this)
}

private fun TextView.UiThread(context: Context, string: String) {
    (context as? Activity)?.runOnUiThread {
        this.text = string
    }
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