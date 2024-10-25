package com.gg.spora.miniGames.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.gg.spora.R
import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.ui.components.MiniGameScreen
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.ui.components.RelationItemSelected
import com.gg.spora.ui.theme.SporaTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RelationsScreen(
    modifier: Modifier = Modifier,
    objectName: String,
    answers: List<Answer>,
    selectedItems: List<String>,
    isCorrect: Boolean?,
    onSelectedItem: (answerId: String) -> Unit,
    onConfirmSelecteds: () -> Unit
) {


    Box(
        modifier = Modifier.fillMaxSize(),
    ) {


        ConstraintLayout(
            modifier = modifier
        ) {

            val (title, item, options, confirmButton) = createRefs()

            val topGuideline = createGuidelineFromTop(0.05f)
            val bottomGuideline = createGuidelineFromBottom(0.2f)
//        createVerticalChain(title, item, options, chainStyle = ChainStyle.Spread)

            Text(
                text = "Seleccioná los 3 conceptos relacionados",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(topGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                    .padding(horizontal = 5.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .heightIn(min = 50.dp)
//                .fillMaxHeight(0.15f)
                    .widthIn(min = 220.dp)
                    .background(colorResource(R.color.tertiary))
                    .constrainAs(item) {
                        top.linkTo(title.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(options.top)
                    }
            ) {
                Text(
                    text = objectName,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            }

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.constrainAs(options) {
                    top.linkTo(item.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomGuideline)
                }
            ) {
                answers.forEach { answer ->
                    RelationItemSelected(
                        modifier = Modifier
//                        .widthIn(min = 140.dp, max = 180.dp)
                            .fillMaxWidth(0.4f)
//                        .heightIn(max = 60.dp),
                            .fillMaxHeight(0.1f),
//                        .heightIn(max = 60.dp),
                        answer = answer.answer,
                        isCorrect = answer.isCorrect,
                        isEnabled = isCorrect == null,
                        isSelected = selectedItems.contains(answer.id),
                        onSelected = { onSelectedItem(answer.id) }
                    )

                }
            }

        }
        if (selectedItems.size == 3 && isCorrect == null) {
            Button(
                onClick = onConfirmSelecteds,
                modifier = Modifier
                    .padding(16.dp)
                    .heightIn(min = 48.dp, max = 60.dp)
//                    .fillMaxHeight(0.15f)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
//                    .constrainAs(confirmButton) {
//                        bottom.linkTo(parent.bottom)
//                        start.linkTo(parent.start)
//                        end.linkTo(parent.end)
//                    }
            ) {
                Text(text = "Confirmar")
            }
        }

    }
}

//@PreviewLightDark
@Preview(
    heightDp = 640,
    widthDp = 360,
)
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun RelationsScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            val isCorrect by rememberSaveable { mutableStateOf<Boolean?>(null) }

            MiniGameScreen(
                modifier = Modifier.fillMaxSize(),
                title = "Titi",
                imageBackground = R.drawable.minigame_background_crop,
                isCorrect = null,
                questionSize = SporaConstant.MAX_QUESTIONS,
                isFinished = false,
                lives = 5,
                showButtonContinue = true,
                counterQuestion = 0,
                onNextQuestion = {},
                onResetGame = {},
                onBackForestStage = { },
                onNavigateNextLevel = { },
                content = {
                    RelationsScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 0.dp),
                        objectName = "Botella de plástico",
                        answers = FakeQuizModels.fakeAnswers.filter { it.id.toInt() > 100 }.take(6)
                            .shuffled(),
                        selectedItems = listOf("55", "56", "57"),
                        isCorrect = isCorrect,
                        onSelectedItem = { },
                        onConfirmSelecteds = {},
                    )
                }
            )

        }
    }
}