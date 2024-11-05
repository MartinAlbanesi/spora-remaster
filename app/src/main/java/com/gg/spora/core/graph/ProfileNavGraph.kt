package com.gg.spora.core.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.profile.ui.ProfileScreen
import com.gg.spora.settings.ui.SettingsScreen

fun NavGraphBuilder.profileNavGraph(navController: NavHostController) {
    navigation<NavigationRoutes.ProfileGraph>(startDestination = NavigationRoutes.ProfileScreen) {
        composable<NavigationRoutes.ProfileScreen> {
            ProfileScreen(
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { navController.navigate(NavigationRoutes.SettingScreen) }
            )
        }
        composable<NavigationRoutes.SettingScreen> {
            SettingsScreen(
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { /*  */ }
            )
        }
    }
}