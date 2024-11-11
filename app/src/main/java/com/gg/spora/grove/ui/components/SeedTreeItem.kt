package com.gg.spora.grove.ui.components

import android.os.Build
import android.util.Log
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
    uiState: Triple<List<SeedTree>, List<ForestTree?>, Map<Int, Long>>,
    isLoading: Boolean,
    onSeedTreeButtonClicked: (Int, Long) -> Unit,
    onPlantForestTree: (ForestTree, Int) -> Unit,
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
                    onSeedTreeButtonClicked(seedTree.id, seedTree.timeToGenerateForestTree)
                    onPlantForestTree(ForestTree(type = seedTree.type), seedTree.id)
                },
//                enabled = (uiState.third[seedTree.id] ?: INITIAL_COOLDOWN_DURATION) == 5000L, // Habilita el botón si el cooldown no se inició (está en 0)
                enabled = (uiState.third[seedTree.id] ?: 0L) == 0L,
            ) {
                // Muestra el texto correspondiente al cooldown
                if (uiState.third[seedTree.id]!! >= 1000 && uiState.third[seedTree.id]!! <= 5000L) {
                    Text("${uiState.third[seedTree.id]?.div(1000)}s")
                    Log.i("GroveViewModel", "Inicializo el cooldown")
                } else if (uiState.third[seedTree.id] == 0L) {
                    Log.i("GroveViewModel", "Button clicked ${uiState.third[seedTree.id]}")
                    Text("Claim")
                }
            }
        }
    } else {
        CircularProgressIndicator()
    }
}
