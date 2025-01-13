package com.gg.spora.grove.data.database

import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.database.entities.CooldownDataEntity
import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import com.gg.spora.grove.data.database.entities.toCooldownData
import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.mappers.toForestTreeEntity
import com.gg.spora.grove.domain.mappers.toSeedTreeEntity
import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import com.gg.spora.grove.domain.models.toCooldownDataEntity
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class GroveRepositoryTest{

    private lateinit var groveRepository: IGroveRepository

    @RelaxedMockK
    private lateinit var groveDao: GroveDao

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        groveRepository = GroveRepository(groveDao)
    }

    // Seed Trees Tests

    @Test
    fun `when SeedTrees is empty then return empty list`() = runTest {
        // Given
        coEvery { groveDao.getSeedTreesList() } returns flowOf(emptyList<SeedTreeEntity>())

        // When
        val result = groveRepository.getSeedTreesListFromDatabase().first()

        // Then
        Assert.assertEquals(emptyList<SeedTree>(), result)
    }

    @Test
    fun `when inserting SeedTrees then insert into database`() = runTest {
        // Given
        val seedTrees = listOf(SeedTree(id = 1.toString(), type = TreeType.SECUOYA))
        val seedTreeEntities = seedTrees.map { it.toSeedTreeEntity() }

        // When
        groveRepository.insertSeedTreesList(seedTrees)

        // Then
        coVerify { groveDao.insertSeedTreesList(seedTreeEntities) }
    }

    @Test
    fun `when deleting SeedTree then delete from database`() = runTest {
        // Given
        val treeId = "1"

        // When
        groveRepository.deleteSeedTreeById(treeId)

        // Then
        coVerify { groveDao.deleteSeedTreeById(treeId) }
    }

    // Forest Trees

    @Test
    fun `when ForestTrees is empty then return list with nulls`() = runTest {
        // Given
        coEvery { groveDao.getForestTreesList() } returns flowOf(emptyList<ForestTreeEntity>())

        // When
        val result = groveRepository.getForestTreesListFromDatabase().first()

        // Then
        Assert.assertEquals(List(50) { null }, result)
    }

    @Test
    fun `when inserting ForestTree then insert into database`() = runTest {
        // Given
        val forestTree = ForestTree(id = 1.toString(), type = TreeType.SECUOYA)
        val forestTreeEntity = forestTree.toForestTreeEntity()

        // When
        groveRepository.insertForestTree(forestTree)

        // Then
        coVerify { groveDao.insertForestTree(forestTreeEntity) }
    }

    @Test
    fun `when deleting ForestTree then delete from database`() = runTest {
        // Given
        val treeId = "1"

        // When
        groveRepository.deleteForestTreeById(treeId)

        // Then
        coVerify { groveDao.deleteForestTreeById(treeId) }
    }

    @Test
    fun `when updating ForestTree growth stage then update in database`() = runTest {
        // Given
        val forestTree = ForestTree(id = 1.toString(), type = TreeType.SECUOYA)

        // When
        groveRepository.updateForestTreeGrowthStage(forestTree)

        // Then
        coVerify { groveDao.updateForestTreeGrowthStageById(forestTree.id, forestTree.currentStage.toString()) }
    }

    // Cooldown Data

    @Test
    fun `when inserting CooldownData then insert into database`() = runTest {
        // Given
        val cooldownData = CooldownData("1")
        val cooldownDataEntity = cooldownData.toCooldownDataEntity()

        // When
        groveRepository.insertCooldownData(cooldownData)

        // Then
        coVerify { groveDao.insertCooldownData(cooldownDataEntity) }
    }

    @Test
    fun `when getting CooldownData and it exists then return CooldownData`() = runTest {
        // Given
        val treeId = "1"
        val cooldownDataEntity = CooldownDataEntity(treeId, 1000L)
        coEvery { groveDao.getCooldownData(treeId) } returns flowOf(cooldownDataEntity)

        // When
        val result = groveRepository.getCooldownData(treeId).first()

        // Then
        Assert.assertEquals(cooldownDataEntity.toCooldownData(), result)
    }

    @Test
    fun `when getting CooldownData and it does not exist then return default CooldownData`() = runTest {
        // Given
        val treeId = "1"
        coEvery { groveDao.getCooldownData(treeId) } returns flowOf(null)

        // When
        val result = groveRepository.getCooldownData(treeId).first()

        // Then
        Assert.assertEquals(CooldownData(treeId, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)), result)
    }
}