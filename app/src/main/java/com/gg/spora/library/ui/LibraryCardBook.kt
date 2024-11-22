package com.gg.spora.library.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarOnlyBackArrow
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.local.entity.InfoCardEntity
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun LibraryCardBook(
    cardList: List<InfoCardEntity>,
    category: StageType,
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


            LibraryCarouselInfoCard(
                cardList = cardList.map { it.toInfoCard() }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {

    SporaTheme {

        LibraryCardBook(
            cardList = FakeRepositoryInfoCard().getAllInfoCards(),
            category = StageType.FOREST
        )
    }

}

