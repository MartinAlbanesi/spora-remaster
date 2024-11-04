package com.gg.spora.forestStage.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.forestStage.data.local.models.LevelEntity
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
    fun insertLevels_WhenInsertedValidatedLevels_ReturnLevelsInserted() {

        val expectedLevels = FakeStageModels.fakeLevelsEntity

        stageDao.insertLevels(expectedLevels)

        val actualLevels = stageDao.getLevels("FOREST")

        assertEquals(expectedLevels, actualLevels)
    }

    @Test
    fun getLevels_WhenDBIsEmpty_ReturnEmptyList() {

        val actualLevels = stageDao.getLevels("FOREST")

        assertEquals(emptyList<LevelEntity>(), actualLevels)
        assertNotEquals(3, actualLevels.size)
    }

    @Test
    fun getLevelsCount_WhenDBIsEmpty_ReturnZero() {

        val actualLevelsCount = stageDao.getLevelsCount()

        assertEquals(0, actualLevelsCount)
    }

    @Test
    fun getLevelsCount_WhenDBIsNotEmpty_ReturnCount() {

        val expectedLevels = FakeStageModels.fakeLevelsEntity

        stageDao.insertLevels(expectedLevels)

        val actualLevelsCount = stageDao.getLevelsCount()

        assertEquals(expectedLevels.size, actualLevelsCount)
    }
}