package com.gg.spora.forestStage.domain

open class Level(
    val image: Int,
    val typeStage: TypeStage,
    var isUnlocked: Boolean,
    var isCompleted: Boolean,
    val id: Int
)