package com.gg.spora.missions.ui

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.ads.showRewardedAd
import com.gg.spora.missions.data.local.MissionModels
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.ui.component.MissionCard
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun MissionScreen(
    modifier: Modifier = Modifier,
    missions: List<Mission>,
    missionResetTime: String,
    onBack: () -> Unit,
    onClaimMission: (Byte, Byte) -> Unit
) {

    val context = LocalContext.current

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
            when(missions.size){
                0 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(color = colorResource(id = R.color.cream)),
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressIndicator()
                    }
                }
                else -> {
                    missions.forEach { mission ->
                        MissionCard(
                            mission = mission,
                            onClaimMission = { missionId, oxygenReward ->
                                if(missionId.toInt() == 0){
                                    showRewardedAd(
                                        context = context,
                                        onUserEarnedReward = { oxygen ->
                                            onClaimMission(missionId, oxygen)
                                        }
                                    )
                                }else{
                                    onClaimMission(missionId, oxygenReward)
                                }
                            },
                        )
                    }
                }
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