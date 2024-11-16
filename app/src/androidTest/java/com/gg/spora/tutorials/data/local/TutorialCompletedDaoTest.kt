package com.gg.spora.tutorials.data.local

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

        tutorialCompletedEntity = TutorialCompletedEntity(1, true, "1")
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
            TutorialCompletedEntity(1, true, "1"),
            TutorialCompletedEntity(2, true, "1"),
            TutorialCompletedEntity(3, true, "1")
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
        val tutorialCompletedEntity = TutorialCompletedEntity(1, true, "1")
        tutorialCompletedDao.insertTutorialCompleted(tutorialCompletedEntity)

        // When
        val tutorialCompletedEntityExpected = TutorialCompletedEntity(1, false, "1")
        tutorialCompletedDao.updateTutorialCompleted(tutorialCompletedEntityExpected)
        val tutorialCompletedEntityActual = tutorialCompletedDao.getTutorialById(1)

        // Then
        assertEquals(tutorialCompletedEntityActual, tutorialCompletedEntityExpected)
        assertEquals(tutorialCompletedEntityActual.isCompleted, false)
    }
}