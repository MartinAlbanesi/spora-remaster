package com.gg.spora.user.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.data.local.entities.UserEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    private lateinit var userDao: UserDao

    private lateinit var db: SporaDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SporaDatabase::class.java)
            .build()
        userDao = db.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }


    @Test
    fun insertUser_WhenInsertedOneValidUser_ReturnUserInserted() = runTest {
        val expectedUser = UserEntity("1", "test", "titi@gmail.com", 100)

        val actualUserEmpty = userDao.getUser("1").first()
        Assert.assertNull(actualUserEmpty)

        userDao.insertUser(expectedUser)

        val actualUser = userDao.getUser("1").first()
        assertEquals(expectedUser, actualUser)
    }

    @Test
    fun getUsersWithLevelsCompleted_WhenSearchByUserId_ThenReturnUserWithLevelsCompleted() =
        runTest {

            // Given
            val expectedUser = UserEntity("1", "test", "titi@gmail.com", 100)
            val expectedLevelsCompleted = listOf(
                LevelCompletedEntity("1", "stage1", "star1", "1"),
                LevelCompletedEntity("2", "stage2", "star2", "1"),
                LevelCompletedEntity("3", "stage3", "star3", "1")
            )

            // When
            userDao.insertUser(expectedUser)

            expectedLevelsCompleted.forEach {
                userDao.insertLevelCompleted(it)
            }

            // Then
            val actualUserWithLevelsCompleted = userDao.getUsersWithLevelsCompleted().first()

            assertEquals(expectedUser, actualUserWithLevelsCompleted[0].user)
        }

    @Test
    fun getLevelsCompletedByUserId_WhenSearchByUserId_ThenReturnLevelsCompleted() = runTest {

        // Given
        val expectedLevelsCompleted = listOf(
            LevelCompletedEntity("1", "stage1", "star1", "1"),
            LevelCompletedEntity("2", "stage2", "star2", "1"),
            LevelCompletedEntity("3", "stage3", "star3", "1")
        )

        expectedLevelsCompleted.forEach {
            userDao.insertLevelCompleted(it)
        }

        // When
        val actualLevelsCompleted = userDao.getLevelsCompletedByUserId("1").first()

        // Then
        assertEquals(expectedLevelsCompleted, actualLevelsCompleted)
    }

    @Test
    fun deleteUser_SetAValidUserToDelete_DeletedUserFromDB() = runTest {

        // Given
        val expectedUser = UserEntity("1", "test", "titi@gmail.com", 100)

        userDao.insertUser(expectedUser)

        // When
        userDao.deleteUser(expectedUser)

        // Then
        val actualUser = userDao.getUser("1").first()
        Assert.assertNull(actualUser)
    }

    @Test
    fun deleteLevelCompleted_SetAValidLevelCompletedToDelete_DeletedLevelCompletedFromDB() = runTest {

            // Given
            val expectedLevelsCompleted = listOf(
                LevelCompletedEntity("1", "stage1", "star1", "1"),
                LevelCompletedEntity("2", "stage2", "star2", "1"),
                LevelCompletedEntity("3", "stage3", "star3", "1")
            )

            expectedLevelsCompleted.forEach {
                userDao.insertLevelCompleted(it)
            }

            // When
            userDao.deleteLevelCompleted(expectedLevelsCompleted[0])

            // Then
            val actualLevelCompleted = userDao.getLevelsCompletedByUserId("1").first()

            assertEquals(expectedLevelsCompleted[1], actualLevelCompleted[0])
    }

    @Test
    fun updateUser_SetAValidUserToUpdate_UpdatedUserFromDB() = runTest {

        // Given
        val expectedUser = FakeUserModels.fakeUserEntity
        userDao.insertUser(expectedUser)


        // When
        val updatedUser = FakeUserModels.fakeUserEntity.copy(userName = "titi")
        userDao.updateUser(updatedUser)

        // Then
        val actualUser = userDao.getUser("1").first()
        assertEquals("titi", actualUser.userName)
    }

    @Test
    fun updateLevelCompleted_SetAValidLevelCompletedToUpdate_UpdatedLevelCompletedFromDB() = runTest {

        // Given
        val expectedLevelsCompleted = FakeUserModels.fakeLevelsCompletedEntity

        expectedLevelsCompleted.forEach {
            userDao.insertLevelCompleted(it)
        }

        // When
        val updatedLevelCompleted = FakeUserModels.fakeLevelsCompletedEntity[0].copy(starState = "THREE")
        userDao.updateLevelCompleted(updatedLevelCompleted)

        // Then
        val actualLevelCompleted = userDao.getLevelsCompletedByUserId("1").first()

        assertNotEquals("ONE", actualLevelCompleted[0].starState)
        assertEquals("THREE", actualLevelCompleted[0].starState)
    }
}