package com.gg.spora.camera.ui

import android.Manifest
import android.content.pm.PackageManager
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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gg.spora.R
import com.gg.spora.camera.domain.ClassifyTf
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.ui.ChallengeViewModel
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
    challengeViewModel: ChallengeViewModel = hiltViewModel(),
) {

    var isScanComplete by remember { mutableStateOf(false) }
    val lottie = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.success))

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var objectsChallenge by remember { mutableStateOf(listOf<ObjectDetail>()) }
    var isCapturing by remember { mutableStateOf(true) }

    LaunchedEffect(challengeViewModel.objectsChallenge) {
        challengeViewModel.objectsChallenge.observe(lifecycleOwner) { objects ->
            objectsChallenge = objects
        }
    }
    BackHandler {
        isCapturing = false
        onNavigateToChallengeScreen()
    }

    if (isScanComplete) {
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
                    challengeViewModel.selectObject(nameObject)
                    challengeViewModel.setObjectInObjectsChallengeWithName(nameObject)
                    onNavigateToChallengeScreen()
                }
            }
        }
    }

    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)

    if (cameraPermissionState.hasPermission) {
        AndroidView(
            factory = { previewView },
            modifier = Modifier.fillMaxSize()
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
                    Log.e("CameraScreen", "Camera binding failed", exc)
                }

                val handler = Handler(Looper.getMainLooper())
                val runnable = object : Runnable {
                    override fun run() {
                        if (isCapturing) {
                            imageCapture.takePicture(
                                ContextCompat.getMainExecutor(context),
                                object : ImageCapture.OnImageCapturedCallback() {
                                    override fun onCaptureSuccess(imageProxy: ImageProxy) {
                                        val bitmap = imageProxy.toBitmap()
                                        ClassifyTf(context).classifyImage(context, bitmap, nameObject) { result ->
                                            if (result) {
                                                isCapturing = false
                                                isScanComplete = true
                                            }
                                        }
                                        imageProxy.close()
                                    }
                                    override fun onError(exception: ImageCaptureException) {
                                        Log.e("CameraScreen", "Image capture failed", exception)
                                    }
                                }
                            )
                            handler.postDelayed(this, 3000)
                        }
                    }
                }
                handler.post(runnable)
            }, ContextCompat.getMainExecutor(context))
        }
    } else {
        LaunchPermissionRequest(cameraPermissionState)
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

