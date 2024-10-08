package com.gg.spora.core.utils

import org.junit.Assert.assertEquals

import org.junit.Test

class ScalarNumberTest {

    @Test
    fun scalarNumber() {

        // Given
        val valor = 5
        val minOriginal = 0
        val maxOriginal = 10

        // When
        val result = com.gg.spora.core.utils.functions.scalarNumber(valor, minOriginal, maxOriginal)

        // Then
        assertEquals(0.5f, result)

    }
}