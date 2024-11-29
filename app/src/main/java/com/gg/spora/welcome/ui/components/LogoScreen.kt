package com.gg.spora.welcome.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.welcome.ui.animations.LogoInitialAnimation

@Composable
fun LogoScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "Area 1 background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        LogoInitialAnimation(
            image = R.drawable.logo_with_border_slogan,
            modifier = modifier.align(Alignment.Center)
        )

        SporaPrimaryButton(
            text = "Continuar",
            textSize = 30,
            onClick = onClick,
            modifier = modifier
                .size(width = 350.dp, height = 50.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-60).dp),
        )
    }
}

@PreviewLightDark
//@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun LogoScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LogoScreen()
        }
    }
}