package com.gg.spora.grove.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun TreeImage(image: Int,size: Dp) {
    Image(
        painter = painterResource(image),
        contentDescription = "Grove Tree",
        contentScale = ContentScale.Inside,
        modifier = Modifier.size(size)
    )
}