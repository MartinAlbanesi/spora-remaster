package com.gg.spora.grove.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.animations.TreeGrowthAnimation
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GroveUiState
import com.gg.spora.grove.domain.models.GrowthStage
import kotlinx.coroutines.delay

/**
 * Composable function for displaying a forest tree item.
 * @param tree The forest tree to display.
 * @param uiState The current UI state.
 * @param isLoading Whether the content is being loaded.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForestTreeItem(
    tree: ForestTree,
    uiState: GroveUiState,
    isLoading: Boolean,
) {
    val currentStage by remember(tree, uiState.forestTreeGrowthTimes) {
        derivedStateOf { tree.currentStage }
    }

    // State to control animation visibility
    var showAnimation by remember { mutableStateOf(false) }

    // LaunchedEffect to trigger animation when currentStage changes
    LaunchedEffect(currentStage) {
        showAnimation = true // Show animation when currentStage changes
        delay(1500) // Adjust delay for animation duration
        showAnimation = false // Hide animation after delay
    }

    if (!isLoading) {
        Box {
            AnimatedVisibility(
                visible = currentStage == GrowthStage.SPROUT,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sprout_tree),
                    contentDescription = "Tree in SPROUT stage",
                    modifier = Modifier.size(64.dp)
                )
            }
            AnimatedVisibility(
                visible = currentStage == GrowthStage.MEDIUM,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.medium_tree),
                    contentDescription = "Tree in MEDIUM stage",
                    modifier = Modifier.size(64.dp)
                )
            }
            AnimatedVisibility(
                visible = currentStage == GrowthStage.ADULT,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Image(
                    painter = painterResource(id = tree.type.imageResource),
                    contentDescription = "Tree in ADULT stage",
                    modifier = Modifier.size(64.dp)
                )
            }
            // Show animation conditionally
            if (showAnimation) {
                TreeGrowthAnimation(
                    modifier = Modifier.size(64.dp),
                    growthStage = currentStage
                )
            }
        }
    } else {
        CircularProgressIndicator()
    }
}