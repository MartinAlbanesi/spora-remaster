package com.gg.spora.grove.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import com.gg.spora.grove.ui.components.TreeImage
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun GroveScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBarWithDualIcon(
                firstLabel = "12",
                firstIcon = R.drawable.trees_icon,
                secondLabel = "465",
                secondIcon = R.drawable.o2_icon,
                showBackArrow = true,
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
                painter = painterResource(id = R.drawable.fondo_generico_sin_pasto),
                contentDescription = "Grove Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
        }

        // Screen Content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValue.calculateTopPadding())
        ) {
            // Seed Tree Row
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = -150.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                TreeImage(image = R.drawable.arbol_madre_detras, size = 110.dp)
                Spacer(modifier = Modifier.weight(1f))
                TreeImage(image = R.drawable.arbol_madre_detras, size = 180.dp)
                Spacer(modifier = Modifier.weight(1f))
                TreeImage(image = R.drawable.arbol_madre_detras, size = 110.dp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GrovePreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GroveScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}