package com.gg.spora.welcome.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyWithTopDialogue(
    modifier: Modifier = Modifier,
    champy: Int,
    dialogue: String,
    x: Dp = 0.dp,
    y: Dp = 0.dp,
    size: Int = 250,
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
        ) {

            TopDialogue(x = x, y, dialogue = dialogue)

            Spacer(modifier = Modifier.height(5.dp))

            Image(
                painter = painterResource(id = champy),
                contentDescription = "Champy",
                modifier = Modifier.size(size.dp).offset(y = y)
            )

        }
    }

}


@Composable
fun TopDialogue(x: Dp = 0.dp, y: Dp = 0.dp, padding: Dp = 70.dp, dialogue: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .offset(x, y),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(R.drawable.dialogue_bubble_introduction),
            contentDescription = "burbuja de dialogo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
        )


        Text(
            text = dialogue, modifier = Modifier
                .align(Alignment.Center)
                .offset(x =(x + 33.dp), y = (-20).dp)
                .padding(horizontal = padding),
//            style = TextStyle.Default.copy(lineBreak = LineBreak.Paragraph),
            textAlign = TextAlign.Center,
//            maxLines = 3,
//            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChampyWithBubbleTextPreview() {

    SporaTheme {

        ChampyWithTopDialogue(
            champy = R.drawable.champy_curious_arms_to_body,
            dialogue = "Pero primero, ¿me contás sobre vos?",
            x = -(30).dp
        )

    }
}