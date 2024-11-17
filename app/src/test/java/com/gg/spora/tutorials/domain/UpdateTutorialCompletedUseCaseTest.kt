package com.gg.spora.tutorials.domain

import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryNetwork
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.google.firebase.auth.FirebaseUser
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class UpdateTutorialCompletedUseCaseTest{

    private lateinit var updateTutorialCompletedUseCase: UpdateTutorialCompletedUseCase

    @RelaxedMockK
    private lateinit var getUserAuthUseCase: GetUserAuthUseCase

    @RelaxedMockK
    private lateinit var tutorialRepositoryLocal: ITutorialRepositoryLocal

    @RelaxedMockK
    private lateinit var tutorialRepositoryNetwork: ITutorialRepositoryNetwork

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        updateTutorialCompletedUseCase = UpdateTutorialCompletedUseCase(
            getUserAuthUseCase,
            tutorialRepositoryLocal,
            tutorialRepositoryNetwork
        )
    }

    @Test
    fun `invoke - When User Is not Logged - Then do not update in network`() = runTest {

        // Given
        val userId = "userId"
        val tutorialId = 1
        val isCompleted = true

        // When

        coEvery { getUserAuthUseCase() } returns null

        updateTutorialCompletedUseCase(userId, tutorialId, isCompleted)

        // Then
        coVerify(exactly = 1) { tutorialRepositoryLocal.updateTutorialCompleted(tutorialId, isCompleted) }
        coVerify(exactly = 0) { tutorialRepositoryNetwork.updateTutorialCompleted(userId, tutorialId, isCompleted) }
    }

    @Test
    fun `invoke - When User Is Logged - Then update in network`() = runTest {

        // Given
        val userId = "userId"
        val tutorialId = 1
        val isCompleted = true
        val currentUser = mockk<FirebaseUser>()

        // When

        coEvery { getUserAuthUseCase() } returns currentUser

        updateTutorialCompletedUseCase(userId, tutorialId, isCompleted)

        // Then
        coVerify(exactly = 1) { tutorialRepositoryLocal.updateTutorialCompleted(tutorialId, isCompleted) }
        coVerify(exactly = 1) { tutorialRepositoryNetwork.updateTutorialCompleted(userId, tutorialId, isCompleted) }
    }
}