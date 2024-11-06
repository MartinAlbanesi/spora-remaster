package com.gg.spora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gg.spora.core.graph.RootNavigationGraph
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.GetUserLocalUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var getUserLocalUseCase: GetUserLocalUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            var isUserLoggedIn : Boolean? by rememberSaveable {
                mutableStateOf(null)
            }

            LaunchedEffect(true) {
                getUserLocalUseCase().collect{
                    isUserLoggedIn = it != null
                }
            }

            screenSplash.apply {
                setKeepOnScreenCondition { isUserLoggedIn == null }
            }
            SporaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    isUserLoggedIn?.let {
                        RootNavigationGraph(
                            isUserLoggedIn = it
                        )
                    }
                }
            }
        }
    }
}