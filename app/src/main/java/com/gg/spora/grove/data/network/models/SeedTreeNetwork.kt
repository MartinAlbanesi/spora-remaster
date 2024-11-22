package com.gg.spora.grove.data.network.models

import com.gg.spora.grove.domain.models.TreeType

data class SeedTreeNetwork (
    val id: String,
    val treeType: String,
    val timeToGenerateForestTree: Long,
    val expectedTimeToGenerateForestTree: Long,
    var amountOfForestTreesGenerated: Int,
)