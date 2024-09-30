package com.gg.spora.core.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.gg.spora.ui.theme.SporaTheme

/**
 * Top bar with progress bar
 * @param title: Title of the screen
 * @param onBackClick: Click listener for back button
 * @param modifier: Modifier
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithProgressBar(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            IconButton(
                onClick = { onBackClick() }
            ) {
                Icon(Icons.Default.Close, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(
                onClick = { }
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Back")
            }
        },
        colors =  TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
    )
}

@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun TopBarWithProgressBarPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TopBarWithProgressBar(
                title = "Title",
                onBackClick = { }
            )
        }
    }
}