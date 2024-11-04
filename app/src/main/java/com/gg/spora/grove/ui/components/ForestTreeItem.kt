package com.gg.spora.grove.ui.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GrowthStage
import kotlinx.coroutines.delay

/**
 * Composable que representa un árbol del bosque en la interfaz de usuario.
 * @param tree El árbol del bosque a representar.
 * @param onTreeUpdated Una función lambda que se llama cuando se actualiza el estado del árbol.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForestTreeItem(
    tree: ForestTree,
    onTreeUpdated: (ForestTree) -> Unit,
    onGrowthStageUpdated: (ForestTree) -> Unit
) {
//    // State para el árbol del bosque
//    var treeState by remember { mutableStateOf(tree) }
//
//    // Un flag para saber cuando el árbol llegue a la etapa adulta y detener el contador de crecimiento
//    var hasReachedAdultStage by remember { mutableStateOf(false) }

    // Imagen correspondiente al estado del árbol
    val imageResource by remember(tree.currentStage, tree.type) {
        derivedStateOf {
            when (tree.currentStage) {
                GrowthStage.SPROUT -> R.drawable.sprout_tree
                GrowthStage.MEDIUM -> R.drawable.medium_tree
                GrowthStage.ADULT -> tree.type.imageResource
            }
        }
    }

    Log.i("ForestTreeItem", "Tree: $tree")
    Log.i("ForestTreeItem", "Image resource: ${imageResource.toString()}")

    // Imagen del árbol y su descripción
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "Tree in ${tree.currentStage.name} stage",
        modifier = Modifier.size(64.dp)
    )

    // Efecto que actualiza el estado del árbol cada segundo
    LaunchedEffect(key1 = tree.currentStage) { // Use tree.id as the key
        if (!tree.hasReachedAdultStage) {
            delay(1000) // Delay for 1 second
            val updatedTree = tree.copy().apply { onGrowthStageUpdated(this) }
            onTreeUpdated(updatedTree) // Trigger the update callback
        }
    }
}