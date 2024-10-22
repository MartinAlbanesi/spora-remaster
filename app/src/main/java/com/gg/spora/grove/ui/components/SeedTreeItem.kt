package com.gg.spora.grove.ui.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.grove.data.models.Seed
import com.gg.spora.grove.data.models.SeedTree
import kotlinx.coroutines.delay

/**
 * Composable que representa un árbol semillero en la interfaz de usuario.
 * @param seedTree El árbol semillero a representar.
 * @param onSeedGenerated Una función lambda que se llama cuando se genera una semilla.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeedTreeItem(
    modifier: Modifier = Modifier,
    seedTree: SeedTree,
    onSeedGenerated: (Seed) -> Unit
) {
    // Estado para el cooldown
    var isCooldownActive by remember { mutableStateOf(!seedTree.isSeedAvailable()) }
    var remainingCooldown by remember { mutableStateOf(0L) }

    // Efecto que actualiza el cooldown
    LaunchedEffect(key1 = seedTree, key2 = remainingCooldown) {
        if (isCooldownActive) {
            while (remainingCooldown > 0) {
                remainingCooldown = seedTree.nextSeedAvailableTime - System.currentTimeMillis()
                delay(1000)
            }
            isCooldownActive = false
        }
    }

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
            modifier = Modifier.
                width(100.dp),
            onClick = {
                // Si el cooldown no está activo, genera una semilla
                val generatedSeed = seedTree.generateSeed()
                Log.d("SeedTreeItem", "Generated Seed: $generatedSeed")
                generatedSeed?.let { seed ->
                    Log.d("SeedTreeItem", "Seed generated: $seed")
                    onSeedGenerated(seed)
                    isCooldownActive = true
                    remainingCooldown = seedTree.nextSeedAvailableTime - System.currentTimeMillis()
                }
            },
            enabled = !isCooldownActive, // Deshabilita el botón si el cooldown está activo
        ) {
            // Muestra el texto correspondiente al cooldown
            if(isCooldownActive){
                Text("${remainingCooldown / 1000}s")
            } else {
                Text("Claim")
            }
        }
    }
}
