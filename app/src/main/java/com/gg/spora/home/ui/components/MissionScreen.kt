package com.gg.spora.home.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
    missionResetTime: String,
    onBack: () -> Unit,
    onClaimMission: (Byte, Byte) -> Unit
) {
    Box(modifier = modifier){
        Column(
//            modifier = modifier
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(RoundedCornerShape(14.dp, 14.dp, 0.dp, 0.dp))
//                    .height(48.dp)
                    .background(color = colorResource(id = R.color.primary))
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Misiones Diarias",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
//                        .fillMaxSize()
//                        .fillMaxWidth()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
                Text(text = missionResetTime)
            }
            missions.forEach { mission ->
                MissionCard(
                    mission = mission,
                    onClaimMission = onClaimMission,
                )
            }
        }

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = colorResource(id = R.color.primary_10),
                modifier = Modifier
                    .size(40.dp)
            )
        }
    }

}

@Composable
fun MissionCard(
    modifier: Modifier = Modifier,
    mission: Mission,
    onClaimMission: (Byte, Byte) -> Unit
) {

    val icon = when (mission.id) {
        MissionType.LIBRARY_MISSION.missionId -> R.drawable.mushy_idle
        MissionType.MINI_GAME_MISSION.missionId -> R.drawable.challenge_level
        else -> R.drawable.tutorial_seed
    }

    val textColor =
        if (mission.isCompleted || mission.isClaimed) colorResource(id = R.color.white) else colorResource(id = R.color.primary_10)

    val backgroundColor =
        if (!mission.isCompleted && !mission.isClaimed) colorResource(id = R.color.cream) else colorResource(id = R.color.secondary_30)

    val progressIndicator by animateFloatAsState(
        targetValue = scalarNumber(
            valor = mission.counter.toInt(),
            maxOriginal = mission.objective.toInt()
        ),
        label = "progressIndicator",
    )

    ListItem(
        colors = ListItemDefaults.colors(
            containerColor = backgroundColor,
        ),
        modifier = modifier,
        overlineContent = {
            if (!mission.isClaimed) {
                Text(
                    text = mission.text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                )
            }
        },
        headlineContent = {
            if (mission.isClaimed) {
                Text(
                    text = mission.text,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                )
            } else {
                if (mission.isCompleted) {
                    Button(
                        onClick = {
                            onClaimMission(mission.id, mission.oxygenReward)
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = textColor,
                            containerColor = colorResource(R.color.secondary)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Reclamar",
                            color = colorResource(R.color.white),
                            fontSize = 16.sp
                        )
                    }
                } else {
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
                }
            }
        },
        supportingContent = {
            if (!mission.isClaimed) {
                if (!mission.isCompleted) {
                    Text(
                        text = "${mission.counter}/${mission.objective}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        },
        leadingContent = {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        },
        trailingContent = {
            if(mission.isClaimed) {
                Icon(
                    Icons.Default.CheckCircleOutline,
                    contentDescription = null,
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier.size(40.dp)
                )
            }else{
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
                        color = textColor,
                    )
                }
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
                missionResetTime = "12h 00m 00s",
                onBack = {},
                onClaimMission = { _, _ -> }
            )
        }
    }
}