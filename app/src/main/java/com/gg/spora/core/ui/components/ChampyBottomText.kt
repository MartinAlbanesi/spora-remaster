package com.gg.spora.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.utils.enums.ChampyStates
import com.gg.spora.core.utils.enums.MushyStates
import com.gg.spora.ui.theme.SporaTheme

@Preview(showBackground = false)
@Composable
fun Preview() {

    SporaTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ChampyWithBottomTextAndMushy(
                modifier = Modifier,
                champyStates = ChampyStates.SMILING,
                mushyStates = MushyStates.IDLE,
                text = "Oh querido Champy y un amigo, ¿Cómo están?",
                isChampyTalking = true
            )
        }
    }
}

@Composable
fun ChampyWithBottomText(
    modifier: Modifier,
    text: String,
    champyStates: ChampyStates
) {

    Box(
        modifier = modifier
            .padding(bottom = 20.dp), contentAlignment = Alignment.BottomEnd
    ) {

        Image(
            painter = painterResource(id = champyStates.image),
            contentDescription = "Champy state",
            modifier = Modifier
                .size(220.dp)
                .offset(y = (-50).dp)
        )

        DialogueWithBottomText(modifier = Modifier, text)

    }
}

@Composable
fun ChampyWithBottomTextAndMushy(
    modifier: Modifier,
    champyStates: ChampyStates,
    mushyStates: MushyStates,
    text: String,
    isChampyTalking: Boolean = true
) {

    Box(
        modifier = modifier
            .padding(bottom = 20.dp), contentAlignment = Alignment.BottomEnd
    ) {

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            if (isChampyTalking) {
                Image(
                    painter = painterResource(id = mushyStates.image),
                    contentDescription = "Mushy state",
                    modifier = Modifier
                        .size(220.dp)
                        .offset(x = (-30).dp, y = (-50).dp),
                    colorFilter = ColorFilter.lighting(Color.Gray, add = Color.Transparent)
                )

                Image(
                    painter = painterResource(id = champyStates.image),
                    contentDescription = "Champy state",
                    modifier = Modifier
                        .size(220.dp)
                        .offset(y = (-50).dp)
                )

            }
            else {

                Image(
                    painter = painterResource(id = mushyStates.image),
                    contentDescription = "Mushy state",
                    modifier = Modifier
                        .size(220.dp)
                        .offset(x = (-30).dp, y = (-50).dp)
                )

                Image(
                    painter = painterResource(id = champyStates.image),
                    contentDescription = "Champy state",
                    modifier = Modifier
                        .size(220.dp)
                        .offset(y = (-50).dp),
                    colorFilter = ColorFilter.lighting(Color.Gray, add = Color.Transparent)
                )
            }
        }

        DialogueWithBottomText(modifier = Modifier, text, isChampyTalking)

    }

}


@Composable
fun DialogueWithBottomText(modifier: Modifier, text: String, isChampyTalking: Boolean = true) {

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(R.drawable.text_bottom),
            contentDescription = "burbuja de dialogo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(horizontal = 5.dp), alignment = Alignment.BottomCenter,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
        )


        Text(
            text = text, modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            style = TextStyle.Default.copy(lineBreak = LineBreak.Paragraph),
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp,
            color = if (isChampyTalking) MaterialTheme.colorScheme.onSurface else colorResource(R.color.mushyTalk),
        )
    }


}

