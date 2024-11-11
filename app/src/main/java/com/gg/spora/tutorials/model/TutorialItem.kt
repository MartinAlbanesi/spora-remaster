package com.gg.spora.tutorials.model

import androidx.compose.ui.geometry.Offset

data class TutorialItem(
    val text: String,
    val champyImageState: Int,
    val isChampyTalking: Boolean = true,
    val secondaryImage: Int? = null,
    val isSecondaryTalking: Boolean = false,
    val focusItem: Offset? = null
)