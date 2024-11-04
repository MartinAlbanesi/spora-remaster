package com.gg.spora.core.graph

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.grove.ui.GroveScreen
import com.gg.spora.grove.ui.GroveViewModel
import com.gg.spora.home.ui.HomeScreen

@SuppressLint("NewApi")
fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.HomeGraph>(startDestination = NavigationRoutes.Home) {
        composable<NavigationRoutes.Home> {
            HomeScreen(
                onNavigateToForestStage = {
                    navController.navigate(NavigationRoutes.Stage("1"))
                },
                onNavigateToGrove = {
                    Log.i("HomeScreen", "Clicked on Grove")
                    navController.navigate(NavigationRoutes.Grove)
                },
                onNavigateToExpoStage = {
                    navController.navigate(NavigationRoutes.Stage("2"))
                }
            )
        }

        composable<NavigationRoutes.Grove> {
            val groveViewModel = hiltViewModel<GroveViewModel>()
            val seedTrees by groveViewModel.seedTrees.collectAsState()
            val forestTrees by groveViewModel.forestTrees.collectAsState()
            val seedTreeCooldowns by groveViewModel.seedTreeCooldowns.collectAsState()

            GroveScreen(
                seedTrees = seedTrees,
                forestTrees = forestTrees,
                seedTreeCooldowns = seedTreeCooldowns,
                onSeedTreeButtonClicked = { seedTreeId, timeToGenerateForestTree ->
                    groveViewModel.onSeedTreeButtonClicked(seedTreeId)
                },
                plantForestTree = { forestTree, seedTreeId ->
                    groveViewModel.plantForestTree(forestTree, seedTreeId)
                },
                updateTree = { tree -> groveViewModel.updateForestTree(tree) },
                updateGrowthStage = { tree -> groveViewModel.updateGrowthStage(tree) },
                popBackStack = {
                    navController.popBackStack()
                },
            )
        }
    }
}