package com.gg.spora.stage.domain.functions

import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StageType

fun getPathLadderByStageType(stageType: StageType): List<Pair<Int, Int>> {
    return when (stageType) {
        StageType.FOREST -> SporaConstant.PATH_LADDER
        StageType.DESERT -> TODO()
        StageType.LAKE -> TODO()
        StageType.EXPO -> SporaConstant.PATH_LADDER_EXPO
    }
}