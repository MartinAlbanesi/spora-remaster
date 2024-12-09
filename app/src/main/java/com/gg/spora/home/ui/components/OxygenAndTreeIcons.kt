package com.gg.spora.home.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.ImageWithTextHorizontal
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun OxygenAndTreeIcons(
    modifier: Modifier = Modifier,
    oxygen: Int,
    trees: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ImageWithTextHorizontal(
            imageResource = R.drawable.oxygen_icon,
            text = oxygen.toString(),
        )
        ImageWithTextHorizontal(
            imageResource = R.drawable.trees_icon,
            text = trees.toString(),
        )
    }
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun OxygenAndTreeIconsPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            OxygenAndTreeIcons(
                oxygen = 1000,
                trees = 20
            )
        }
    }
}