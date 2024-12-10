package com.gg.spora.library.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.gg.spora.R
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.library.domain.model.InfoCard
import com.gg.spora.ui.theme.SporaTheme
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

fun calculateCurrentOffsetForPage(page: Int, currentPage: Int, currentPageOffset: Float): Float {
    return (currentPage - page) + currentPageOffset
}

@Composable
fun LibraryCarouselInfoCard(
    modifier : Modifier = Modifier,
    cardList: List<InfoCard>
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { cardList.size }
    )

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        InfoCardCountCollection(
            pager = pagerState,
            listSize = cardList.size
        )

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 65.dp),
            modifier = Modifier.height(400.dp)
        ) { page ->
            InfoCardCarousel(
                card = cardList[page],
                page = page,
                isUnlocked = cardList[page].isUnlocked,
                pagerState = pagerState
            )
        }

        Row(
            Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(cardList.size) {

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(if (pagerState.currentPage == it) 30.dp else 20.dp)
                        .background(color = if (pagerState.currentPage == it) MaterialTheme.colorScheme.primary else Color.Gray)
                        .clickable {
                            scope.launch {
                                pagerState.animateScrollToPage(it)
                            }
                        }
                )

                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    }
}

@Composable
fun InfoCardCarousel(
    card: InfoCard,
    isUnlocked: Boolean = false,
    page: Int,
    pagerState: PagerState
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isUnlocked) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(300.dp)
            .height(450.dp)
            .graphicsLayer {
                val pageOffset =
                    calculateCurrentOffsetForPage(
                        page,
                        currentPage = pagerState.currentPage,
                        currentPageOffset = pagerState.currentPageOffsetFraction
                    ).absoluteValue
                lerp(
                    start = 0.85f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }
                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                )
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {

        Text(
            text = if (isUnlocked) card.title else "Bloqueado",
            fontSize = 26.sp,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .padding(top = 10.dp, end = 5.dp, start = 5.dp)
                .align(Alignment.CenterHorizontally)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            if (isUnlocked) {

                Spacer(modifier = Modifier.height(20.dp))

                SubcomposeAsyncImage(
                    model =
                    ImageRequest.Builder(LocalContext.current)
                        .data(card.image)
//                        .placeholder(R.drawable.spora_face_splash)
                        .error(R.drawable.champy_defeated_arms_body)
                        .build(),
                    contentDescription = "library card image",
                    contentScale = ContentScale.FillBounds,
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(44.dp)
                                .align(Alignment.TopCenter)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(top = 2.dp, end = 5.dp, start = 5.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
                )

                Text(
                    text = card.info,
                    fontSize = 22.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(10.dp)
                        .scrollable(
                            state = rememberScrollState(),
                            orientation = Orientation.Vertical
                        ),
                    textAlign = TextAlign.Center
                )

            } else {

                Spacer(modifier = Modifier.height(50.dp))

                Image(
                    painter = painterResource(id = R.drawable.locked_level),
                    contentDescription = "library card image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
                )
            }
        }
    }
}


@Composable
fun InfoCardCountCollection(pager: PagerState, listSize: Int) {

    Row(
        Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = "${pager.currentPage + 1} / $listSize",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )
    }

}
@Preview
@Composable
fun PreviewCarousel() {

    SporaTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) { }
        LibraryCarouselInfoCard(
            cardList = FakeRepositoryInfoCard().getAllInfoCards().map { it.toInfoCard() }
        )
    }
}
