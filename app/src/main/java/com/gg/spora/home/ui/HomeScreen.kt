package com.gg.spora.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarWithDualIcon
import com.gg.spora.core.ui.modifiers.ModifierStyle
import com.gg.spora.home.ui.components.ImageWithTextVertical
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {

    // Icons in the left
    val leftIcons = mapOf(
        R.drawable.profile_icon to "Perfil",
        R.drawable.ranking_icon to "Ranking",
        R.drawable.missions_icon to "Misiones",
    )

    // Icons in the right
    val rightIcons = mapOf(
        R.drawable.eco_diary_icon to "Diario",
        R.drawable.grove_icon to "Arboleda",
    )

    Scaffold(
        topBar = {
            TopAppBarWithDualIcon(
                firstLabel = "12",
                firstIcon = R.drawable.trees_icon,
                secondLabel = "465",
                secondIcon = R.drawable.o2_icon,
                showBackArrow = false,
                modifier = ModifierStyle.brush
            )
        },
        modifier = modifier
    ) { paddingValue ->

        // Screen Background
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

        // Screen Content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValue.calculateTopPadding(), start = 8.dp, end = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                leftIcons.forEach { (image, text) ->
                    ImageWithTextVertical(
                        image = image,
                        text = text,
                        modifier = Modifier,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                rightIcons.forEach { (image, text) ->
                    ImageWithTextVertical(
                        image = image,
                        text = text,
                        modifier = Modifier,
                    )
                }
            }
        }

        // Forest Sign Button
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.forest_sign),
                contentDescription = "Forest Sign",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .size(140.dp)
                    .offset(y = -40.dp, x = -80.dp)
            )
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