package com.gg.spora

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gg.spora.challenge.ui.ChallengeListObject
import com.gg.spora.challenge.ui.ChallengeScreen
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.ui.screenFadeWithSlideInToLeft
import com.gg.spora.core.ui.screenFadeWithSlideOutToRight
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.forestStage.ui.LevelPreview
import com.gg.spora.forestStage.ui.StageScreen
import com.gg.spora.forestStage.ui.StageViewModel
import com.gg.spora.grove.ui.GroveScreen
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.minigameQuizImage.ui.QuizImageScreen
import com.gg.spora.minigameQuizImage.ui.QuizImageViewModel
import com.gg.spora.minigameRelations.ui.MinigameRelationsScreen
import com.gg.spora.quiz.ui.QuizScreen
import com.gg.spora.quiz.ui.QuizViewModel
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.welcome.ui.WelcomeScreen
import com.gg.spora.welcome.ui.WelcomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SporaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoutes.Welcome,
                        enterTransition = ::screenFadeWithSlideInToLeft,
                        exitTransition = ::screenFadeWithSlideOutToRight,
                        popEnterTransition = ::screenFadeWithSlideInToLeft,
                        popExitTransition = ::screenFadeWithSlideOutToRight,
                        modifier = Modifier.background(color = Color.Black)
                    ) {
                        composable<NavigationRoutes.Welcome> {
                            val welcomeViewModel = hiltViewModel<WelcomeViewModel>()
                            WelcomeScreen(
                                onNavigateToHome = {
                                    navController.navigate(NavigationRoutes.Home) {
                                        popUpTo(NavigationRoutes.Welcome) {
                                            inclusive = true
                                        }
                                    }
                                },
                                setGuestName = { welcomeViewModel.setGuestName(it) },
                            )
                        }
                        composable<NavigationRoutes.Home> {
                            HomeScreen(
                                onNavigateToForestStage = {
                                    navController.navigate(NavigationRoutes.ForestStage(0))
                                },
                                onNavigateToGrove = {
                                    navController.navigate(NavigationRoutes.Grove)
                                }
                            )
                        }
                        composable<NavigationRoutes.Grove> {
                            GroveScreen()
                        }
                        composable<NavigationRoutes.ForestStage> { backStackEntry ->

                            val oxygen = backStackEntry.toRoute<NavigationRoutes.ForestStage>()

                            val stageViewModel = hiltViewModel<StageViewModel>()

                            val levels by stageViewModel.levels.collectAsState()

                            val currentLevel by stageViewModel.currentLevel.collectAsState()

                            var showLevelPreview by rememberSaveable {
                                mutableStateOf(false)
                            }

                            var localQuestionType by rememberSaveable {
                                mutableStateOf(0)
                            }

                            LevelPreview(
                                isVisible = showLevelPreview,
                                backgroundImage = R.drawable.fondo_minijuegos_crop,
                                level = currentLevel!!,
                                onClickPrimaryButton = {
                                    showLevelPreview = false
                                    when (localQuestionType) {
                                        0 -> {
                                            navController.navigate(NavigationRoutes.QuizGame("${currentLevel!!.levelName} - ${currentLevel!!.stageType.label}"))
                                        }

                                        1 -> {
                                            navController.navigate(NavigationRoutes.RelationsGame("${currentLevel!!.levelName} - ${currentLevel!!.stageType.label}"))
                                        }

                                        2 -> {
                                            navController.navigate(NavigationRoutes.QuizImage("${currentLevel!!.levelName} - ${currentLevel!!.stageType.label}"))
                                        }

                                        3 -> {
                                            navController.navigate(NavigationRoutes.Challenge("${currentLevel!!.levelName} - ${currentLevel!!.stageType.label}"))
                                        }
                                    }
                                },
                                onClickSecondaryButton = {
                                    showLevelPreview = false
                                },
                            )

                            StageScreen(
                                oxygen = oxygen.oxygen,
                                levels = levels,
                                onNavigateToQuizGame = { title ->
                                    navController.navigate(NavigationRoutes.QuizGame(title))
                                },
                                onNavigateToQuizImage = { title ->
                                    navController.navigate(NavigationRoutes.QuizImage(title))
                                },
                                onNavigateToRelationsGame = { title ->
                                    navController.navigate(NavigationRoutes.RelationsGame(title))
                                },
                                onNavigateToChallenge = { title ->
                                    navController.navigate(NavigationRoutes.Challenge(title))
                                },
                                popBackStack = {
                                    navController.popBackStack()
                                },
                                onClickLevelItem = { level, showPreview, questionType ->
                                    stageViewModel.onLevelSelected(level)
                                    showLevelPreview = showPreview
                                    localQuestionType = questionType.typeNumber
                                }
                            )
                        }
                        composable<NavigationRoutes.QuizGame> {

                            val title = it.toRoute<NavigationRoutes.QuizGame>()

                            val quizViewModel = hiltViewModel<QuizViewModel>()

                            val currentQuestion by quizViewModel.currentQuestion.collectAsState()

                            val isCorrect by quizViewModel.isCorrect.collectAsState()

                            val isFinished by quizViewModel.isFinished.collectAsState()

                            val lives by quizViewModel.lives.collectAsState()

                            val counterQuestion by quizViewModel.counterQuestion.collectAsState()

                            MiniGameScreen(
                                modifier = Modifier.fillMaxSize(),
                                title = title.title,
                                imageBackground = R.drawable.fondo_minijuegos,
                                isCorrect = isCorrect,
                                questionSize = SporaConstant.MAX_QUESTIONS,
                                isFinished = isFinished,
                                lives = lives,
                                counterQuestion = counterQuestion,
                                onNextQuestion = quizViewModel::nextQuestion,
                                onResetGame = quizViewModel::resetGame,
                                onBackForestStage = { navController.popBackStack() },
                                content = {
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
                            )
                        }
                        composable<NavigationRoutes.Challenge> {

                            val title = it.toRoute<NavigationRoutes.QuizGame>()

                            ChallengeScreen(
                                modifier = Modifier,
                                imageBackground = R.drawable.fondo_minijuegos,
                                champyImage = R.drawable.champy_celebrando_brazoslevantados,
                                onBackClick = { }
                            ) {
                                ChallengeListObject(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp),
                                    recyclerOptions = mapOf(
                                        "Vidrio" to true,
                                        "Residuos Orgánicos" to null,
                                        "Papel y Cartón" to null,
                                        "Envases de Plástico" to null,
                                    )
                                )
                            }
                        }
                        composable<NavigationRoutes.QuizImage> {

                            val title = it.toRoute<NavigationRoutes.QuizGame>()

                            val quizImageViewModel = hiltViewModel<QuizImageViewModel>()

                            val currentImageQuestion by quizImageViewModel.currentQuestion.collectAsState()

                            val isCorrect by quizImageViewModel.isCorrect.collectAsState()

                            val currentImageResIdState by quizImageViewModel.currentImageResId.collectAsState()

                            val isFinished by quizImageViewModel.isFinished.collectAsState()

                            val lives by quizImageViewModel.lives.collectAsState()

                            val counterQuestion by quizImageViewModel.counterQuestion.collectAsState()

                            MiniGameScreen(modifier = Modifier.fillMaxSize(),
                                imageBackground = R.drawable.fondo_minijuegos,
                                title = title.title,
                                isCorrect = isCorrect,
                                questionSize = SporaConstant.MAX_QUESTIONS,
                                isFinished = isFinished,
                                lives = lives,
                                counterQuestion = counterQuestion,
                                onNextQuestion = quizImageViewModel::nextQuestion,
                                onResetGame = quizImageViewModel::resetGame,
                                onBackForestStage = { navController.popBackStack() },
                                content = {
                                    QuizImageScreen(
                                        modifier = Modifier,
                                        questionTitle = currentImageQuestion!!.question,
                                        answerOptions = currentImageQuestion!!.answers,
                                        currentImageResIdState = currentImageResIdState,
                                        onAnswerSelected = quizImageViewModel::isAnswerCorrect,
                                        onNextQuestion = quizImageViewModel::nextQuestion,
                                    )
                                }
                            )
                        }
                        composable<NavigationRoutes.RelationsGame> {

                            val title = it.toRoute<NavigationRoutes.QuizGame>()

                            MiniGameScreen(modifier = Modifier.fillMaxSize(),
                                imageBackground = R.drawable.fondo_minijuegos,
                                title = title.title,
                                isCorrect = null, // <- Cambiar por tu variable de estado
                                questionSize = SporaConstant.MAX_QUESTIONS,
                                isFinished = false, // <- Cambiar por tu variable de estado
                                lives = 5, // <- Cambiar por tu variable de estado
                                counterQuestion = 0, // <- Cambiar por tu variable de estado
                                onNextQuestion = { /* Ingresar logica de siguiente */ },
                                onResetGame = { /* Ingresar logica de reset */ },
                                onBackForestStage = { navController.popBackStack() },
                                content = {
                                    MinigameRelationsScreen() {

                                    }
                                }
                            )

                        }
                    }
                }
            }
        }
    }

}