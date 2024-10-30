package com.gg.spora.grove.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R

// Muestra una imagen de plantacion vacia
@Composable
fun PlantingPlaceholder(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.empty_tree_spot),
        contentDescription = "Planting Placeholder",
        modifier = modifier
            .size(64.dp)
    )
}