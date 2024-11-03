package com.gg.spora.grove.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
    onForestTreeGenerated: (ForestTree, Int) -> Unit,
    onCooldownTriggered: (Int) -> Unit
) {
//    // Estado para el cooldown
//    var isCooldownActive by remember { mutableStateOf(!seedTree.isForestTreeAvailable()) }
//    var remainingCooldown by remember { mutableStateOf(0L) }

//    // Efecto que actualiza el cooldown
//    LaunchedEffect(key1 = seedTree, key2 = remainingCooldown) {
//        if (isCooldownActive) {
//            while (remainingCooldown > 0) {
//                remainingCooldown =
//                    seedTree.nextForestTreeAvailableTime - System.currentTimeMillis()
//                delay(1000)
//            }
//            isCooldownActive = false
//        }
//    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = seedTree.type.imageResource), // Access imageResource from seedTree.type
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Button(
            modifier = Modifier.width(100.dp),
            onClick = {
//                if (!isCooldownActive) { // Only generate if not on cooldown
//                    val newForestTree = ForestTree(type = seedTree.type)
//                    onForestTreeGenerated(newForestTree, seedTree.id)
//                    Log.d("SeedTreeItem", "Forest Tree generated: $newForestTree")
//
//                    // Trigger cooldown update in ViewModel
//                    onCooldownTriggered(seedTree.id)
//
//                    // Update UI state (optional, if you need immediate visual feedback)
//                    isCooldownActive = true
//                    remainingCooldown = seedTree.timeToGenerateForestTree.toMillis()
//                }
            },
//            enabled = !isCooldownActive, // Deshabilita el botón si el cooldown está activo
        ) {
            // Muestra el texto correspondiente al cooldown
//            if (isCooldownActive) {
//                Text("${remainingCooldown / 1000}s")
//            } else {
//                Text("Claim")
//            }
        }
    }
}
