package com.gg.spora.challenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.challenge.domain.model.StepObjectDetail

@Composable
fun StepObjectDetail(
    modifier: Modifier = Modifier,
    stepObjectDetail: StepObjectDetail,
    onPreviousStep: () -> Unit,
    onNextStep: () -> Unit,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .height(170.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        if(!stepObjectDetail.isFirst){
            IconButton(
                onClick = { onPreviousStep() },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.primary),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "Previous Step",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Black

                )
            }
        }

        Column(
            modifier = Modifier
                .weight(8f)
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ValidateImageStep(stepObjectDetail.numberStep)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stepObjectDetail.nameObjectDetail!!,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = stepObjectDetail.description!!,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        if(!stepObjectDetail.isLast){
            IconButton(
                onClick = { onNextStep() },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.next_icon),
                    contentDescription = "Next Step",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun ValidateImageStep(numberStep : Int){

    val image : Int = when(numberStep){
        1 -> R.drawable.step_one
        2 -> R.drawable.step_two
        3 -> R.drawable.step_three
        4 -> R.drawable.step_four
        else -> R.drawable.camera_icon
    }

    Image(
        painter = painterResource(id = image),
        contentDescription = "Step Icon",
        modifier = Modifier.size(30.dp)
    )
}

/*
@Preview
@Composable
fun StepObjectDetailPreview() {
    SporaTheme {
        Surface(
            color = Color.Transparent
        ) {
            StepObjectDetail(
                stepImage = R.drawable.step_one, // Asegúrate de tener el ícono correcto
                stepTitle = "Validación",
                stepDescription = "Una botella de plástico que se puede reciclar deberá tener un ícono de reciclaje.",
                onPreviousStep = {},
                onNextStep = {},
                isFirstStep = true,
                isLastStep = false
            )
        }
    }
}
 */