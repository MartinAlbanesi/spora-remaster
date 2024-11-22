package com.gg.spora.grove.domain.models

/**
 * Data class representing the UI state of the Grove screen.
 * @param seedTrees The list of seed trees.
 * @param forestTrees The list of forest trees.
 * @param seedTreeCooldowns The map of seed tree cooldowns.
 * @param forestTreeGrowthTimes The map of forest tree growth times.
 * @param accumulatedOxygen The accumulated oxygen.
 * @param userOxygen The user's oxygen.
 * @param oxygenCooldown The oxygen cooldown.
 * @see com.gg.spora.grove.ui.GroveViewModel
 * @see com.gg.spora.grove.ui.GroveScreen
 */
data class GroveUiState (
    val seedTrees: List<SeedTree>,
    val forestTrees: List<ForestTree?>,
    val seedTreeCooldowns: Map<String, Long>,
    val forestTreeGrowthTimes: Map<String, Long>,
    val accumulatedOxygen: Int,
    val userOxygen: Int,
    val oxygenCooldown: Long,
)