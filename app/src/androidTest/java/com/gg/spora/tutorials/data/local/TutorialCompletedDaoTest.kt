package com.gg.spora.tutorials.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.tutorials.data.local.entity.TutorialCompletedDao
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TutorialCompletedDaoTest{

    private lateinit var tutorialCompletedDao: TutorialCompletedDao

    private lateinit var db: SporaDatabase

    private lateinit var tutorialCompletedEntity: TutorialCompletedEntity

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SporaDatabase::class.java)
            .build()
        tutorialCompletedDao = db.tutorialCompletedDao()

        tutorialCompletedEntity = TutorialCompletedEntity(1, true, "Home")
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun getAllTutorialsCompleted_WhenTableIsEmpty_ThenReturnEmptyList() = runTest {

        // When
        val tutorialsCompleted = tutorialCompletedDao.getAllTutorialsCompleted()

        // Then
        assertEquals(tutorialsCompleted, emptyList<TutorialCompletedEntity>())
        assertEquals(tutorialsCompleted.size,0)
    }

    @Test
    fun insertTutorialCompleted_WhenInsertCorrectEntity_ThenGetTutorialById() = runTest {

        // When
        tutorialCompletedDao.insertTutorialCompleted(tutorialCompletedEntity)
        val tutorialsCompleted = tutorialCompletedDao.getTutorialById(1)

        // Then
        assertEquals(tutorialsCompleted, tutorialCompletedEntity)
    }

    @Test
    fun insertAllTutorialsCompleted_WhenInsertCorrectList_ThenGetAllTutorialsCompleted() = runTest {

        // Given
        val tutorialCompletedEntityListExpected = listOf(
            TutorialCompletedEntity(1, true, "Home"),
            TutorialCompletedEntity(2, true, "Home"),
            TutorialCompletedEntity(3, true, "Home")
        )

        // When
        tutorialCompletedDao.insertAllTutorialsCompleted(tutorialCompletedEntityListExpected)
        val tutorialsCompletedActual = tutorialCompletedDao.getAllTutorialsCompleted()

        // Then
        assertEquals(tutorialsCompletedActual, tutorialCompletedEntityListExpected)
        assertEquals(tutorialsCompletedActual.size, 3)
    }

    @Test
    fun updateTutorialCompleted_WhenUpdateIsCompleted_ThenGetEntityWithUpdate() = runTest {

        // Given
        val tutorialCompletedEntity = TutorialCompletedEntity(1, true, "Home")
        tutorialCompletedDao.insertTutorialCompleted(tutorialCompletedEntity)

        // When
        tutorialCompletedDao.updateTutorialCompleted(tutorialId = 1, isCompleted = false)
        val tutorialCompletedEntityActual = tutorialCompletedDao.getTutorialById(1)

        // Then
        assertEquals(tutorialCompletedEntityActual.isCompleted, false)
    }

    @Test
    fun getTutorialById_WhenIdIsIncorrect_ThenReturnNull() = runTest {

        // When
        val tutorialCompletedEntity = tutorialCompletedDao.getTutorialById(1)

        // Then
        assertEquals(tutorialCompletedEntity, null)
    }
}