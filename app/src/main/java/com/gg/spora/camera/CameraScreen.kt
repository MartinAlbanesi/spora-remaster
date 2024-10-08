package com.gg.spora.camera

import android.Manifest
import android.content.Context
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gg.spora.challenge.ui.ChallengeViewModel
import com.gg.spora.challenge.ui.ClassifyTf
import com.gg.spora.challenge.ui.classes
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.ml.ModelObject
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Composable
fun CameraScreen(
    onNavigateToChallengeScreen : () -> Unit,
    challengeViewModel: ChallengeViewModel = viewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var selectedObject = ""
    var objectsChallenge = mapOf<String, Boolean>()


    LaunchedEffect(challengeViewModel.selectedObject) {
        challengeViewModel.selectedObject.observe(lifecycleOwner) { newObject ->
            selectedObject = newObject
        }
    }

    LaunchedEffect(challengeViewModel.objectsChallenge) {
        challengeViewModel.objectsChallenge.observe(lifecycleOwner) { objects ->
            objectsChallenge = objects
        }
    }

    // Obtengo el permiso de camara
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)

    if (cameraPermissionState.hasPermission) {

        // Vista de la camara
        AndroidView(
            factory = { previewView },
            modifier = Modifier
                .fillMaxSize()
        )

        // Codigo suspendido y config asincronico
        LaunchedEffect(Unit) {
            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()
                val preview = androidx.camera.core.Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }
                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                //
                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview,
                        imageCapture
                    )
                } catch (exc: Exception) {
                }

                val handler = Handler(Looper.getMainLooper())
                val runnable = object : Runnable {
                    override fun run() {
                        imageCapture.takePicture(
                            ContextCompat.getMainExecutor(context),
                            object : ImageCapture.OnImageCapturedCallback() {
                                override fun onCaptureSuccess(imageProxy: ImageProxy) {


                                    val bitmap = imageProxy.toBitmap()
                                    ClassifyTf(context).classifyImage(bitmap, selectedObject) { result ->
                                        if (result) {
                                            challengeViewModel.setObjectsChallenge(
                                                objectsChallenge.toMutableMap().apply {
                                                    this[selectedObject] = true
                                                }
                                            )
                                            onNavigateToChallengeScreen
                                        }
                                    }
                                    imageProxy.close()
                                }

                                override fun onError(exception: ImageCaptureException) {
                                    onError(exception)
                                }
                            }
                        )
                        handler.postDelayed(this, 1000)
                    }
                }
                handler.post(runnable)
            }, ContextCompat.getMainExecutor(context))
        }
    } else {
        launchPermissionRequest(cameraPermissionState)
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

@Composable
fun launchPermissionRequest(cameraPermissionState : PermissionState){
    LaunchedEffect(Unit) {
        cameraPermissionState.launchPermissionRequest()
    }
}

data class PermissionState(
    val hasPermission: Boolean,
    val launchPermissionRequest: () -> Unit
)

