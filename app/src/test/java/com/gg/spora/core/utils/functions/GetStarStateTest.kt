package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StarState
import org.junit.Assert.assertEquals
import org.junit.Test


class GetStarStateTest{


    @Test
    fun `this - When lives is five - Return StarState-Three`(){
        // Given
        val lives = 5

        // When
        val result = getStarState(lives)

        // Then
        assertEquals(StarState.THREE, result)
    }

    @Test
    fun `this - When lives is four - Return StarState-Two`(){
        // Given
        val lives = 4

        // When
        val result = getStarState(lives)

        // Then
        assertEquals(StarState.TWO, result)
    }

    @Test
    fun `this - When lives is One - Return StarState-One`(){
        // Given
        val lives = 1

        // When
        val result = getStarState(lives)

        // Then
        assertEquals(StarState.ONE, result)
    }

    @Test
    fun `this - When lives is Zero - Return StarState-Zero`(){
        // Given
        val lives = 0

        // When
        val result = getStarState(lives)

        // Then
        assertEquals(StarState.ZERO, result)
    }

}