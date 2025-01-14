package com.gg.spora.home.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.gg.spora.BuildConfig
import com.gg.spora.R
import com.gg.spora.core.ads.BannerAd
import com.gg.spora.core.ui.animations.ChampyBlinkAnimation
import com.gg.spora.core.ui.animations.TypewriteText
import com.gg.spora.core.ui.components.TopBarWithLeadingAndTrailingIcon
import com.gg.spora.home.domain.models.HomeIcon
import com.gg.spora.home.ui.components.ImageWithTextVertical
import com.gg.spora.home.ui.components.OxygenAndTreeIcons
import com.gg.spora.home.ui.components.SignButton
import com.gg.spora.missions.data.local.MissionModels
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.ui.MissionScreen
import com.gg.spora.ui.theme.SporaTheme

@Suppress("LongMethod")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    oxygen: Int,
    showTutorial: Boolean = true,
    champyQuote: String?,
    missions: List<Mission>,
    missionResetTime: String,
    trees: Int,
    onNavigateToForestStage: () -> Unit,
    onNavigateToGrove: () -> Unit,
    onNavigateToRanking: () -> Unit,
    onNavigateToLibrary: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onClaimMission: (Byte, Byte) -> Unit
) {

    val context = LocalContext.current

    var hasNotificationPermission by remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            mutableStateOf(
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            )
        } else mutableStateOf(true)
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            hasNotificationPermission = isGranted
        }
    )

    LaunchedEffect(!hasNotificationPermission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    var showMission by rememberSaveable { mutableStateOf(false) }

    val missionNotClaimed = missions.filter { !it.isClaimed }.size

    // Icons in the left
    val leftIcons = listOf<HomeIcon>(
        HomeIcon(
            image = R.drawable.profile_icon,
            text = "Perfil",
            onClick = onNavigateToProfile
        ),
        HomeIcon(
            image = R.drawable.ranking_icon,
            text = "Ranking",
            onClick = onNavigateToRanking
        ),
        HomeIcon(
            image = R.drawable.missions_icon,
            text = "Misiones",
            onClick = {
                showMission = !showMission
            }
        )
    )

    // Icons in the right
    val rightIcons = listOf<HomeIcon>(
        HomeIcon(
            image = R.drawable.eco_diary_icon,
            text = "Biblioteca",
            onClick = onNavigateToLibrary
        ),
        HomeIcon(
            image = R.drawable.grove_icon,
            text = "Arboleda",
            onClick = onNavigateToGrove
        )
    )

    Scaffold(
        topBar = {
            TopBarWithLeadingAndTrailingIcon(
                modifier = Modifier,
                leadingIcon = null,
                title = "",
                titleContent = {
                    OxygenAndTreeIcons(
                        oxygen = oxygen,
                        trees = trees,
                    )
                }
            )
        },
        modifier = modifier
    ) { paddingValue ->

        // Screen Background
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.home_background_rework),
                contentDescription = "Home Background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
            )
        }
        // Screen Content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValue.calculateTopPadding(), start = 8.dp, end = 8.dp)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
                //.align(Alignment.TopStart)
            ) {
                leftIcons.forEach { (image, text, onClick) ->
                    Box() {
                        ImageWithTextVertical(
                            image = image,
                            text = text,
                            modifier = Modifier.clickable(onClick = onClick),
                        )

                        if (text == "Misiones" && missionNotClaimed > 0) {
                            Badge(
                                containerColor = colorResource(R.color.primary),
                                contentColor = colorResource(R.color.white),
                                modifier = Modifier
                                    .size(32.dp)
                                    .align(Alignment.BottomEnd)
                                    .offset(x = (-8).dp, y = (-20).dp)
                            ) {
                                Text(
                                    text = missionNotClaimed.toString(),
                                    fontSize = 24.sp
                                )
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                rightIcons.forEach { (image, text, onClick) ->
                    ImageWithTextVertical(
                        image = image,
                        text = text,
                        modifier = Modifier.clickable(onClick = { onClick() }),
                    )
                }
            }

            // Forest Sign Button
            SignButton(
                image = R.drawable.forest_sign,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .size(140.dp)
                    .offset(y = (-120).dp, x = (-130).dp)
                    .clickable(onClick = onNavigateToForestStage)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.Center)
//                    .fillMaxSize()
            ) {
                if (!showTutorial) {
                    ChampyBlinkAnimation(
                        modifier = Modifier
                            .size(140.dp)
                            .align(Alignment.Center)
                            .offset(x = (-20).dp)
                    )
                    champyQuote?.let {
                        TypewriteText(
                            text = it,
                            preoccupySpace = false,
                            modifier = Modifier
                                .offset(x = (-20).dp, y = (100).dp)
                                .clip(MaterialTheme.shapes.medium)
                                .align(Alignment.Center)
                                .background(colorResource(R.color.cream))
                                .fillMaxWidth(0.6f)
                                .padding(16.dp)
                        )
                    }
                }
            }

            BannerAd(
                modifier = Modifier.align(
                    Alignment.BottomCenter
                ),
                bannerId = BuildConfig.BANNER_AD
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AnimatedVisibility(
            showMission,
            enter = expandHorizontally(),
            exit = shrinkHorizontally(),
            modifier = Modifier
                .align(Alignment.CenterStart)
        ) {
            MissionScreen(
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                missions = missions,
                missionResetTime = missionResetTime,
                onBack = {
                    showMission = false
                },
                onClaimMission = onClaimMission,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MiniGameScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                modifier = Modifier.fillMaxSize(),
                oxygen = 0,
                showTutorial = false,
                missions = MissionModels.fakeMissions,
                trees = 20,
                champyQuote = "¡Hola! Soy Champy, tu compañero de aventuras. ¿Estás listo para explorar el bosque?",
                missionResetTime= "5123",
                onNavigateToForestStage = {},
                onNavigateToGrove = {},
                onNavigateToLibrary = {},
                onNavigateToRanking = {},
                onNavigateToProfile = {},
                onClaimMission = { _, _ -> }
            )
        }
    }
}