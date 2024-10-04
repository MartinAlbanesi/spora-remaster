package com.gg.spora.forestStage.domain

class ChallengeLevel(
    image: Int,
    typeStage: TypeStage,
    isUnlocked: Boolean,
    isCompleted: Boolean,
    id: Int
) : Level(image, typeStage, isUnlocked, isCompleted, id)