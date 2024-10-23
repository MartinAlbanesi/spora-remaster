package com.gg.spora.gameResultUI

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
import com.gg.spora.core.ui.components.ChampyDialog
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getTotalOxygenFromStars
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun GameResultPopUp(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    backgroundImage: Int,
    starsState: StarState,
    rewards: List<Int>,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: () -> Unit,
) {

//    val (localRewards, totalOxygen) = getStarsRewards(starsState, rewards)

    val totalOxygen = getTotalOxygenFromStars(starsState, rewards)

    val champyImage = when (starsState) {
        StarState.ZERO -> R.drawable.champy_derrotado_brazosalcuerpo
        StarState.ONE -> R.drawable.champy_serio_idle
        StarState.TWO -> R.drawable.champy_sonriente_idle
        StarState.THREE -> R.drawable.champy_celebrando_brazoslevantados
    }

    ChampyDialog(
        modifier = modifier,
        backgroundImage = backgroundImage,
        champyImage = champyImage,
        title = "Recompensa",
        isVisible = isVisible,
        starsState = starsState,
        rewards = rewards,
        textPrimaryButton = if (starsState.starCount != 0) "Siguiente" else "Volver",
        textSecondaryButton = "Reiniciar",
        onClickPrimaryButton = onClickPrimaryButton,
        onClickSecondaryButton = onClickSecondaryButton,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.o2_icon),
                contentDescription = "Oxígeno",
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = "+ $totalOxygen",
                fontSize = 24.sp,
                color = Color.White,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black, offset = Offset(5f, 5f), blurRadius = 5f
                    )
                ),
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
            GameResultPopUp(
                isVisible = true,
                backgroundImage = R.drawable.fondo_minijuegos_crop,
                starsState = StarState.ONE,
                rewards = listOf(10, 20, 60),
                onClickPrimaryButton = {},
                onClickSecondaryButton = {},
            )
        }

    }
}