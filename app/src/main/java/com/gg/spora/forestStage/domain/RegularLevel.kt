package com.gg.spora.forestStage.domain

import androidx.compose.ui.graphics.painter.Painter

class RegularLevel(
    val number: Int,
    var stars: Int,
    image: Painter,
    typeStage: TypeStage,
    isUnlocked: Boolean,
    isCompleted: Boolean,
    onClicked: () -> Unit
) : Level(image, typeStage, isUnlocked, isCompleted, onClicked){



}
