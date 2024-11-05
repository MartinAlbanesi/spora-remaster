package com.gg.spora.core.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.profile.ui.ProfileScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.HomeGraph>(startDestination = NavigationRoutes.Home) {
        composable<NavigationRoutes.Home> {
            HomeScreen(
                onNavigateToProfile = {
                    navController.navigate(NavigationRoutes.ProfileScreen)
                },
                onNavigateToForestStage = {
                    navController.navigate(NavigationRoutes.Stage("1"))
                },
                onNavigateToExpoStage = {
                    navController.navigate(NavigationRoutes.Stage("2"))
                }
            )
        }
        composable<NavigationRoutes.Grove> {

        }
        composable<NavigationRoutes.ProfileScreen> {
            ProfileScreen(
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { navController.navigate(NavigationRoutes.SettingScreen) }
            )


    }
}
}