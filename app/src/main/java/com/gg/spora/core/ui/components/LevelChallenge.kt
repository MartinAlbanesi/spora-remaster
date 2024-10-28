package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R

@Composable
fun LevelChallenge(modifier: Modifier, blocked: Boolean = true, onClick: () -> Unit = {}){

    Box(modifier = modifier.clickable { onClick() }) {
        if(blocked){
            Image(
                painter = painterResource(id = R.drawable.locked_level),
                contentDescription = "Level blocked",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
//                    .padding(end = 70.dp)
                    .size(100.dp)
            )
        }else{
            Image(
                painter = painterResource(id = R.drawable.challenge_level),
                contentDescription = "Challenge level",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
//                    .padding(end = 70.dp)
                    .size(100.dp)
            )
        }

    }
}

@Preview
@Composable
fun PreviewLevelChallenge(){

    LevelChallenge(modifier = Modifier)


}