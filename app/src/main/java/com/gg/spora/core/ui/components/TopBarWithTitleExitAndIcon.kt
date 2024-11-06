package com.gg.spora.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

/**
 * Top bar with progress bar
 * @param title: Title of the screen
 * @param onBackClick: Click listener for back button
 * @param modifier: Modifier
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithTitleExitAndIcon(
    modifier: Modifier = Modifier,
    title: String,
    showIcon: Boolean = true,
    showSettingsIcon: Boolean = false,
    lives: Int = 0,
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { onBackClick() }
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        },
        actions = {
            if (showIcon) {
                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null,
                        tint = colorResource(id = R.color.error),
                        modifier = Modifier.size(44.dp)
                    )
                    Text(
                        lives.toString(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            if (showSettingsIcon) {
                IconButton(
                    onClick = { onSettingsClick() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings_icon),
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black, Color.Transparent)
                )
            )
    )
}

@Preview
@Composable
private fun TopBarWithProgressBarPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TopBarWithTitleExitAndIcon(
                title = "Title",
                onBackClick = { },
                showSettingsIcon = true,
                onSettingsClick = { }
            )
        }
    }
}