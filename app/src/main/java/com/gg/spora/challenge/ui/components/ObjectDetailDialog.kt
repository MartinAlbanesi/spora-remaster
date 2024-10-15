package com.gg.spora.challenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun ChampyDialogConfirm(
    modifier: Modifier = Modifier,
    onContinueButton: () -> Unit,
    nameObject : String,
    contentObjectDescription : String
) {

        Dialog(
            onDismissRequest = { },
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                dismissOnClickOutside = true,
                dismissOnBackPress = false
            )
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF215727),
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = modifier
                    .padding(15.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = modifier
                        .padding(15.dp)
                ){
                    Text(
                        text = nameObject,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                    Row(
                        modifier = modifier.clip(shape = RoundedCornerShape(20.dp))
                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                            .padding(10.dp)
                    )
                    {
                        Column(
                            modifier = modifier.width(220.dp),
                            verticalArrangement = Arrangement.Top
                        )
                        {
                            Text(
                                text = "Detalle",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Text(
                                modifier = modifier.padding(top = 5.dp),
                                text = contentObjectDescription,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }

                        Column(
                            modifier = modifier.width(120.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.botella_de_plastico),
                                contentDescription = "Botella de Plastico",
                                modifier = modifier.size(100.dp)
                            )
                        }
                    }

                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "¿Como reciclarlo?",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                    )

                    StepObjectDetail(
                        stepImage = R.drawable.step_one, // Asegúrate de tener el ícono correcto
                        stepTitle = "Validación",
                        stepDescription = "Una botella de plástico que se puede reciclar deberá tener un ícono de reciclaje.",
                        onPreviousStep = {},
                        onNextStep = {}
                    )
                }

                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SporaPrimaryButton(
                        text = "Continuar",
                        onClick = onContinueButton,
                        modifier = modifier
                            .padding(10.dp)
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
            ChampyDialogConfirm(
                onContinueButton = {},
                nameObject = "Botella de plastico",
                contentObjectDescription = "Objeto de alta importancia ecologica"
            )
        }
    }
}