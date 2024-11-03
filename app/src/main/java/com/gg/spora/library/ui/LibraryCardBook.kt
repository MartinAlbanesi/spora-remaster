package com.gg.spora.library.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarOnlyBackArrow
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.data.local.entity.InfoCardEntity
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun LibraryCardBook(
    cardList: List<InfoCardEntity>,
    category: StageType,
    unlockCard: () -> Unit,
    onBackClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.library_background_v3),
            contentDescription = "library background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .alpha(0.2f)
        )

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            TopAppBarOnlyBackArrow(
                modifier = Modifier,
                onBackClick = onBackClick,
                title = category.label
            )

            ListInfoCard(
                cardList = cardList,
                unlockCard = unlockCard
            )
        }

    }
}

@Composable
fun ListInfoCard(cardList: List<InfoCardEntity>, unlockCard: () -> Unit) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(150.dp),
        verticalItemSpacing = 12.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
    ) {
        items(cardList.size) {
            InfoCard(cardList[it], cardList[it].isUnlocked, unlockCard)
        }
    }

}


@Composable
fun InfoCard(
    card: InfoCardEntity,
    isUnlocked: Boolean = false,
    unlockCard: () -> Unit = {}
) {

    if (isUnlocked) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .width(200.dp)
                .height(300.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .clickable{
                        unlockCard()
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = card.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    modifier = Modifier.padding(top = 5.dp)
                )

                Image(
                    painter = painterResource(id = card.image),
                    contentDescription = "library card image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(top = 2.dp, end = 5.dp, start = 5.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
                )

                Text(
                    text = card.info,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(5.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    } else {

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .width(200.dp)
                .height(300.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sin aprender",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    modifier = Modifier.padding(top = 5.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.locked_level),
                    contentDescription = "library card image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(top = 80.dp)
                        .size(100.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCard() {

    SporaTheme {
        LibraryCardBook(
            cardList = FakeRepositoryInfoCard().getAllInfoCards(),
            unlockCard = {},
            category = StageType.FOREST
        )
    }

}