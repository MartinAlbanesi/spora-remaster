package com.gg.spora.grove.data.network.models

import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.TreeType
import java.time.LocalDateTime

data class ForestTreeNetwork (
    val id: String,
    val treeType: String,
    var currentStage: String,
    val plantingDate: Long,
    var position: Int = 0,
    var hasReachedAdultStage: Boolean,
    var timesOxygenClaimed: Int,
)