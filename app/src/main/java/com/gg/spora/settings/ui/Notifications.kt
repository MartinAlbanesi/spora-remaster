package com.gg.spora.settings.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun Notifications(
    onBackClick: () -> Unit
) {
    var switchState1 by remember { mutableStateOf(false) }
    var switchState2 by remember { mutableStateOf(false) }
    var switchState3 by remember { mutableStateOf(false) }
    var switchState4 by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.settings_fondo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TopBarWithTitleExitAndIcon(
                    title = "Notificaciones",
                    onBackClick = onBackClick,
                    showSettingsIcon = false,
                    showIcon = false
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .height(350.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rectangle_profile),
                            contentDescription = "Rectangle Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .matchParentSize()
                                .clip(RoundedCornerShape(16.dp))
                        )
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(16.dp)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            NotificationRow("Misión diaria", switchState1) { switchState1 = it }
                            Divider(color = Color.Black, thickness = 1.dp)
                            NotificationRow("Recompensa del árbol", switchState2) { switchState2 = it }
                            Divider(color = Color.Black, thickness = 1.dp)
                            NotificationRow("Recordatorio de juego", switchState3) { switchState3 = it }
                            Divider(color = Color.Black, thickness = 1.dp)
                            NotificationRow("Desactivar todas", switchState4) { switchState4 = it }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NotificationRow(text: String, switchState: Boolean, onSwitchChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Switch(
            checked = switchState,
            onCheckedChange = onSwitchChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Gray,
                uncheckedThumbColor = Color.Gray,
                checkedTrackColor = colorResource(id = R.color.primary)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationsPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Notifications(
                onBackClick = {}
            )
        }
    }
}
