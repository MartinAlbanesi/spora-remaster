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
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.functions.getIsCompleteFromPreviousLevel
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun StageScreen(
    modifier: Modifier = Modifier,
    title: String,
    oxygen: Int,
    levels: List<Level>,
    backgroundImage: Int,
    pathLadder: List<Pair<Int,Int>>,
    onNavigateToChallenge: (String) -> Unit,
    onClickLevelItem: (Level, Boolean) -> Unit,
    popBackStack: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarWithO2Icon(
                title = title,
                firstLabel = oxygen.toString(),
                firstIcon = R.drawable.oxygen,
                showBackArrow = true,
                showIcon = false,
                onBackClick = {
                    popBackStack()
                },
            )
        }
    ) { paddingValue ->

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = backgroundImage),
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
                    LevelStageItem(
                        itemNumber = index.toString(),
                        starsState = level.starState,
                        stage = level.stageType,
                        isBlocked = !levels.getIsCompleteFromPreviousLevel(index),
                        modifier = Modifier
                            .offset(
                                x = pathLadder[index].first.dp,
                                y = pathLadder[index].second.dp
                            )
                            .clickable {
                                if(levels.getIsCompleteFromPreviousLevel(index)) onClickLevelItem(level, true)
                            }
                    )
                }
                item {
                    ChallengeStageItem(
                        stage = StageType.FOREST,
                        isBlocked = !levels.getIsCompleteFromPreviousLevel(levels.size),
                        modifier = Modifier
                            .offset(
                                x = pathLadder[levels.size].first.dp,
                                y = pathLadder[levels.size].second.dp
                            )
                            .clickable {
                                if(levels.getIsCompleteFromPreviousLevel(levels.size)) onNavigateToChallenge("Desafío")
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
                title = "Titi",
                levels = FakeStageModels.fakeLevels,
                backgroundImage = R.drawable.expo_proyecto_stage_background,
                pathLadder = SporaConstant.PATH_LADDER_EXPO,
                onNavigateToChallenge = {},
                popBackStack = {},
                onClickLevelItem = { _, _ -> }

            )
        }
    }
}