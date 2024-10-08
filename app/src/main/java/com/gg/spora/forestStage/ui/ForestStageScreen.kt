package com.gg.spora.forestStage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import com.gg.spora.core.ui.components.LevelChallenge
import com.gg.spora.core.ui.components.LevelStage
import com.gg.spora.core.ui.components.TopAppBarWithO2Icon
import com.gg.spora.forestStage.domain.TypeStage

@Composable
fun ForestStageScreen(
    modifier: Modifier = Modifier,
    oxygen: Int,
    onNavigateToQuizGame: () -> Unit = {},
    onNavigateToChallenge: () -> Unit = {},
    onNavigateToQuizImage: () -> Unit = {}
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarWithO2Icon(
                title = "Área del Bosque",
                firstLabel = oxygen.toString(),
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

            ListOfLevels(
                modifier = Modifier,
                paddingValues = paddingValue,
                stage = TypeStage.FOREST,
                onNavigateToQuizGame = onNavigateToQuizGame,
                onNavigateToChallenge = onNavigateToChallenge,
                onNavigateToQuizImage = onNavigateToQuizImage
            )

        }
    }
}

@Composable
fun ListOfLevels(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    stage: TypeStage,
    onNavigateToQuizGame: () -> Unit = {},
    onNavigateToChallenge: () -> Unit = {},
    onNavigateToQuizImage: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        LevelStage(
            number = 1,
            0,
            false,
            stage,
            modifier = Modifier.clickable {
                onNavigateToQuizGame()
            }
        )
        Spacer(modifier = Modifier.height(40.dp))

        LevelStage(
            2,
            0,
            false,
            stage,
            modifier.offset(x = (-10).dp).clickable {
                onNavigateToQuizImage()
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        LevelStage(
            3,
            0,
            false,
            stage,
            modifier.offset(x = (40).dp).clickable {
                /*Nav to minigame 3*/
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        LevelChallenge(
            modifier
                .offset(x = 90.dp),
            onClick = onNavigateToChallenge,
        )
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewAreaBosqueScreen() {
    ForestStageScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        oxygen = 0
    )
}