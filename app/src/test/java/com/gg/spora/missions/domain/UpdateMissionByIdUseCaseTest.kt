package com.gg.spora.missions.domain

import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UpdateMissionByIdUseCaseTest{

    private lateinit var updateMissionByIdUseCase: UpdateMissionByIdUseCase

    @RelaxedMockK
    private lateinit var missionRepositoryLocal: IMissionRepositoryLocal

    private lateinit var mission: Mission

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        updateMissionByIdUseCase = UpdateMissionByIdUseCase(missionRepositoryLocal)

        mission = Mission(1, "Pasar un nivel", 15, 1, 0)
    }

    @Test
    fun `invoke - When Id Is Incorrect - Then Return Null`() = runTest {

        // Given
        val missionId = 1.toByte()

        // When
        coEvery { missionRepositoryLocal.updateCounterMission(missionId) } returns Unit
        coEvery { missionRepositoryLocal.getMissionById(missionId) } returns null

        // Then
        val result = updateMissionByIdUseCase(missionId)

        assertEquals(null, result)
    }

    @Test
    fun `invoke - When Counter Is Different To Objective - Then Return Null`() = runTest {

        // Given
        val missionId = 1.toByte()

        // When
        coEvery { missionRepositoryLocal.updateCounterMission(missionId) } returns Unit
        coEvery { missionRepositoryLocal.getMissionById(missionId) } returns mission

        // Then
        val result = updateMissionByIdUseCase(missionId)

        assertEquals(null, result)
    }

    @Test
    fun `invoke - When Counter Is Equal To Objective - Then Return Mission`() = runTest {

        // Given
        val missionId = 1.toByte()

        // When
        coEvery { missionRepositoryLocal.updateCounterMission(missionId) } returns Unit
        coEvery { missionRepositoryLocal.getMissionById(missionId) } returns mission.copy(counter = 1)

        // Then
        val result = updateMissionByIdUseCase(missionId)

        assertEquals(mission.copy(counter = 1), result)
    }
}