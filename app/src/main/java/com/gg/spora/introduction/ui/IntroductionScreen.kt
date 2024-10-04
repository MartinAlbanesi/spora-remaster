package com.gg.spora.introduction.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun IntroductionScreen1(
    modifier: Modifier = Modifier,
    text: String = "Paginas",
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Image(
            painter = painterResource(id = R.drawable.fondo_introduccion),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_reborde_slogan),
                contentDescription = "Logo",
                Modifier
                    .size(350.dp)
                    .offset(y = (-50).dp),
                contentScale = ContentScale.Fit
            )

            SporaPrimaryButton(modifier, "Continuar") {
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroductionHorizontalPager(modifier: Modifier = Modifier) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = {
            3
        })

    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier.fillMaxWidth()) {
            HorizontalPager(state = pagerState) { page ->
                IntroductionScreen1(modifier)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
private fun IntroductionScreenPreview() {
    SporaTheme {
        IntroductionHorizontalPager(modifier = Modifier)
    }
}
