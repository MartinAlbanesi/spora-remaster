package com.gg.spora.minigameQuizImageUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R // Assuming this is the correct path to your resources
import com.gg.spora.core.components.SporaWithCard
import com.gg.spora.core.components.TopBarWithProgressBar
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun MinigameQuizImageScreen(
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
            SporaWithCard(
                modifier = Modifier.fillMaxSize(),
                sporaImage = R.drawable.champy_sonriente_idle,
            ) { }
        }
    }




}
    /*Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo_minijuegos),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.35f),
            contentScale = ContentScale.Crop
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.65f),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Card Content")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MinigameQuizImageScreen()
}*/

@Preview
@Composable
fun MinigameQuizImageScreenPreview() {
    MinigameQuizImageScreen(onBackClick = {})
}