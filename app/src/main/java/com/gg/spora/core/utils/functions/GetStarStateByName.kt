package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StarState

fun getStarStateByName(name: String): StarState {
    return when (name) {
        "ZERO" -> StarState.ZERO
        "ONE" -> StarState.ONE
        "TWO" -> StarState.TWO
        "THREE" -> StarState.THREE
        else -> StarState.ZERO
    }
}