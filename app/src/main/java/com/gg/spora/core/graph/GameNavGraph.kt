package com.gg.spora.core.graph

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.ui.platform.LocalContext
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
import com.gg.spora.core.ads.showInterstitialAd
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.miniGames.ui.QuizImageScreen
import com.gg.spora.miniGames.ui.QuizScreen
import com.gg.spora.miniGames.ui.QuizViewModel
import com.gg.spora.miniGames.ui.RelationsScreen
import com.gg.spora.missions.domain.functions.getMissionIcon
import com.gg.spora.missions.ui.component.MissionCompletedPopUp
import com.gg.spora.stage.domain.model.getLevelWithStage
import com.gg.spora.stage.ui.LevelPreview
import com.gg.spora.stage.ui.StageScreen
import com.gg.spora.stage.ui.StageViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("LongMethod")
fun NavGraphBuilder.gameNavGraph(navController: NavHostController) {
    navigation<NavigationRoutes.GameGraph>(startDestination = NavigationRoutes.Stage("1")) {
        composable<NavigationRoutes.Stage>(
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(
                        durationMillis = 500,
                    ),
                )
            },
            exitTransition = {
                slideOutVertically(
                    animationSpec = tween(
                        durationMillis = 200,
                    ),
                    targetOffsetY = { -it },
                )
            }
        ) {
            val stageViewModel = hiltViewModel<StageViewModel>()
            val stage by stageViewModel.stage.collectAsState()

            val levels by stageViewModel.levels.collectAsState()

            val currentLevel by stageViewModel.currentLevel.collectAsState()

            val oxygen by stageViewModel.oxygen.collectAsState()

            var showLevelPreview by rememberSaveable {
                mutableStateOf(false)
            }

            currentLevel?.let {
                LevelPreview(
                    isVisible = showLevelPreview,
                    backgroundImage = stage!!.levelPreviewImage,
                    level = currentLevel!!,
                    oxygen = oxygen,
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
                        navController.navigate(
                            NavigationRoutes.Challenge(
                                stageId = stage!!.id,
                                nameObject = ""
                            )
                        )
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

        composable<NavigationRoutes.QuizGame>(
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 500,
                    ),
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                    ),
                )
            }
        ) {

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

            val champyHelpingText by quizViewModel.champyHelpingText.collectAsState()

            val currentTotalRewards by quizViewModel.currentTotalRewards.collectAsState()

            val currentRewards by quizViewModel.currentRewards.collectAsState()

            val isRewardsLoading by quizViewModel.isRewardsLoading.collectAsState()

            val missionCompleted by quizViewModel.missionManager.missionCompleted.collectAsState()

            val context = LocalContext.current

            LaunchedEffect(counterQuestion) {
                quizViewModel.onShowChampyHelp()
            }

            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                isRewardsLoading = isRewardsLoading,
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
                champyHelpingText = champyHelpingText,
                totalOxygen = currentTotalRewards,
                rewards = currentRewards,
                onNextQuestion = quizViewModel::nextQuestion,
                onResetGame = quizViewModel::resetGame,
                onBackForestStage = {
                    showInterstitialAd(context){
                        navController.popBackStack()
                    }
                },
                onNavigateNextLevel = {
                    showInterstitialAd(context) {
                        navController.popBackStack()
                    }
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
                                onConfirmAnswer = quizViewModel::onConfirmAnswer,
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
                                onConfirmAnswer = quizViewModel::onConfirmAnswer,
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
                                onConfirmSelects = quizViewModel::relationsAnswerSelected,
                            )
                        }
                    }
                }
            )

            MissionCompletedPopUp(
                modifier = Modifier,
                missionText = missionCompleted?.text ?: "",
                missionIcon = getMissionIcon(missionCompleted?.id ?: 0),
                showMissionCompleted = missionCompleted != null
            )
        }

        challengeNavGraph(navController = navController)
    }
}
