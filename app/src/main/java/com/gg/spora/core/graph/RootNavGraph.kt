package com.gg.spora.core.graph

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.gg.spora.core.ui.screenFadeWithSlideInToLeft
import com.gg.spora.core.ui.screenFadeWithSlideOutToRight

@Composable
fun RootNavigationGraph(
    navController: NavHostController = rememberNavController(),
    isUserLoggedIn: Boolean,
){
    NavHost(
        navController = navController,
        startDestination = if(!isUserLoggedIn) NavigationRoutes.AuthGraph else NavigationRoutes.HomeGraph,
        enterTransition = ::screenFadeWithSlideInToLeft,
        exitTransition = ::screenFadeWithSlideOutToRight,
        popEnterTransition = ::screenFadeWithSlideInToLeft,
        popExitTransition = ::screenFadeWithSlideOutToRight,
        modifier = Modifier.background(color = Color.Black)
    ) {
        authNavGraph(navController = navController)

        homeNavGraph(navController = navController)

        gameNavGraph(navController = navController)

        profileNavGraph(navController = navController)

    }
}