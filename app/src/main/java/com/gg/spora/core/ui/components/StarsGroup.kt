package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getStarsImages
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun StarsGroup(
    modifier: Modifier = Modifier,
    starState: StarState
) {

    val localStars = getStarsImages(starState)

    val rotateItems = SporaConstant.ROTATE_ITEMS_LEVEL_PREVIEW

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(-4.dp)
    ) {
        itemsIndexed(localStars){ index, star ->
            Image(
                painter = painterResource(star),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(rotateItems.keys.elementAt(index))
                    .offset(y = rotateItems.values.elementAt(index).dp)
            )
        }
    }
}

@PreviewLightDark
//@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun StarsGroupPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StarsGroup(
                modifier = Modifier,
                starState = StarState.STAR_TWO
            )
        }
    }
}