package com.gg.spora.grove.data.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.grove.data.database.entities.toCooldownData
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
import java.time.LocalDateTime

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

    @Test
    @Throws(Exception::class)
    fun insertSeedTreesListAndGetSeedTreesListListList() = runTest{
        // Given
        val seedTreeList = listOf(
            SeedTree(
                type = TreeType.BAOBAB,
                timeToGenerateForestTree = 5000L
            ),
            SeedTree(
                type = TreeType.SECUOYA,
                timeToGenerateForestTree = 5000L
            ),
            SeedTree(
                type = TreeType.MANGROVE,
                timeToGenerateForestTree = 5000L
            ),
            SeedTree(
                type = TreeType.PINE,
                timeToGenerateForestTree = 5000L
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
    fun insertForestTreeAndGetForestTreeById() = runTest{
        val forestTree = ForestTree(type = TreeType.SECUOYA)

        groveDao.insertForestTree(forestTree.toForestTreeEntity())

        val forestTreeById = groveDao.getSeedTreeById(forestTree.id).first()

        Assert.assertEquals(forestTree, forestTreeById.toSeedTree())
    }

    @Test
    @Throws(Exception::class)
    fun insertCooldownDataAndGetCooldownData() = runTest{
        val cooldownData = CooldownData(
            treeId = "1",
            lastUpdateDate = LocalDateTime.now()
        )

        groveDao.insertCooldownData(cooldownData.toCooldownDataEntity())

        val cooldownDataById = groveDao.getCooldownData(cooldownData.treeId).first()

        Assert.assertEquals(cooldownData, cooldownDataById?.toCooldownData())
    }
}