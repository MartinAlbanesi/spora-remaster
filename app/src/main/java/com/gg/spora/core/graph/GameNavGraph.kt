package com.gg.spora.core.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.gg.spora.R
import com.gg.spora.camera.ui.CameraScreen
import com.gg.spora.challenge.ui.ChallengeScreen
import com.gg.spora.challenge.ui.ChallengeViewModel
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.stage.domain.model.getLevelWithStage
import com.gg.spora.stage.ui.LevelPreview
import com.gg.spora.stage.ui.StageScreen
import com.gg.spora.stage.ui.StageViewModel
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

            val levels by stageViewModel.levels.collectAsState()

            val currentLevel by stageViewModel.currentLevel.collectAsState()

            val oxygen by stageViewModel.oxygen.collectAsState()

            var showLevelPreview by rememberSaveable {
                mutableStateOf(false)
            }

            currentLevel?.let{
                LevelPreview(
                    isVisible = showLevelPreview,
                    backgroundImage = stage!!.levelPreviewImage,
                    level = currentLevel!!,
                    onClickPrimaryButton = {
                        showLevelPreview = false
                        navController
                            .navigate(
                                NavigationRoutes.QuizGame(
                                    title = currentLevel!!.getLevelWithStage(),
                                    quizCount = currentLevel!!.quizCount.toInt(),
                                    imageCount = currentLevel!!.imageCount.toInt(),
                                    relationsCount = currentLevel!!.relationsCount.toInt(),
                                    levelId = currentLevel!!.id,
                                    imageBackground = stage!!.levelPreviewImage,
                                    stageType = stage!!.stageType.name,
                                    oxygenRewards = currentLevel!!.rewardsOxygen.map { it.toInt() },
                                )
                            )
                    },
                    onClickSecondaryButton = {
                        showLevelPreview = false
                    },
                )
            }

            stage?.let {
                StageScreen(
                    oxygen = oxygen,
                    title = stage!!.stageType.label,
                    levels = levels,
                    backgroundImage = stage!!.stageBackgroundImage,
                    pathLadder = stage!!.pathLadder,
                    onNavigateToChallenge = {
                        navController.navigate(NavigationRoutes.Challenge(stageId = stage!!.id, nameObject = ""))
                    },
                    popBackStack = {
                        navController.popBackStack()
                    },
                    onClickLevelItem = { level, showPreview ->
                        stageViewModel.onLevelSelected(level)
                        showLevelPreview = showPreview
                    }
                )
            }
        }

        composable<NavigationRoutes.QuizGame> {

            val quizGameRoute = it.toRoute<NavigationRoutes.QuizGame>()

            val quizViewModel = hiltViewModel<QuizViewModel>()

            val currentQuestion by quizViewModel.currentQuestion.collectAsState()

            val isCorrect by quizViewModel.isCorrect.collectAsState()

            val isFinished by quizViewModel.isFinished.collectAsState()

            val lives by quizViewModel.lives.collectAsState()

            val livesLost by quizViewModel.livesLost.collectAsState()

            val counterQuestion by quizViewModel.counterQuestion.collectAsState()

            val currentImage by quizViewModel.currentImageResId.collectAsState()

            val selectedItems by quizViewModel.relationsItems.collectAsState()

            val questions by quizViewModel.questions.collectAsState()

            val showChampyHelp by quizViewModel.showChampyHelp.collectAsState()

            LaunchedEffect(currentQuestion){
                quizViewModel.onShowChampyHelp()
            }

            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                title = quizGameRoute.title,
                imageBackground = quizGameRoute.imageBackground,
                isCorrect = isCorrect,
                questionSize = questions.size - 1,
                isFinished = isFinished,
                lives = lives,
                livesLost = livesLost,
                counterQuestion = counterQuestion,
                showButtonContinue = isCorrect != null,
                showChampyHelp = showChampyHelp,
                onNextQuestion = quizViewModel::nextQuestion,
                onResetGame = quizViewModel::resetGame,
                onBackForestStage = { navController.popBackStack() },
                onNavigateNextLevel = {
                    navController.popBackStack()
                },
                content = {
                    when (currentQuestion!!.typeGame) {
                        TypeGame.QUIZ -> {
                            QuizScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                isCorrect = isCorrect,
                                questionTitle = currentQuestion!!.question,
                                answerOptions = currentQuestion!!.answers,
                                onAnswerSelected = quizViewModel::isAnswerCorrect,
                            )
                        }

                        TypeGame.QUIZ_IMAGE -> {
                            QuizImageScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 8.dp),
                                questionTitle = currentQuestion!!.question,
                                answerOptions = currentQuestion!!.answers,
                                currentImageResIdState = currentImage,
                                isCorrect = isCorrect,
                                onAnswerSelected = quizViewModel::isAnswerCorrect,
                            )
                        }

                        TypeGame.RELATIONS -> {
                            RelationsScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(vertical = 0.dp),
                                objectName = currentQuestion!!.question,
                                answers = currentQuestion!!.answers,
                                selectedItems = selectedItems,
                                isCorrect = isCorrect,
                                onSelectedItem = quizViewModel::onSelectedItem,
                                onConfirmSelecteds = quizViewModel::relationsAnswerSelected,
                            )
                        }
                    }
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
                            continueDialogObjectDetail = { challengeRoute.nameObject = "" },
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
                },
                onNavigateToBack = {
                    navController.navigate(NavigationRoutes.Challenge(stageId = cameraRoute.stageId, nameObject = ""))
                }
            )
        }
    }
}
