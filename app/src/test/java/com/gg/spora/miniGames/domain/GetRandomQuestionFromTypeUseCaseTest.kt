package com.gg.spora.miniGames.domain

import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.mappers.toAnswer
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.jupiter.api.DisplayName


class GetRandomQuestionFromTypeUseCaseTest {

    private lateinit var getRandomQuestionFromTypeUseCase: GetRandomQuestionFromTypeUseCase

    @RelaxedMockK
    private lateinit var quizLocalRepository: IQuizLocalRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getRandomQuestionFromTypeUseCase = GetRandomQuestionFromTypeUseCase(quizLocalRepository)
    }

    @DisplayName("invoke" +
        "Cuando se ingrese un tipo de juego RELATIONS, " +
        "Entonces se deberia retornar una lista con preguntas aleatorias con 6 respuestas")
    @Test
    fun invoke_RELATIONS_GAME_Test() {
        // Given
        val count = 5
        val typeQuestion = listOf(TypeQuestion.RELATIONS_QUESTION)
        val typeGame = TypeGame.RELATIONS

        // When
        every { quizLocalRepository.getRandomQuestions(count, typeQuestion, typeGame) } returns FakeQuizModels.fakeQuestionRelations.shuffled()

        // Then
        val actual = getRandomQuestionFromTypeUseCase(count, typeQuestion, typeGame)

        // Verify
        assertEquals(count, actual.size)
    }

    @Ignore
    @DisplayName("invoke" +
        "Cuando se ingrese un tipo de juego QUIZ, " +
        "Entonces se deberia retornar una lista con preguntas del tipo QUIZ aleatorias con 4 respuestas cada una")
    @Test
    fun invoke_QUIZ_GAME_Test() {
        // Given
        val count = 4
        val typeQuestion = listOf(TypeQuestion.MARTIN, TypeQuestion.RECYCLE)
        val typeGame = TypeGame.QUIZ

        // When
        every { quizLocalRepository.getRandomAnswers(count, typeQuestion, typeGame) } returns  FakeQuizModels.fakeLocalAnswers.map { it.toAnswer() }
        every { quizLocalRepository.getRandomQuestions(count, typeQuestion, typeGame) } returns FakeQuizModels.fakeQuestionQuizTypeMartin.shuffled()

        // Then
        val actual = getRandomQuestionFromTypeUseCase(count, typeQuestion, typeGame)

        assertEquals(count, actual.size)
        assertEquals("wea", actual[0].question)
    }
}