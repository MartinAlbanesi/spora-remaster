package com.gg.spora.core.graph

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.gg.spora.R
import com.gg.spora.camera.ui.CameraScreen
import com.gg.spora.challenge.ui.ChallengeScreen
import com.gg.spora.challenge.ui.ChallengeViewModel
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.utils.SporaConstant

fun NavGraphBuilder.challengeNavGraph(navController: NavHostController) {
    composable<NavigationRoutes.Challenge> { backStackEntry ->

        Log.e("titi","Challenger" )

        val challengeViewModel = hiltViewModel<ChallengeViewModel>()
        val objectsChallenge by challengeViewModel.objectsChallenge.observeAsState(listOf())
        var isCorrect by remember { mutableStateOf(false) }
        val isChallengeFinallyUser by challengeViewModel.isFinally.observeAsState(false)
        val isLoading by challengeViewModel.isLoading.observeAsState(true)
        val challengeRoute = backStackEntry.toRoute<NavigationRoutes.Challenge>()
        isCorrect = objectsChallenge.isNotEmpty() && objectsChallenge.all { it.isValidate }

        if (challengeRoute.nameObject != "") {
            challengeViewModel.setObjectInObjectsChallengeWithName(challengeRoute.nameObject)
        }
        if (!isLoading) {
            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                imageBackground = R.drawable.minigame_background_crop,
                title = stringResource(R.string.title_challenge),
                isCorrect = null,
                questionSize = SporaConstant.MAX_QUESTIONS,
                isFinished = false,
                lives = 0,
                counterQuestion = 0,
                showIcon = false,
                showButtonContinue = false,
                showProgressBar = false,
                totalOxygen = 0,
                onNextQuestion = {},
                onResetGame = {},
                onBackForestStage = {
                    navController.navigate(NavigationRoutes.Stage(challengeRoute.stageId)) {
                        popUpTo(NavigationRoutes.Stage(challengeRoute.stageId)) { inclusive = true }
                    }
                    challengeViewModel.setObjectsChallengeEmpty()
                },
                onNavigateNextLevel = {},
                content = {
                    ChallengeScreen(
                        modifier = Modifier,
                        onNavigateToCameraScreen = { nameObject ->
                            navController.navigate(
                                NavigationRoutes.Camera(
                                    stageId = challengeRoute.stageId,
                                    nameObject = nameObject.toString()
                                )
                            )
                        },
                        onNavigateToGrove = {
                            challengeViewModel.insertSeedTreeOfChallengeOne()
                            navController.navigate(NavigationRoutes.Grove) {
                                popUpTo(NavigationRoutes.Grove) { inclusive = true }
                            }
                        },
//                            isChallengeFinallyUser = isChallengeFinallyUser,
                        challengeObjects = objectsChallenge,
                        continueDialogObjectDetail = { challengeRoute.nameObject = "" },
                        selectedObject = challengeViewModel.getObjectDetailWithName(
                            challengeRoute.nameObject
                        )
                    )
                }
            )
        }
    }

    composable<NavigationRoutes.Camera> { backStackEntry ->
        val cameraRoute = backStackEntry.toRoute<NavigationRoutes.Camera>()
        val nameObject = cameraRoute.nameObject

        Log.e("titi","Camera" )

        CameraScreen(
            nameObject = nameObject,
            onNavigateToChallengeScreen = {
                navController.navigate(
                    NavigationRoutes.Challenge(
                        stageId = cameraRoute.stageId,
                        nameObject = nameObject
                    )
                )
            },
            onNavigateToBack = {
                navController.navigate(
                    NavigationRoutes.Challenge(
                        stageId = cameraRoute.stageId,
                        nameObject = ""
                    )
                )
            }
        )
    }
}