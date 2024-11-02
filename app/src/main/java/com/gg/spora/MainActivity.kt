package com.gg.spora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gg.spora.core.graph.RootNavigationGraph
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.user.domain.GetUserAuthUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var getUserAuthUseCase: GetUserAuthUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            screenSplash.setKeepOnScreenCondition { false }
            SporaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    RootNavigationGraph(
                        isUserLoggedIn = getUserAuthUseCase() != null
                    )
                }
            }
        }
    }
}