package com.gg.spora.grove.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GroveUiState

/**
 * Composable function for displaying a row of seed trees.
 * @param uiState The current UI state.
 * @param isLoading Whether the content is being loaded.
 * @param plantForestTree The action to perform when a forest tree is planted.
 */
@Composable
fun SeedTreesRow(
    modifier: Modifier = Modifier,
    uiState: GroveUiState,
    isLoading: Boolean,
    plantForestTree: (ForestTree, String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier,
    ) {
        uiState.seedTrees.forEach { seedTree ->
            SeedTreeItem(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .align(Alignment.Bottom),
                seedTree = seedTree,
                uiState = uiState,
                isLoading = isLoading,
                onPlantForestTree = { forestTree, seedTreeId ->
                    plantForestTree(forestTree, seedTreeId)
                }
            )
        }
    }
}