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

class SetNewStagesLevelUseCaseTest{

    private lateinit var setNewStagesLevelUseCase: SetNewStagesLevelUseCase

    @RelaxedMockK
    private lateinit var stageRepositoryLocal: IStageRepositoryLocal

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        setNewStagesLevelUseCase = SetNewStagesLevelUseCase(stageRepositoryLocal)
    }

    @Test
    fun `invoke - When Stages Level Count Is Greater MAX_STAGES_LEVEL - Then Do Not Save New Stages Level`() = runTest {

        // Given
        val stageLevels = FakeStageModels.fakeStage

        // When
        coEvery { stageRepositoryLocal.getStageLevelCount() } returns SporaConstant.MAX_STAGES_LEVEL

        setNewStagesLevelUseCase(stageLevels)

        // Then
        coVerify(exactly = 1) { stageRepositoryLocal.getStageLevelCount() }
        coVerify(exactly = 0) { stageRepositoryLocal.setNewStagesLevel(stageLevels) }
    }

    @Test
    fun `invoke - When Stages Level Count Is Zero - Then Save New Stages Level`() = runTest {

        // Given
        val stageLevels = FakeStageModels.fakeStage

        // When
        coEvery { stageRepositoryLocal.getStageLevelCount() } returns 0

        setNewStagesLevelUseCase(stageLevels)

        // Then
        coVerify(exactly = 1) { stageRepositoryLocal.getStageLevelCount() }
        coVerify(exactly = 1) { stageRepositoryLocal.setNewStagesLevel(stageLevels) }
    }
}