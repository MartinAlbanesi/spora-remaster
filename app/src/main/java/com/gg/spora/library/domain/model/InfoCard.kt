package com.gg.spora.library.domain.model

import com.gg.spora.core.utils.enums.StageType

data class InfoCard(
    val id: String,
    val title: String,
    val info: String,
    val image: Int,
    var isUnlocked: Boolean = false,
    val category: StageType
)