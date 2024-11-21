package com.gg.spora.grove.ui

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarWithDualIcon
import com.gg.spora.core.ui.modifiers.ModifierStyle
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GroveUiState
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import com.gg.spora.grove.ui.components.ButtonWithIcon
import com.gg.spora.grove.ui.components.ForestTreesFlowRow
import com.gg.spora.grove.ui.components.SeedTreesRow
import com.gg.spora.ui.theme.SporaTheme
import kotlinx.coroutines.launch

/**
 * Composable function for displaying the Grove screen.
 * @param modifier The modifier for styling.
 * @param uiState The current UI state.
 * @param isLoading Whether the content is being loaded.
 * @param forestTreesColumnCount The number of columns for the forest trees grid.
 * @param scrollState The scroll state for horizontal scrolling.
 * @param plantForestTree The action to perform when a forest tree is planted.
 * @param claimOxygen The action to perform when the oxygen button is clicked.
 * @param popBackStack The action to perform when the back button is clicked.
 */
@OptIn(ExperimentalLayoutApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GroveScreen(
    modifier: Modifier = Modifier,
    uiState: GroveUiState,
    isLoading: Boolean,
    forestTreesColumnCount: Int,
    scrollState: ScrollState = rememberScrollState(),
    plantForestTree: (ForestTree, String) -> Unit,
    claimOxygen: () -> Unit,
    popBackStack: () -> Unit,
    errorState: String?
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(errorState) {
        errorState?.let { errorMessage ->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(
                    message = errorMessage,
                    actionLabel = "OK"
                )
            }
        }
    }

    BackHandler{
        popBackStack()
    }
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
                painter = painterResource(id = R.drawable.grove_rework_without_clouds),
                contentDescription = "Grove Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
            )

            // Trees content column
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.weight(0.30f))

                // Seed Trees Row
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(bottom = 16.dp),
                ) {
                    SeedTreesRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        uiState = uiState,
                        isLoading = isLoading,
                        plantForestTree = { forestTree, seedTreeId ->
                            plantForestTree(forestTree, seedTreeId)
                        }
                    )
                }

                // Forest Trees Grid (FlowRow)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                ) {
                    ForestTreesFlowRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        uiState = uiState,
                        isLoading = isLoading,
                        forestTreesColumnCount = forestTreesColumnCount
                    )
                }
            }
        }

        // Claim Oxygen Button
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp)
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
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GrovePreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GroveScreen(
                modifier = Modifier.fillMaxSize(),
                uiState = GroveUiState(
                    seedTrees = listOf(
                        SeedTree(type = TreeType.PINE),
                        SeedTree(type = TreeType.SECUOYA),
                        SeedTree(type = TreeType.MANGROVE),
                        SeedTree(type = TreeType.BAOBAB),
                    ),
                    forestTrees = List(50) { null },
                    seedTreeCooldowns = emptyMap(),
                    forestTreeGrowthTimes = emptyMap(),
                    accumulatedOxygen = 0,
                    userOxygen = 0,
                    oxygenCooldown = 0L,
                ),
                isLoading = false,
                forestTreesColumnCount = 10,
                plantForestTree = { _, _ -> },
                claimOxygen = {},
                popBackStack = {},
                errorState = ""
            )
        }
    }
}