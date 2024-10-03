package com.gg.spora.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarWithDualIcon
import com.gg.spora.home.ui.components.ImageWithTextVertical
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    /*
    val leftIcons = listOf(
        ImageWithTextVertical(
            image = R.drawable.profile_icon,
            text = "Perfil"
        ),
        ImageWithTextVertical(
            image = R.drawable.ranking_icon,
            text = "Ranking"
        ),
        ImageWithTextVertical(
            image = R.drawable.missions_icon,
            text = "Misiones"
        ),
    )
     */

    Scaffold(
        topBar = {
            TopAppBarWithDualIcon(
                firstLabel = "12",
                firstIcon = R.drawable.trees_icon,
                secondLabel = "465",
                secondIcon = R.drawable.o2_icon,
                showBackArrow = false,
            )
        },
        modifier = modifier
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo_home),
                contentDescription = "Home Background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
            )
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 8.dp,
                )
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(top = paddingValue.calculateTopPadding(), start = 8.dp, end = 8.dp)
            ) {
                item {
                    ImageWithTextVertical(
                        image = R.drawable.profile_icon,
                        text = "Perfil"
                    )
                }
                item {
                    ImageWithTextVertical(
                        image = R.drawable.ranking_icon,
                        text = "Ranking"
                    )
                }
                item {
                    ImageWithTextVertical(
                        image = R.drawable.missions_icon,
                        text = "Misiones"
                    )
                }
                item {
                    ImageWithTextVertical(
                        image = R.drawable.grove_icon,
                        text = "Arboleda"
                    )
                }
                item {
                    ImageWithTextVertical(
                        image = R.drawable.eco_diary_icon,
                        text = "Diario"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MiniGameScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}