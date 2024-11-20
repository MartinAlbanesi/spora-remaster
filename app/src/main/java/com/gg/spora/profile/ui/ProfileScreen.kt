// ProfileScreen.kt
package com.gg.spora.profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.gg.spora.user.domain.models.User

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit,
   //
//    currentIndex: Int = 0,
    user: User?,
//    onLeftArrowClick: () -> Unit,
//    onRightArrowClick: () -> Unit
) {
   // val currentIndex by viewModel.currentIndex.collectAsState()
//    val images = listOf(
//        R.drawable.logro_semilla,
//        R.drawable.plastic_bottle,
//        R.drawable.spora_logo_without_slogan
//    )

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
                                text = user?.userName ?: "User Name",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                            Text(
                                text = user?.email ?: "email",
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }

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
                        text = "PRÓXIMAMENTE",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 45.dp)
                    )
                    // descomentar para habilitar la funcionalidad de los botones de cambio de logro
                    /*
                    Row(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 80.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.left_arrow),
                            contentDescription = "Left Arrow",
                            modifier = Modifier
                                .size(88.dp)
                                .clickable {
                                    onLeftArrowClick()
                                }
                        )
                        Image(
                            painter = painterResource(id = images[currentIndex]),
                            contentDescription = "Achievement Image",
                            modifier = Modifier.size(180.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "Right Arrow",
                            modifier = Modifier
                                .size(88.dp)
                                .clickable {
                                   onRightArrowClick()
                                }
                        )*/
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
                onSettingsClick = {},
                user = User(
                    userName = "User Name",
                    email = "email",
                    oxygen = 0,
                    levelsCompleted = emptyList(),
                    id = "id",
                    treesCount = 0,
                    userImage = R.drawable.spora_face_splash
                ),
//                onLeftArrowClick = {},
//                onRightArrowClick = {}
            )
        }
    }
}
