package com.gg.spora.challenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.ui.theme.SporaTheme

/**
 * Screen for objects to scan
 * @param modifier: Modifier
 * @param recyclerOptions: Objects in the list of challenge
 */
@Composable
fun ChallengeListObject(
    modifier: Modifier = Modifier,
    recyclerOptions: Map<String,Boolean?>,
) {
    var isSelectedAnswer by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        recyclerOptions.forEach {
            ButtonObjectScannerChallenge(
                textObject = it.key,
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = MaterialTheme.shapes.large,
                        ambientColor = DefaultShadowColor
                    )
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large)
                    .height(60.dp)
                    .clickable {
                        isSelectedAnswer = true
                    },
                isValidate = it.value
            )
        }
    }
}
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