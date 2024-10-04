package com.gg.spora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gg.spora.core.components.MiniGameScreen
import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.quiz.ui.QuizScreen
import com.gg.spora.quiz.ui.QuizViewModel
import com.gg.spora.ui.theme.SporaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val quizViewModel: QuizViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            SporaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {

                    val currentQuestion by quizViewModel.currentQuestion.collectAsState()

                    MiniGameScreen(
                        modifier = Modifier.fillMaxSize(),
                        imageBackground = R.drawable.fondo_minijuegos,
                        champyImage = R.drawable.champy_celebrando_brazoslevantados,
                        onBackClick = { },
                        content = {
                            QuizScreen(
                                modifier = Modifier.fillMaxSize().padding(16.dp),
                                questionTitle = currentQuestion!!.question,
                                answerOptions = currentQuestion!!.answers,
                                answerQuestionId = currentQuestion!!.answer.id,
                                onAnswerSelected = quizViewModel::isAnswerCorrect,
                                onNextQuestion = quizViewModel::nextQuestion
                            )
                        }
                    )
                }
            }
        }
    }
}