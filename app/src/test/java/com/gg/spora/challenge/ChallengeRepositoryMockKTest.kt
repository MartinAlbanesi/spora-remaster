package com.gg.spora.challenge

import com.gg.spora.challenge.data.dao.ChallengeDao
import com.gg.spora.challenge.data.repositories.ChallengeRepository
import com.gg.spora.challenge.domain.entities.ObjectDetailEntity
import com.gg.spora.challenge.domain.model.ObjectDetail
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ChallengeRepositoryMockKTest {

    private lateinit var challengeDao: ChallengeDao
    private lateinit var challengeRepository: ChallengeRepository

    @Before
    fun setUp() {
        challengeDao = mockk(relaxed = true)
        challengeRepository = ChallengeRepository(challengeDao)
    }

    @Test
    fun `test getAllObjectsDetail`() = runBlocking {
        val objectDetailEntities = listOf(
            ObjectDetailEntity("Test Object 1", "Description 1", false),
            ObjectDetailEntity("Test Object 2", "Description 2", true)
        )

        coEvery { challengeDao.getAllObjectsDetail() } returns objectDetailEntities

        val objectDetails = challengeRepository.getAllObjectsDetail()

        assertEquals(2, objectDetails.size)
        assertEquals("Test Object 1", objectDetails[0].nameObjectDetail)
        assertEquals("Test Object 2", objectDetails[1].nameObjectDetail)

        coVerify { challengeDao.getAllObjectsDetail() }
    }

    @Test
    fun `test insertObjectDetail`() = runBlocking {
        val objectDetail = ObjectDetail("Test Object", "Test Description", false)

        challengeRepository.insertObjectDetail(objectDetail)

        coVerify { challengeDao.insertObjetDetail(objectDetail.toObjectDetailEntity()) }
    }

    @Test
    fun `test updateObjectDetailWithId`() = runBlocking {
        challengeRepository.setValidObjectDetailInDatabase("Test Object")

        // Verificar que se llamó al método de actualización en el DAO
        coVerify { challengeDao.setValidObjectDetailInDatabase("Test Object") }
    }
}
