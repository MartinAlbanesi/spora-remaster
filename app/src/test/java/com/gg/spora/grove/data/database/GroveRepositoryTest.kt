package com.gg.spora.grove.data.database

import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import com.gg.spora.grove.data.database.entities.toForestTree
import com.gg.spora.grove.data.database.entities.toSeedTree
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneOffset

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
        coEvery { groveDao.getSeedTrees() } returns flowOf(emptyList<SeedTreeEntity>())

        // When
        val result = groveRepository.getSeedTreesFromDatabase().first()

        // Then
        Assert.assertEquals(emptyList<SeedTree>(), result)
    }

    @Test
    fun `when SeedTrees is not empty then return list`() = runTest {
        // Given
        val seedTreeEntity = SeedTreeEntity(treeType = TreeType.SECUOYA.name, timeToGenerateForestTree = Duration.ofSeconds(5).toMillis())
        val expectedSeedTree = seedTreeEntity.toSeedTree()
        coEvery { groveDao.getSeedTrees() } returns flowOf(listOf(seedTreeEntity))

        // When
        val result = groveRepository.getSeedTreesFromDatabase().first()

        // Then
        Assert.assertEquals(listOf(expectedSeedTree), result)
    }

    // Forest Trees Tests
    @Test
    fun `when ForestTree is empty then return empty list`() = runTest {
        // Given
        coEvery { groveDao.getForestTrees() } returns flowOf(emptyList<ForestTreeEntity>())

        // When
        val result = groveRepository.getForestTreesFromDatabase().first()

        // Then
        val expectedList = MutableList<ForestTree?>(25) { null }
        Assert.assertEquals(expectedList, result)
    }

    @Test
    fun `when ForestTree is not empty then return list`() = runTest {
        // Given
        val forestTreeEntity = ForestTreeEntity(
            idForestTree = 1,
            treeType = TreeType.SECUOYA.name,
            currentStage = GrowthStage.SPROUT.toString(),
            plantingDate = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),
            position = 0
        )
        val expectedForestTree = forestTreeEntity.toForestTree()
        coEvery { groveDao.getForestTrees() } returns flowOf(listOf(forestTreeEntity))

        // When
        val result = groveRepository.getForestTreesFromDatabase().first()

        // Then
        val expectedList = MutableList<ForestTree?>(25) { null }
        expectedList[forestTreeEntity.position] = expectedForestTree
        Assert.assertEquals(expectedList, result)
    }
}