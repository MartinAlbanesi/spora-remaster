package com.gg.spora.grove.data.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gg.spora.core.data.database.GroveDatabase
import com.gg.spora.grove.data.database.entities.toSeedTree
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
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
    private lateinit var db : GroveDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,GroveDatabase::class.java)
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
    fun insertSeedTreesAndGetSeedTrees() = runTest{
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
        groveDao.insertSeedTrees(seedTreeList.map { it.toSeedTreeEntity() })

        val seedTrees = groveDao.getSeedTrees().first()

        Assert.assertEquals(4, seedTrees.size)
    }

    @Test
    @Throws(Exception::class)
    fun insertForestTree() = runTest{
        val forestTree = ForestTree(type = TreeType.SECUOYA)

        groveDao.insertForestTree(forestTree.toForestTreeEntity())

        val forestTreeById = groveDao.getSeedTreeById(0).first()

        println(forestTreeById)

        Assert.assertEquals(forestTree, forestTreeById.toSeedTree())
    }

}