package com.gg.spora.grove.data.network.models

data class ForestTreeNetwork(
    val id: String? = null,
    val treeType: String? = null,
    var currentStage: String? = null,
    val plantingDate: Long? = null,
    var position: Int? = null,
    var hasReachedAdultStage: Boolean? = null,
    var timesOxygenClaimed: Int? = null,
)