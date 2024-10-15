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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun StepValidationDetail(
    modifier: Modifier = Modifier,
    stepImage: Int,
    stepTitle: String,
    stepDescription: String,
    onPreviousStep: () -> Unit,
    onNextStep: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .height(100.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
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
                modifier = Modifier.size(25.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(8f)
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = stepImage),
                    contentDescription = "Step Icon",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stepTitle,
                    style = MaterialTheme.typography.bodyLarge,
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
                text = stepDescription,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

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
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@Preview
@Composable
fun StepValidationDetailPreview() {
    SporaTheme {
        Surface(
            color = Color.Transparent
        ) {
            StepValidationDetail(
                stepImage = R.drawable.step_one, // Asegúrate de tener el ícono correcto
                stepTitle = "Validación",
                stepDescription = "Una botella de plástico que se puede reciclar deberá tener un ícono de reciclaje.",
                onPreviousStep = {},
                onNextStep = {}
            )
        }
    }
}