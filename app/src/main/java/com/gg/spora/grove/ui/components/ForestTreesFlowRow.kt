package com.gg.spora.grove.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gg.spora.grove.domain.models.GroveUiState

/**
 * Composable function for displaying a flow row of forest trees.
 * @param uiState The current UI state.
 * @param isLoading Whether the content is being loaded.
 * @param forestTreesColumnCount The number of columns for the flow row.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ForestTreesFlowRow(
    modifier: Modifier = Modifier,
    uiState: GroveUiState,
    isLoading: Boolean,
    forestTreesColumnCount: Int
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        maxItemsInEachRow = forestTreesColumnCount
    ) {
        uiState.forestTrees.forEach { tree ->
            if (tree == null) {
                PlantingPlaceholder(
                    isLoading = isLoading
                ) // Empty spot placeholder
            } else {
                ForestTreeItem(
                    tree = tree,
                    uiState = uiState,
                    isLoading = isLoading,
                )
            }
        }
    }
}