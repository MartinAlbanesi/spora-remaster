package com.gg.spora.stage.domain.functions

import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.core.utils.enums.StarState

/**
 * Change the oxygen rewards based on the star state of the level completed
 */
fun updateOxygenReward(
    starState: StarState,
    oxygenRewards: List<Int>,
): List<Int>{
    val updatedOxygenRewards = mutableListOf<Int>()

    for (i in 1..MAX_STAR) {
        if (i <= starState.starCount) {
            updatedOxygenRewards.add(0)
        } else {
            updatedOxygenRewards.add(oxygenRewards[i - 1])
        }
    }

    return updatedOxygenRewards
}