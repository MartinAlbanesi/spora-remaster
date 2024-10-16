package com.gg.spora.core.utils.functions

import com.gg.spora.forestStage.domain.model.Level

fun List<Level>.getIsCompleteFromPreviousLevel(index: Int): Boolean {
    return if (index == 0) {
        true
    } else {
        this[index - 1].isComplete
    }
}