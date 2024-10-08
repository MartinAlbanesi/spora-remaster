package com.gg.spora.gameResultUI.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyWithRewards(
    modifier: Modifier = Modifier,
    champyImage: Int,
    oxygenAmount: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = champyImage),
            contentDescription = "Champy",
            modifier = Modifier.size(120.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.o2_icon),
                contentDescription = "Oxígeno",
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = "+ $oxygenAmount",
                fontSize = 24.sp,
                color = Color.White
            )
        }
    }
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun ChampyWithRewardsPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampyWithRewards(
                champyImage = R.drawable.champy_sonriente_idle,
                oxygenAmount = 20,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}