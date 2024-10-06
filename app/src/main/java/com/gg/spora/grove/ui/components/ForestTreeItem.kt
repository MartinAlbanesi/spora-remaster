package com.gg.spora.grove.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.grove.data.models.ForestTree
import com.gg.spora.grove.data.models.GrowthStage
import kotlinx.coroutines.delay

/**
 * Composable que representa un árbol del bosque en la interfaz de usuario.
 * @param tree El árbol del bosque a representar.
 * @param onTreeUpdated Una función lambda que se llama cuando se actualiza el estado del árbol.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForestTreeItem(tree: ForestTree, onTreeUpdated: (ForestTree) -> Unit) {
    // State para el árbol del bosque
    var treeState by remember { mutableStateOf(tree) }

    // Imagen correspondiente al estado del árbol
    val imageResource = when (treeState.currentStage) {
        GrowthStage.SPROUT -> R.drawable.sprout_tree
        GrowthStage.MEDIUM -> R.drawable.medium_tree
        GrowthStage.ADULT -> treeState.type.imageResource
    }

    // Efecto que actualiza el estado del árbol cada segundo
    LaunchedEffect(key1 = tree, key2 = treeState.currentStage) {
        while (true) {
            delay(1000)
            val updatedTree = treeState.copy()
            updatedTree.updateGrowthStage()
            onTreeUpdated(updatedTree)
            treeState = updatedTree
        }
    }

    // Imagen del árbol y su descripción
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "Tree in ${treeState.currentStage.name} stage", // More descriptive
        modifier = Modifier.size(64.dp)
    )

    // Estado actual del árbol
    Text(
        text = treeState.currentStage.name,
        fontSize = 12.sp,
        modifier = Modifier.fillMaxWidth()
    )
}