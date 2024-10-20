package com.gg.spora.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

/**
 * Top bar with progress bar
 * @param firstLabel: Label for the first icon
 * @param firstIcon: Image for the first icon
 * @param secondLabel: Label for the second icon
 * @param secondIcon: Image for the second icon
 * @param showBackArrow: Boolean to show or not the back arrow
 * @param onBackClick: Lambda to be executed when the back arrow is clicked
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithDualIcon(
    modifier: Modifier = Modifier,
    firstLabel: String,
    firstIcon: Int,
    secondLabel: String,
    secondIcon: Int,
    showBackArrow: Boolean = false,
    onBackClick: () -> Unit = {}
) {
    Box {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 8.dp)
//                        .align(Alignment.TopCenter)
                ) {
//                    ImageWithTextHorizontal(imageResource = firstIcon, text = firstLabel)
//                    Spacer(Modifier.size(50.dp))
                    ImageWithTextHorizontal(imageResource = secondIcon, text = secondLabel)
                }
            },
            navigationIcon = {
                if (showBackArrow) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back",
                            tint = MaterialTheme.colorScheme.background,
                            modifier = Modifier.size(64.dp)
                        )
                    }
                }
            },
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    SporaTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TopAppBarWithDualIcon(
                firstLabel = "0",
                firstIcon = R.drawable.trees_icon,
                secondLabel = "0",
                secondIcon = R.drawable.o2_icon,
                showBackArrow = false,
            )
        }
    }
}