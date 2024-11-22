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
        val expected = listOf(
            Pair(10, null),
            Pair(20, null),
            Pair(30, null)
        )
        // When
        val result = getStarWithOxygen(starState, oxygenRewards)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `this - When StarState is One - Then Return Map with images`() {
        // Given
        starState = StarState.ONE
        val expected = listOf(
            Pair(10,2131230881),
            Pair(20, null),
            Pair(30, null)
        )

        // When
        val result = getStarWithOxygen(starState, oxygenRewards)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `this - When StarState is Two - Then Return Map with images`() {
        // Given
        starState = StarState.TWO
        val expected = listOf(
            Pair(10,2131230881),
            Pair(20,2131230881),
            Pair(30, null)
        )

        // When
        val result = getStarWithOxygen(starState, oxygenRewards)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `this - When StarState is Three - Then Return Map with images`() {
        // Given
        starState = StarState.THREE
        val expected = listOf(
            Pair(10, 2131230881),
            Pair(20, 2131230881),
            Pair(30, 2131230881)
        )

        // When
        val result = getStarWithOxygen(starState, oxygenRewards)

        // Then
        assertEquals(expected, result)
    }
}