package com.gg.spora.miniGames.data.local

import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class QuizLocalRepositoryTest{

    private lateinit var quizLocalRepository: QuizLocalRepository

    @RelaxedMockK
    private lateinit var quizLocalService: QuizLocalService

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        quizLocalRepository = QuizLocalRepository(
            quizLocalService = quizLocalService, 
            context = mockk()
        )
    }

    @Test
    fun `getAnswerById - When insert a correct ID - Then return correct Answer` () = runTest{
        // Given
        val expect = "11"
        every { quizLocalService.getLocalAnswers() } returns FakeQuizModels.fakeLocalAnswers

        // When
        val answer = quizLocalRepository.getAnswerById(expect)

        // Then
        assertEquals(expect, answer?.id)
    }

    @Test
    fun `getAnswerById - When insert a incorrect ID - Then return null` (){
        // Given
        val expect = "16"
        every { quizLocalService.getLocalAnswers() } returns FakeQuizModels.fakeLocalAnswers

        // When
        val answer = quizLocalRepository.getAnswerById(expect)

        // Then
        assertEquals(null, answer?.id)
    }

    @Test
    fun `getRandomAnswers - When insert a correct count - Then return correct count of Answers` (){
        // Given
        val count = 4
        val typeQuestion = listOf(TypeQuestion.MARTIN, TypeQuestion.RECYCLE)
        val typeGame = TypeGame.QUIZ
        every { quizLocalService.getLocalAnswers() } returns FakeQuizModels.fakeLocalAnswers

        // When
        val actual = quizLocalRepository.getRandomAnswers(
            count = count,
            typeQuestion = typeQuestion,
            typeGame = typeGame
        )
        // Then
        assertEquals(count, actual.size)
    }

}