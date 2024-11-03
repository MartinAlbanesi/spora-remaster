package com.gg.spora.core.graph

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.LibraryScreen
import com.gg.spora.library.domain.mappers.toInfoCardEntity
import com.gg.spora.library.ui.LibraryCardBook
import com.gg.spora.library.ui.LibraryViewModel
import com.google.android.play.core.integrity.z

@Suppress("LongMethod")
fun NavGraphBuilder.libraryNavGraph(navController: NavHostController) {
    navigation<NavigationRoutes.LibraryGraph>(startDestination = NavigationRoutes.Library) {

        composable<NavigationRoutes.Library> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()
            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            LibraryScreen(
                onBackButtonClick = { navController.navigate(NavigationRoutes.Home) },
                onClickFirst = { navController.navigate(NavigationRoutes.LibraryForestInfo) },
                onClickSecond = { navController.navigate(NavigationRoutes.LibraryRiverInfo) },
                onClickThird = { navController.navigate(NavigationRoutes.LibraryDesertInfo) }
            )
        }

        composable<NavigationRoutes.LibraryForestInfo> {

            val libraryViewModel = hiltViewModel<LibraryViewModel>()
            val cardList by libraryViewModel.infoCardEntityList.collectAsState()


            LaunchedEffect(true) {
                libraryViewModel.getInfoCardListByCategory(StageType.FOREST)
            }

            LibraryCardBook(
                cardList = cardList.map { it.toInfoCardEntity() },
                category = StageType.FOREST,
                unlockCard = {},
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<NavigationRoutes.LibraryRiverInfo> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()
            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            LaunchedEffect(true) {
                libraryViewModel.getInfoCardListByCategory(StageType.RIVER)
            }
            LibraryCardBook(
                cardList = cardList.map { it.toInfoCardEntity() },
                category = StageType.RIVER,
                unlockCard = {},
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<NavigationRoutes.LibraryDesertInfo> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()
            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            LaunchedEffect(true) {
                libraryViewModel.getInfoCardListByCategory(StageType.DESERT)
            }
            LibraryCardBook(
                cardList = cardList.map { it.toInfoCardEntity() },
                category = StageType.DESERT,
                unlockCard = {},
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}