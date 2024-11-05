package com.gg.spora.stage.ui

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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.ui.components.ChampyDialog
import com.gg.spora.stage.domain.model.Level
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun LevelPreview(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    backgroundImage: Int,
    level: Level,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: () -> Unit,
) {

    val champyImage = R.drawable.champy_smiling_idle

    ChampyDialog(
        modifier = modifier,
        backgroundImage = backgroundImage,
        champyImage = champyImage,
        title = "${level.levelName} - ${level.stageType.label}",
        isVisible = isVisible,
        starsState = level.starState,
        rewards = level.rewardsOxygen.map { it.toInt() },
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
                color = Color.White,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black, offset = Offset(5f, 5f), blurRadius = 5f
                    )
                ),
            )
            Image(
                painter = painterResource(id = R.drawable.oxygen_icon),
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
                backgroundImage = R.drawable.minigame_background_crop,
                level = FakeStageModels.fakeLevels.first(),
                onClickPrimaryButton = {},
                onClickSecondaryButton = {},
            )
        }

    }
}