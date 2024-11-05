package com.gg.spora.core.graph

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.ranking.ui.Ranking
import com.gg.spora.ranking.ui.RankingViewModel

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
           val viewModel: RankingViewModel = hiltViewModel()
            val rankingItems by viewModel.rankingItems.collectAsState()
            Ranking(
                onBackClick = { navController.popBackStack() },
                userList = rankingItems
            )
        }
    }
}