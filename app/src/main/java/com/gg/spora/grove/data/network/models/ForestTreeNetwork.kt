package com.gg.spora.grove.data.network.models

import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.TreeType
import java.time.LocalDateTime

data class ForestTreeNetwork (
    val id: String,
    val type: TreeType,
    var currentStage: GrowthStage,
    val plantingDate: LocalDateTime,
    var position: Int = 0,
    var hasReachedAdultStage: Boolean,
    var timesOxygenClaimed: Int,
)