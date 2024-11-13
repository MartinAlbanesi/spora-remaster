package com.gg.spora.grove.ui.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GroveUiState
import com.gg.spora.grove.domain.models.GrowthStage

/**
 * Composable que representa un árbol del bosque en la interfaz de usuario.
 * @param tree El árbol del bosque a representar.
 * @param onTreeUpdated Una función lambda que se llama cuando se actualiza el estado del árbol.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForestTreeItem(
    tree: ForestTree,
    uiState: GroveUiState,
//    onTreeUpdated: (ForestTree) -> Unit,
//    onGrowthStageUpdated: (ForestTree) -> Unit
) {
    val currentStage by remember(tree, uiState.forestTreeGrowthTimes) {
        derivedStateOf { tree.currentStage } // Observe currentStage reactively
    }

    val imageResource = when (currentStage) { // Update imageResource based on derived state
        GrowthStage.SPROUT -> R.drawable.sprout_tree
        GrowthStage.MEDIUM -> R.drawable.medium_tree
        GrowthStage.ADULT -> tree.type.imageResource
    }

    Log.i("ForestTreeItem", "Tree: $tree")
    Log.i("ForestTreeItem", "Image resource: $imageResource")

    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "Tree in ${currentStage.name} stage",
        modifier = Modifier.size(64.dp)
    )
}