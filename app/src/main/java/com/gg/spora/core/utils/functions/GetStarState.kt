package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StarState

fun getStarState(lives: Int): StarState {
    return when (lives) {
        0 -> StarState.STAR_ZERO
        1,2 -> StarState.STAR_ONE
        3,4 -> StarState.STAR_TWO
        5 -> StarState.STAR_THREE
        else -> StarState.STAR_ZERO
    }
}