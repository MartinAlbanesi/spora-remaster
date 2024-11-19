package com.gg.spora.core.graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.R
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.home.ui.HomeViewModel
import com.gg.spora.profile.ui.ProfileScreen
import com.gg.spora.profile.ui.ProfileViewModel
import com.gg.spora.ranking.ui.Ranking
import com.gg.spora.ranking.ui.RankingViewModel
import com.gg.spora.tutorials.ui.component.ChampyTalkingTutorial
import com.gg.spora.user.domain.models.User

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.HomeGraph>(startDestination = NavigationRoutes.Home) {
        composable<NavigationRoutes.Home> {

            val homeViewModel: HomeViewModel = hiltViewModel()

//            val user by homeViewModel.user.collectAsState()

            val userOxygen by homeViewModel.oxygen.collectAsState()

            val isLoading by homeViewModel.isLoading.collectAsState()

            val currentTutorialItem by homeViewModel.tutorialSelected.currentTutorialItem.collectAsState()

            val showTutorial by homeViewModel.tutorialSelected.showTutorial.collectAsState()

            val champyQuote by homeViewModel.champyQuote.collectAsState()

            if (!isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                HomeScreen(
                    oxygen = userOxygen,
                    showTutorial = showTutorial,
                    champyQuote = champyQuote,
                    onNavigateToForestStage = {
                        navController.navigate(NavigationRoutes.Stage(StageType.FOREST.name))
                    },
                    onNavigateToExpoStage = {
                        navController.navigate(NavigationRoutes.Stage(StageType.EXPO.name))
                    },
                    onNavigateToLibrary = {
                        homeViewModel.getTutorial(
                            Tutorials.LIBRARY_ICON_TUTORIAL,
                        ) {
                            navController.navigate(NavigationRoutes.LibraryGraph)
                        }
                    },
                    onNavigateToRanking = {
                        navController.navigate(NavigationRoutes.Ranking)
                    },
                    onNavigateToProfile = {
                        navController.navigate(NavigationRoutes.ProfileScreen)
                    },
                    onNavigateToGrove = {
                        homeViewModel.getTutorial(
                            Tutorials.GROVE_ICON_TUTORIAL,
                        ) {
//                            navController.navigate(NavigationRoutes.Grove)
                        }
                    },
                )
            }
            if (showTutorial) {
//                currentTutorialItem?.let { item ->
                ChampyTalkingTutorial(
                    modifier = Modifier.fillMaxSize(),
                    champyImage = currentTutorialItem!!.champyImageState,
                    isChampyTalking = currentTutorialItem!!.isChampyTalking,
                    secondaryImage = currentTutorialItem!!.secondaryImage,
                    isSecondaryTalking = currentTutorialItem!!.isSecondaryTalking,
                    text = currentTutorialItem!!.text,
                    focusPosition = currentTutorialItem!!.focusItem,
                    onClickSkip = homeViewModel.tutorialSelected::skipTutorial,
                    onNextItem = homeViewModel.tutorialSelected::nextTutorialItem
                )
//                }
            }

        }
        composable<NavigationRoutes.Grove> {

        }
        composable<NavigationRoutes.Ranking> {

            val viewModel: RankingViewModel = hiltViewModel()
            val rankingItems by viewModel.rankingItems.collectAsState()
            val currentUser by viewModel.currentUser.collectAsState()

            Ranking(
                onBackClick = { navController.popBackStack() },
                userList = rankingItems,
                currentUser = currentUser
            )
        }
        composable<NavigationRoutes.ProfileScreen> {
            val viewModel: ProfileViewModel = hiltViewModel()
            val currentIndex by viewModel.currentIndex.collectAsState()

            val user by viewModel.user.collectAsState()

            ProfileScreen(
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { navController.navigate(NavigationRoutes.SettingGraph) },
                user = user,
//                onLeftArrowClick = { viewModel.onLeftArrowClick() },
//                onRightArrowClick = { viewModel.onRightArrowClick() },
//                currentIndex = currentIndex
            )
        }
    }
}