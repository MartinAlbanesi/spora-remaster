package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.core.utils.enums.StarState

fun getTotalOxygenFromStars(
    starsState: StarState,
    oxygenRewards: List<Int>,
): Int {
    var totalOxygen = 0

    for (i in 1..MAX_STAR) {
        if (i <= starsState.starCount) {
            totalOxygen += oxygenRewards[i - 1]
        }
    }

    return totalOxygen
}