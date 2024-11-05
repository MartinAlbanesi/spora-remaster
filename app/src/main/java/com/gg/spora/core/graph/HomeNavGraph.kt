package com.gg.spora.core.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.ranking.ui.Ranking

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.HomeGraph>(startDestination = NavigationRoutes.Home) {
        composable<NavigationRoutes.Home> {
            HomeScreen(
                onNavigateToForestStage = {
                    navController.navigate(NavigationRoutes.Stage("1"))
                },
                onNavigateToExpoStage = {
                    navController.navigate(NavigationRoutes.Stage("2"))
                },
                onNavigateToRanking = {
                    navController.navigate(NavigationRoutes.Ranking)
                }
            )
        }
        composable<NavigationRoutes.Grove> {

        }
        composable<NavigationRoutes.Ranking> {
            Ranking(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}