package com.gg.spora.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.animations.TypewriteText
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyTalkingAnimation(
    modifier: Modifier = Modifier,
    champyModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    @DrawableRes champyImage: Int,
    champySize: Int = 250,
    champyText: String
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = champyImage),
            contentDescription = "Champy",
            modifier = champyModifier
                .size(champySize.dp)
                .align(Alignment.Center)
        )

        TypewriteText(
            text = champyText,
            preoccupySpace = false,
            modifier = textModifier
                .align(Alignment.Center)
        )

    }
}

@PreviewLightDark
//@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun ChampyTalkingAnimationPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampyTalkingAnimation(
                modifier = Modifier
                    .fillMaxWidth(),
                champyImage = R.drawable.champy_celebrating_raised_arms,
                champyText = "Hola aaaaaaaaaaaa aaa a aaaaa",
                textModifier = Modifier
                    .offset(y = (160).dp)
                    .clip(MaterialTheme.shapes.medium)
//                        .align(Alignment.Center)
                    .background(colorResource(R.color.cream))
                    .fillMaxWidth(0.6f)
                    .padding(16.dp)
            )
        }
    }
}