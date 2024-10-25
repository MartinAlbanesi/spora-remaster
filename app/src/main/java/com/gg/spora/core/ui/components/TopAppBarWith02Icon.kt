package com.gg.spora.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R


/**
 * Top bar with o2Icon and backarrow
 * @param firstLabel: Label for the first icon
 * @param title: Title of the top bar
 * @param firstIcon: Image for the first icon
 * @param showBackArrow: Boolean to show or not the back arrow
 * @param onBackClick: Lambda to be executed when the back arrow is clicked
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithO2Icon(
    modifier: Modifier = Modifier,
    title: String,
    firstLabel: String,
    firstIcon: Int,
    showBackArrow: Boolean = true,
    showIcon: Boolean = true,
    onBackClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black, Color.Transparent)
                )
            )
            .height(100.dp)
    ) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        fontSize = 26.sp,
                        color = MaterialTheme.colorScheme.background,
                        fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                    )

                    if (showIcon){
                        ImageWithTextHorizontal(
                            imageResource = firstIcon,
                            text = firstLabel
                        )
                    }

                }
            },
            navigationIcon = {
                if (showBackArrow) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back",
                            tint = MaterialTheme.colorScheme.background,
                            modifier = Modifier.size(100.dp)
                        )
                    }
                }
            },
            modifier = modifier,

        )
    }
}

@Composable
@Preview()
fun PreviewTopAppBarWithO2Icon() {
    TopAppBarWithO2Icon(
        title = "Title",
        firstLabel = "10",
        firstIcon = R.drawable.oxygen,
        showBackArrow = true,
    )
}
