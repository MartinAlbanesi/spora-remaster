package com.gg.spora

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
import com.gg.spora.core.graph.RootNavigationGraph
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.ui.screenFadeWithSlideInToLeft
import com.gg.spora.core.ui.screenFadeWithSlideOutToRight
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.forestStage.domain.model.getLevelWithStage
import com.gg.spora.forestStage.ui.LevelPreview
import com.gg.spora.forestStage.ui.StageScreen
import com.gg.spora.forestStage.ui.StageViewModel
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
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            screenSplash.setKeepOnScreenCondition { false }
            SporaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                    
                ) {
                    RootNavigationGraph()
                }
            }
        }
    }
}