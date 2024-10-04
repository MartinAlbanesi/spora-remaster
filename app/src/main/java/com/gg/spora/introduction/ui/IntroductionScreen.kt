package com.gg.spora.introduction.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.SporaPrimaryInverseButton
import com.gg.spora.introduction.ui.components.ChampyWithTopDialogue
import com.gg.spora.introduction.ui.components.SporaLabelPrimary
import com.gg.spora.ui.theme.SporaTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroductionHorizontalPager(modifier: Modifier = Modifier) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {
        5
    })

    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier.fillMaxWidth()) {
            HorizontalPager(state = pagerState, modifier = modifier.weight(0.7f)) { page ->

                when (page) {
                    0 -> IntroductionScreen1(modifier) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }

                    1 -> IntroductionScreen2(modifier) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }

                    2 -> IntroductionScreen3(modifier) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }

                    3 -> IntroductionScreen4(modifier) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }

                    else -> {
                        IntroductionScreen1(modifier) {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page + 1)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun IntroductionScreen1(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Image(
            painter = painterResource(id = R.drawable.fondo_introduccion),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_reborde_slogan),
                contentDescription = "Logo",
                Modifier
                    .size(350.dp)
                    .offset(y = (-50).dp),
                contentScale = ContentScale.Fit
            )

            SporaPrimaryButton(modifier.offset(y = 60.dp), "Continuar", onClick = onClick)

        }
    }
}


@Composable
fun IntroductionScreen2(modifier: Modifier, onClick: () -> Unit) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_introduccion),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ChampyWithTopDialogue(
                champy = R.drawable.champy_sonriente_brazo_izquierdo_levantado,
                dialogue = "¡Hola! Me llamo Champy y necesito tu ayuda para salvar mi hogar.",
                x = -(30).dp
            )

            SporaPrimaryButton(
                modifier = modifier, text = "Continuar", onClick = onClick
            )
        }

    }
}


@Composable
fun IntroductionScreen3(modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Image(
            painter = painterResource(id = R.drawable.fondo_introduccion),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ChampyWithTopDialogue(
                champy = R.drawable.champy_curioso_brazos_al_cuerpo,
                dialogue = "Pero primero, ¿me contas sobre vos?",
                x = -(30).dp
            )


            Column(
                modifier = modifier.height(120.dp), verticalArrangement = Arrangement.SpaceBetween
            ) {
                SporaPrimaryButton(modifier = modifier, text = "Crear cuenta") {
                    /*Nav to Sign Up screen*/
                }

                SporaPrimaryInverseButton(
                    modifier = modifier, text = "Jugar como invitado", onClick = onClick
                )
            }
        }
    }
}

@Composable
fun IntroductionScreen4(modifier: Modifier, onClick: () -> Unit) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Image(
            painter = painterResource(id = R.drawable.fondo_introduccion),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ChampyWithTopDialogue(
                champy = R.drawable.champy_curioso_brazo_izquierdo_en_la_mejilla,
                "Entonces... " +
                        "\n¿Cómo te llamas?",
                x = -(30).dp
            )

            Column(
                modifier = modifier.height(120.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                SporaLabelPrimary(modifier = modifier, "")

                SporaPrimaryButton(modifier, "Siguente", onClick = onClick)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntroductionScreenPreview() {
    SporaTheme {
        IntroductionScreen4(modifier = Modifier, onClick = {})
    }
}