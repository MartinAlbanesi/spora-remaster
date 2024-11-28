package com.gg.spora.challenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.challenge.ui.components.ObjectDetailDialog
import com.gg.spora.core.ui.components.ChampyDialog
import com.gg.spora.core.utils.enums.StarState


/**
 * Screen for challenge
 * @param modifier: Modifier
 * @param onNavigateToCameraScreen: Click listener for back button
 * @param onNavigateToCameraScreen: Action for navigate to Camera Screen
 */
@Composable
fun ChallengeScreen(
    modifier: Modifier = Modifier,
    onNavigateToCameraScreen: (Any?) -> Unit,
    onNavigateToGrove: () -> Unit,
    challengeObjects: List<ObjectDetail>,
    continueDialogObjectDetail: () -> Unit,
    selectedObject: ObjectDetail,
//    isChallengeFinallyUser: Boolean
) {
    val buttonContinueEnabled = challengeObjects.isNotEmpty()
            && challengeObjects.all { it.isValidate }

    var showDialog by remember { mutableStateOf(false) }
    var showDialogChallengeFinish by remember { mutableStateOf(false) }

    if (selectedObject.nameObjectDetail.isNotEmpty()) {
        showDialog = true
    }

    if (showDialog) {
        ObjectDetailDialog(
            onContinueButton = {
                showDialog = false
                continueDialogObjectDetail()
                selectedObject.nameObjectDetail = ""
            },
            objectDetail = selectedObject
        )
    }

    if(showDialogChallengeFinish){
        DialogFinishChallenge(
            modifier = modifier,
            onNavigateToGrove = onNavigateToGrove,
            onBackDialogFinishChallenge = { showDialogChallengeFinish = false }
        )
    }

    Column(
        modifier = modifier.padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(R.string.label_challenge),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier.padding(10.dp)
        )

        ObjectsChallengeList(challengeObjects, onNavigateToCameraScreen )

        Spacer(modifier = Modifier.height(48.dp))

        ContinueButton(
            enabled = buttonContinueEnabled,
            onClick = {
                showDialogChallengeFinish = true

            }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }

}

@Composable
fun DialogFinishChallenge(
    modifier: Modifier,
    onNavigateToGrove: () -> Unit,
    onBackDialogFinishChallenge: () -> Unit
){
    ChampyDialog(
        modifier = modifier,
        backgroundImage = R.drawable.minigame_background_crop,
        champyImage = R.drawable.champy_celebrating_raised_arms,
        title = stringResource(R.string.rewards),
        isVisible = true,
        starsState = StarState.THREE,
        isChallenge = true,
        textPrimaryButton = stringResource(R.string.plant_seed),
        textSecondaryButton = stringResource(R.string.back),
        onClickPrimaryButton = onNavigateToGrove,
        onClickSecondaryButton = onBackDialogFinishChallenge,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                /*
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.padding(bottom = 5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.oxygen_icon),
                        contentDescription = "Oxigen",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "+ $totalOxygen",
                        fontSize = 24.sp,
                        color = Color.White,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black, offset = Offset(5f, 5f), blurRadius = 5f
                            )
                        ),
                    )
                }
*/
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.seed),
                        contentDescription = "Seed",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "+ 1",
                        fontSize = 24.sp,
                        color = Color.White,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black, offset = Offset(5f, 5f), blurRadius = 5f
                            )
                        ),
                    )
                }
            }
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