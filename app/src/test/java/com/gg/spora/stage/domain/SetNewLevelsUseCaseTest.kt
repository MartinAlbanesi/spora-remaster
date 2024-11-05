package com.gg.spora.stage.domain

import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.utils.SporaConstant
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SetNewLevelsUseCaseTest {

    private lateinit var setNewLevelsUseCase: SetNewLevelsUseCase

    @RelaxedMockK
    private lateinit var stageRepositoryLocal: IStageRepositoryLocal

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        setNewLevelsUseCase = SetNewLevelsUseCase(stageRepositoryLocal)
    }

    @Test
    fun `invoke - When Levels Count is Greater than MAX_STAGES_LEVEL - Then Not Save New Levels`() = runTest {

        // Given
        val levels = FakeStageModels.fakeLevels

        // When
        coEvery { stageRepositoryLocal.getLevelsCount() } returns SporaConstant.MAX_STAGES_LEVEL

        setNewLevelsUseCase(levels)

        // Then
        coVerify(exactly = 1) { stageRepositoryLocal.getLevelsCount() }
        coVerify(exactly = 0) { stageRepositoryLocal.setNewLevels(levels) }
    }

    @Test
    fun `invoke - When Levels Count is Zero - Then Save New Levels`() = runTest {

        // Given
        val levels = FakeStageModels.fakeLevels

        // When
        coEvery { stageRepositoryLocal.getLevelsCount() } returns 0

        setNewLevelsUseCase(levels)

        // Then
        coVerify(exactly = 1) { stageRepositoryLocal.getLevelsCount() }
        coVerify(exactly = 1) { stageRepositoryLocal.setNewLevels(levels) }
    }
}