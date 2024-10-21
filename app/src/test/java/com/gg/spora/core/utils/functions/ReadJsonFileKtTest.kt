package com.gg.spora.core.utils.functions

import org.junit.Assert.assertTrue
import org.junit.Test
import readJsonFile

class ReadJsonFileKtTest {

    @Test
    fun testRawResource() {
        // Carga el archivo desde el sistema de archivos
        val file = readJsonFile("src/main/res/raw/questions.json")
        assertTrue(file.isNotEmpty())
    }
}