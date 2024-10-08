package com.gg.spora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gg.spora.challenge.ui.ChallengeListObject
import com.gg.spora.challenge.ui.ChallengeScreen
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.ui.screenFadeWithSlideInToLeft
import com.gg.spora.core.ui.screenFadeWithSlideOutToRight
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.forestStage.ui.ForestStageScreen
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
                        startDestination = NavigationRoutes.ForestStage,
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
                                    navController.navigate(NavigationRoutes.ForestStage)
                                }
                            )
                        }

                        composable<NavigationRoutes.Grove> {

                        }

                        composable<NavigationRoutes.ForestStage> {
                            ForestStageScreen(
                                oxygen = 100,
                                onNavigateToQuizGame = {
                                    navController.navigate(NavigationRoutes.QuizGame)
                                },
                                onNavigateToChallenge = {
                                    navController.navigate(NavigationRoutes.Challenge)
                                },
                                onNavigateToQuizImage = {
                                    navController.navigate(NavigationRoutes.QuizImage)
                                },
                                popBackStack = {
                                    navController.popBackStack()
                                },
                                onNavigateToRelationsGame = {
                                    navController.navigate(NavigationRoutes.RelationsGame)
                                }

                            )
                        }
                        composable<NavigationRoutes.QuizGame> {

                            val quizViewModel = hiltViewModel<QuizViewModel>()

                            val currentQuestion by quizViewModel.currentQuestion.collectAsState()

                            val isCorrect by quizViewModel.isCorrect.collectAsState()

                            val isFinished by quizViewModel.isFinished.collectAsState()

                            val lives by quizViewModel.lives.collectAsState()

                            val counterQuestion by quizViewModel.counterQuestion.collectAsState()

                            MiniGameScreen(
                                modifier = Modifier.fillMaxSize(),
                                imageBackground = R.drawable.fondo_minijuegos,
                                isCorrect = isCorrect,
                                questionSize = SporaConstant.MAX_QUESTIONS,
                                isFinished = isFinished,
                                lives = lives,
                                counterQuestion = counterQuestion,
                                onBackClick = { },
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
                            val quizImageViewModel = hiltViewModel<QuizImageViewModel>()

                            val currentImageQuestion by quizImageViewModel.currentQuestion.collectAsState()

                            val isCorrect by quizImageViewModel.isCorrect.collectAsState()

                            val currentImageResIdState by quizImageViewModel.currentImageResId.collectAsState()

                            val isFinished by quizImageViewModel.isFinished.collectAsState()

                            val lives by quizImageViewModel.lives.collectAsState()

                            val counterQuestion by quizImageViewModel.counterQuestion.collectAsState()

//                            MinigameQuizImageScreen(
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .padding(16.dp),
//                                onBackClick = { },
//                                questionTitle = currentImageQuestion!!.question,
//                                answerOptions = currentImageQuestion!!.answers,
//                                onAnswerSelected = quizImageViewModel::isAnswerCorrect,
//                                onNextQuestion = quizImageViewModel::nextQuestion,
//                                questionImageResId = quizImageViewModel.questionImageResId
//                            )
                            MiniGameScreen(modifier = Modifier.fillMaxSize(),
                                imageBackground = R.drawable.fondo_minijuegos,
                                isCorrect = isCorrect,
                                questionSize = SporaConstant.MAX_QUESTIONS,
                                isFinished = isFinished,
                                lives = lives,
                                counterQuestion = counterQuestion,
                                onBackClick = { },
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
                            MinigameRelationsScreen() {

                            }
                        }

                    }
                }
            }
        }
    }

}