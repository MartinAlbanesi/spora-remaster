package com.gg.spora.miniGames.domain.functions

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetResourceImageFromStringKtTest {

    lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun this_Cuando_se_ingresa_el_nombre_de_una_imagen_que_no_existe_en_res_drawable_Entonces_retornar_0() {
        val actual = getResourceImageFromString(context = context, resourcesString = "image")
        val expected = 0
        println("Actual: $actual")
        assertEquals(expected, actual)
    }

    @Test
    fun this_Cuando_se_ingresa_el_nombre_de_una_imagen_que_existe_en_res_drawable_Entonces_retornar_el_valor_correct() {
        val actual = getResourceImageFromString(context = context, resourcesString = "calentamiento_global")
        val expected = 2131230810
        println("Actual: $actual")
        assertEquals(expected, actual)
    }


}