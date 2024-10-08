package com.gg.spora.forestStage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.fake.FakeLevelModels
import com.gg.spora.core.ui.components.ChampyDialog
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun LevelPreview(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    backgroundImage: Int,
//    levelName: String,
//    levelArea: String,
//    requiredOxygen: Int,
//    rewards: List<Int>,
//    starsState: StarState,
    level: Level,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: () -> Unit,
) {

//    val totalOxygen = getTotalOxygenFromStars(starsState, rewards)

    val champyImage = R.drawable.champy_sonriente_idle

    ChampyDialog(
        modifier = modifier,
        backgroundImage = backgroundImage,
        champyImage = champyImage,
        title = "${level.levelName} - ${level.stageType.label}",
        isVisible = isVisible,
        starsState = level.starState,
        rewards = level.rewardsOxygen,
        textPrimaryButton = "Jugar",
        textSecondaryButton = "Cancelar",
        onClickPrimaryButton = onClickPrimaryButton,
        onClickSecondaryButton = onClickSecondaryButton,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Requisito: ${level.requiredOxygen}",
                fontSize = 24.sp,
                color = Color.White
            )
            Image(
                painter = painterResource(id = R.drawable.o2_icon),
                contentDescription = "Oxígeno",
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameResultPopupPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LevelPreview(
                isVisible = true,
                backgroundImage = R.drawable.fondo_minijuegos_crop,
//                levelName = "Nivel 1",
//                levelArea = "Bosque",
//                requiredOxygen = 100,
//                starsState = StarState.STAR_ZERO,
//                rewards = listOf(10, 20, 30),
                level = FakeLevelModels.fakeLevels.first(),
                onClickPrimaryButton = {},
                onClickSecondaryButton = {},
            )
        }

    }
}