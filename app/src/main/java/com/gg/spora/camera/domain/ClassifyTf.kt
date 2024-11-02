package com.gg.spora.camera.domain

import android.content.Context
import android.graphics.Bitmap
import com.gg.spora.challenge.ui.classes
import com.gg.spora.ml.ModelObjects
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

class ClassifyTf(val context: Context) {
    /**
     * Classifies with TensorFlow the image when the camera takes a screenshot.
     * @param bitmap: Bitmap of the image
     * @param selectedObject: String of the object that the user wants to scan
     */
    fun classifyImage(bitmap: Bitmap, selectedObject: String, onResult: (Boolean, Float) -> Unit) {
        var resultScan = false
        var confidence = 0f

        val modelObj = ModelObjects.newInstance(context)

        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(preprocessImage(bitmap))

        val outputs = modelObj.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        val outputArray = outputFeature0.floatArray

        val selectedIndex = classes.indexOf(selectedObject)
        if (selectedIndex != -1) {
            confidence = outputArray[selectedIndex] * 100

            if (confidence >= 100) {
                resultScan = true
            }
        }

        onResult(resultScan, confidence)
    }


    /**
     * Converts bitmap of image to the format necessary for TensorFlow.
     * @param bitmap: Bitmap of the image
     */
    private fun preprocessImage(bitmap: Bitmap): ByteBuffer {
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
}
