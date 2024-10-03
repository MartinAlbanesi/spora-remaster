package com.gg.spora.challenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.components.ChampyWithCard
import com.gg.spora.core.components.TopBarWithProgressBar
import com.gg.spora.ui.theme.SporaTheme


/**
 * Screen for mini games with Spora and progress bar
 * @param modifier: Modifier
 * @param imageBackground: Background image
 * @param onBackClick: Click listener for back button
 * @param content: Content of the screen in the champy card
 */
@Composable
fun ChallengeScreen(
    modifier: Modifier = Modifier,
    imageBackground: Int,
    champyImage: Int,
    onBackClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(imageBackground),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-360).dp)
        )
        Column(
            modifier = modifier
        ) {
            TopBarWithProgressBar(
                title = stringResource(R.string.title_challenge),
                onBackClick = onBackClick,
                buttonLike = false
            )
            ChampyWithCard(
                modifier = Modifier.fillMaxSize(),
                champyImage = champyImage,
            ) {
                content()
            }
        }
    }
}

@Preview
//@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun ChallengeScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChallengeScreen(
                modifier = Modifier.fillMaxSize(),
                imageBackground = R.drawable.fondo_minijuegos,
                champyImage = R.drawable.champy_sonriente_brazosalcuerpo,
                onBackClick = { },
                content = {
                    ChallengeListObject(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        recyclerOptions = mapOf(
                            "Vidrio" to true,
                            "Residuos Orgánicos" to null,
                            "Papel y Cartón" to null,
                            "Envases de Plástico" to null,
                        )
                    )

                }
            )
        }
    }
}