package com.gg.spora.missions.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.gg.spora.core.data.SporaDatabase
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException


class MissionDaoTest{

    private lateinit var missionDao: MissionDao

    private lateinit var db: SporaDatabase

    private lateinit var missionEntity: MissionEntity

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SporaDatabase::class.java)
            .build()
        missionDao = db.missionDao()

        missionEntity = MissionEntity(1, "Pasar un nivel", 15, 1, 0)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun updateMission_WhenSetACorrectMission_UpdateMission() = runTest {

        // Given
        missionDao.insertMission(missionEntity)

        // When
        val mission = missionDao.getMissionById(1)
        mission?.let {
            it.counter++
            missionDao.updateMission(it)
        }

        // Then
        val updatedMission = missionDao.getMissionById(1)

        assertEquals(updatedMission?.counter, 1.toByte())

    }

    @Test
    fun updateCounterMission_WhenSetACorrectMission_UpdateCounterMission() = runTest {

        // Given
        missionDao.insertMission(missionEntity)

        // When
        missionDao.updateCounterMission(1)

        // Then
        val updatedMission = missionDao.getMissionById(1)

        assertEquals(updatedMission?.counter, 1.toByte())

    }
}