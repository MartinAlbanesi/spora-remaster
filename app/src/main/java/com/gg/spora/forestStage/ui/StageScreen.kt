package com.gg.spora.forestStage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.ui.components.ChallengeStageItem
import com.gg.spora.core.ui.components.LevelStageItem
import com.gg.spora.core.ui.components.TopAppBarWithO2Icon
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun StageScreen(
    modifier: Modifier = Modifier,
    oxygen: Int,
    levels: List<Level>,
    onNavigateToChallenge: (String) -> Unit,
    onClickLevelItem: (Level, Boolean) -> Unit,
    popBackStack: () -> Unit,
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
                    .fillMaxSize()
                    .padding(paddingValue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(40.dp),
            ) {
                itemsIndexed(
                    levels,
                    key = { _, level -> level.id }
                ) { index, level ->
//                    val navigateGame = when (level.typeGame) {
//                        TypeGame.QUIZ -> TypeGame.QUIZ
//                        TypeGame.RELATIONS -> TypeGame.RELATIONS
//                        TypeGame.QUIZ_IMAGE -> TypeGame.QUIZ_IMAGE
//                        TypeGame.CHALLENGE -> TypeGame.CHALLENGE
//                    }
                    LevelStageItem(
                        itemNumber = level.id,
                        starsState = level.starState,
                        stage = level.typeStage,
                        modifier = Modifier
                            .offset(x = SporaConstant.PATH_LADDER[index].dp)
                            .clickable {

                                onClickLevelItem(level, true)
                            }
                    )
                }
                item {
                    ChallengeStageItem(
                        stage = TypeStage.FOREST,
                        modifier = Modifier
                            .offset(x = SporaConstant.PATH_LADDER[levels.size].dp)
                            .clickable {
                                onNavigateToChallenge("Desafío")
                            }
                    )
                }
            }

        }
    }
}

@Preview
@Composable
private fun StageScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StageScreen(
                oxygen = 0,
                levels = FakeStageModels.fakeStage.levels,
                onNavigateToChallenge = {},
                popBackStack = {},
                onClickLevelItem = { _, _ -> }

            )
        }
    }
}