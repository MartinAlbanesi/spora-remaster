package com.gg.spora.profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_perfil),
            contentDescription = "Profile Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBarWithTitleExitAndIcon(
                title = "Perfil",
                onBackClick = onBackClick,
                onSettingsClick = onSettingsClick,
                showIcon = false,
                showSettingsIcon = true
            )
            // Top section for additional information
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user_image),
                        contentDescription = "User Image",
                        modifier = Modifier.size(200.dp) 
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rectangle_profile),
                            contentDescription = "Rectangle Profile",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.matchParentSize()
                        )
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Username",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                            Text(
                                text = "Email",
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
            // Bottom section for achievements sign
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cartel_logros),
                    contentDescription = "Achievements Sign",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.matchParentSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "LOGROS",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 38.dp)
                    )
                    // Add your text here
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileScreen(
                onBackClick = {},
                onSettingsClick = {}
            )
        }
    }
}
