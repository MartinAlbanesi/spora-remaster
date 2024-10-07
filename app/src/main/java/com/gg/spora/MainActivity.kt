package com.gg.spora

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gg.spora.camera.CameraScreen
import com.gg.spora.camera.classifyImage
import com.gg.spora.challenge.ui.ChallengeScreen
import com.gg.spora.challenge.ui.ChallengeViewModel
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.forestStage.ui.ForestStageScreen
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.introduction.ui.WelcomeScreen
import com.gg.spora.quiz.ui.QuizScreen
import com.gg.spora.quiz.ui.QuizViewModel
import com.gg.spora.ui.theme.SporaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            SporaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    var scannedObjects by remember { mutableStateOf(mapOf(
                        "Botella de plastico" to false,
                        "Residuos Orgánicos" to false,
                        "Papel y Cartón" to false,
                        "Envases de Plástico" to false,
                    )) }

                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoutes.Welcome
                    ) {
                        composable<NavigationRoutes.Welcome> {
                            WelcomeScreen(
                                onNavigateToHome = {
                                    navController.navigate(NavigationRoutes.Home)
                                }
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
                                o2 = 100,
                                onNavigateToQuizGame = {
                                    navController.navigate(NavigationRoutes.QuizGame)
                                },
                                onNavigateToChallenge = {
                                    navController.navigate(NavigationRoutes.Challenge)
                                }
                            )
                        }
                        composable<NavigationRoutes.QuizGame> {

                            val quizViewModel = hiltViewModel<QuizViewModel>()

                            val currentQuestion by quizViewModel.currentQuestion.collectAsState()

                            MiniGameScreen(
                                modifier = Modifier.fillMaxSize(),
                                imageBackground = R.drawable.fondo_minijuegos,
                                champyImage = R.drawable.champy_celebrando_brazoslevantados,
                                onBackClick = { },
                                content = {
                                    QuizScreen(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(16.dp),
                                        questionTitle = currentQuestion!!.question,
                                        answerOptions = currentQuestion!!.answers,
                                        answerQuestionId = currentQuestion!!.answer.id,
                                        onAnswerSelected = quizViewModel::isAnswerCorrect,
                                        onNextQuestion = quizViewModel::nextQuestion
                                    )
                                }
                            )
                        }
                        composable<NavigationRoutes.Camera> {
                            CameraScreen(
                                onNavigateToChallengeScreen = {
                                    navController.navigate(NavigationRoutes.Challenge)
                                }
                            )
                        }
                        composable<NavigationRoutes.Challenge> {
                            ChallengeScreen(
                                modifier = Modifier,
                                champyImage = R.drawable.champy_sonriente_brazosalcuerpo,
                                recyclerOptions = scannedObjects,
                                onBackClick = { },
                                onNavigateToCameraScreen = {
                                    navController.navigate(NavigationRoutes.Camera)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}