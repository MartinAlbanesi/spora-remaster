package com.gg.spora.forestStage.domain.model

import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.miniGames.domain.model.Challenge

data class StageLevel(
    val id: String,
    val typeStage: TypeStage,
    val levels : List<Level>,
    val challenge: Challenge
)
