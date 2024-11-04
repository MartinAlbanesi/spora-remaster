package com.gg.spora.forestStage.domain.model

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.miniGames.domain.model.Challenge

data class StageLevel(
    val id: String,
    val stageType: StageType,
//    val levels : List<Level>,
//    val challenge: Challenge,
    val levelPreviewImage: Int,
    val stageBackgroundImage: Int,
    val pathLadder: List<Pair<Int,Int>>
)
