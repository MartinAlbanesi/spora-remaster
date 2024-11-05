package com.gg.spora.forestStage.domain.functions

import com.gg.spora.core.utils.enums.StarState
import org.junit.Assert.assertEquals
import org.junit.Test

class UpdateOxygenRewardTest {

    @Test
    fun `this - When Star State is Zero - Then Oxygen Rewards Do not changed`() {

        val oxygenRewards = listOf(10, 20, 30)
        val starState1 = StarState.ZERO

        val oxygenRewardsChanged = updateOxygenReward(starState1, oxygenRewards)

        assertEquals(oxygenRewards, oxygenRewardsChanged)
    }

    @Test
    fun `this - When Star State is One - Then Oxygen Rewards Changed`() {

        val oxygenRewards = listOf(10, 20, 30)
        val starState1 = StarState.ONE

        val oxygenRewardsChanged = updateOxygenReward(starState1, oxygenRewards)

        assertEquals(listOf(0, 20, 30), oxygenRewardsChanged)
    }

    @Test
    fun `this - When Star State is Two - Then Oxygen Rewards Changed`() {

        val oxygenRewards = listOf(10, 20, 30)
        val starState1 = StarState.TWO

        val oxygenRewardsChanged = updateOxygenReward(starState1, oxygenRewards)

        assertEquals(listOf(0, 0, 30), oxygenRewardsChanged)
    }

    @Test
    fun `this - When Star State is Three - Then Oxygen Rewards Changed`() {

        val oxygenRewards = listOf(10, 20, 30)
        val starState1 = StarState.THREE

        val oxygenRewardsChanged = updateOxygenReward(starState1, oxygenRewards)

        assertEquals(listOf(0, 0, 0), oxygenRewardsChanged)
    }
}