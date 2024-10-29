package com.gg.spora.core.graph

import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.login.ui.LoginScreen
import com.gg.spora.login.ui.LoginViewModel
import com.gg.spora.registeredLogin.iu.RegisteredLoginScreen
import com.gg.spora.welcome.ui.WelcomeScreen
import com.gg.spora.welcome.ui.WelcomeViewModel

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {

    navigation< NavigationRoutes.AuthGraph>(startDestination = NavigationRoutes.Welcome){
        composable<NavigationRoutes.Welcome> {
            val welcomeViewModel = hiltViewModel<WelcomeViewModel>()
            WelcomeScreen(
                onNavigateToHome = {
                    navController.navigate(NavigationRoutes.Home) {
                        popUpTo(NavigationRoutes.Welcome) {
                            inclusive = true
                        }
                    }
                },
                setGuestName = { welcomeViewModel.setGuestName(it) },
                modifier = Modifier,
                onNavigateToSignUp = {
                    navController.navigate(NavigationRoutes.SignUp)
                }
            )
        }

        composable<NavigationRoutes.SignUp> {

            val loginViewModel = hiltViewModel<LoginViewModel>()

            LoginScreen(
                viewModel = loginViewModel,
                navController = navController
            )
        }

        composable<NavigationRoutes.RegisteredLogin> {

            RegisteredLoginScreen(
                onBackClick = { navController.popBackStack() },
                onGoogleLoginClick = { },
                onLoginClick = { },
                onRegisterClick = { },
                navController = navController
            )
        }
    }

}