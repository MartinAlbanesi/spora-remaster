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
import androidx.compose.foundation.lazy.grid.itemsIndexed
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
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GroveUiState
import com.gg.spora.grove.ui.components.ForestTreeItem
import com.gg.spora.grove.ui.components.PlantingPlaceholder
import com.gg.spora.grove.ui.components.SeedTreeItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GroveScreen(
    modifier: Modifier = Modifier,
    uiState: GroveUiState,
    isLoading: Boolean,
    onSeedTreeButtonClicked: (Int, Long) -> Unit,
    plantForestTree: (ForestTree, Int) -> Unit,
    popBackStack: () -> Unit
//    updateTree: (ForestTree) -> Unit,
//    updateGrowthStage: (ForestTree) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBarWithDualIcon(
                modifier = ModifierStyle.brush,
                secondLabel = "465",
                secondIcon = R.drawable.oxygen_icon,
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
                painter = painterResource(id = R.drawable.generic_background_no_grass),
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
                for (seedTree in uiState.seedTrees) {
                    SeedTreeItem(
                        seedTree = seedTree,
                        uiState = uiState,
                        isLoading = isLoading,
//                        onSeedTreeButtonClicked = {p1, p2 -> onSeedTreeButtonClicked(p1, p2)},
                        onPlantForestTree = { forestTree, seedTreeId ->
                            plantForestTree(forestTree, seedTreeId)
                        },
                    )
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
                columns = GridCells.Fixed(5),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .offset(y = (-50).dp)
            ) {
                itemsIndexed(uiState.forestTrees) { index, tree -> // Use itemsIndexed here
                    if (tree == null) {
                        PlantingPlaceholder() // Componente de plantacion vacia
                    } else {
                        ForestTreeItem(
                            tree = tree,
                            uiState = uiState,
//                            onTreeUpdated = updateTree,
//                            onGrowthStageUpdated = updateGrowthStage
                        )
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
                modifier = Modifier.fillMaxSize(),
                seedTrees = emptyList(),
                forestTrees = emptyList(),
                plantSeedInForest = {},
                updateTree = {},
                popBackStack = {}
            )
        }
    }
}
 */