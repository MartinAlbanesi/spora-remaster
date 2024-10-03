package com.gg.spora.forestStage.domain

import androidx.compose.ui.graphics.painter.Painter

class ChallengeLevel(
    image: Painter,
    typeStage: TypeStage,
    isUnlocked: Boolean,
    isCompleted: Boolean,
    onClicked: () -> Unit
) : Level(image, typeStage, isUnlocked, isCompleted, onClicked) {


}