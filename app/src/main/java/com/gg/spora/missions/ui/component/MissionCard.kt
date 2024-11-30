package com.gg.spora.missions.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
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
import com.gg.spora.core.utils.functions.calculateProgress
import com.gg.spora.missions.domain.functions.getMissionIcon
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun MissionCard(
    modifier: Modifier = Modifier,
    mission: Mission,
    onClaimMission: (Byte, Byte) -> Unit
) {

    val icon = getMissionIcon(mission.id)

    val textColor = when {
        mission.isCompleted || mission.isClaimed -> colorResource(id = R.color.white)
        else -> colorResource(id = R.color.primary_10)
    }

    val backgroundColor = when {
        mission.isCompleted || mission.isClaimed -> colorResource(id = R.color.secondary_30)
        else -> colorResource(id = R.color.cream)
    }

    val progressIndicator by animateFloatAsState(
        targetValue = calculateProgress(
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
            when {
                mission.isClaimed -> ClaimedMissionText(mission.text, textColor)
                mission.isCompleted -> ClaimMissionButton(mission.id, mission.oxygenReward, textColor, onClaimMission)
                else -> MissionProgressIndicator(progressIndicator)
            }
        },
        supportingContent = {
            if (!mission.isClaimed && !mission.isCompleted) {
                Text(
                    text = "${mission.counter}/${mission.objective}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
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

@Composable
private fun ClaimedMissionText(missionText: String, textColor: Color) {
    Text(
        text = missionText,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = textColor,
    )
}

@Composable
private fun ClaimMissionButton(
    missionId: Byte,
    missionOxygenReward: Byte,
    textColor: Color,
    onClaimMission: (Byte, Byte) -> Unit
) {
    Button(
        onClick = { onClaimMission(missionId, missionOxygenReward) },
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
}

@Composable
private fun MissionProgressIndicator(progressIndicator: Float) {
    LinearProgressIndicator(
        progress = { progressIndicator },
        gapSize = 0.dp,
        strokeCap = StrokeCap.Butt,
        color = colorResource(R.color.secondary),
        trackColor = colorResource(R.color.primary),
        modifier = Modifier
            .height(24.dp)
            .clip(MaterialTheme.shapes.large)
    )
}

@PreviewLightDark
//@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun MissionCardPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MissionCard(
                modifier = Modifier,
                mission = Mission(
                    id = 1,
                    text = "Misión 1",
                    objective = 10,
                    counter = 5,
                    oxygenReward = 5,
                    isCompleted = false,
                    isClaimed = true
                ),
                onClaimMission = { _, _ -> }
            )
        }
    }
}