package com.gg.spora.user.domain

import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getTotalOxygenFromStars
import com.gg.spora.forestStage.domain.functions.updateOxygenReward
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import com.google.firebase.auth.FirebaseUser
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.mockkStatic
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
    private lateinit var getUserAuthUseCase: GetUserAuthUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        updateUserLevelsAndOxygenUseCase = UpdateUserLevelsAndOxygenUseCase(
            userRepositoryLocal,
            userRepositoryNetwork,
            getUserAuthUseCase
        )
    }

    @Test
    fun `invoke - When StarState is greater than CurrentUserLevelCompleted - Then Update User in local & remote`() = runTest {

        // Given
        val levelId = "1"
        val stageType = StageType.FOREST
        val starState = StarState.THREE
        val currentUser = mockk<FirebaseUser>()
        val oxygen = listOf(10, 20, 30)
        mockkStatic(::getTotalOxygenFromStars)
        mockkStatic(::updateOxygenReward)

        coEvery { userRepositoryLocal.getUser() } returns flowOf(FakeUserModels.fakeUsers.first())
        coEvery { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) } returns Unit
        coEvery { getUserAuthUseCase() } returns currentUser
        coEvery { userRepositoryNetwork.updateUserById(any(), any()) } returns Unit
        coEvery { updateOxygenReward(any(), any()) } returns listOf(0, 20, 30)
        coEvery { getTotalOxygenFromStars(any(), any()) } returns 50

        // When
        updateUserLevelsAndOxygenUseCase(levelId, starState, stageType, oxygen)

        // Then
        coVerify(exactly = 1) { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) }
        coVerify(exactly = 1) { userRepositoryNetwork.updateUserById(any(), any()) }
        coVerify(exactly = 1) { updateOxygenReward(any(), any()) }
        coVerify(exactly = 1) { getTotalOxygenFromStars(any(), any()) }
    }

    @Test
    fun `invoke - When set corrects params and UserNetwork is null - Then Update User in local`() = runTest {

        // Given
        val levelId = "1"
        val stageType = StageType.FOREST
        val starState = StarState.TWO
        val currentUser = null
        val oxygen = listOf(10, 20, 30)
        mockkStatic(::getTotalOxygenFromStars)
        mockkStatic(::updateOxygenReward)

        coEvery { userRepositoryLocal.getUser() } returns flowOf(FakeUserModels.fakeUsers.first())
        coEvery { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) } returns Unit
        coEvery { getUserAuthUseCase() } returns currentUser
        coEvery { userRepositoryNetwork.updateUserById(any(), any()) } returns Unit
        coEvery { updateOxygenReward(any(), any()) } returns listOf(0, 0, 0)
        coEvery { getTotalOxygenFromStars(any(), any()) } returns 0

        // When
        updateUserLevelsAndOxygenUseCase(levelId, starState, stageType, oxygen)

        // Then
        coVerify(exactly = 1) { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) }
        coVerify(exactly = 0) { userRepositoryNetwork.updateUserById(any(), any()) }
        coVerify(exactly = 1) { updateOxygenReward(any(), any()) }
        coVerify(exactly = 1) { getTotalOxygenFromStars(any(), any()) }
    }

    @Test
    fun `invoke - When StarState is Less to Current User Level Completed- Then Do not Update Data`() = runTest {
        // Given
        val levelId = "2"
        val stageType = StageType.FOREST
        val starState = StarState.ONE
        val currentUser = null
        val oxygen = listOf(10, 20, 30)
        mockkStatic(::getTotalOxygenFromStars)
        mockkStatic(::updateOxygenReward)

        coEvery { userRepositoryLocal.getUser() } returns flowOf(FakeUserModels.fakeUsers.first())
        coEvery { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) } returns Unit
        coEvery { getUserAuthUseCase() } returns currentUser
        coEvery { userRepositoryNetwork.updateUserById(any(), any()) } returns Unit
        coEvery { updateOxygenReward(any(), any()) } returns listOf(10, 20, 30)
        coEvery { getTotalOxygenFromStars(any(), any()) } returns 20

        // When
        updateUserLevelsAndOxygenUseCase(levelId, starState, stageType, oxygen)

        // Then
        coVerify(exactly = 0) { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) }
        coVerify(exactly = 0) { userRepositoryNetwork.updateUserById(any(), any()) }
        coVerify(exactly = 0) { updateOxygenReward(any(), any()) }
        coVerify(exactly = 0) { getTotalOxygenFromStars(any(), any()) }
    }

    @Test
    fun `invoke - When user do not have levels completed - Then Save new level with starState & Oxygen won`() = runTest {

        // Given
        val userWithinoutLevels = FakeUserModels.fakeUsers.last()
        val levelId = "1"
        val stageType = StageType.FOREST
        val starState = StarState.TWO
        val currentUser = null
        val oxygen = listOf(10, 20, 30)
        mockkStatic(::getTotalOxygenFromStars)
        mockkStatic(::updateOxygenReward)

        coEvery { userRepositoryLocal.getUser() } returns flowOf(userWithinoutLevels)
        coEvery { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) } returns Unit
        coEvery { getUserAuthUseCase() } returns currentUser
        coEvery { userRepositoryNetwork.updateUserById(any(), any()) } returns Unit
        coEvery { updateOxygenReward(any(), any()) } returns oxygen
        coEvery { getTotalOxygenFromStars(any(), any()) } returns 20

        // When
        updateUserLevelsAndOxygenUseCase(levelId, starState, stageType, oxygen)

        // Then
        coVerify(exactly = 1) { userRepositoryLocal.updateUserWithLevelCompleted(any(), any()) }
        coVerify(exactly = 0) { userRepositoryNetwork.updateUserById(any(), any()) }
        coVerify(exactly = 0) { updateOxygenReward(any(), any()) }
        coVerify(exactly = 1) { getTotalOxygenFromStars(any(), any()) }
    }
}