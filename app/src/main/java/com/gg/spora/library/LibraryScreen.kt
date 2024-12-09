package com.gg.spora.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gg.spora.R
import com.gg.spora.core.ads.BannerAd
import com.gg.spora.core.ui.animations.MushyBlinkAnimation
import com.gg.spora.core.ui.components.TopBarWithLeadingAndTrailingIcon


@Preview(showBackground = true)
@Composable
fun PreviewLibrary() {
    LibraryScreen(
        false
    )
}

@Composable
fun LibraryScreen(
    showTutorial: Boolean,
    onBackButtonClick: () -> Unit = {},
    onClickFirst: () -> Unit = {},
    onClickSecond: () -> Unit = {},
    onClickThird: () -> Unit = {}
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.library_xxl_v2),
            contentDescription = "Library background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )

        TopBarWithLeadingAndTrailingIcon(
            title = "",
            onClickLeadingIcon = onBackButtonClick,
        )

        TorchFire(modifier = Modifier)

        BookcaseScreenClicker(
            modifier = Modifier,
            onClickFirst = onClickFirst,
            onClickSecond = onClickSecond,
            onClickThird = onClickThird
        )

        MushyAndTable(
            modifier = Modifier,
            showTutorial = showTutorial
        )

        BannerAd(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun TorchFire(modifier: Modifier) {
    val lottie = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.fire))
    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(bottom = 300.dp, end = 5.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(
                (-7).dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                composition = lottie.value,
                iterations = LottieConstants.IterateForever,
                speed = 0.7f,
                modifier = Modifier.size(65.dp)
            )

            Image(
                painter = painterResource(R.drawable.torch_base),
                contentDescription = "Torch base for lottie animation",
                modifier = Modifier.size(50.dp)
            )
        }
    }

}

@Composable
fun MushyAndTable(
    modifier: Modifier,
    showTutorial: Boolean
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 40.dp, end = 140.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        if(!showTutorial){
            MushyBlinkAnimation(
                modifier
                    .size(260.dp)
                    .offset(y = -(20).dp, x = 5.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.library_table),
            contentDescription = "Table",
            modifier.size(230.dp).offset(y = 70.dp)
        )
    }
}


@Composable
fun BookcaseScreenClicker(
    modifier: Modifier,
    onClickFirst: () -> Unit = {},
    onClickSecond: () -> Unit = {},
    onClickThird: () -> Unit = {}
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
        Column(
            modifier
                .fillMaxHeight()
                .padding(end = 15.dp, bottom = 180.dp),
            verticalArrangement = Arrangement.Center,
        ) {

            Box(
                modifier = Modifier
                    .width(170.dp)
                    .height(90.dp)
                    .background(color = Color.Transparent)
                    .clickable(onClick = {
                        //Nav to forest area info
                        onClickFirst()
                    }),
            )

            Box(
                modifier = Modifier
                    .width(170.dp)
                    .height(90.dp)
                    .background(color = Color.Transparent)
                    .clickable(onClick = {
                        //Nav to river area info
                        onClickSecond()
                    }),
            )

            Box(
                modifier = Modifier
                    .width(170.dp)
                    .height(90.dp)
                    .background(color = Color.Transparent)
                    .clickable(onClick = {
                        //Nav to desert area info
                        onClickThird()
                    })
            )

        }

    }


}