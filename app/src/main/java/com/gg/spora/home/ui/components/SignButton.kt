package com.gg.spora.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

// Forest Sign Button
@Composable
fun SignButton(
    modifier: Modifier = Modifier,
    image: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "Wood Sign",
            modifier = modifier,
        )
    }
}