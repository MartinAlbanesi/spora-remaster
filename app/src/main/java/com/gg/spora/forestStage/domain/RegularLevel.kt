package com.gg.spora.forestStage.domain

class RegularLevel(
    val numberLevel: Int,
    var numberStars: Int,
    image: Int,
    typeStage: TypeStage,
    isUnlocked: Boolean,
    isCompleted: Boolean,
    id: Int
) : Level(image, typeStage, isUnlocked, isCompleted, id)
