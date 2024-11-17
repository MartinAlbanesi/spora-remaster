package com.gg.spora.core.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.settings.ui.EditProfileScreen
import com.gg.spora.settings.ui.SettingViewModel
import com.gg.spora.settings.ui.SettingsScreen

fun NavGraphBuilder.settingNavGraph(navController: NavHostController) {
    navigation<NavigationRoutes.SettingGraph>(startDestination = NavigationRoutes.SettingScreen) {
        composable<NavigationRoutes.SettingScreen> {

            val settingViewModel = hiltViewModel<SettingViewModel>()

            SettingsScreen(
                onBackClick = { navController.popBackStack() },
                onLogOut = {
                    settingViewModel.logout {
                        navController.navigate(NavigationRoutes.AuthGraph)
                    }
                },
                onNavigateToEditProfile = { navController.navigate(NavigationRoutes.EditProfileScreen) }
            )
        }
        composable<NavigationRoutes.EditProfileScreen> {
            EditProfileScreen (
                onBackClick = { navController.popBackStack() }
            )

    }

}
}