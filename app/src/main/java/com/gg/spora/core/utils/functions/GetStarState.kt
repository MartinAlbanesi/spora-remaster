package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StarState

fun getRewardsStarState(livesLost: Int): StarState {
    return when (livesLost) {
        5 -> StarState.ZERO
        3,4 -> StarState.ONE
        1,2 -> StarState.TWO
        0 -> StarState.THREE
        else -> StarState.ZERO
    }
}