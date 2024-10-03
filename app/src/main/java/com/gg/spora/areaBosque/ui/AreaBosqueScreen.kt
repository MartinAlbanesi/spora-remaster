package com.gg.spora.areaBosque.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarWithO2Icon

@Composable
fun AreaBosqueScreen(
    modifier: Modifier = Modifier,
    o2 : Int
) {

    Scaffold(
        topBar = {
            TopAppBarWithO2Icon(
                title = "Área Bosque",
                firstLabel = o2.toString(),
                firstIcon = R.drawable.o2,
                showBackArrow = true,
                onBackClick = {},
            )
        }
    ) { paddingValue ->

        Box(modifier = Modifier.fillMaxSize()) {


            Image(
                painter = painterResource(id = R.drawable.fondo_area1),
                contentDescription = "Area 1 background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.nivel_bosque_0e),
                    contentDescription = "Area nivel 1",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(end = 70.dp)
                        .size(100.dp)
                        .clickable(enabled = true) {
                        /*Nav to area 1 screen*/
                        }
                )

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.nivel_desafio),
                    contentDescription = "Area desafio",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(end = 70.dp)
                        .size(100.dp)
                        .clickable(enabled = true) {
                        /*Nav to challenge screen*/
                        }
                )
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun PreviewAreaBosqueScreen() {
    AreaBosqueScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        o2 = 50
    )
}