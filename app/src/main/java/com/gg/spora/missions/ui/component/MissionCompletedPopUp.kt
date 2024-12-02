package com.gg.spora.missions.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun MissionCompletedPopUp(
    modifier: Modifier = Modifier,
    showMissionCompleted: Boolean,
    missionText: String,
    @DrawableRes missionIcon: Int,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            visible = showMissionCompleted,
            enter = slideInVertically {
                it
            },
            exit = slideOutVertically {
                it
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            MissionCompleted(
                modifier = modifier,
                missionText = missionText,
                missionIcon = missionIcon
            )
        }
    }
}

@PreviewLightDark
//@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MissionCompletedPopUpPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MissionCompletedPopUp(
                modifier = Modifier,
                showMissionCompleted = true,
                missionText = "Plantar un árbol",
                missionIcon = R.drawable.trees_icon
            )
        }
    }
}