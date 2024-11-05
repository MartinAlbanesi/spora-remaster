package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun SporaWithCard(
    modifier: Modifier = Modifier,
    sporaImage: Int,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(sporaImage),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .offset(y = (35).dp)
        )
        Card(
            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {
            content()
        }

    }

}

@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun SporaWithCardPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SporaWithCard(
                modifier = Modifier.fillMaxSize(),
                sporaImage = R.drawable.champy_smiling_idle,
            ) {}
        }
    }
}