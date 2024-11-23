package com.gg.spora.grove.data.network.models

data class SeedTreeNetwork (
    val id: String? = null,
    val treeType: String? = null,
    val timeToGenerateForestTree: Long? = null,
    val expectedTimeToGenerateForestTree: Long? = null,
    var amountOfForestTreesGenerated: Int? = null,
)