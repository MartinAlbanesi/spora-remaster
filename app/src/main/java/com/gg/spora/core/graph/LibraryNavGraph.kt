package com.gg.spora.core.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
import com.gg.spora.tutorials.ui.component.ChampyTalkingTutorial

fun NavGraphBuilder.libraryNavGraph(navController: NavHostController) {
    navigation<NavigationRoutes.LibraryGraph>(startDestination = NavigationRoutes.Library) {
        composable<NavigationRoutes.Library> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()
            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            val showTutorial by libraryViewModel.showTutorial.collectAsState()

            val currentTutorialItem by libraryViewModel.currentTutorialItem.collectAsState()

            LibraryScreen(
                showTutorial = showTutorial,
                onBackButtonClick = { navController.navigate(NavigationRoutes.Home) },
                onClickFirst = { navController.navigate(NavigationRoutes.LibraryForestInfo) },
                onClickSecond = { navController.navigate(NavigationRoutes.LibraryRiverInfo) },
                onClickThird = { navController.navigate(NavigationRoutes.LibraryDesertInfo) },
            )

            if (showTutorial) {
                currentTutorialItem?.let { item ->
                    ChampyTalkingTutorial(
                        modifier = Modifier.fillMaxSize(),
                        champyImage = item.champyImageState,
                        isChampyTalking = item.isChampyTalking,
                        secondaryImage = item.secondaryImage,
                        isSecondaryTalking = item.isSecondaryTalking,
                        text = item.text,
                        focusPosition = item.focusItem,
                        onClickSkip = libraryViewModel::skipTutorial,
                        onNextItem = libraryViewModel::nextTutorialItem
                    )
                }
            }
        }

        composable<NavigationRoutes.LibraryForestInfo> {

            val libraryViewModel = hiltViewModel<LibraryViewModel>()

            libraryViewModel.getInfoCardListByCategory(StageType.FOREST)

            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            LibraryCardBook(
                cardList = cardList.map { it.toInfoCardEntity() },
                category = StageType.FOREST,
                onBackClick = { navController.popBackStack() }
            )

        }

        composable<NavigationRoutes.LibraryRiverInfo> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()

            libraryViewModel.getInfoCardListByCategory(StageType.RIVER)

            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            LibraryCardBook(
                cardList = cardList.map { it.toInfoCardEntity() },
                category = StageType.RIVER,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<NavigationRoutes.LibraryDesertInfo> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()

            libraryViewModel.getInfoCardListByCategory(StageType.DESERT)

            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            LibraryCardBook(
                cardList = cardList.map { it.toInfoCardEntity() },
                category = StageType.DESERT,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}