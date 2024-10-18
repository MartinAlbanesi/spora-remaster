package com.gg.spora.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopAppBarOnlyBackArrow


@Preview(showBackground = true)
@Composable
fun PreviewLibrary() {
    LibraryScreen()
}

@Composable
fun LibraryScreen() {

    Box(modifier = Modifier.fillMaxSize()) {


        Image(
            painter = painterResource(R.drawable.library_background_v2),
            contentDescription = "Library background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )

        TopAppBarOnlyBackArrow {
            //onBackButtonClick()
        }

        BookcaseScreenClicker(modifier = Modifier)
    }
}


@Composable
fun BookcaseScreenClicker(modifier: Modifier) {

    Box(modifier = Modifier
        .width(170.dp)
        .height(70.dp)
        .offset(x = 210.dp, y = 225.dp)
        .background(color = Color.Transparent)
        .clickable(onClick = {
            //Nav to info recycler
        }),
        )

    Box(modifier = Modifier
        .width(170.dp)
        .height(60.dp)
        .offset(x = 210.dp, y = 310.dp)
        .background(color = Color.Transparent)
        .clickable(onClick = {
            //Nav to info watercare
        }),
    )

    Box(modifier = Modifier
        .width(170.dp)
        .height(70.dp)
        .offset(x = 210.dp, y = 380.dp)
        .background(color = Color.Transparent)
        .clickable(onClick = {
            //Nav to info eco energy
        }),
    )




}