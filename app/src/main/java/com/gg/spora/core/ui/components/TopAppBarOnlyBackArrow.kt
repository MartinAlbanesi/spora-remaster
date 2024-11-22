package com.gg.spora.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R

@Preview
@Composable
fun PreviewTopAppBarOnlyBackArrow() {
    TopAppBarOnlyBackArrow(title = "Forest")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarOnlyBackArrow(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: () -> Unit = {},
    showSettingsIcon: Boolean = false,
    onSettingsClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black, Color.Transparent)
                )
            )
            .height(80.dp)
    ) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = title,
                        fontSize = 32.sp,
                        color = MaterialTheme.colorScheme.background,
                        fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            },
            navigationIcon = {
                Box(modifier = Modifier.size(48.dp)) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back",
                            tint = MaterialTheme.colorScheme.background,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            },
            actions = {
                Box(modifier = Modifier.size(48.dp)) {
                    if (showSettingsIcon) {
                        IconButton(onClick = onSettingsClick) {
                            Icon(
                                painter = painterResource(id = R.drawable.settings_icon),
                                contentDescription = "Settings",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            },
            modifier = modifier,
        )
    }
}