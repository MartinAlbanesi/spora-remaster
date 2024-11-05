package com.gg.spora.stage.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.stage.data.local.models.LevelEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class StageDaoTest{

    private lateinit var stageDao: StageDao

    private lateinit var db: SporaDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SporaDatabase::class.java)
            .build()
        stageDao = db.stageDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertLevels_WhenInsertedValidatedLevels_ReturnLevelsInserted() = runTest {

        val expectedLevels = FakeStageModels.fakeLevelsEntity

        stageDao.insertLevels(expectedLevels)

        val actualLevels = stageDao.getLevelsByStageType("FOREST")

        assertEquals(expectedLevels, actualLevels)
    }

    @Test
    fun getLevels_ByStageType_WhenDBIsEmpty_ReturnEmptyList() = runTest {

        val actualLevels = stageDao.getLevelsByStageType("FOREST")

        assertEquals(emptyList<LevelEntity>(), actualLevels)
        assertNotEquals(3, actualLevels.first().size)
    }

    @Test
    fun getLevelsByStageTypeCount_WhenDBIsEmpty_ReturnZero() = runTest {

        val actualLevelsCount = stageDao.getLevelsCount()

        assertEquals(0, actualLevelsCount)
    }

    @Test
    fun getLevelsByStageTypeCount_WhenDBIsNotEmpty_ReturnCount() = runTest {

        val expectedLevels = FakeStageModels.fakeLevelsEntity

        stageDao.insertLevels(expectedLevels)

        val actualLevelsCount = stageDao.getLevelsCount()

        assertEquals(expectedLevels.size, actualLevelsCount)
    }

    @Test
    fun insertStages_WhenInsertedValidatedStages_ReturnStagesInserted() = runTest {

        val expectedStages = FakeStageModels.fakeStageEntities

        stageDao.insertStages(expectedStages)

        val actualStages = stageDao.getStagesByStageType("FOREST")

        assertEquals(expectedStages.first(), actualStages)
        assertNotEquals("EXPO", actualStages?.stageType)
    }

    @Test
    fun getStagesByStageType_WhenDBIsEmpty_ReturnNull() = runTest {

        val actualStages = stageDao.getStagesByStageType("FOREST")

        assertEquals(null, actualStages)
    }

    @Test
    fun getStagesCount_WhenDBIsEmpty_ReturnZero() = runTest {

        val actualStagesCount = stageDao.getStagesCount()

        assertEquals(0, actualStagesCount)
    }

    @Test
    fun getStagesCount_WhenDBIsNotEmpty_ReturnCount() = runTest {

        val expectedStages = FakeStageModels.fakeStageEntities

        stageDao.insertStages(expectedStages)

        val actualStagesCount = stageDao.getStagesCount()

        assertEquals(expectedStages.size, actualStagesCount)
    }

}