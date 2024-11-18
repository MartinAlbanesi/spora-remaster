package com.gg.spora.grove.data.network.models

import com.gg.spora.grove.domain.models.TreeType
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.UUID

data class SeedTreeNetwork (
    val id: String,
    val type: TreeType,
    val timeToGenerateForestTree: Long,
    val expectedTimeToGenerateForestTree: Long,
    var amountOfForestTreesGenerated: Int,
)