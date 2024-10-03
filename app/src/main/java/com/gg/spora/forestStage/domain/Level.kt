package com.gg.spora.forestStage.domain

import androidx.compose.ui.graphics.painter.Painter

open class Level(
    val image: Painter,
    val typeStage: TypeStage,
    var isUnlocked: Boolean,
    var isCompleted: Boolean,
    var onClicked: () -> Unit
)