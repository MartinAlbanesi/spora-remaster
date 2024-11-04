package com.gg.spora.home.domain.models

import androidx.compose.ui.Modifier

data class HomeIcon(
    val image: Int,
    val text: String,
    val onClick: () -> Unit,
    val modifier: Modifier = Modifier
)