package com.gg.spora

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gg.spora.core.graph.RootNavigationGraph
import com.gg.spora.core.ads.loadInterstitial
import com.gg.spora.core.ads.loadRewarded
import com.gg.spora.core.ads.removeInterstitial
import com.gg.spora.core.ads.removeRewarded
import com.gg.spora.core.ui.MainViewModel
import com.gg.spora.core.ui.components.ChampyDialogConfirm
import com.gg.spora.core.ui.components.ShowCircularProgressIndicator
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.user.domain.GetUserLocalUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)

        initAds()

        setContent {

            val context = LocalContext.current

            val isUserLoggedIn by mainViewModel.isUserLoggedIn.collectAsState()

            val canAccessToApp by mainViewModel.canAccessToApp.collectAsState()

            screenSplash.apply {
                setKeepOnScreenCondition {
                    isUserLoggedIn == null && canAccessToApp == null
                }
            }

            SporaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    isUserLoggedIn?.let { RootNavigationGraph(isUserLoggedIn = it) }
                }
            }

            canAccessToApp?.let {
                ChampyDialogConfirm(
                    backgroundImage = R.drawable.minigame_background_crop,
                    isVisible = !it,
                    showSecondaryButton = false,
                    title = "!Nueva Actualizacion!",
                    body = "Para continuar usando la app, actualiza a la última versión con mejoras y nuevas funciones.",
                    champyImage = R.drawable.champy_smiling_idle,
                    primaryButtonText = "Actualizar",
                    onDismissRequest = {},
                    onConfirmRequest = {
                        navigateToPlayStore(context)
                    },
                )
            }
        }
    }

    override fun onDestroy() {
        removeInterstitial()
        removeRewarded()
        super.onDestroy()
    }

    private fun initAds() {
        loadInterstitial(this)
        loadRewarded(this)
    }
}

@Suppress("TooGenericExceptionCaught")
fun navigateToPlayStore(context: Context) {
    val appPackage = context.packageName
    try {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=$appPackage")
//                Uri.parse("https://play.google.com/store/apps/details?id=com.gg.spora")
            )
        )
    } catch (e: Exception) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$appPackage")
//                Uri.parse("https://play.google.com/store/apps/details?id=com.gg.spora")
            )
        )

    }
}