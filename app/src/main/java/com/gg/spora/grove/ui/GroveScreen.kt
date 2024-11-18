package com.gg.spora.grove.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
import com.gg.spora.grove.ui.components.ButtonWithIcon
import com.gg.spora.grove.ui.components.ForestTreeItem
import com.gg.spora.grove.ui.components.PlantingPlaceholder
import com.gg.spora.grove.ui.components.SeedTreeItem

@OptIn(ExperimentalLayoutApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GroveScreen(
    modifier: Modifier = Modifier,
    uiState: GroveUiState,
    isLoading: Boolean,
    forestTreesColumnCount: Int,
    plantForestTree: (ForestTree, String) -> Unit,
    claimOxygen: () -> Unit,
    popBackStack: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBarWithDualIcon(
                modifier = ModifierStyle.brush,
                secondLabel = uiState.userOxygen.toString(),
                secondIcon = R.drawable.oxygen_icon,
                showBackArrow = true,
                onBackClick = popBackStack
            )
        },
        modifier = modifier
    ) { paddingValue ->

        // Horizontal scrollable content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .horizontalScroll(scrollState),
        ) {
            // Background image
            Image(
                painter = painterResource(id = R.drawable.generic_background_no_grass),
                contentDescription = "Grove Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.weight(0.47f))

                // Seed Trees Row
                Box(
                    modifier = Modifier
//                        .padding(paddingValue)
//                        .offset(y = 120.dp)
                        .weight(0.5f)
                        .padding(bottom = 10.dp),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .fillMaxWidth(),
//                            .padding(bottom = 16.dp)
                    ) {
                        uiState.seedTrees.forEach { seedTree ->
                            SeedTreeItem(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .align(Alignment.Bottom), // or .wrapContentSize()
                                seedTree = seedTree,
                                uiState = uiState,
                                isLoading = isLoading,
                                onPlantForestTree = { forestTree, seedTreeId ->
                                    plantForestTree(forestTree, seedTreeId)
                                }
                            )
                        }
                    }
                }

                // Forest Trees Grid
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                ) {
                    Log.i("ForestTrees", "ForestTrees: ${uiState.forestTrees}")
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth(),
//                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        maxItemsInEachRow = forestTreesColumnCount
                    ) {
                        uiState.forestTrees.forEach { tree ->
                            if (tree == null) {
                                PlantingPlaceholder(
                                    isLoading = isLoading
                                ) // Empty spot placeholder
                            } else {
                                ForestTreeItem(
                                    tree = tree,
                                    uiState = uiState,
                                    isLoading = isLoading,
                                )
                            }
                        }
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp)
//                    .weight(0.2f)
        ) {
            ButtonWithIcon(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(160.dp),
                text = "${uiState.accumulatedOxygen}",
                icon = R.drawable.oxygen_icon,
                cooldownValue = uiState.oxygenCooldown,
                cooldownType = OXYGEN_COOLDOWN_DURATION,
                onClick = { claimOxygen() }
            )
        }

        /*
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValue)
                        .offset(y = (-100).dp)
                ) {
                    // Fila de árboles semilleros
                    LazyRow(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .padding(bottom = 30.dp)
                    ) {
                        // Componente para cada árbol semillero
                        itemsIndexed(uiState.seedTrees) { _, seedTree ->
                            SeedTreeItem(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter),
                                seedTree = seedTree,
                                uiState = uiState,
                                isLoading = isLoading,
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
                            .padding(horizontal = 16.dp, vertical = 24.dp)
                            .offset(y = (-50).dp)
                    ) {
                        itemsIndexed(uiState.forestTrees) { index, tree ->
                            if (tree == null) {
                                PlantingPlaceholder() // Componente de plantacion vacia
                            } else {
                                ForestTreeItem(
                                    tree = tree,
                                    uiState = uiState,
                                )
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValue)
                        .width(150.dp)
                        .padding(16.dp)
                ) {
                    ButtonWithIcon(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .width(160.dp),
                        text = "${uiState.accumulatedOxygen}",
                        icon = R.drawable.oxygen_icon,
                        cooldownValue = uiState.oxygenCooldown,
                        cooldownType = OXYGEN_COOLDOWN_DURATION,
                        onClick = { claimOxygen() }
                    )
                }
                */
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