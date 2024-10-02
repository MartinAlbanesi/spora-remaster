package com.gg.spora.challenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

/**
 * Screen for Challenge with the objects to scan
 * @param modifier: Modifier
 */
@Composable
fun ChallengeScannerScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(R.color.white),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = modifier
        ) {

        }
    }
}

@Preview
@Composable
private fun ChallengeScannerScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChallengeScannerScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}