package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StarState
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetStarWithOxygenKtTest{

    private lateinit var starState: StarState

    private lateinit var oxygenRewards: List<Int>

    @Before
    fun setUp() {
        starState = StarState.ZERO
        oxygenRewards = listOf(10, 20, 30)
    }

    @Test
    fun `this - When StarState is Zero - Then Return Map with images null`() {
        // Given
        val expected = mapOf(10 to null, 20 to null, 30 to null)

        // When
        val result = getStarWithOxygen(starState, oxygenRewards)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `this - When StarState is One - Then Return Map with images`() {
        // Given
        starState = StarState.ONE
        val expected = mapOf(10 to 2131230880, 20 to null, 30 to null)

        // When
        val result = getStarWithOxygen(starState, oxygenRewards)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `this - When StarState is Two - Then Return Map with images`() {
        // Given
        starState = StarState.TWO
        val expected = mapOf(10 to 2131230880, 20 to 2131230880, 30 to null)

        // When
        val result = getStarWithOxygen(starState, oxygenRewards)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `this - When StarState is Three - Then Return Map with images`() {
        // Given
        starState = StarState.THREE
        val expected = mapOf(10 to 2131230880, 20 to 2131230880, 30 to 2131230880)

        // When
        val result = getStarWithOxygen(starState, oxygenRewards)

        // Then
        assertEquals(expected, result)
    }
}