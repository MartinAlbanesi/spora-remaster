package com.gg.spora.challenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.challenge.ui.components.ObjectDetailDialog

val classes = arrayOf("Botella de plástico", "Caja de carton", "Nada", "Tapita de plástico")

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
    onNavigateToCameraScreen: (Any?) -> Unit,
    onNavigateToForestStage: () -> Unit,
    challengeViewModel: ChallengeViewModel = hiltViewModel()
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    var buttonContinueEnabled by remember { mutableStateOf(false) }
    var champyImage by remember { mutableIntStateOf(R.drawable.champy_smiling_arms_body) }
    var objectsChallenge by remember { mutableStateOf(listOf<ObjectDetail>()) }
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

    if(objectsChallenge.isNotEmpty() && objectsChallenge.all{ it.isValidate }){
        champyImage = R.drawable.champy_celebrating_raised_arms
        buttonContinueEnabled = true
    }

    if(showDialog && selectedObject != ""){
        val objectDetail = challengeViewModel.getObjectDetailWithName(selectedObject)
        ObjectDetailDialog(
            onContinueButton = {
                showDialog = false
                challengeViewModel.setEmptySelectedObject()
                },
            objectDetail = objectDetail
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
                val nameObject = it.nameObjectDetail

                ButtonObjectScannerChallenge(
                    textObject = nameObject!!,
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
                    isValidate = it.isValidate
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
                contentColor = colorResource(id = R.color.cream)
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