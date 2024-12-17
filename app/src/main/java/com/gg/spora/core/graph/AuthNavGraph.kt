package com.gg.spora.core.graph

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.gg.spora.login.ui.LoginScreen
import com.gg.spora.login.ui.LoginViewModel
import com.gg.spora.login.ui.RegisteredLoginScreen
import com.gg.spora.welcome.ui.WelcomeScreen
import com.gg.spora.welcome.ui.WelcomeViewModel

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.AuthGraph>(startDestination = NavigationRoutes.Welcome) {
        composable<NavigationRoutes.Welcome> {
            val welcomeViewModel = hiltViewModel<WelcomeViewModel>()
            WelcomeScreen(
                modifier = Modifier,
                setGuestName = welcomeViewModel::setGuestName,
                onNavigateToHome = {
                    navController.navigate(NavigationRoutes.Home) {
                        welcomeViewModel.setNewUser()
                        popUpTo(NavigationRoutes.Welcome) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToSignUp = {
                    navController.navigate(NavigationRoutes.SignUp(""))
                },
                filterNames = welcomeViewModel::filterBannedWords
            )
        }

        composable<NavigationRoutes.SignUp> {

            val routeArguments = it.toRoute<NavigationRoutes.SignUp>()

            val loginViewModel = hiltViewModel<LoginViewModel>()

            val showError by loginViewModel.showError.collectAsState()

            if (showError.first) {
                AlertDialog(
                    text = {
                        Text(showError.second)
                    },
                    onDismissRequest = { loginViewModel.isShowError() },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                loginViewModel.isShowError()
                            }
                        ) {
                            Text("Aceptar")
                        }
                    })
            }

            LoginScreen(
                userName = routeArguments.userName,
                loginViewModel = loginViewModel,
                onNavigationToHome = {
                    navController.navigate(NavigationRoutes.HomeGraph) {
                        popUpTo(NavigationRoutes.SignUp("")) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToRegisteredLogin = {
                    navController.navigate(NavigationRoutes.RegisteredLogin)
                }
            )
        }

        composable<NavigationRoutes.RegisteredLogin> {

            RegisteredLoginScreen(
//                onBackClick = { navController.popBackStack() },
//                onGoogleLoginClick = { },
//                onLoginClick = { },
//                onRegisterClick = { },
//                navController = navController
                onSignUpClick = { navController.navigate(NavigationRoutes.SignUp("")) },
                onNavigateToHome = { navController.navigate(NavigationRoutes.Home) }
            )
        }
    }

}