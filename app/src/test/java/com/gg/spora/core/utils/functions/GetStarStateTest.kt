package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StarState
import org.junit.Assert.assertEquals
import org.junit.Test


class GetStarStateTest{


    @Test
    fun `this - When livesLost is five - Return StarState-ZERO`(){
        // Given
        val livesLost = 5

        // When
        val result = getRewardsStarState(livesLost)

        // Then
        assertEquals(StarState.ZERO, result)
    }

    @Test
    fun `this - When lives is four or Three - Return StarState-ONE`(){
        // Given
        val livesLost = 4

        // When
        val result = getRewardsStarState(livesLost)

        // Then
        assertEquals(StarState.ONE, result)
    }

    @Test
    fun `this - When livesLost is One or Two - Return StarState-TWO`(){
        // Given
        val lives = 1

        // When
        val result = getRewardsStarState(lives)

        // Then
        assertEquals(StarState.TWO, result)
    }

    @Test
    fun `this - When lives is Zero - Return StarState-THREE`(){
        // Given
        val livesLost = 0

        // When
        val result = getRewardsStarState(livesLost)

        // Then
        assertEquals(StarState.THREE, result)
    }

}