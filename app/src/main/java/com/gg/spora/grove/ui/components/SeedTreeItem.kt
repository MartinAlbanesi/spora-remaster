package com.gg.spora.grove.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GroveUiState
import com.gg.spora.grove.domain.models.SeedTree

/**
 * Composable que representa un árbol semillero en la interfaz de usuario.
 * @param seedTree El árbol semillero a representar.
 * @param onForestTreeGenerated Una función lambda que se llama cuando se genera una semilla.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeedTreeItem(
    modifier: Modifier = Modifier,
    seedTree: SeedTree,
    uiState: GroveUiState,
    isLoading: Boolean,
    onPlantForestTree: (ForestTree, String) -> Unit,
) {

    if (!isLoading) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(id = seedTree.type.imageResource),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )

            Button(
                modifier = Modifier.width(100.dp),
                onClick = {
                    onPlantForestTree(ForestTree(type = seedTree.type), seedTree.id)
                },
                enabled = (uiState.seedTreeCooldowns[seedTree.id] ?: 0L) == 0L,
            ) {
                // Muestra el texto correspondiente al cooldown
                val cooldown = uiState.seedTreeCooldowns[seedTree.id]
                if (cooldown?.let { it >= 1000L && it <= 5000L } == true) {
                    Text("${cooldown.div(1000L)}s")
                } else if (cooldown == 0L) {
                    Text("Claim")
                }
            }
        }
    } else {
        CircularProgressIndicator()
    }
}
