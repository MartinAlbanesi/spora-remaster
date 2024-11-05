package com.gg.spora.settings.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.core.ui.components.SporaPrimaryButton

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.settings_fondo),
            contentDescription = "Settings Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopBarWithTitleExitAndIcon(
                title = "Opciones",
                onBackClick = onBackClick,
                onSettingsClick = onSettingsClick,
                showIcon = false,
                showSettingsIcon = false
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .height(200.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_profile),
                        contentDescription = "Rectangle Profile 1",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .matchParentSize()
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Usuario",
                                modifier = Modifier.weight(1f),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Divider(color = Color.Black, thickness = 1.dp)
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Editar Perfil", modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(id = R.drawable.next_icon),
                                contentDescription = "Next Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Divider(color = Color.Black, thickness = 1.dp)
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Notificaciones", modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(id = R.drawable.next_icon),
                                contentDescription = "Next Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .height(200.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_profile),
                        contentDescription = "Rectangle Profile 2",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .matchParentSize()
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Información",
                                modifier = Modifier.weight(1f),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Divider(color = Color.Black, thickness = 1.dp)
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Soporte", modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(id = R.drawable.next_icon),
                                contentDescription = "Next Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Divider(color = Color.Black, thickness = 1.dp)
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Sobre Nosotros", modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(id = R.drawable.next_icon),
                                contentDescription = "Next Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                SporaPrimaryButton(
                    text = "Cerrar sesión",
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SettingsScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            SettingsScreen(
                onBackClick = {},
                onSettingsClick = {}
            )
        }
    }
}