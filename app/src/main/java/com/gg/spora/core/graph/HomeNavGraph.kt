package com.gg.spora.core.graph

import android.annotation.SuppressLint
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.grove.ui.GroveScreen
import com.gg.spora.grove.ui.GroveViewModel
import com.gg.spora.home.ui.HomeScreen
import androidx.compose.runtime.getValue

@SuppressLint("NewApi")
fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.HomeGraph>(startDestination = NavigationRoutes.Home) {
        composable<NavigationRoutes.Home> {
            HomeScreen(
                onNavigateToForestStage = {
                    navController.navigate(NavigationRoutes.Stage("1"))
                },
                onNavigateToGrove = {
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

            GroveScreen(
                seedTrees = seedTrees,
                forestTrees = forestTrees,
                plantSeedInForest = { treeType -> groveViewModel.plantSeedInForest(treeType) },
                updateTree = { tree -> groveViewModel.updateTree(tree) },
                popBackStack = {
                    navController.popBackStack()
                },
            )
        }
    }
}