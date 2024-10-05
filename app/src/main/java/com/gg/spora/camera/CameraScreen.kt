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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.gg.spora.challenge.ui.classes
import com.gg.spora.ml.ModelObject
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Composable
fun CameraScreen(
    onImageCaptured: (Bitmap) -> Unit,
    onError: (Exception) -> Unit,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)

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
                        handler.postDelayed(this, 1000)
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

fun classifyImage(context: Context, bitmap: Bitmap, selectedObject: String, onResult: (Boolean) -> Unit) {
    var resultScan = false

    // Carga el modelo de TensorFlow Lite
    val modelObj = ModelObject.newInstance(context)

    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)

    inputFeature0.loadBuffer(preprocessImage(bitmap))


    val outputs = modelObj.process(inputFeature0)
    val outputFeature0 = outputs.outputFeature0AsTensorBuffer

    val outputArray = outputFeature0.floatArray
    val maxConfidenceIndex = outputArray.indices.maxByOrNull { outputArray[it] } ?: 0

    if(selectedObject == classes[maxConfidenceIndex])
        resultScan = true

    onResult(resultScan)
}


fun preprocessImage(bitmap: Bitmap): ByteBuffer {
    val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true)
    val byteBuffer = ByteBuffer.allocateDirect(4 * 224 * 224 * 3)
    byteBuffer.order(ByteOrder.nativeOrder())

    val intValue = IntArray(224 * 224)

    resizedBitmap.getPixels(intValue, 0, resizedBitmap.width, 0, 0, resizedBitmap.width, resizedBitmap.height)

    for (pixelValue in intValue) {
        byteBuffer.putFloat((pixelValue shr 16 and 0xFF) * (1f / 255))
        byteBuffer.putFloat((pixelValue shr 8 and 0xFF) * (1f / 255))
        byteBuffer.putFloat((pixelValue and 0xFF) * (1f / 255))
    }

    return byteBuffer
}