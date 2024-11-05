package com.gg.spora.miniGames.data.local

import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.miniGames.domain.mappers.toAnswer
import com.gg.spora.miniGames.domain.mappers.toQuestion
import io.mockk.every
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class QuizLocalServiceTest {

    private lateinit var quizLocalService: QuizLocalService

    @Before
    fun setUp() {
        quizLocalService = QuizLocalService()
    }

    @Test
    fun `get questions from json file`(){
        val questionsLocal = quizLocalService.getLocalQuestions().first()
        println("QuestionLocal: $questionsLocal")
        assertEquals(questionsLocal.question, "¿Cuál de estas acciones pertenece a la regla de las 3 erres de la sostenibilidad?")
    }

    @Test
    fun `get answers from json file`() {
        val answersLocal = quizLocalService.getLocalAnswers()
        assertEquals(answersLocal[0].answer, "Aire")
    }

    @Test
    fun `AnswerLocal to Answer`(){
        val answerLocal = quizLocalService.getLocalAnswers().first()
        val answer = answerLocal.toAnswer()
        println("AnswerLocal: $answerLocal")
        println("Answer     : $answer")
        assertEquals(answer.answer, "Aire")
    }

    @Test
    fun `QuestionLocal to Question`(){
        val questionLocal = quizLocalService.getLocalQuestions()[10]
        println("QuestionLocal: $questionLocal")
        assertEquals(questionLocal.question, "¿Qué representa la imagen?")
    }
}