package com.gg.spora.challenge.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.R
import com.gg.spora.challenge.domain.model.ObjectDetail

@Composable
fun ObjectDetailDialog(
    modifier: Modifier = Modifier,
    onContinueButton: () -> Unit,
    objectDetail : ObjectDetail
) {

    var buttonContinueEnabled by remember { mutableStateOf(false) }
    var currentStep by remember { mutableIntStateOf(1) }

    val continueButtonColor = if (buttonContinueEnabled)  {
        Color(0xFFFFA500)
    } else {
        Color.Gray
    }

    if(currentStep == 2){
        buttonContinueEnabled = true
    }

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
                    .wrapContentHeight()
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = modifier
                        .padding(15.dp)
                ){
                    Text(
                        text = objectDetail.name,
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
                                text = objectDetail.description,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }

                        Column(
                            modifier = modifier.width(120.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            ValidateImageOfObjectDetail(objectDetail.name)
                        }
                    }

                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = stringResource(R.string.question_recycle),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                    )

                    Crossfade(targetState = currentStep, label = "") { step ->
                        objectDetail.steps.forEach { stepObject ->
                            if (step == stepObject.number) {
                                StepObjectDetail(
                                    stepObjectDetail = stepObject,
                                    onPreviousStep = {
                                        if (currentStep > 1) currentStep--
                                    },
                                    onNextStep = {
                                        if (currentStep < objectDetail.steps.size) currentStep++
                                    }
                                )
                            }
                        }
                    }

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth(1.0f),
                            onClick = {
                                if (buttonContinueEnabled) {
                                    onContinueButton()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = continueButtonColor,
                                contentColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Text(
                                text = stringResource(R.string.text_continue),
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            )
                        }

                    }
                }
                }

        }

}

@Composable
fun ValidateImageOfObjectDetail(objectDetailName : String){
    val image : Int = if(objectDetailName == "Botella de plastico"){
        R.drawable.botella_de_plastico
    }
    else{
        R.drawable.caja_de_carton
    }

    Image(
        painter = painterResource(id = image),
        contentDescription = "Image Detail",
        modifier = Modifier.size(100.dp)
    )
}

/*
@Preview
@Composable
private fun ChampyDialogConfirmPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ObjectDetailDialog(
                onContinueButton = {},
                nameObject = "Botella de plastico",
                contentObjectDescription = "Objeto de alta importancia ecologica"
            )
        }
    }
}

 */