package com.gg.spora.welcome.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.ChampyTalkingAnimation
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.SporaPrimaryInverseButton
import com.gg.spora.core.ui.components.TopBarWithLeadingAndTrailingIcon
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.welcome.ui.components.LogoScreen
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
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 5})

    val champyWelcomeItem = listOf(
        Pair(R.drawable.champy_smiling_left_arm_raised,
            "¡Hola! Me llamo Champy y necesito tu ayuda para salvar mi bosque."),
        Pair(R.drawable.champy_curious_arms_to_body, "Pero primero, ¿me contás sobre vos?"),
        Pair(R.drawable.champy_curious_left_arm_in_the_cheek, "Entonces... ¿Cómo te llamás?"),
        Pair(R.drawable.champy_celebrating_raised_arms, "¡Genial, ${name}!\n Vamos a mi hogar")
    )

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (pagerState.currentPage > 0) {

                if (pagerState.currentPage == 3) {
                    TopBarWithLeadingAndTrailingIcon(
                        modifier = modifier
                            .weight(1f),
                        title = "",
                        onClickLeadingIcon = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                name = ""
                            }
                        }
                    )
                } else Spacer(modifier = modifier.weight(1f))

                ChampyTalkingAnimation(
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(4f),
                    champyImage = champyWelcomeItem[pagerState.currentPage-1].first,
                    champyText = champyWelcomeItem[pagerState.currentPage-1].second,
                    textModifier = Modifier
                        .offset(y = (160).dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(colorResource(R.color.cream))
                        .fillMaxWidth(0.6f)
                        .padding(16.dp)
                )
            }


            HorizontalPager(
                state = pagerState,
                modifier = modifier
                    .weight(1f),
                userScrollEnabled = false
            ) { page ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    when (page) {
                        0 -> {
                            LogoScreen(modifier) {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(page + 1)
                                }
                            }
                        }

                        1 -> {
                            SporaPrimaryButton(
                                text = "Continuar",
                                textSize = 30,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(page + 1)
                                    }
                                },
                                modifier = modifier
                                    .height(height = 50.dp)
                                    .fillMaxWidth(0.8f)
                            )
                        }

                        2 -> {
                            TypeUserSelectionScreen(
                                modifier = modifier,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(page + 1)
                                    }
                                },
                                onNavigateToSignUp = onNavigateToSignUp
                            )
                        }

                        3 -> {
                            GuestEnterNameScreen(
                                modifier,
                                guestName = name,
                                onValueChange = { name = it },
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(page + 1)
                                    }
                                },
                                filterNames = filterNames,
                            )
                        }

                        4 -> {
                            ChampyTalkGuestScreen(modifier) {
                                setGuestName(name)
                                onNavigateToHome()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TypeUserSelectionScreen(
    modifier: Modifier,
    onClick: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        SporaPrimaryInverseButton(
            text = "Jugar como invitado",
            textSize = 20,
            onClick = onClick,
            modifier = Modifier
                .height(height = 50.dp)
                .fillMaxWidth(0.8f)
        )
        SporaPrimaryButton(
            text = "Crear cuenta",
            textSize = 20,
            onClick = {
                onNavigateToSignUp()
            },
            modifier = Modifier
                .height(height = 50.dp)
                .fillMaxWidth(0.8f)
        )
    }
}

@Composable
fun GuestEnterNameScreen(
    modifier: Modifier,
    guestName: String,
    onValueChange: (String) -> Unit,
    filterNames: (String) -> String = { "" },
    onClick: () -> Unit
) {
    var isBannedWord by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {

        SporaTextField(
            modifier = modifier,
            guestName,
            onValueChange,
            filterNames = filterNames,
            isAllowedName = { isBannedWord = it }
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

@Composable
fun ChampyTalkGuestScreen(
    modifier: Modifier,
    onClick: () -> Unit
) {
    SporaPrimaryButton(
        text = "Comenzar",
        textSize = 24,
        modifier = modifier
            .height(height = 50.dp)
            .fillMaxWidth(0.8f)
    ) {
        onClick()
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WelcomeScreen(
                onNavigateToSignUp = {},
                onNavigateToHome = {}
            )
        }
    }
}