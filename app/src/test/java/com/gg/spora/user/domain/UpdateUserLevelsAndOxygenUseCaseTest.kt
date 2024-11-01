package com.gg.spora.user.domain

import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import com.google.firebase.auth.FirebaseUser
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class UpdateUserLevelsAndOxygenUseCaseTest {

    private lateinit var updateUserLevelsAndOxygenUseCase: UpdateUserLevelsAndOxygenUseCase

    @RelaxedMockK
    private lateinit var userRepositoryLocal: IUserRepositoryLocal

    @RelaxedMockK
    private lateinit var userRepositoryNetwork: IUserRepositoryNetwork

    @RelaxedMockK
    private lateinit var getCurrentUserUseCase: GetCurrentUserUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        updateUserLevelsAndOxygenUseCase = UpdateUserLevelsAndOxygenUseCase(
            userRepositoryLocal,
            userRepositoryNetwork,
            getCurrentUserUseCase
        )
    }

    @Test
    fun `invoke - When set corrects params and CurrentUser is not null - Then Update User in local & remote`() = runTest {

        // Given
        val userId = FakeUserModels.fakeUsers.first().id
        val levelId = "1"
        val stageType = StageType.FOREST
        val starState = StarState.TWO
        val currentUser = mockk<FirebaseUser>()

        coEvery { userRepositoryLocal.getUserByIdFlow(userId) } returns flowOf(FakeUserModels.fakeUsers.first())
        coEvery { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) } returns Unit
        coEvery { getCurrentUserUseCase() } returns currentUser
        coEvery { userRepositoryNetwork.updateUserById(any(), any()) } returns Unit

        // When
        updateUserLevelsAndOxygenUseCase(userId, levelId, starState, stageType, 100)

        // Then
        coVerify(exactly = 1) { userRepositoryLocal.getUserByIdFlow(userId) }
        coVerify(exactly = 1) { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) }
        coVerify(exactly = 1) { getCurrentUserUseCase() }
        coVerify(exactly = 1) { userRepositoryNetwork.updateUserById(any(), any()) }
    }

    @Test
    fun `invoke - When set corrects params and CurrentUser is null - Then Update User in local`() = runTest {

        // Given
        val userId = FakeUserModels.fakeUsers.first().id
        val levelId = "1"
        val stageType = StageType.FOREST
        val starState = StarState.TWO
        val currentUser = null

        coEvery { userRepositoryLocal.getUserByIdFlow(userId) } returns flowOf(FakeUserModels.fakeUsers.first())
        coEvery { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) } returns Unit
        coEvery { getCurrentUserUseCase() } returns currentUser
        coEvery { userRepositoryNetwork.updateUserById(any(), any()) } returns Unit

        // When
        updateUserLevelsAndOxygenUseCase(userId, levelId, starState, stageType, 100)

        // Then
        coVerify(exactly = 1) { userRepositoryLocal.getUserByIdFlow(userId) }
        coVerify(exactly = 1) { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) }
        coVerify(exactly = 1) { getCurrentUserUseCase() }
        coVerify(exactly = 0) { userRepositoryNetwork.updateUserById(any(), any()) }
    }
}