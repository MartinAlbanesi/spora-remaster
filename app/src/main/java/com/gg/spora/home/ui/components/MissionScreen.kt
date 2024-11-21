package com.gg.spora.home.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.utils.functions.scalarNumber
import com.gg.spora.missions.data.local.MissionModels
import com.gg.spora.missions.domain.enums.MissionType
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun MissionScreen(
    modifier: Modifier = Modifier,
    missions: List<Mission>,
    onBack: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(14.dp, 14.dp, 0.dp, 0.dp))
                .height(48.dp)
                .background(color = colorResource(id = R.color.primary))
                .fillMaxWidth()
        ) {
            Text(
                text = "Missiones Diarias",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
//            Text(text = "12:00:00")
        }
        missions.forEach { mission ->
            MissionCard(
                mission = mission
            )
        }
    }
}

@Composable
fun MissionCard(
    modifier: Modifier = Modifier,
    mission: Mission
) {

    val icon = when(mission.id){
        MissionType.LIBRARY_MISSION.missionId -> R.drawable.mushy_idle
        MissionType.MINI_GAME_MISSION.missionId -> R.drawable.challenge_level
        else -> R.drawable.tutorial_seed
    }

    val progressIndicator by animateFloatAsState(
        targetValue = scalarNumber(valor = mission.counter.toInt(), maxOriginal = mission.objective.toInt()),
        label = "progressIndicator",
    )

    ListItem(
        colors = ListItemDefaults.colors(
            containerColor = colorResource(id = R.color.cream),
        ),
        modifier = modifier,
        overlineContent = {
            Text(
                text = mission.text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        },
        headlineContent = {
            LinearProgressIndicator(
                progress = { progressIndicator },
                gapSize = 0.dp,
                strokeCap = StrokeCap.Butt,
                color = colorResource(R.color.secondary),
                trackColor = colorResource(R.color.primary),
                modifier = Modifier
                    .height(24.dp)
//                    .align(Alignment.CenterHorizontally)
                    .clip(MaterialTheme.shapes.large)
            )
        },
        supportingContent = {
            Text(
                text = "${mission.counter}/${mission.objective}",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        leadingContent = {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        },
        trailingContent = {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.oxygen_icon),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "x${mission.oxygenReward}",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
    )
}

@PreviewLightDark
//@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MissionScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MissionScreen(
                modifier = Modifier.fillMaxWidth(0.6f),
                missions = MissionModels.fakeMissions,
                onBack = {}
            )
        }
    }
}