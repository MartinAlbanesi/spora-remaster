package com.gg.spora.tutorials.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.gg.spora.R
import com.gg.spora.core.ui.animations.TypewriteText
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyTalkingTutorial(
    modifier: Modifier = Modifier,
    champyImage: Int,
    isChampyTalking: Boolean,
    secondaryImage: Int? = null,
    isSecondaryTalking: Boolean,
    text: String,
    focusPosition: Offset? = null,
    onClickSkip: () -> Unit,
    onNextItem: () -> Unit,
) {

    var pointerOffset by remember { mutableStateOf(Offset(0f, 0f)) }

    ConstraintLayout(
        modifier = modifier
            .clickable { onNextItem() }
            .onSizeChanged { size ->
                pointerOffset = Offset(
                    size.width.toFloat() * (focusPosition?.x ?: 0.3f),
                    size.height.toFloat() * (focusPosition?.y ?: 0.05f)
                )
            }
            .drawBehind {
                drawRect(
                    Brush.radialGradient(
                        listOf(
                            Color.Transparent,
                            Color.Transparent,
                            Color.Transparent,
                            Color(0x00000000),
                            Color(0xCC000000)
                        ),
                        center = pointerOffset,
                        radius = if(focusPosition != null) 160f else 0.1f,
                    ),
                )
            }
    ) {
        val (champyImg, textBackground, body, skipButton, secondaryImg) = createRefs()

        SporaPrimaryButton(
            modifier = Modifier
                .constrainAs(skipButton) {
                    top.linkTo(parent.top, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },
            text = "Omitir",
            textSize = 16,
            onClick = onClickSkip
        )

        secondaryImage?.let {
            Image(
                painter = painterResource(secondaryImage),
                contentDescription = null,
                colorFilter = if(!isSecondaryTalking) {
                    ColorFilter.lighting(Color.Gray, add = Color.Transparent)
                } else null,
                modifier = Modifier
                    .offset(x = 0.dp, y = 12.dp)
                    .size(200.dp)
                    .constrainAs(secondaryImg) {
                        end.linkTo(parent.end)
                        bottom.linkTo(textBackground.top)
                    }
            )
        }

        Image(
            painter = painterResource(champyImage),
            contentDescription = null,
            colorFilter = if(!isChampyTalking) {
                ColorFilter.lighting(Color.Gray, add = Color.Transparent)
            } else null,
            modifier = Modifier
                .offset(x = 0.dp, y = 12.dp)
                .size(200.dp)
                .constrainAs(champyImg) {
                    start.linkTo(parent.start)
                    bottom.linkTo(textBackground.top)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.text_bottom),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .height(100.dp)
                .constrainAs(textBackground) {
//                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        TypewriteText(
            text = text,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(body) {
                    top.linkTo(textBackground.top)
                    bottom.linkTo(textBackground.bottom)
                    start.linkTo(textBackground.start)
                    end.linkTo(textBackground.end)
                }
        )
    }
}

//@PreviewLightDark
@Preview
@Preview(device = "spec:width=1080px,height=2340px,dpi=640")
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun ChampyTalkingPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampyTalkingTutorial(
                modifier = Modifier.fillMaxSize(),
                champyImage = R.drawable.champy_celebrating_raised_arms,
                text = "La wea de la que te iadkasd askdñaskdñas askdakkñdkaklñsdkaskdk añdkañlsdkañskdñalskdlña",
                secondaryImage = R.drawable.mushy_idle,
                isChampyTalking = true,
                isSecondaryTalking = true,
                focusPosition = Offset(0.6f, 0.05f),
                onClickSkip = { },
                onNextItem = { }
            )
        }
    }
}