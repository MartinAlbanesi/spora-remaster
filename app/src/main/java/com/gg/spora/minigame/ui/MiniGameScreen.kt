package com.gg.spora.minigame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.components.ChampyWithCard
import com.gg.spora.core.components.TopBarWithProgressBar
import com.gg.spora.ui.theme.SporaTheme

/**
 * Screen for mini games with Spora and progress bar
 * @param modifier: Modifier
 * @param onBackClick: Click listener for back button
 */
@Composable
fun MiniGameScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(R.drawable.fondo_minijuegos),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-260).dp)
        )
        Column(
            modifier = modifier
        ) {
            TopBarWithProgressBar(
                title = "Mini Game",
                onBackClick = onBackClick,
            )
            LinearProgressIndicator(
                progress = { 0.4f },
                gapSize = 0.dp,
                strokeCap = StrokeCap.Butt,
                color = Color(0xFFf58c0a),
                trackColor = Color(0xFFffeacc),
                modifier = Modifier
                    .height(24.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(MaterialTheme.shapes.large)
            )
            ChampyWithCard(
                modifier = Modifier.fillMaxSize(),
                champyImage = R.drawable.champy_sonriente_brazosalcuerpo,
            ) { }
        }
    }
}

@Preview
//@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MiniGameScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                onBackClick = { }
            )
        }
    }
}