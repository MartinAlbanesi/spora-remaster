// ProfileScreen.kt
package com.gg.spora.profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarOnlyBackArrow
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
    userPosition: Int
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
            TopAppBarOnlyBackArrow(
                title = "Perfil",
                onBackClick = onBackClick,
                showSettingsIcon = true,
                onSettingsClick = onSettingsClick
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
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(user?.userImage ?: "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_smile.png?alt=media&token=332929a3-a86a-4a8c-834e-28bccc40fe36")
                            .placeholder(R.drawable.user_image)
                            .build(),
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
                        text = "Posición actual",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 45.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 130.dp)
                            .height(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ranking_user),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.matchParentSize()
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp)
                                ,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(88.dp)
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = userPosition.toString(),
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(
                                modifier = Modifier
                                    .width(2.dp)
                                    .height(65.dp)
                                    .padding(bottom = 5.dp)
                                    .background(Color.Black)
                            )
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(user?.userImage)
                                    .placeholder(R.drawable.user_image)
                                    .build(),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(63.dp)
                                    .padding(bottom = 5.dp, start = 8.dp)
                            )

                            var userName = "Usuario"
                            if (user?.userName != null) {
                                userName = user.userName
                            }
                            Column(
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .width(130.dp)
                            ) {
                                Text(
                                    text = userName,
                                    style = if (userName.count() > 12) {
                                        MaterialTheme.typography.titleSmall
                                    } else {
                                        MaterialTheme.typography.titleMedium
                                    },
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Black,
                                    modifier = Modifier
                                        .padding(bottom = 2.dp)
                                )
                                Text(
                                    text = user?.email ?: "",
                                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                                    color = Color.Black,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .padding(bottom = 20.dp)
                                )
                            }

                            Spacer(modifier = Modifier.padding(end = 8.dp))
                            Box(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .width(75.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.oxygen_icon),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Text(
                                        text = user?.oxygen.toString(),
                                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 16.sp),
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.Black,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }
                            }
                        }
                    }
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
                    userImage = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_smile.png?alt=media&token=332929a3-a86a-4a8c-834e-28bccc40fe36",
                    weeklyOxygen = 0
                ),
                userPosition = 0
//                onLeftArrowClick = {},
//                onRightArrowClick = {}

            )
        }
    }
}
