package com.gg.spora.ranking.ui
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gg.spora.R
import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon
import com.gg.spora.user.domain.models.User
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import kotlinx.coroutines.delay
import java.time.Duration


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Ranking(
    modifier: Modifier = Modifier,
    userList: List<User>,
    currentUser: User?,
    onBackClick: () -> Unit,
    viewModel: RankingViewModel = hiltViewModel()
) {
    val timeUntilReset by viewModel.timeUntilReset.collectAsState()
    var imageRanking = R.drawable.ranking_sign

    var remainingTime by remember { mutableStateOf(timeUntilReset) }

    LaunchedEffect(Unit) {
        while (true) {
            remainingTime = viewModel.calculateTimeUntilNextMonday()
            delay(1000L)
        }
    }

    Image(
        painter = painterResource(id = R.drawable.ranking_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopBarWithTitleExitAndIcon(
            title = "Ranking",
            onBackClick = onBackClick,
            showIcon = false
        )

        Text(
            text = "¡Competí por oxígeno para quedar entre los primeros y ganar un logro!",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            Text(
                text = "Tiempo hasta el reinicio: ${remainingTime.toHours()}h ${remainingTime.toMinutesPart()}m ${remainingTime.toSecondsPart()}s",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(0.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(450.dp)
        ) {
            currentUser?.let{
                itemsIndexed(userList) { index, item ->
                    var numImage = 0
                    if (item.id != currentUser.id) {
                        numImage = index + 1
                    }

                    imageRanking = when (numImage) {
                        0 -> R.drawable.ranking_user
                        1 -> R.drawable.ranking_ore
                        2 -> R.drawable.ranking_plate
                        3 -> R.drawable.ranking_bronze
                        else -> R.drawable.ranking_sign
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = imageRanking),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.matchParentSize()
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 8.dp, end = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(88.dp)
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                if (item.oxygen == 0) {
                                    Text(
                                        text = "",
                                        style = MaterialTheme.typography.headlineLarge,
                                        color = Color.Black,
                                        textAlign = TextAlign.Center
                                    )
                                } else {
                                    when (index) {
                                        0 -> Image(
                                            painter = painterResource(id = R.drawable.medalladeoro),
                                            contentDescription = null,
                                            modifier = Modifier.size(66.dp)
                                        )
                                        1 -> Image(
                                            painter = painterResource(id = R.drawable.medalladeplata),
                                            contentDescription = null,
                                            modifier = Modifier.size(66.dp)
                                        )
                                        2 -> Image(
                                            painter = painterResource(id = R.drawable.medalladebronce),
                                            contentDescription = null,
                                            modifier = Modifier.size(66.dp)
                                        )
                                        else -> Text(
                                            text = (index + 1).toString(),
                                            style = MaterialTheme.typography.headlineLarge,
                                            color = Color.Black,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                            Spacer(
                                modifier = Modifier
                                    .width(2.dp)
                                    .height(65.dp)
                                    .padding(bottom = 5.dp)
                                    .background(Color.Black)
                            )

                            SubcomposeAsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(item.userImage)
                                    .placeholder(R.drawable.user_image)
                                    .build(),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                loading = {
                                    CircularProgressIndicator(
                                        modifier = Modifier
                                            .size(44.dp)
                                            .align(Alignment.TopCenter)
                                    )
                                },
                                modifier = Modifier
                                    .size(63.dp)
                                    .padding(bottom = 5.dp, start = 8.dp)
                            )

                            Column(
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .width(130.dp)
                            ) {
                                Text(
                                    text = item.userName,
                                    style = if (item.userName.count() > 12) {
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
                                    text = item.email,
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
                                    .padding(end = 8.dp)
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
                                        text = item.oxygen.toString(),
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

        Spacer(modifier = Modifier.height(10.dp))

        // Sección "Tu puntaje"
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tu puntaje",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
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
                        .padding(end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .width(88.dp)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        if (currentUser?.oxygen == 0) {
                            Text(
                                text = "",
                                style = MaterialTheme.typography.headlineLarge,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        } else {
                            var index = -1
                            userList.forEachIndexed { i, user ->
                                if (currentUser?.id == user.id) {
                                    index = i
                                }
                            }
                            when (index) {
                                0 -> Image(
                                    painter = painterResource(id = R.drawable.medalladeoro),
                                    contentDescription = null,
                                    modifier = Modifier.size(66.dp)
                                )
                                1 -> Image(
                                    painter = painterResource(id = R.drawable.medalladeplata),
                                    contentDescription = null,
                                    modifier = Modifier.size(66.dp)
                                )
                                2 -> Image(
                                    painter = painterResource(id = R.drawable.medalladebronce),
                                    contentDescription = null,
                                    modifier = Modifier.size(66.dp)
                                )
                                else -> Text(
                                    text = (index + 1).toString(),
                                    style = MaterialTheme.typography.headlineLarge,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
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
                            .data(currentUser?.userImage)
                            .placeholder(R.drawable.user_image)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(63.dp)
                            .padding(bottom = 5.dp, start = 8.dp)
                    )

                    var userName = "Usuario"
                    if (currentUser?.userName != null) {
                        userName = currentUser.userName
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
                            text = currentUser?.email ?: "",
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
                                text = currentUser?.oxygen.toString(),
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

@Preview
@Composable
fun RankingPreview() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Ranking(
            userList = FakeUserModels.fakeUsers,
            onBackClick = {},
            currentUser = null,
        )
    }
}
