package com.gg.spora.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.miniGames.ui.components.LivesCounter
import com.gg.spora.ui.theme.SporaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithLeadingAndTrailingIcon(
    modifier: Modifier = Modifier,
    title: String,
    leadingIcon: ImageVector? = Icons.AutoMirrored.Filled.ArrowBack,
    trailingIcon: ImageVector? = null,
    onClickLeadingIcon: () -> Unit = {},
    onClickTrailingIcon: () -> Unit = {},
    trailingContent: @Composable () -> Unit = {},
    titleContent: @Composable () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White
            )
            titleContent()
        },
        navigationIcon = {
            leadingIcon?.let {
                IconButton(onClick = onClickLeadingIcon) {
                    Icon(
                        leadingIcon,
                        contentDescription = "Leading Icon",
                        tint = Color.White
                    )
                }
            }
        },
        actions = {
            trailingIcon?.let {
                IconButton(
                    onClick = onClickTrailingIcon
                ) {
                    Icon(
                        trailingIcon,
                        contentDescription = "Trailing Icon",
                        tint = Color.White
                    )
                }
            }
            trailingContent()
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

@PreviewLightDark
//@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun TopBarWithLeadingAndTrailingIconPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
                    TopBarWithLeadingAndTrailingIcon(
                        modifier = Modifier,
                        title = "Title Large Wea",
                        leadingIcon = Icons.AutoMirrored.Filled.ArrowBack,
                        trailingContent = {
                            LivesCounter(
                                lives = 5.toString(),
                            )
                        }
                    )
                }
            ) { paddingValues ->
                paddingValues
            }

        }
    }
}