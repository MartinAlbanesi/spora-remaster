package com.gg.spora.core.graph

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun NavGraphBuilder.libraryNavGraph(navController: NavHostController) {
    navigation<NavigationRoutes.LibraryGraph>(startDestination = NavigationRoutes.Library) {
        composable<NavigationRoutes.Library> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()
//            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            val showTutorial by libraryViewModel.tutorialSelected.showTutorial.collectAsState()

            val currentTutorialItem by libraryViewModel.tutorialSelected.currentTutorialItem.collectAsState()

            val missionCompleted by libraryViewModel.missionCompleted.collectAsState()

            val snackBarHostState = remember { SnackbarHostState() }

            LaunchedEffect(missionCompleted != null) {
                missionCompleted?.let {
                    snackBarHostState.showSnackbar(
                        message = "La Misión: '${missionCompleted!!.text}' ha sido completada",
                    )
                }
            }

            Scaffold(
                snackbarHost = {
                    SnackbarHost(hostState = snackBarHostState)
                },
            ){
                LibraryScreen(
                    showTutorial = showTutorial,
                    onBackButtonClick = { navController.popBackStack() },
                    onClickFirst = { navController.navigate(NavigationRoutes.LibraryForestInfo) },
                    onClickSecond = { navController.navigate(NavigationRoutes.LibraryLakeInfo) },
                    onClickThird = { navController.navigate(NavigationRoutes.LibraryDesertInfo) },
                )
            }



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
                        onClickSkip = libraryViewModel.tutorialSelected::skipTutorial,
                        onNextItem = libraryViewModel.tutorialSelected::nextTutorialItem
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

        composable<NavigationRoutes.LibraryLakeInfo> {
            val libraryViewModel = hiltViewModel<LibraryViewModel>()

            libraryViewModel.getInfoCardListByCategory(StageType.LAKE)

            val cardList by libraryViewModel.infoCardEntityList.collectAsState()

            LibraryCardBook(
                cardList = cardList.map { it.toInfoCardEntity() },
                category = StageType.LAKE,
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