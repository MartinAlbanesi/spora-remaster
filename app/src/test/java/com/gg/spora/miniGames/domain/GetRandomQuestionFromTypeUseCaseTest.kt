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


class GetRandomQuestionFromTypeUseCaseTest {

    private lateinit var getRandomQuestionFromTypeUseCase: GetRandomQuestionFromTypeUseCase

    @RelaxedMockK
    private lateinit var quizLocalRepository: IQuizLocalRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getRandomQuestionFromTypeUseCase = GetRandomQuestionFromTypeUseCase(quizLocalRepository)
    }

    @Test
    fun invoke_WhenInsertAGameTypeRELATIONS_ThenReturnRandomListWith6Answer() {
        // Given
        val count = 5
        val typeQuestion = listOf(TypeQuestion.RELATIONS_QUESTION)
        val typeGame = TypeGame.RELATIONS

        // When
        every { quizLocalRepository.getRandomQuestions(count, typeQuestion, typeGame) } returns FakeQuizModels.newFakeQuizQuestions.shuffled()

        // Then
        val actual = getRandomQuestionFromTypeUseCase(count, typeQuestion, typeGame)

        // Verify
        assertEquals(count, actual.size)
    }

    @Ignore("This test is failing because the function is not implemented")
    @Test
    fun invoke_WhenInsertAQuizGameType_ThenReturnRandomQuestionList() {
        // Given
        val count = 4
        val typeQuestion = listOf(TypeQuestion.MARTIN, TypeQuestion.RECYCLE)
        val typeGame = TypeGame.QUIZ

        // When
        every { quizLocalRepository.getRandomAnswers(count, typeQuestion, typeGame) } returns  FakeQuizModels.newFakeAnswers
        every { quizLocalRepository.getRandomQuestions(count, typeQuestion, typeGame) } returns FakeQuizModels.newFakeQuizQuestions.shuffled()

        // Then
        val actual = getRandomQuestionFromTypeUseCase(count, typeQuestion, typeGame)

        assertEquals(count, actual.size)
        assertEquals("wea", actual[0].question)
    }
}