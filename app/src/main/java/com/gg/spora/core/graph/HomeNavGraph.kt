package com.gg.spora.core.graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.gg.spora.home.ui.CreateProfileScreen
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.home.ui.HomeViewModel
import com.gg.spora.profile.ui.ProfileScreen
import com.gg.spora.profile.ui.ProfileViewModel
import com.gg.spora.ranking.ui.Ranking
import com.gg.spora.ranking.ui.RankingViewModel
import com.gg.spora.tutorials.ui.component.ChampyTalkingTutorial
import com.gg.spora.user.domain.models.User

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.HomeGraph>(startDestination = NavigationRoutes.Home) {
        composable<NavigationRoutes.Home> {

            val homeViewModel: HomeViewModel = hiltViewModel()

            val userOxygen by homeViewModel.oxygen.collectAsState()

            val isLoading by homeViewModel.isLoading.collectAsState()

            val currentTutorialItem by homeViewModel.tutorialSelected.currentTutorialItem.collectAsState()

            val showTutorial by homeViewModel.tutorialSelected.showTutorial.collectAsState()

            val champyQuote by homeViewModel.champyQuote.collectAsState()

            val isUserLoggedIn by homeViewModel.isUserLoggedIn.collectAsState()

            val missions by homeViewModel.missions.collectAsState()

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
                    missions = missions,
                    onNavigateToForestStage = {
                        navController.navigate(NavigationRoutes.Stage(StageType.FOREST.name))
                    },
                    onNavigateToLibrary = {
                        homeViewModel.getTutorial(
                            Tutorials.LIBRARY_ICON_TUTORIAL,
                        ) {
                            navController.navigate(NavigationRoutes.LibraryGraph)
                        }
                    },
                    onNavigateToRanking = {
                        if (isUserLoggedIn) {
                            navController.navigate(NavigationRoutes.Ranking)
                        } else {
                            navController.navigate(NavigationRoutes.CreateProfileScreen)
                        }
                    },
                    onNavigateToProfile = {
                        if (isUserLoggedIn) {
                            navController.navigate(NavigationRoutes.ProfileScreen)
                        } else {
                            navController.navigate(NavigationRoutes.CreateProfileScreen)
                        }
                    },
                    onNavigateToGrove = {
                        homeViewModel.getTutorial(
                            Tutorials.GROVE_ICON_TUTORIAL,
                        ) {
//                            navController.navigate(NavigationRoutes.Grove)
                        }
                    },
                    onClaimMission = homeViewModel::claimMission
                )
            }
            if (showTutorial) {
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
            val userPosition by viewModel.userPosition.collectAsState()
            val user by viewModel.user.collectAsState()

            LaunchedEffect(Unit) {
                user?.let { viewModel.fetchUserData(it) }
            }

            ProfileScreen(
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { navController.navigate(NavigationRoutes.SettingGraph) },
                user = user,
                userPosition = userPosition,

//                onLeftArrowClick = { viewModel.onLeftArrowClick() },
//                onRightArrowClick = { viewModel.onRightArrowClick() },
//                currentIndex = currentIndex
            )
        }

        composable<NavigationRoutes.CreateProfileScreen> {
            CreateProfileScreen(
                modifier = Modifier.fillMaxSize(),
                onSkip = {
                    navController.popBackStack()
                },
                onConfirm = {
                    navController.navigate(NavigationRoutes.SignUp)
                }
            )
        }
    }
}