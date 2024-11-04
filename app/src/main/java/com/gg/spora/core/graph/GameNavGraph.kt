package com.gg.spora.core.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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

            val levels by stageViewModel.levels.collectAsState()

            val currentLevel by stageViewModel.currentLevel.collectAsState()

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
                    oxygen = 75,
                    title = stage!!.stageType.label,
                    levels = levels,
                    backgroundImage = stage!!.stageBackgroundImage,
                    pathLadder = stage!!.pathLadder,
                    onNavigateToChallenge = { title ->
                        navController.navigate(NavigationRoutes.Challenge(stageId = stage!!.id))
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

            val challengeRoute =
                backStackEntry.toRoute<NavigationRoutes.Challenge>()

            val challengeViewModel = hiltViewModel<ChallengeViewModel>()

            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                imageBackground = R.drawable.expo_background,
                title = "Desafío",
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
                        popUpTo<NavigationRoutes.Stage> {
                            inclusive = true
                        }
                    }
                    challengeViewModel.setObjectsChallengeEmpty()

                },
                onNavigateNextLevel = {},
                content = {
                    ChallengeScreen(
                        modifier = Modifier,
                        onNavigateToCameraScreen = { nameObject ->
                            navController.navigate(
                                NavigationRoutes.Camera.createRoute(
                                    nameObject.toString()
                                )
                            )
                        },
                        onNavigateToForestStage = {
                            navController.navigate(
                                NavigationRoutes.Stage(
                                    challengeRoute.stageId
                                )
                            ) {
                                popUpTo<NavigationRoutes.Stage> {
                                    inclusive = true
                                }
                            }
                        },
                        challengeViewModel = challengeViewModel
                    )
                }
            )
        }

        composable(
            route = NavigationRoutes.Camera.route,
            arguments = listOf(navArgument("nameObject") {
                type = NavType.StringType
            })
        ) {

            val challengeViewModel = hiltViewModel<ChallengeViewModel>()

            val nameObject = it.arguments?.getString("nameObject") ?: ""

            CameraScreen(
                nameObject = nameObject,
                onNavigateToChallengeScreen = {
                    navController.popBackStack()
                },
                challengeViewModel = challengeViewModel
            )
        }
    }
}