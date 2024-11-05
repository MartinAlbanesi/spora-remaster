package com.gg.spora.core.graph

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.profile.ui.ProfileScreen
import com.gg.spora.profile.ui.ProfileViewModel
import com.gg.spora.user.domain.models.User

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
            val viewModel: ProfileViewModel = hiltViewModel()
            val currentIndex by viewModel.currentIndex.collectAsState()
            ProfileScreen(
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { navController.navigate(NavigationRoutes.SettingGraph) },
                        user = User(
                        userName = "User Name",
                email = "email",
                oxygen = 0,
                levelsCompleted = emptyList(),
                id = "id"),
            onLeftArrowClick = { viewModel.onLeftArrowClick() },
            onRightArrowClick = { viewModel.onRightArrowClick() },
                currentIndex = currentIndex
            )
    }
}
}