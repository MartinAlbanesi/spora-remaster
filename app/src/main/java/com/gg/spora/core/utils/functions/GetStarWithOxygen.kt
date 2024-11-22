package com.gg.spora.core.utils.functions

import com.gg.spora.R
import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.core.utils.enums.StarState

fun getStarWithOxygen (
    starsState: StarState,
    oxygenRewards: List<Int>,
): List<Pair<Int, Int?>>{
    val localRewards: MutableList<Pair<Int, Int?>> = mutableListOf()

    for (i in 1..MAX_STAR) {
        if (i <= starsState.starCount) {
            localRewards.add(Pair(oxygenRewards[i - 1], R.drawable.gray_star))
        } else {
            localRewards.add(Pair(oxygenRewards[i - 1], null))
        }
    }

    return localRewards
}