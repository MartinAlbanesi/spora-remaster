package com.gg.spora.areaBosque.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarWithO2Icon

@Composable
fun AreaBosqueScreen(
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            TopAppBarWithO2Icon(
                title = "Área Bosque",
                firstLabel = "10",
                firstIcon = R.drawable.o2,
                showBackArrow = true,
                onBackClick = {},
            )
        },
        modifier = Modifier
    ) { paddingValue ->
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.fondo_area1),
                contentDescription = "Area 1 background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )
        }

    }

}

@Composable
@Preview(showBackground = true)
fun PreviewAreaBosqueScreen() {
    AreaBosqueScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    )
}