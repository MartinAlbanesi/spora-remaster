package com.gg.spora.missions.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.library.LibraryScreen
import com.gg.spora.missions.domain.functions.getMissionIcon
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun MissionCompleted(
    modifier: Modifier = Modifier,
    missionText: String,
    @DrawableRes missionIcon: Int,
) {
    ListItem(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium),
        colors = ListItemDefaults.colors(
            containerColor = colorResource(id = R.color.secondary_30),
        ),
        leadingContent = {
            Image(
                painter = painterResource(id = missionIcon),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        },
        headlineContent = {
            Text(
                text = missionText,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        trailingContent = {
            Icon(
                Icons.Default.CheckCircleOutline,
                contentDescription = null,
                tint = colorResource(id = R.color.white),
                modifier = Modifier.size(40.dp)
            )
        }
    )
}

@Composable
fun MissionCompletedPopUp(
    modifier: Modifier = Modifier,
    showMissionCompleted: Boolean,
    missionText: String,
    @DrawableRes missionIcon: Int,
) {
    AnimatedVisibility(
        visible = showMissionCompleted,
        enter = slideInVertically {
            it
        },
        exit = slideOutVertically {
            it
        },
        modifier = modifier,
    ) {
        MissionCompleted(

            missionText = missionText,
            missionIcon = missionIcon
        )
    }
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MissionCompletePreview() {
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