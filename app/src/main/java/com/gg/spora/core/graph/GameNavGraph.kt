package com.gg.spora.core.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.gg.spora.R
import com.gg.spora.camera.ui.CameraScreen
import com.gg.spora.challenge.ui.ChallengeScreen
import com.gg.spora.challenge.ui.ChallengeViewModel
import com.gg.spora.challenge.ui.components.ObjectDetailDialog
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.forestStage.domain.model.getLevelWithStage
import com.gg.spora.forestStage.ui.LevelPreview
import com.gg.spora.forestStage.ui.StageScreen
import com.gg.spora.forestStage.ui.StageViewModel
import com.gg.spora.miniGames.ui.QuizImageScreen
import com.gg.spora.miniGames.ui.QuizScreen
import com.gg.spora.miniGames.ui.QuizViewModel
import com.gg.spora.miniGames.ui.RelationsScreen

@Suppress("LongMethod")
fun NavGraphBuilder.gameNavGraph(navController: NavHostController) {
    navigation<NavigationRoutes.GameGraph>(startDestination = NavigationRoutes.Stage("1")) {
        composable<NavigationRoutes.Stage> {
            val stageViewModel = hiltViewModel<StageViewModel>()
            val stage by stageViewModel.stage.collectAsState()
            val currentLevel by stageViewModel.currentLevel.collectAsState()
            var showLevelPreview by rememberSaveable { mutableStateOf(false) }

            // Configuración de la pantalla StageScreen
            LevelPreview(
                isVisible = showLevelPreview,
                backgroundImage = stage!!.levelPreviewImage,
                level = currentLevel!!,
                onClickPrimaryButton = {
                    showLevelPreview = false
                    navController.navigate(
                        NavigationRoutes.QuizGame(
                            title = currentLevel!!.getLevelWithStage(),
                            quizCount = currentLevel!!.quizCount,
                            imageCount = currentLevel!!.imageCount,
                            relationsCount = currentLevel!!.relationsCount,
                            levelId = currentLevel!!.id,
                            imageBackground = stage!!.levelPreviewImage,
                            stageId = stage!!.id
                        )
                    )
                },
                onClickSecondaryButton = { showLevelPreview = false },
            )

            StageScreen(
                oxygen = 75,
                title = stage!!.stageType.label,
                levels = stage!!.levels,
                backgroundImage = stage!!.stageBackgroundImage,
                pathLadder = stage!!.pathLadder,
                onNavigateToChallenge = { title ->
                    navController.navigate(NavigationRoutes.Challenge(stageId = stage!!.id, nameObject = ""))
                },
                popBackStack = { navController.popBackStack() },
                onClickLevelItem = { level, showPreview ->
                    stageViewModel.onLevelSelected(level)
                    showLevelPreview = showPreview
                }
            )
        }

        composable<NavigationRoutes.Challenge> { backStackEntry ->
            val challengeViewModel = hiltViewModel<ChallengeViewModel>()
            val objectsChallenge by challengeViewModel.objectsChallenge.observeAsState(listOf())
            var isCorrect by remember { mutableStateOf(false) }
            val isLoading by challengeViewModel.isLoading.observeAsState(true)
            val challengeRoute = backStackEntry.toRoute<NavigationRoutes.Challenge>()
            isCorrect = objectsChallenge.isNotEmpty() && objectsChallenge.all { it.isValidate }

            if(challengeRoute.nameObject != ""){
                challengeViewModel.selectObject(challengeRoute.nameObject)
                challengeViewModel.setObjectInObjectsChallengeWithName(challengeRoute.nameObject)
            }
            val objectChallenge by challengeViewModel.selectedObject.observeAsState("")

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
                    onNextQuestion = {},
                    onResetGame = {},
                    onBackForestStage = {
                        navController.navigate(NavigationRoutes.Stage(challengeRoute.stageId)) {
                            popUpTo<NavigationRoutes.Stage> { inclusive = true }
                        }
                        challengeViewModel.setObjectsChallengeEmpty()
                    },
                    onNavigateNextLevel = {},
                    content = {
                        ChallengeScreen(
                            modifier = Modifier,
                            onNavigateToCameraScreen = { nameObject ->
                                navController.navigate(NavigationRoutes.Camera(stageId = challengeRoute.stageId,
                                    nameObject = nameObject.toString()))
                            },
                            onNavigateToForestStage = {
                                navController.navigate(NavigationRoutes.Stage(challengeRoute.stageId)) {
                                    popUpTo<NavigationRoutes.Stage> { inclusive = true }
                                }
                            },
                            challengeObjects = objectsChallenge,
                            continueDialogObjectDetail = { challengeViewModel.setEmptySelectedObject() },
                            selectedObject = challengeViewModel.getObjectDetailWithName(challengeRoute.nameObject)
                        )
                    }
            )
            }
        }

        composable<NavigationRoutes.Camera> { backStackEntry ->
            val cameraRoute = backStackEntry.toRoute<NavigationRoutes.Camera>()
            val nameObject = cameraRoute.nameObject

            CameraScreen(
                nameObject = nameObject,
                onNavigateToChallengeScreen = {
                    navController.navigate(NavigationRoutes.Challenge(stageId = cameraRoute.stageId, nameObject = nameObject))
                }
            )
        }
    }
}
