package com.gg.spora.gameResultUI.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyWithRewards(
    modifier: Modifier = Modifier,
    champyImage: Int,
    title: String,
    body: @Composable () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = champyImage),
            contentDescription = "Champy",
            modifier = Modifier.size(120.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black, offset = Offset(5f, 5f), blurRadius = 5f
                    )
                ),
            )
            body()
        }
    }
}

//@Composable
//fun ChampyWithRewards(
//    modifier: Modifier = Modifier,
//    champyImage: Int,
//    oxygenAmount: Int,
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier
//    ) {
//        Image(
//            painter = painterResource(id = champyImage),
//            contentDescription = "Champy",
//            modifier = Modifier.size(120.dp)
//        )
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.o2_icon),
//                contentDescription = "Oxígeno",
//                modifier = Modifier.size(48.dp)
//            )
//            Text(
//                text = "+ $oxygenAmount",
//                fontSize = 24.sp,
//                color = Color.White
//            )
//        }
//    }
//}

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
                modifier = Modifier.fillMaxWidth(),
                champyImage = R.drawable.champy_sonriente_idle,
                title = "Recompensa",
                body = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.o2_icon),
                            contentDescription = "Oxígeno",
                            modifier = Modifier.size(48.dp)
                        )
                        Text(
                            text = "+ $50",
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }
                }
            )
        }
    }
}