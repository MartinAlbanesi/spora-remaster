package com.gg.spora.core.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.library.LibraryScreen
import com.gg.spora.library.ui.LibraryCardBook
import com.gg.spora.library.ui.LibraryViewModel

@Suppress("LongMethod")
fun NavGraphBuilder.libraryNavGraph(navController: NavHostController) {
    navigation<NavigationRoutes.LibraryGraph>(startDestination = NavigationRoutes.Library) {


        composable<NavigationRoutes.Library> {
            LibraryScreen(
                onBackButtonClick = { navController.navigate(NavigationRoutes.Home) },
                onClickFirst = { navController.navigate(NavigationRoutes.LibraryForestInfo) },
                onClickSecond = { navController.navigate(NavigationRoutes.LibraryRiverInfo) },
                onClickThird = { navController.navigate(NavigationRoutes.LibraryDesertInfo) }
            )
        }

        composable<NavigationRoutes.LibraryForestInfo> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()

            LibraryCardBook(
                cardList = libraryViewModel.getForestInfoCards(),
                unlockCard = {},
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<NavigationRoutes.LibraryRiverInfo> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()

            LibraryCardBook(
                cardList = libraryViewModel.getRiverInfoCards(),
                unlockCard = {},
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<NavigationRoutes.LibraryDesertInfo> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()

            LibraryCardBook(
                cardList = libraryViewModel.getDesertInfoCards(),
                unlockCard = {},
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}