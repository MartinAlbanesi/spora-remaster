package com.gg.spora.grove.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R

/**
 * Composable function for displaying a planting placeholder.
 * @param isLoading Whether the content is being loaded.
 */
@Composable
fun PlantingPlaceholder(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
) {
    if(!isLoading) {
        Image(
            painter = painterResource(id = R.drawable.empty_tree_spot),
            contentDescription = "Planting Placeholder",
            modifier = modifier
                .size(64.dp)
        )
    } else {
        CircularProgressIndicator()
    }
}