package com.gg.spora.core.graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
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
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.home.ui.HomeViewModel
import com.gg.spora.profile.ui.ProfileScreen
import com.gg.spora.profile.ui.ProfileViewModel
import com.gg.spora.ranking.ui.Ranking
import com.gg.spora.ranking.ui.RankingViewModel
import com.gg.spora.user.domain.models.User

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {

    navigation<NavigationRoutes.HomeGraph>(startDestination = NavigationRoutes.Home) {
        composable<NavigationRoutes.Home> {

            val homeViewModel: HomeViewModel = hiltViewModel()

//            val user by homeViewModel.user.collectAsState()

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
                        navController.navigate(NavigationRoutes.Stage(StageType.FOREST.name))
                    },
                    onNavigateToExpoStage = {
                        navController.navigate(NavigationRoutes.Stage(StageType.EXPO.name))
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