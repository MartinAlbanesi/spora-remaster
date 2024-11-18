package com.gg.spora.grove.data.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.grove.data.database.entities.toCooldownData
import com.gg.spora.grove.data.database.entities.toForestTree
import com.gg.spora.grove.data.database.entities.toSeedTree
import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import com.gg.spora.grove.domain.models.toCooldownDataEntity
import com.gg.spora.grove.domain.models.toForestTreeEntity
import com.gg.spora.grove.domain.models.toSeedTreeEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class GroveDaoTest {
    private lateinit var groveDao: GroveDao
    private lateinit var db : SporaDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,SporaDatabase::class.java)
            .build()
        groveDao = db.groveDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    // Seed Trees Tests

    @Test
    @Throws(Exception::class)
    fun insertSeedTreesListAndGetSeedTreesList() = runTest{
        // Given
        val seedTreeList = listOf(
            SeedTree(
                type = TreeType.BAOBAB,
            ),
            SeedTree(
                type = TreeType.SECUOYA,
            ),
            SeedTree(
                type = TreeType.MANGROVE,
            ),
            SeedTree(
                type = TreeType.PINE,
            )
        )

        // When
        groveDao.insertSeedTreesList(seedTreeList.map { it.toSeedTreeEntity() })
        val seedTrees = groveDao.getSeedTreesList().first()

        // Then
        Assert.assertEquals(4, seedTrees.size)
    }

    @Test
    @Throws(Exception::class)
    fun insertSeedTreeAndGetSeedTreeById() = runTest{
        // Given
        val seedTree = SeedTree(
            type = TreeType.BAOBAB,
        )

        // When
        groveDao.insertSeedTree(seedTree.toSeedTreeEntity())
        val seedTreeById = groveDao.getSeedTreeById(seedTree.id).first()

        // Then
        Assert.assertEquals(seedTree, seedTreeById.toSeedTree())
    }

    @Test
    @Throws(Exception::class)
    fun insertSeedTreeAndDeleteSeedTreeById() = runTest{
        // Given
        val seedTree = SeedTree(
            type = TreeType.BAOBAB,
        )

        // When
        groveDao.insertSeedTree(seedTree.toSeedTreeEntity())
        groveDao.deleteSeedTreeById(seedTree.id)
        val seedTrees = groveDao.getSeedTreesList().first()

        // Then
        Assert.assertEquals(0, seedTrees.size)
    }

    // Forest Tree Tests

    @Test
    @Throws(Exception::class)
    fun insertForestTreesListAndGetForestTreesList() = runTest{
        // Given
        val forestTreeList = List(10) {
            ForestTree(type = TreeType.SECUOYA)
        }

        // When
        groveDao.insertForestTreesList(forestTreeList.map { it.toForestTreeEntity() })
        val forestTrees = groveDao.getForestTreesList().first()

        // Then
        Assert.assertEquals(10, forestTrees.size)
    }

    @Test
    @Throws(Exception::class)
    fun insertForestTreeAndGetForestTreeById() = runTest{
        // Given
        val forestTree = ForestTree(type = TreeType.SECUOYA)

        // When
        groveDao.insertForestTree(forestTree.toForestTreeEntity())
        val forestTreeById = groveDao.getForestTreeById(forestTree.id).first()

        // Then
        Assert.assertEquals(forestTree, forestTreeById.toForestTree())
    }

    @Test
    @Throws(Exception::class)
    fun insertForestTreeAndDeleteForestTreeById() = runTest{
        // Given
        val forestTree = ForestTree(type = TreeType.SECUOYA)

        // When
        groveDao.insertForestTree(forestTree.toForestTreeEntity())
        groveDao.deleteForestTreeById(forestTree.id)
        val forestTrees = groveDao.getForestTreesList().first()

        // Then
        Assert.assertEquals(0, forestTrees.size)
    }

    // Growth Stage Test

    @Test
    @Throws(Exception::class)
    fun updateForestTreeGrowthStageById() = runTest{
        // Given
        val forestTree = ForestTree(type = TreeType.SECUOYA)

        // When
        groveDao.insertForestTree(forestTree.toForestTreeEntity())
        groveDao.updateForestTreeGrowthStageById(forestTree.id, "STAGE_TWO")
        val forestTreeById = groveDao.getForestTreeById(forestTree.id).first()

        // Then
        Assert.assertEquals("STAGE_TWO", forestTreeById.currentStage)
    }

    // Cooldown Data Test

    @Test
    @Throws(Exception::class)
    fun insertCooldownDataAndGetCooldownData() = runTest{
        // Given
        val cooldownData = CooldownData(
            treeId = "1",
        )

        // When
        groveDao.insertCooldownData(cooldownData.toCooldownDataEntity())
        val cooldownDataById = groveDao.getCooldownData(cooldownData.treeId).first()

        // Then
        Assert.assertEquals(cooldownData, cooldownDataById?.toCooldownData())
    }
}