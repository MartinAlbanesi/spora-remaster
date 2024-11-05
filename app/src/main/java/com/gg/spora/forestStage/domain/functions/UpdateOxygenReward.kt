package com.gg.spora.forestStage.domain.functions

import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.core.utils.enums.StarState

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