package com.gg.spora.challenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gg.spora.R
import com.gg.spora.challenge.ui.components.ButtonObjectScannerChallenge
import com.gg.spora.core.ui.components.ChampyWithCard
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon
import com.gg.spora.ui.theme.SporaTheme
import javax.inject.Inject

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
    challengeViewModel: ChallengeViewModel = hiltViewModel()
) {


    val lifecycleOwner = LocalLifecycleOwner.current
    var buttonContinueEnabled by remember { mutableStateOf(false) }
    var champyImage by remember { mutableIntStateOf(R.drawable.champy_sonriente_brazosalcuerpo) }
    var objectsChallenge by remember { mutableStateOf(mapOf<String, Boolean>()) }

    LaunchedEffect(challengeViewModel.objectsChallenge) {
        challengeViewModel.objectsChallenge.observe(lifecycleOwner) { objects ->
                objectsChallenge = objects
        }
    }

    if(objectsChallenge.values.all{ it }){
        champyImage = R.drawable.champy_celebrando_brazoslevantados
        buttonContinueEnabled = true
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(R.drawable.fondo_minijuegos),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-360).dp)
        )
        Column(
            modifier = modifier
        ) {
            TopBarWithTitleExitAndIcon(
                title = stringResource(R.string.title_challenge),
                onBackClick = onBackClick,
                showIcon = false
            )
            ChampyWithCard(
                modifier = Modifier.fillMaxSize(),
                champyImage = champyImage,
            ) {
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
                                        challengeViewModel.selectObject(nameObject)
                                        onNavigateToCameraScreen(nameObject)
                                    },
                                isValidate = it.value
                            )
                        }
                    }


                }
            }
        }
    }
}
/*
@Preview
//@PreviewLightDark
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun ChallengeScreenPreview() {
SporaTheme {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ChallengeScreen(
            modifier = Modifier,
            onBackClick = { },
            onNavigateToCameraScreen = {

            }
        )
    }
}
}

 */