package com.gg.spora.grove.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gg.spora.grove.domain.models.GroveUiState

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