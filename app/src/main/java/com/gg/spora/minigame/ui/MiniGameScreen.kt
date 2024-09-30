package com.gg.spora.minigame.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.gg.spora.core.components.TopBarWithProgressBar
import com.gg.spora.ui.theme.SporaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiniGameScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        TopBarWithProgressBar(
            title = "Mini Game",
            onBackClick = { }
        )
        LinearProgressIndicator(
            progress = { 0.2f },
            gapSize = 0.dp,
            strokeCap = StrokeCap.Butt,
            modifier = Modifier
                .height(24.dp)
                .align(Alignment.CenterHorizontally)
                .clip(MaterialTheme.shapes.large)
        )
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
            MiniGameScreen()
        }
    }
}