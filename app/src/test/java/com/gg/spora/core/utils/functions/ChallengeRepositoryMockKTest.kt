package com.gg.spora.core.utils.functions

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
        // Crear un mock del DAO usando MockK
        challengeDao = mockk(relaxed = true)
        // Crear una instancia del repositorio usando el DAO simulado
        challengeRepository = ChallengeRepository(challengeDao)
    }

    @Test
    fun `test getAllObjectsDetail`() = runBlocking {
        // Simular el comportamiento del DAO con MockK
        val objectDetailEntities = listOf(
            ObjectDetailEntity(1, "Test Object 1", "Description 1", false),
            ObjectDetailEntity(2, "Test Object 2", "Description 2", true)
        )

        // Configurar MockK para devolver esta lista cuando se llame a `getAllObjectsDetail`
        coEvery { challengeDao.getAllObjectsDetail() } returns objectDetailEntities

        // Llamar al método del repositorio
        val objectDetails = challengeRepository.getAllObjectsDetail()

        // Verificar que los datos se transforman correctamente
        assertEquals(2, objectDetails.size)
        assertEquals("Test Object 1", objectDetails[0].nameObjectDetail)
        assertEquals("Test Object 2", objectDetails[1].nameObjectDetail)

        // Verificar que se llamó el método correcto del DAO
        coVerify { challengeDao.getAllObjectsDetail() }
    }

    @Test
    fun `test insertObjectDetail`() = runBlocking {
        val objectDetail = ObjectDetail(1, "Test Object", "Test Description", false)

        // Llamar al método del repositorio para insertar el objeto
        challengeRepository.insertObjectDetail(objectDetail)

        // Verificar que se llamó al método de inserción en el DAO
        coVerify { challengeDao.insertObjetDetail(objectDetail.toObjectDetailEntity()) }
    }

    @Test
    fun `test updateObjectDetailWithId`() = runBlocking {
        // Llamar al método del repositorio para actualizar un objeto por su ID
        challengeRepository.updateObjectDetailWithId(1)

        // Verificar que se llamó al método de actualización en el DAO
        coVerify { challengeDao.updateObjectDetailWithId(1) }
    }
}
