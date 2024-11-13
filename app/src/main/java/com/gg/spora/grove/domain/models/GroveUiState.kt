package com.gg.spora.grove.domain.models

data class GroveUiState (
    val seedTrees: List<SeedTree>,
    val forestTrees: List<ForestTree?>,
    val seedTreeCooldowns: Map<Int, Long>,
    val forestTreeGrowthTimes: Map<Int, Long>
)