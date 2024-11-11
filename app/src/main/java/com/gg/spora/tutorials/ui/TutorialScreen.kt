package com.gg.spora.tutorials.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.gg.spora.R
import com.gg.spora.tutorials.ui.component.ChampyTalkingTutorial
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun TutorialScreen(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.home_background),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
    )

    ChampyTalkingTutorial(
        modifier = Modifier.fillMaxSize(),
        champyImage = R.drawable.champy_celebrating_raised_arms,
        text = "La wea de la que te iadkasd askdñaskdñas askdakkñdkaklñsdkaskdk añdkañlsdkañskdñalskdlña",
        secondaryImage = R.drawable.mushy_idle,
        isChampyTalking = true,
        isSecondaryTalking = false,
        onClickSkip = {  }
    )
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun TutorialScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TutorialScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}