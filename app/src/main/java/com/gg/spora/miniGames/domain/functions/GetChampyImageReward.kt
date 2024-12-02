package com.gg.spora.miniGames.domain.functions

import com.gg.spora.R
import com.gg.spora.core.utils.enums.StarState

fun getChampyImageReward(starsState: StarState): Int {
    return when (starsState) {
        StarState.ZERO -> R.drawable.champy_defeated_arms_body
        StarState.ONE, StarState.TWO -> R.drawable.champy_serious_idle
        StarState.THREE -> R.drawable.champy_celebrating_raised_arms
    }
}