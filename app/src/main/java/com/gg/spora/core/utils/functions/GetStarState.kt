package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StarState

fun getStarState(lives: Int): StarState {
    return when (lives) {
        0 -> StarState.ZERO
        1,2 -> StarState.ONE
        3,4 -> StarState.TWO
        5 -> StarState.THREE
        else -> StarState.ZERO
    }
}