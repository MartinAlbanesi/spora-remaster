package com.gg.spora.gameResultUI.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun StarWithOxygen(
    modifier: Modifier = Modifier,
    starImage: Int,
    oxygenAmount: Int,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = starImage),
            contentDescription = "Estrella",
            modifier = Modifier.size(96.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.o2),
                contentDescription = "Oxígeno",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "+$oxygenAmount",
                fontSize = 16.sp,
            )
        }
    }
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun StarWithOxygenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StarWithOxygen(
                oxygenAmount = 10,
                starImage = R.drawable.estrella,
                modifier = Modifier.offset(y = (-16).dp)
            )
        }
    }
}