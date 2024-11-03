package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StarState
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetTotalOxygenFromStarsTest{

    private lateinit var oxygenRewards: List<Int>

    private lateinit var starState: StarState

    @Before
    fun setUp() {
        oxygenRewards = listOf(10, 20, 30)
    }

    @Test
    fun `When StarState is ZERO - Then Return 0 Oxygen`() {
        // Given
        starState = StarState.ZERO

        // When
        val result = getTotalOxygenFromStars(starState, oxygenRewards)

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `When StarState is ONE - Then Return 10 Oxygen`() {
        // Given
        starState = StarState.ONE

        // When
        val result = getTotalOxygenFromStars(starState, oxygenRewards)

        // Then
        assertEquals(10, result)
    }

    @Test
    fun `When StarState is TWO - Then Return 30 Oxygen`() {
        // Given
        starState = StarState.TWO

        // When
        val result = getTotalOxygenFromStars(starState, oxygenRewards)

        // Then
        assertEquals(30, result)
    }

    @Test
    fun `When StarState is THREE - Then Return 60 Oxygen`() {
        // Given
        starState = StarState.THREE

        // When
        val result = getTotalOxygenFromStars(starState, oxygenRewards)

        // Then
        assertEquals(60, result)
    }
}