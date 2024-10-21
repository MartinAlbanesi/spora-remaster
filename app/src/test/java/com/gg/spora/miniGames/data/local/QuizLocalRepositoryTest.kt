package com.gg.spora.miniGames.data.local

import android.content.Context
import com.gg.spora.miniGames.domain.mappers.toAnswer
import com.gg.spora.miniGames.domain.mappers.toQuestion
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class QuizLocalRepositoryTest{

    private lateinit var quizLocalRepository: QuizLocalRepository

    private val context = mockk<Context>(relaxed = true)

    @Before
    fun setUp(){
        quizLocalRepository = QuizLocalRepository(context)
    }

    @Test
    fun `get questions from json file`(){
        val questionsLocal = quizLocalRepository.questionsLocal[0]
        println("QuestionLocal: $questionsLocal")
        assertEquals(questionsLocal.question, "¿Cuál de estas acciones pertenece a la regla de las 3 erres de la sostenibilidad?")
    }

    @Test
    fun `get answers from json file`() {
        val answersLocal = quizLocalRepository.answersLocal
        assertEquals(answersLocal[0].answer, "Aire")
    }

    @Test
    fun `AnswerLocal to Answer`(){
        val answerLocal = quizLocalRepository.answersLocal[0]
        val answer = answerLocal.toAnswer()
        println("AnswerLocal: $answerLocal")
        println("Answer     : $answer")
        assertEquals(answer.answer, "Aire")
    }

    @Test
    fun `QuestionLocal to Question`(){
        val questionLocal = quizLocalRepository.questionsLocal[10]
        val question = questionLocal.toQuestion(context)
        println("QuestionLocal: $questionLocal")
        println("Question     : $question")
        assertEquals(question.question, "¿Qué representa la imagen?")
    }

}