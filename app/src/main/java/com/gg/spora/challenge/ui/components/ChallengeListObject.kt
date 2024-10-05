package com.gg.spora.challenge.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.ui.theme.SporaTheme


//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MinigameQuizScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChallengeListObject(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                recyclerOptions = mapOf(
                    "Botella" to true,
                    "Caja" to null,
                    "Metal" to null,
                    "Nose" to null,
                )
            )
        }
    }
}