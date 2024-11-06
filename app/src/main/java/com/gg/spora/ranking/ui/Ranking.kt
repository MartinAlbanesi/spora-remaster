package com.gg.spora.ranking.ui
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon
import com.gg.spora.user.domain.models.User


@Composable
fun Ranking(
    modifier: Modifier = Modifier,
    userList: List<User>,
    currentUser: User?,
    onBackClick: () -> Unit,
) {
   // val rankingItems by viewModel.rankingItems.collectAsState()
    Image(
        painter = painterResource(id = R.drawable.ranking_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    Column(
        modifier = modifier
            .fillMaxSize()
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
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(0.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(450.dp)
        ) {
            itemsIndexed(userList) { index, item ->
                var numImage = 0
                if(item.id != currentUser!!.id){
                    numImage = index + 1
                }

                val imageRanking = when(numImage){
                    0 -> R.drawable.ranking_user
                    1 -> R.drawable.ranking_ore
                    2 -> R.drawable.ranking_plate
                    3 -> R.drawable.ranking_bronze
                    else -> {
                        R.drawable.ranking_sign
                    }
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
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(88.dp)
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
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
                        Spacer(
                            modifier = Modifier
                                .width(2.dp)
                                .height(65.dp)
                                .padding(bottom = 5.dp)
                                .background(Color.Black)
                        )
                        Image(
                            painter = painterResource(id = item.userImage),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(63.dp)
                                .padding(bottom = 5.dp, start = 5.dp)
                        )/*
                        Column(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .align(Alignment.Top)
                        ) {*/
                            Text(
                                text = item.userName,
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 2.dp)
                                    .padding(start = 10.dp)
                            )
                            /*Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 4.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.trees_icon),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = item.treesCount.toString(),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Black,
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                            }
                        }*/
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .padding(end = 15.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.oxygen_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = item.oxygen.toString(),
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 4.dp)
                            )
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
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.headlineLarge,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .width(2.dp)
                            .height(65.dp)
                            .padding(bottom = 5.dp)
                            .background(Color.Black)
                    )
                    Image(
                        painter = painterResource(id = currentUser?.userImage ?: R.drawable.spora_face_splash),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(63.dp)
                            .padding(bottom = 5.dp, start = 5.dp)
                    )
                    /*
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.Top) // Align to the top
                    ) {
*/
                        Text(
                            text = currentUser?.userName ?: "Usuario",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 4.dp)
                                .padding(start = 10.dp)
                        )
                    /*
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.trees_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = currentUser?.treesCount.toString(),
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }

                     */
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.oxygen_icon),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            text = currentUser?.oxygen.toString(),
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RankingPreview() {
    Ranking(
        userList = FakeUserModels.fakeUsers,
        onBackClick = {},
        currentUser = null
    )
}
