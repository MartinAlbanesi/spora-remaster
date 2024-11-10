package com.gg.spora.camera.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gg.spora.R
import com.gg.spora.camera.domain.ClassifyTf
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.ui.ChallengeViewModel
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.delay


/**
 * Screen init the camera
 * @param nameObject: The name of the object that was selected in the challenge list.
 * @param onNavigateToChallengeScreen: Navigate when user returns from camera
 * @param challengeViewModel: View Model of the challenge
 */
@Composable
fun CameraScreen(
    nameObject: String,
    onNavigateToChallengeScreen: () -> Unit,
    onNavigateToBack: () -> Unit
) {
    val lottie = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.success))
    val isCapturing = remember { mutableStateOf(true) }
    val isScanComplete = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var confidence by remember { mutableFloatStateOf(0f) }

    BackHandler {
        isCapturing.value = false
        onNavigateToBack()
    }

    if (isScanComplete.value) {
        ShowDialogScanSuccess(onNavigateToChallengeScreen, lottie)
    }

    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)

    if (cameraPermissionState.hasPermission) {
        Box(modifier = Modifier.fillMaxSize()) {
            AndroidView(
                factory = { previewView },
                modifier = Modifier.fillMaxSize()
            )

            if (confidence > 0) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .border(2.dp, Color.Green)
                        .background(Color(0x8000FF00))
                        .align(Alignment.TopCenter)
                ) {
                    Text(
                        text = "${nameObject}: ${confidence.toInt()}%",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(vertical = 70.dp, horizontal = 30.dp)
                        .fillMaxSize()
                        .border(3.dp, Color.Green)
                )
            }

            LaunchedEffect(Unit) {
                cameraProviderFuture.addListener({
                    prepareFunctionOfCamera(cameraProviderFuture, previewView, lifecycleOwner, imageCapture)
                    setFunctionsOfCamera(isCapturing, imageCapture, context, nameObject, isScanComplete) { newConfidence ->
                        confidence = newConfidence
                    }
                }, ContextCompat.getMainExecutor(context))
            }
        }
    } else {
        LaunchPermissionRequest(cameraPermissionState)
    }
}

fun setFunctionsOfCamera(
    isCapturing: MutableState<Boolean>,
    imageCapture: ImageCapture,
    context: Context,
    nameObject: String,
    isScanComplete: MutableState<Boolean>,
    onConfidenceUpdate: (Float) -> Unit
) {
    val handler = Handler(Looper.getMainLooper())
    val runnable = object : Runnable {
        override fun run() {
            if (isCapturing.value) {
                imageCapture.takePicture(
                    ContextCompat.getMainExecutor(context),
                    object : ImageCapture.OnImageCapturedCallback() {
                        override fun onCaptureSuccess(imageProxy: ImageProxy) {
                            val bitmap = imageProxy.toBitmap()
                            ClassifyTf(context).classifyImage(bitmap, nameObject) { result, confidence ->
                                onConfidenceUpdate(confidence)
                                if (result) {
                                    isCapturing.value = false
                                    isScanComplete.value = true
                                }
                            }
                            imageProxy.close()
                        }

                        override fun onError(exception: ImageCaptureException) {
                            Log.e("CameraScreen", "Image capture failed", exception)
                        }
                    }
                )
                handler.postDelayed(this, 1700)
            }
        }
    }
    handler.post(runnable)
}

@Composable
fun ShowDialogScanSuccess(
    onNavigateToChallengeScreen: () -> Unit,
    lottie: LottieCompositionResult
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center,
    ) {
        Dialog(onDismissRequest = {}) {
            LottieAnimation(
                composition = lottie.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
            )

            LaunchedEffect(lottie.isComplete) {
                delay(1600)
                onNavigateToChallengeScreen()
            }
        }
    }
}

fun prepareFunctionOfCamera(
    cameraProviderFuture: ListenableFuture<ProcessCameraProvider>,
    previewView: PreviewView,
    lifecycleOwner: LifecycleOwner,
    imageCapture: ImageCapture
) {

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
        Log.e("CameraScreen", "Camera binding failed", exc)
    }
}

/**
 * Get the permission state
 * @param permission: The permission that the user wants request.
 */
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
            // Completar o eliminar el onDispose
        }
    }

    return PermissionState(permissionState.value) {
        permissionRequestLauncher.launch(permission)
    }
}

/**
 * Ask user for permission
 * @param cameraPermissionState: Instance of permission
 */
@Composable
fun LaunchPermissionRequest(cameraPermissionState : PermissionState){
    LaunchedEffect(Unit) {
        cameraPermissionState.launchPermissionRequest()
    }
}

/**
 * Class of permission
 */
data class PermissionState(
    val hasPermission: Boolean,
    val launchPermissionRequest: () -> Unit
)

