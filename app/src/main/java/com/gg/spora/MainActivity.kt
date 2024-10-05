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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gg.spora.camera.CameraScreen
import com.gg.spora.camera.classifyImage
import com.gg.spora.challenge.ui.ChallengeListObject
import com.gg.spora.challenge.ui.ChallengeScreen
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
                    var scannedObject by remember { mutableStateOf("") }

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
                        composable<NavigationRoutes.Camera>{
                            val context = LocalContext.current
                            CameraScreen(
                                onImageCaptured = { bitmap: Bitmap ->
                                    classifyImage(context, bitmap, "Botella de plastico") { result ->
                                       if(result){
                                           scannedObject = "Botella de plastico"
                                           navController.navigate(NavigationRoutes.Challenge)
                                       }
                                    }
                                },
                                onError = { error ->
                                    // Manejar error
                                })

                        }
                        composable<NavigationRoutes.Challenge> {
                            ChallengeScreen(
                                modifier = Modifier,
                                champyImage = R.drawable.champy_sonriente_brazosalcuerpo,
                                recyclerOptions = mapOf(
                                    "Botella de plastico" to true,
                                    "Residuos Orgánicos" to null,
                                    "Papel y Cartón" to null,
                                    "Envases de Plástico" to null,
                                ),
                                scannedObject = scannedObject,
                                onBackClick = { },
                                onNavigateToCamera = {
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