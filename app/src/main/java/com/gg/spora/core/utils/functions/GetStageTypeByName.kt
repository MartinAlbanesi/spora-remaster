package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.StageType

fun getStageTypeByName(name: String): StageType {
    return when (name) {
        "FOREST" -> StageType.FOREST
        "DESERT" -> StageType.DESERT
        "LAKE" -> StageType.LAKE
        "EXPO" -> StageType.EXPO
        else -> StageType.FOREST
    }
}