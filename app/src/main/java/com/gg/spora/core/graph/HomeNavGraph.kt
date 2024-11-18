package com.gg.spora.core.graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.gg.spora.grove.ui.GroveScreen
import com.gg.spora.grove.ui.GroveViewModel
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.home.ui.HomeViewModel
import com.gg.spora.profile.ui.ProfileScreen
import com.gg.spora.profile.ui.ProfileViewModel
import com.gg.spora.ranking.ui.Ranking
import com.gg.spora.ranking.ui.RankingViewModel

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.HomeGraph>(startDestination = NavigationRoutes.Home) {
        composable<NavigationRoutes.Home> {

            val homeViewModel: HomeViewModel = hiltViewModel()

            val userOxygen by homeViewModel.oxygen.collectAsState()

            val isLoading by homeViewModel.isLoading.collectAsState()

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
                    onNavigateToForestStage = {
                        navController.navigate(NavigationRoutes.Stage("1"))
                    },
                    onNavigateToGrove = {
                        navController.navigate(NavigationRoutes.Grove)
                    },
                    onNavigateToExpoStage = {
                        navController.navigate(NavigationRoutes.Stage("2"))
                    },
                    onNavigateToLibrary = {
                        navController.navigate(NavigationRoutes.LibraryGraph)
                    },
                    onNavigateToRanking = {
                        navController.navigate(NavigationRoutes.Ranking)
                    },
                    onNavigateToProfile = {
                        navController.navigate(NavigationRoutes.ProfileScreen)
                    }
                )
            }
        }

        composable<NavigationRoutes.Grove> {
            val groveViewModel : GroveViewModel = hiltViewModel()
            val uiState by groveViewModel.uiState.collectAsState()
            val isLoading by groveViewModel.isLoading.collectAsState()

            DisposableEffect(Unit) {
                onDispose {
                    groveViewModel.saveTreeCooldowns()
                }
            }

            GroveScreen(
                uiState = uiState,
                isLoading = isLoading,
                forestTreesColumnCount = 10,
                plantForestTree = { forestTree, seedTreeId ->
                    groveViewModel.plantForestTree(forestTree, seedTreeId)
                },
                claimOxygen = { groveViewModel.claimOxygen() },
                popBackStack = {
                    groveViewModel.saveTreeCooldowns()
                    navController.popBackStack()
                }
            )
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
            //val currentIndex by viewModel.currentIndex.collectAsState()

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