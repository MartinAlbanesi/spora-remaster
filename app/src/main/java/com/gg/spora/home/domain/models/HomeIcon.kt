package com.gg.spora.home.domain.models

data class HomeIcon(
    val image: Int,
    val text: String,
    val onClick: () -> Unit
)