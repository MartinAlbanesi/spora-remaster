package com.gg.spora

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.gg.spora.camera.ui.CameraScreen
import com.gg.spora.challenge.ui.ChallengeScreen
import com.gg.spora.challenge.ui.ChallengeViewModel
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.ui.screenFadeWithSlideInToLeft
import com.gg.spora.core.ui.screenFadeWithSlideOutToRight
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.forestStage.domain.model.getLevelWithStage
import com.gg.spora.forestStage.ui.LevelPreview
import com.gg.spora.forestStage.ui.StageScreen
import com.gg.spora.forestStage.ui.StageViewModel
import com.gg.spora.grove.ui.GroveScreen
import com.gg.spora.grove.ui.GroveViewModel
import com.gg.spora.home.ui.HomeScreen
import com.gg.spora.login.ui.LoginScreen
import com.gg.spora.login.ui.LoginViewModel
import com.gg.spora.miniGames.ui.QuizImageScreen
import com.gg.spora.miniGames.ui.QuizScreen
import com.gg.spora.miniGames.ui.QuizViewModel
import com.gg.spora.miniGames.ui.RelationsScreen
import com.gg.spora.registeredLogin.iu.RegisteredLoginScreen
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.welcome.ui.WelcomeScreen
import com.gg.spora.welcome.ui.WelcomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("NewApi")

    private val challengeViewModel: ChallengeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            screenSplash.setKeepOnScreenCondition { false }
            SporaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoutes.Welcome,
//                        startDestination = NavigationRoutes.Stage("2"),
                        startDestination = NavigationRoutes.Home,
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
                                modifier = Modifier,
                                onNavigateToSignUp = {
                                    navController.navigate(NavigationRoutes.SignUp)
                                }
                            )
                        }

                        composable<NavigationRoutes.SignUp> {

                            val loginViewModel = hiltViewModel<LoginViewModel>()

                            LoginScreen(
                                viewModel = loginViewModel,
                                navController = navController
                            )
                        }

                        composable<NavigationRoutes.RegisteredLogin> {

                            RegisteredLoginScreen(
                                onBackClick = { navController.popBackStack() },
                                onGoogleLoginClick = { },
                                onLoginClick = { },
                                onRegisterClick = { },
                                navController = navController
                            )
                        }

                        composable<NavigationRoutes.Home> {
                            HomeScreen(
                                onNavigateToForestStage = {
                                    navController.navigate(NavigationRoutes.ForestStage)
                                },
                                onNavigateToGrove = {
                                    navController.navigate(NavigationRoutes.Grove)
                                    navController.navigate(NavigationRoutes.Stage("1"))
                                },
                                onNavigateToExpoStage = {
                                    navController.navigate(NavigationRoutes.Stage("2"))
                                }
                            )
                        }
                        composable<NavigationRoutes.Grove> {
                            val groveViewModel = hiltViewModel<GroveViewModel>()
                            val seedTrees by groveViewModel.seedTrees.collectAsState()
                            val forestTrees by groveViewModel.forestTrees.collectAsState()

                            GroveScreen(
                                seedTrees = seedTrees,
                                forestTrees = forestTrees,
                                plantSeedInForest = { treeType -> groveViewModel.plantSeedInForest(treeType) },
                                updateTree = { tree -> groveViewModel.updateTree(tree) },
                                popBackStack = {
                                    navController.popBackStack()
                                },
                            )
                        }
                        composable<NavigationRoutes.Stage> {

                            val stageViewModel = hiltViewModel<StageViewModel>()

                            val stage by stageViewModel.stage.collectAsState()

//                            val levels by stageViewModel.levels.collectAsState()

                            val currentLevel by stageViewModel.currentLevel.collectAsState()

                            var showLevelPreview by rememberSaveable {
                                mutableStateOf(false)
                            }

//                            var localQuestionType by rememberSaveable {
//                                mutableIntStateOf(0)
//                            }

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
                                                quizCount = currentLevel!!.quizCount,
                                                imageCount = currentLevel!!.imageCount,
                                                relationsCount = currentLevel!!.relationsCount,
                                                levelId = currentLevel!!.id,
                                                imageBackground = stage!!.levelPreviewImage,
                                                stageId = stage!!.id
                                            )
                                        )
                                },
                                onClickSecondaryButton = {
                                    showLevelPreview = false
                                },
                            )

                            StageScreen(
                                oxygen = 75,
                                title = stage!!.typeStage.label,
                                levels = stage!!.levels,
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
//                                    localQuestionType = questionType.typeNumber
                                }
                            )
                        }
                        composable<NavigationRoutes.QuizGame> {

                            val quizGameRoute = it.toRoute<NavigationRoutes.QuizGame>()

                            val quizViewModel = hiltViewModel<QuizViewModel>()

                            val currentQuestion by quizViewModel.currentQuestion.collectAsState()

                            val isCorrect by quizViewModel.isCorrect.collectAsState()

                            val isFinished by quizViewModel.isFinished.collectAsState()

                            val lives by quizViewModel.lives.collectAsState()

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
                                counterQuestion = counterQuestion,
                                showButtonContinue = isCorrect != null,
                                onNextQuestion = quizViewModel::nextQuestion,
                                onResetGame = quizViewModel::resetGame,
                                onBackForestStage = { navController.popBackStack() },
                                onNavigateNextLevel = {
                                    if(quizGameRoute.stageId == "2"){
                                        navController.navigate(NavigationRoutes.Challenge(stageId = quizGameRoute.stageId))
                                    }else{
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
                        composable(
                            route = NavigationRoutes.Camera.route,
                            arguments = listOf(navArgument("nameObject") {
                                type = NavType.StringType
                            })
                        ) {
                            val nameObject = it.arguments?.getString("nameObject") ?: ""
                            CameraScreen(
                                nameObject = nameObject,
                                onNavigateToChallengeScreen = {
                                    navController.popBackStack()
                                },
                                challengeViewModel = challengeViewModel
                            )
                        }

                        composable<NavigationRoutes.Challenge> { backStackEntry ->

                            val challengeRoute =
                                backStackEntry.toRoute<NavigationRoutes.Challenge>()

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
                    }
                }
            }
        }
    }
}