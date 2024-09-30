package com.gg.spora.home.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.core.ui.components.DualIconTopAppBar

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            DualIconTopAppBar(
                statusLabel = "12",
                statusIcon = Icons.Default.Menu,
                actionLabel = "465",
                actionIcon = Icons.Default.Menu,
                showBackArrow = false,
            )
        },
    ) { paddingValue ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValue.calculateTopPadding(),
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 8.dp,
                )
        ) {
            Text(text = "Inicio")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}