package com.gg.spora.welcome.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.SporaPrimaryInverseButton
import com.gg.spora.core.ui.components.TopAppBarOnlyBackArrow
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.welcome.ui.animations.LogoInitialAnimation
import com.gg.spora.welcome.ui.components.ChampyWithTopDialogue
import com.gg.spora.welcome.ui.components.SporaTextField
import kotlinx.coroutines.launch


@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    setGuestName: (String) -> Unit = {},
    onNavigateToHome: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    filterNames: (String) -> String = { "" },
) {
    var name by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {
        5
    })

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = modifier,
            userScrollEnabled = false
        ) { page ->

            when (page) {
                0 -> LogoScreen(modifier) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(page + 1)
                    }
                }

                1 -> ChampyTalkScreen(modifier) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(page + 1)
                    }
                }

                2 -> TypeUserSelectionScreen(
                    modifier = modifier,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    },
                    onNavigateToSignUp = onNavigateToSignUp
                )

                3 -> GuestEnterNameScreen(
                    modifier,
                    guestName = name,
                    onValueChange = { name = it },
                    onNavigateBack = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page - 1)
                            name = ""
                        }
                    },
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    },
                    filterNames = filterNames,
                )
                4 -> ChampyTalkGuestScreen(modifier, guestName = name) {
                    setGuestName(name)
                    onNavigateToHome()
                }

                else -> {
                    LogoScreen(modifier) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun LogoScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(5.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {

        LogoInitialAnimation(
            image = R.drawable.logo_with_border_slogan,
            modifier = modifier.align(Alignment.Center)
        )

        SporaPrimaryButton(
//                    .offset(y = 60.dp),
            text = "Continuar",
            textSize = 30,
            onClick = onClick,
            modifier = modifier
                .size(width = 350.dp, height = 50.dp)
                .align(Alignment.BottomCenter)
                .offset(y = -60.dp),
        )

    }
//    }
}


@Composable
fun ChampyTalkScreen(
    modifier: Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

//        Column(
//            modifier = modifier.fillMaxHeight(),
//            verticalArrangement = Arrangement.SpaceEvenly,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
        ChampyWithTopDialogue(
            champy = R.drawable.champy_smiling_left_arm_raised,
            dialogue = "¡Hola! Me llamo Champy y necesito tu ayuda para salvar mi bosque.",
            x = -(30).dp,
            y = -(22).dp,
            modifier = Modifier.align(Alignment.Center)
        )

        SporaPrimaryButton(
            text = "Continuar",
            textSize = 30,
            onClick = onClick,
            modifier = modifier
                .size(width = 350.dp, height = 50.dp)
                .align(Alignment.BottomCenter)
                .offset(y = -60.dp),
        )
//        }
    }
}


@Composable
fun TypeUserSelectionScreen(
    modifier: Modifier,
    onClick: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

//        Column(
//            modifier = modifier.fillMaxHeight(),
//            verticalArrangement = Arrangement.SpaceEvenly,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {

        ChampyWithTopDialogue(
            champy = R.drawable.champy_curious_arms_to_body,
            dialogue = "Pero primero, ¿me contás sobre vos?",
            x = -(30).dp,
            modifier = Modifier.align(Alignment.Center)
        )


//            Column(
//                modifier = modifier.height(120.dp), verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                SporaPrimaryButton(modifier = modifier, text = "Crear cuenta") {
//                    /*Nav to Sign Up screen*/
//                }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-60).dp),
        ) {
            SporaPrimaryInverseButton(
                text = "Jugar como invitado",
                textSize = 20,
                onClick = onClick,
                modifier = Modifier
                    .size(width = 350.dp, height = 50.dp)
//                    .align(Alignment.BottomCenter)
//                    .offset(y = -60.dp),
            )
            SporaPrimaryButton(
                text = "Crear cuenta",
                textSize = 20,
                onClick = {
                    onNavigateToSignUp()
                },
                modifier = Modifier
                    .size(width = 350.dp, height = 50.dp)
//                    .offset(y = 10.dp),
            )
        }
    }
//        }
//    }
}

@Composable
fun GuestEnterNameScreen(
    modifier: Modifier,
    guestName: String,
    onValueChange: (String) -> Unit,
    onNavigateBack: () -> Unit,
    filterNames: (String) -> String = { "" },
    onClick: () -> Unit
) {
    var isBannedWord by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )


        TopAppBarOnlyBackArrow(
            onBackClick = onNavigateBack,
            modifier = modifier,
            title = ""
        )

        ChampyWithTopDialogue(
            champy = R.drawable.champy_curious_left_arm_in_the_cheek,
            dialogue = "Entonces... " +
                "\n¿Cómo te llamás?",
            x = -(30).dp,
            modifier = Modifier.align(Alignment.Center)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-60).dp),
        ) {

            SporaTextField(
                modifier = modifier,
                guestName,
                onValueChange,
                filterNames = filterNames,
                isAllowedName = {isBannedWord = it}
            )

                SporaPrimaryButton(
                    modifier.size(width = 350.dp, height = 50.dp),
                    "Siguiente",
                    textSize = 30,
                    onClick = onClick,
                    isEnable = guestName.isNotBlank() && !isBannedWord
                )
        }
    }
}

@Composable
fun ChampyTalkGuestScreen(
    modifier: Modifier,
    guestName: String,
    onClick: () -> Unit
) {

    Box(modifier = modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

//        Column(
//            modifier = modifier.fillMaxHeight(),
//            verticalArrangement = Arrangement.SpaceEvenly,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {

        ChampyWithTopDialogue(
            champy = R.drawable.champy_celebrating_raised_arms,
            dialogue = "¡Genial, ${guestName}!\n Vamos a mi hogar",
            x = -(30).dp,
            y = -(22).dp,
            modifier = Modifier.align(Alignment.Center)
        )

        SporaPrimaryButton(
            text = "Comenzar",
            textSize = 24,
            modifier = modifier
                .size(width = 350.dp, height = 60.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-60).dp),
        ) {
            onClick()
        }
    }
//    }
}

@Preview(showBackground = true)
@Composable
fun IntroductionScreenPreview() {
    SporaTheme {
        GuestEnterNameScreen(
            modifier = Modifier,
            guestName = "Ga",
            onValueChange = {},
            onNavigateBack = {},
            onClick = {},
        )
    }
}