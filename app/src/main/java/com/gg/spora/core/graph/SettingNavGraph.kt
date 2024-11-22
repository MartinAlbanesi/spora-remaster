package com.gg.spora.core.graph

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.settings.ui.EditProfileScreen
import com.gg.spora.settings.ui.Notifications
import com.gg.spora.settings.ui.SettingViewModel
import com.gg.spora.settings.ui.SettingsScreen
import com.gg.spora.settings.ui.SupportScreen
import com.gg.spora.settings.ui.SupportViewModel
import com.gg.spora.user.data.local.UserRepositoryLocal
import com.gg.spora.user.domain.GetUserLocalUseCase

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
                onNavigateToEditProfile = { navController.navigate(NavigationRoutes.EditProfileScreen) },
                onNavigateToSupport = { navController.navigate(NavigationRoutes.SupportScreen) },
                onNavigateToNotifications = { navController.navigate(NavigationRoutes.NotificationScreen) }
            )
        }
        composable<NavigationRoutes.EditProfileScreen> {
            EditProfileScreen(
                onBackClick = { navController.popBackStack() }
            )

        }
        composable<NavigationRoutes.SupportScreen> {

            val supportViewModel: SupportViewModel = hiltViewModel()

            val currentUserEmail by supportViewModel.currentUserEmail.collectAsState()

            SupportScreen(
                onBackClick = { navController.popBackStack() },
                onSendClick = { subject, description ->
                    var emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:")
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("spora.proyecto@gmail.com"))
                        putExtra(Intent.EXTRA_SUBJECT, "Soporte: ${subject}")
                        putExtra(Intent.EXTRA_TEXT, description)
                        putExtra(Intent.EXTRA_CC, currentUserEmail)
                    }
                    Log.d("SupportScreen", "onSendClick: ${emailIntent}")
                    navController.context.startActivity(emailIntent)
                })

        }

        composable<NavigationRoutes.NotificationScreen> {
            Notifications(
                onBackClick = { navController.popBackStack() }
            )

        }

    }
}