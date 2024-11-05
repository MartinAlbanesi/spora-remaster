package com.gg.spora.stage.domain

import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.user.domain.GetUserLocalUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class GetLevelsUseCaseTest {

    private lateinit var getLevelsUseCase: GetLevelsUseCase

    @RelaxedMockK
    private lateinit var stageRepositoryLocal: IStageRepositoryLocal

    @RelaxedMockK
    private lateinit var getUserLocalUseCase: GetUserLocalUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        getLevelsUseCase = GetLevelsUseCase(stageRepositoryLocal, getUserLocalUseCase)
    }

    @DisplayName("Cuando se invoca al caso de uso, " +
        "se debe retornar un flujo de niveles combinado con los niveles completados por el usuario")

    @Test
    operator fun invoke() = runTest {

        // Given
        val levelsFlow = flowOf(FakeStageModels.fakeLevels)
        val userLevelsCompleted = flowOf(FakeUserModels.fakeUsers.first())

        coEvery { getUserLocalUseCase() } returns userLevelsCompleted
        coEvery { stageRepositoryLocal.getLevelsByStageType(any()) } returns levelsFlow

        // When
        val result = getLevelsUseCase(StageType.FOREST).first()

        // Then
        assertNotEquals(FakeStageModels.fakeLevels, result)
        assertEquals(StarState.ONE, result.first().starState)
    }
}