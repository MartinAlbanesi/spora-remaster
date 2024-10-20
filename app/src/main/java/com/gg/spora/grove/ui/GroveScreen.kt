package com.gg.spora.grove.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarWithDualIcon
import com.gg.spora.core.ui.modifiers.ModifierStyle
import com.gg.spora.grove.data.models.ForestTree
import com.gg.spora.grove.data.models.Seed
import com.gg.spora.grove.data.models.SeedTree
import com.gg.spora.grove.ui.components.ForestTreeItem
import com.gg.spora.grove.ui.components.PlantingPlaceholder
import com.gg.spora.grove.ui.components.SeedTreeItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GroveScreen(
    modifier: Modifier = Modifier,
    seedTrees: List<SeedTree>,
    forestTrees: List<List<ForestTree?>>,
    plantSeedInForest: (Seed) -> Unit,
    updateTree: (ForestTree) -> Unit,
    popBackStack: () -> Unit
) {
    // State para los árboles semilleros
    val seedTrees = seedTrees

    // State para los árboles del bosque
    val forestTrees = forestTrees

    /*
    val forestTree = groveViewModel.forestTree.collectAsState()
    val currentTree = forestTree.value
     */

    Scaffold(
        topBar = {
            TopAppBarWithDualIcon(
                modifier = ModifierStyle.brush,
                firstLabel = "12",
                firstIcon = R.drawable.trees_icon,
                secondLabel = "465",
                secondIcon = R.drawable.o2_icon,
                showBackArrow = true,
                onBackClick = popBackStack
            )
        },
        modifier = modifier
    ) { paddingValue ->

        // Fondo de la pantalla
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo_generico_sin_pasto),
                contentDescription = "Grove Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .offset(y = (-100).dp)
        ) {
            // Fila de árboles semilleros
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                // Componente para cada árbol semillero
                for (seedTree in seedTrees) {
                    SeedTreeItem(seedTree) { seed ->
                        plantSeedInForest(seed)
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
        ) {
            // Cuadricula de árboles del bosque
            LazyVerticalGrid(
                columns = GridCells.Fixed(forestTrees[0].size),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                // Componente para cada árbol del bosque
                items(forestTrees.flatten()) { tree ->
                    if (tree != null) {
                        ForestTreeItem(tree) { updatedTree ->
                            updateTree(updatedTree)
                        }
                    } else {
                        PlantingPlaceholder() // Componente de plantacion vacia
                    }
                }
            }
        }
    }
}

/*
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun GrovePreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GroveScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
 */