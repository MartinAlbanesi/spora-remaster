package com.gg.spora.forestStage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.QuestionType
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.domain.model.Level

@Composable
fun StageScreen(
    modifier: Modifier = Modifier,
    oxygen: Int,
    levels: List<Level>,
    onNavigateToQuizGame: () -> Unit = {},
    onNavigateToChallenge: () -> Unit = {},
    onNavigateToQuizImage: () -> Unit = {},
    onNavigateToRelationsGame: () -> Unit = {},
    popBackStack: () -> Unit = {},
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarWithO2Icon(
                title = "Área del Bosque",
                firstLabel = oxygen.toString(),
                firstIcon = R.drawable.o2,
                showBackArrow = true,
                onBackClick = {
                    popBackStack()
                },
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

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(40.dp),
            ) {
                itemsIndexed(
                    levels,
                    key = { _, level -> level.id }
                ){ index, level ->
                    val navigateGame = when(level.questionType) {
                        QuestionType.QUIZ -> onNavigateToQuizGame
                        QuestionType.RELATIONS -> onNavigateToRelationsGame
                        QuestionType.QUIZ_IMAGE -> onNavigateToQuizImage
                        QuestionType.CHALLENGE -> TODO()
                    }

                    LevelStage(
                        number = index,
                        stars = level.starState.starCount,
                        blocked = false,
                        level.stageType,
                        modifier = Modifier
                            .offset(x = SporaConstant.PATH_LADDER[index].dp)
                            .clickable {
                            navigateGame()
                        }
                    )
                }
                item{
                    LevelChallenge(
                        modifier
                            .offset(x = 50.dp),
                        onClick = onNavigateToChallenge,
                    )
                }
            }

        }
    }
}

@Composable
fun ListOfLevels(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    stage: StageType,
    onNavigateToQuizGame: () -> Unit = {},
    onNavigateToChallenge: () -> Unit = {},
    onNavigateToQuizImage: () -> Unit = {},
    onNavigateToRelationsGame: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp),
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

        LevelStage(
            2,
            0,
            false,
            stage,
            modifier
                .offset(x = (-10).dp)
                .clickable {
                    onNavigateToQuizImage()
                }
        )
        LevelStage(
            3,
            0,
            false,
            stage,
            modifier
                .offset(x = (30).dp)
                .clickable {
                    onNavigateToRelationsGame()
                }
        )

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
//    StageScreen(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.background),
//        oxygen = 0
//    )
}