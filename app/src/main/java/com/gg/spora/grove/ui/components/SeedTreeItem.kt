package com.gg.spora.grove.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.BuildConfig.INITIAL_COOLDOWN_DURATION
import com.gg.spora.R
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GroveUiState
import com.gg.spora.grove.domain.models.SeedTree

/**
 * Composable function for displaying a seed tree item.
 * @param seedTree The seed tree to display.
 * @param uiState The current UI state.
 * @param isLoading Whether the content is being loaded.
 * @param onPlantForestTree The action to perform when the forest tree is planted.
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
            verticalArrangement = Arrangement.Bottom,
            modifier = modifier
        ) {

            Image(
                painter = painterResource(id = seedTree.type.imageResource),
                contentDescription = null,
                modifier = Modifier
                    .weight(0.8f)
                    .size(120.dp)
            )

            ButtonWithIcon(
                modifier = Modifier
                    .weight(0.2f)
                    .width(134.dp),
                icon = R.drawable.seed_reward,
                cooldownValue = uiState.seedTreeCooldowns[seedTree.id],
                cooldownType = INITIAL_COOLDOWN_DURATION,
                onClick = { onPlantForestTree(ForestTree(type = seedTree.type), seedTree.id) }
            )
        }
    } else {
        CircularProgressIndicator()
    }
}
