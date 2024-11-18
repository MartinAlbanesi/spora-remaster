package com.gg.spora.grove.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.grove.utils.functions.formatTime

/**
 * Composable function for a button with an icon and a cooldown text.
 * @param text Text to display on the button.
 * @param icon Resource ID for the icon to display.
 * @param cooldownValue Current cooldown value in milliseconds.
 * @param cooldownType Maximum cooldown value in milliseconds.
 * @param onClick Action to perform when the button is clicked.
 */
@Composable
fun ButtonWithIcon(
    modifier: Modifier = Modifier,
    text: String = "",
    icon: Int,
    cooldownValue: Long?,
    cooldownType: Long,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = cooldownValue == 0L,
        contentPadding = PaddingValues(
            start = ButtonDefaults.ContentPadding.calculateStartPadding(LocalLayoutDirection.current),
            top = 1.dp,
            end = ButtonDefaults.ContentPadding.calculateEndPadding(LocalLayoutDirection.current),
            bottom = 1.dp
        )
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Image for the button",
            modifier = Modifier
                .size(32.dp)
        )

        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        if (cooldownValue != null) {
            if (cooldownValue >= 1000L && cooldownValue <= cooldownType) {
                Text(
                    text = formatTime(cooldownValue),
                    fontSize = 16.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            } else if (cooldownValue == 0L) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonWithIconPreview() {
    ButtonWithIcon(
        text = "Reclamar",
        icon = R.drawable.seed_reward,
        cooldownValue = 0L,
        cooldownType = 5000L,
        onClick = {}
    )
}