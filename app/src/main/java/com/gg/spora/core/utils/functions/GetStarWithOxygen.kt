package com.gg.spora.core.utils.functions

import com.gg.spora.R
import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.core.utils.enums.StarState

fun getStarWithOxygen (
    starsState: StarState,
    oxygenRewards: List<Int>,
): Map<Int, Int>{
    val localRewards: MutableMap<Int, Int> = mutableMapOf()

    for (i in 1..MAX_STAR) {
        if (i <= starsState.starCount) {
            localRewards[oxygenRewards[i - 1]] = R.drawable.star
        } else {
            localRewards[oxygenRewards[i - 1]] = R.drawable.gray_star
        }
    }

    return localRewards
}