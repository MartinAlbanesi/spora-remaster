package com.gg.spora.tutorials.domain.model

import androidx.compose.ui.geometry.Offset

data class TutorialItem(
    val text: String,
    val champyImageState: Int? = null,
    val isChampyTalking: Boolean = true,
    val secondaryImage: Int? = null,
    val isSecondaryTalking: Boolean = false,
    val focusItem: Offset? = null
)