package com.gg.spora.challenge.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.gg.spora.R
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.challenge.ui.components.ObjectDetailDialog

val classes = arrayOf("Botella de plastico", "Caja de carton", "Nada")

/**
 * Screen for mini games with Spora and progress bar
 * @param modifier: Modifier
 * @param onBackClick: Click listener for back button
 * @param onNavigateToCameraScreen: Action for navigate to Camera Screen
 * @param challengeViewModel: View model for the Challenge
 */
@Composable
fun ChallengeScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onNavigateToCameraScreen: (Any?) -> Unit,
    onNavigateToForestStage: () -> Unit,
    challengeViewModel: ChallengeViewModel = hiltViewModel()
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    var buttonContinueEnabled by remember { mutableStateOf(false) }
    var champyImage by remember { mutableIntStateOf(R.drawable.champy_sonriente_brazosalcuerpo) }
    var objectsChallenge by remember { mutableStateOf(mapOf<String, Boolean>()) }
    var showDialog by remember { mutableStateOf(false) }
    var selectedObject by remember { mutableStateOf("") }

    LaunchedEffect(challengeViewModel.selectedObject) {
        challengeViewModel.selectedObject.observe(lifecycleOwner) { selectedObjectObserve ->
            if(selectedObjectObserve != null && selectedObjectObserve != ""){
                selectedObject = selectedObjectObserve
                showDialog = true
            }
        }
    }

    LaunchedEffect(challengeViewModel.objectsChallenge) {
        challengeViewModel.objectsChallenge.observe(lifecycleOwner) { objects ->
            objectsChallenge = objects
        }
    }

    if(objectsChallenge.values.isNotEmpty() && objectsChallenge.values.all{ it }){
        champyImage = R.drawable.champy_celebrando_brazoslevantados
        buttonContinueEnabled = true
    }

    if(showDialog && selectedObject != ""){
        val stepsObjectDetail = getStepsObjectDetail(selectedObject)
        ObjectDetailDialog(
            onContinueButton = { showDialog = false },
            objectDetail = ObjectDetail(1, selectedObject,
                stepsObjectDetail, "Objeto de alta importancia ecologica")
        )
    }

    Column(
        modifier = modifier.padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(R.string.label_challenge),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
        if(objectsChallenge.isNotEmpty()){
            objectsChallenge.forEach {
                val nameObject = it.key

                ButtonObjectScannerChallenge(
                    textObject = nameObject,
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            shape = MaterialTheme.shapes.large,
                            ambientColor = DefaultShadowColor
                        )
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.large)
                        .height(60.dp)
                        .clickable {
                            onNavigateToCameraScreen(nameObject)
                        },
                    isValidate = it.value
                )
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        val continueButtonColor = if (buttonContinueEnabled)  {
            Color(0xFFFFA500)
        } else {
            Color.Gray
        }

        Button(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(1.0f),
            onClick = {
                if (buttonContinueEnabled) {
                    onNavigateToForestStage()
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

        Spacer(modifier = Modifier.height(24.dp))

    }
}

//Por ahora harcodeado, la idea es que estos datos se obtengan a traves de una consulta a la base
fun getStepsObjectDetail(selectedObject : String) : List<StepObjectDetail> {
    if(selectedObject == "Botella de plastico"){
            return mutableListOf(StepObjectDetail(1, 1,"Limpieza",
                "Vaciá y limpiá las botellas enjuagándolas " +
                    "con agua y unas gotitas de detergente.",
                true, false),
                StepObjectDetail(1, 2,"Validación",
                    "Una botella de plástico que se puede " +
                            "reciclar debera tener un ícono de reciclaje. "),
                StepObjectDetail(1, 3,"Reciclado",
                    "Si la botella se puede reciclar entonces se " +
                            "puede ingresar en los contenedores de reciclado."),
                StepObjectDetail(1, 4,"Crear",
                    "Si no se pueda reciclar, entonces se pueden hacer " +
                            "manualidades u objetos de decoración con los materiales.",
                     false, true))
    }
    else{
        return mutableListOf(StepObjectDetail(2, 1,"Limpieza",
            "Asegurate que la caja de Carton este limpia " +
                    "y sin ningun elemento que pueda interferir con su reciclaje",true, false),
            StepObjectDetail(2, 2,"Recortar",
                "Acompañado de un adulto, recorta la caja de carton en pequeños trozos"),
            StepObjectDetail(2, 3,"Crear",
                "Con estos pequeños trozos de carton podes " +
                        "hacer manualidades divertidas.",false, true))
    }
}