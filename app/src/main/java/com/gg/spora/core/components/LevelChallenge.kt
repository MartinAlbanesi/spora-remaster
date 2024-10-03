package com.gg.spora.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R

@Composable
fun LevelChallenge(modifier: Modifier, blocked: Boolean = false, onClick: () -> Unit = {}){

    Box(modifier = modifier) {
        if(blocked){
            Image(
                painter = painterResource(id = R.drawable.nivel_bloqueado),
                contentDescription = "Level blocked",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(end = 70.dp)
                    .size(100.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.nivel_desafio),
            contentDescription = "Challenge level",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(end = 70.dp)
                .size(100.dp)
        )
    }
}

@Preview
@Composable
fun PreviewLevelChallenge(){

    LevelChallenge(modifier = Modifier)


}