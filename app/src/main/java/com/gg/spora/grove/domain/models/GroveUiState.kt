package com.gg.spora.grove.domain.models

data class GroveUiState (
    val seedTrees: List<SeedTree>,
    val forestTrees: List<ForestTree?>,
    val seedTreeCooldowns: Map<String, Long>,
    val forestTreeGrowthTimes: Map<String, Long>
)