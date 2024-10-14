package com.gg.spora.challenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun StepObjectDetail(
    modifier: Modifier = Modifier,
    onNextButton: () -> Unit,
    stepImage : Int,
    stepTitle : String,
    stepDescription : String
) {

    Column(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                )
            )
            .background(MaterialTheme.colorScheme.primaryContainer),
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.clip(shape = RoundedCornerShape(20.dp))
                .background(color = MaterialTheme.colorScheme.background)
                .padding(10.dp)
        )
        {
            Column(
                modifier = modifier.width(30.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = stepImage),
                    contentDescription = "Step",
                    modifier = modifier.size(30.dp)
                )
            }
            Column(
                modifier = modifier.width(50.dp)
            )
            {
                Text(
                    text = stepTitle,

                    color = Color.Black,
                    fontSize = 24.sp
                )
            }
        }
    }


}

@Preview
@Composable
private fun ChampyDialogConfirmPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StepObjectDetail(
                onNextButton = {},
                stepImage = 1,
                stepTitle = "Recicla",
                stepDescription = "Podes reciclar tu botella de plastico"
            )
        }
    }
}