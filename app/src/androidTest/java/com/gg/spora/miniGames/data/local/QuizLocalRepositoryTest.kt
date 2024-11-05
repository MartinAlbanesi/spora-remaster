package com.gg.spora.miniGames.data.local

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QuizLocalRepositoryTest {

    private lateinit var quizLocalRepository: QuizLocalRepository

    private lateinit var context: Context

    @RelaxedMockK
    private lateinit var quizLocalService: QuizLocalService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
        quizLocalRepository = QuizLocalRepository(context, quizLocalService)
    }


//    @Test
//    fun getQuestionById_WhenInsertACorrectID_ThenReturnQuestionWithItID(){
//        // Given
//        val id = "1"
//        every { quizLocalService.getLocalQuestions() } returns FakeQuizModels.fakeLocalQuestions
//
//        // When
//        val question = quizLocalRepository.getQuestionById(id)
//
//        // Then
//        assertEquals(question?.id, id)
//    }
}