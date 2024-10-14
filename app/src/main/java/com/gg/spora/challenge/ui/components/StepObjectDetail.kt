package com.gg.spora.challenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun StepValidationDetail(
    modifier: Modifier = Modifier,
    stepImage: Int, // Cambié el nombre del parámetro para mayor claridad
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
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.primary),
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Previous Step",
                tint = Color.Black,
                modifier = Modifier.height(50.dp)
            )
        }

        // Contenido del paso
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ícono del paso
                Image(
                    painter = painterResource(id = stepImage), // Usa tu imagen
                    contentDescription = "Step Icon",
                    modifier = Modifier.size(25.dp) // Tamaño adecuado del ícono
                )
                Spacer(modifier = Modifier.width(8.dp)) // Espacio entre ícono y texto
                // Título
                Text(
                    text = stepTitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            // Línea divisoria
            Divider(
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Descripción
            Text(
                text = stepDescription,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        IconButton(
            onClick = { onNextStep() },
            modifier = Modifier
                .width(25.dp)
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next Step",
                tint = Color.Black
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
/*
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

 */