package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.forestStage.domain.TypeStage

/**
 * Icon for levels with image and number
 * @param number: level number of the stage
 * @param stars: stars of the stage
 * @param blocked: Boolean to show or not the level
 * @param stage: Stage of the level
 * @param modifier: Modifier
 * @param onClick: Lambda to be executed when the level is clicked
 */


@Composable
fun LevelStage(
    number: Int,
    stars: Int,
    blocked: Boolean = false,
    stage: TypeStage,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {


    Box(modifier = modifier) {

        if (blocked) {
            Image(
                painter = painterResource(id = R.drawable.nivel_bloqueado),
                contentDescription = "Level blocked",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(end = 70.dp)
                    .size(100.dp)
            )
        } else
            when (stage) {

                TypeStage.FOREST ->
                    when (stars) {
                        0 -> Image(
                            painter = painterResource(id = R.drawable.nivel_bosque_0e),
                            contentDescription = "Forest level without stars",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .padding(end = 70.dp)
                                .size(100.dp)
                        )

                        1 -> Image(
                            painter = painterResource(id = R.drawable.nivel_bosque_1e),
                            contentDescription = "Forest level with 1 star",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .padding(end = 70.dp)
                                .size(100.dp)
                        )

                        2 -> Image(
                            painter = painterResource(id = R.drawable.nivel_bosque_2e),
                            contentDescription = "Forest level with 2 stars",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .padding(end = 70.dp)
                                .size(100.dp)
                        )

                        3 -> Image(
                            painter = painterResource(id = R.drawable.nivel_bosque_3e),
                            contentDescription = "Forest level with 3 stars",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .padding(end = 70.dp)
                                .size(100.dp)
                        )

                        else -> Image(
                            painter = painterResource(id = R.drawable.nivel_bosque_0e),
                            contentDescription = "Forest level without stars",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .padding(end = 70.dp)
                                .size(100.dp)
                        )
                    }

                TypeStage.DESERT -> TODO()
                TypeStage.RIVER -> TODO()
                else -> TODO()
            }

        if (!blocked) {
            Text(
                text = number.toString(),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Black,
                fontSize = 35.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (-10).dp, x = (-36).dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewIconLevelStage() {
    LevelStage(
        number = 1,
        stars = 0,
        blocked = false,
        stage = TypeStage.FOREST,
    ) {
        /*Nav to level*/
    }

}