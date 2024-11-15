package com.gg.spora.grove.ui.components

import android.os.Build
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
) {
    val currentStage by remember(tree, uiState.forestTreeGrowthTimes) {
        derivedStateOf { tree.currentStage }
    }

    val imageResource = when (currentStage) {
        GrowthStage.SPROUT -> R.drawable.sprout_tree
        GrowthStage.MEDIUM -> R.drawable.medium_tree
        GrowthStage.ADULT -> tree.type.imageResource
    }

    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "Tree in ${currentStage.name} stage",
        modifier = Modifier.size(64.dp)
    )
}