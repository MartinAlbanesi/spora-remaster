package com.gg.spora.forestStage.domain

data class Stage(
    val type: TypeStage,
    val imageBackground: Int,
    val title: String,
    val listLevel: List<Level>,
    val id: Int
)
