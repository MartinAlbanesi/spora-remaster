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
import androidx.compose.runtime.livedata.observeAsState
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
import com.gg.spora.R
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.challenge.ui.components.ObjectDetailDialog
import com.gg.spora.forestStage.ui.StageViewModel


/**
 * Screen for mini games with Spora and progress bar
 * @param modifier: Modifier
 * @param onNavigateToCameraScreen: Click listener for back button
 * @param onNavigateToCameraScreen: Action for navigate to Camera Screen
 * @param challengeViewModel: View model for the Challenge
 */
@Composable
fun ChallengeScreen(
    modifier: Modifier = Modifier,
    onNavigateToCameraScreen: (Any?) -> Unit,
    onNavigateToForestStage: () -> Unit
) {
    val challengeViewModel = hiltViewModel<ChallengeViewModel>()
    val selectedObject by challengeViewModel.selectedObject.observeAsState()
    val objectsChallenge by challengeViewModel.objectsChallenge.observeAsState(listOf())
    val isLoading by challengeViewModel.isLoading.observeAsState(true)
    val buttonContinueEnabled = objectsChallenge.isNotEmpty() && objectsChallenge.all { it.isValidate }
    var showDialog by remember { mutableStateOf(false) }
    var champyImage by remember { mutableIntStateOf(R.drawable.champy_smiling_arms_body) }

    if (buttonContinueEnabled) champyImage = R.drawable.champy_celebrating_raised_arms

    LaunchedEffect(selectedObject) {
        if (!selectedObject.isNullOrEmpty()) {
            showDialog = true
        }
    }

    if (showDialog && !selectedObject.isNullOrEmpty()) {
        ObjectDetailDialog(
            onContinueButton = {
                showDialog = false
                challengeViewModel.setEmptySelectedObject()
            },
            objectDetail = challengeViewModel.getObjectDetailWithName(selectedObject!!)
        )
    }

    if (!isLoading) {
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

            ObjectsChallengeList(objectsChallenge, onNavigateToCameraScreen)

            Spacer(modifier = Modifier.height(48.dp))

            ContinueButton(
                enabled = buttonContinueEnabled,
                onClick = onNavigateToForestStage
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

/**
 * Displays a list of objects for the current challenge, each as a clickable button
 * @param objectsChallenge List of objects that are part of the challenge
 * @param onNavigateToCameraScreen Action triggered when a button is clicked, to navigate to the Camera Screen with the object name
 */
@Composable
fun ObjectsChallengeList(
    objectsChallenge: List<ObjectDetail>,
    onNavigateToCameraScreen: (String) -> Unit
) {
    objectsChallenge.forEach { objectDetail ->
        ButtonObjectScannerChallenge(
            textObject = objectDetail.nameObjectDetail ?: "",
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
                    onNavigateToCameraScreen(objectDetail.nameObjectDetail ?: "")
                },
            isValidate = objectDetail.isValidate
        )
    }
}

/**
 * Renders a continue button that enables navigation to the next stage when activated
 * @param enabled Boolean indicating if the button should be enabled
 * @param onClick Action triggered when the button is clicked to proceed to the next stage
 */
@Composable
fun ContinueButton(
    enabled: Boolean,
    onClick: () -> Unit
) {
    val continueButtonColor = if (enabled) Color(0xFFFFA500) else Color.Gray
    Button(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        onClick = { if (enabled) onClick() },
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
}