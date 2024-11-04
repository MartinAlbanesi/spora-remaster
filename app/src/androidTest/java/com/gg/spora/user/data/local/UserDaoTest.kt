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
        val expectedUser = FakeUserModels.fakeUserEntity

        userDao.insertUser(expectedUser)

        val actualUser = userDao.getUsersWithLevelsCompleted().first()?.user

        assertEquals(expectedUser, actualUser)
    }

    @Test
    fun getUsersWithLevelsCompleted_WhenSearchByUserId_ThenReturnUserByEmailWithLevelsCompleted() =
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

            assertEquals(expectedUser, actualUserWithLevelsCompleted?.user)
        }

    @Test
    fun getUsersWithLevelsCompleted_WhenDBIsEmpty_ThenReturnEmptyList() = runTest {

        val actual = userDao.getUsersWithLevelsCompleted().first()

        assertEquals(null, actual)
    }

    @Test
    fun getLevelsCompleted_WhenSearchByUserId_ThenReturnLevelsCompleted() = runTest {

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
        val actualLevelsCompleted = userDao.getLevelsCompleted().first()

        // Then
        assertEquals(expectedLevelsCompleted, actualLevelsCompleted)
    }

    @Test
    fun getLevelsCompleted_WhenLevelCompletedTableIsEmpty_ThenReturnEmptyList() = runTest {

        val actualLevelsCompleted = userDao.getLevelsCompleted().first()

        assertEquals(emptyList<LevelCompletedEntity>(), actualLevelsCompleted)
    }

    /*
    @Test
    fun deleteUser_SetAValidUserToDelete_DeletedUserFromDB() = runTest {

        // Given
        val expectedUser = UserEntity("1", "test", "titi@gmail.com", 100)

        userDao.insertUser(expectedUser)

        // When
//        userDao.deleteUser(expectedUser)

        // Then
//        val actualUser = userDao.getUserByEmail("titi@gmail.com").first()
//        Assert.assertNull(actualUser)
    }
     */

    /*
    @Test
    fun deleteLevelCompleted_SetAValidLevelCompletedToDelete_DeletedLevelCompletedFromDB() =
        runTest {

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
//            userDao.deleteLevelCompleted(expectedLevelsCompleted[0])

            // Then
//            val actualLevelCompleted = userDao.getLevelsCompletedByUserId("1").first()

//            assertEquals(expectedLevelsCompleted[1], actualLevelCompleted[0])
        }

     */

    @Test
    fun updateUser_SetAValidUserToUpdate_UpdatedUserFromDB() = runTest {

        // Given
        val expectedUser = FakeUserModels.fakeUserEntity
        userDao.insertUser(expectedUser)


        // When
        val updatedUser = FakeUserModels.fakeUserEntity.copy(userName = "titi")
        userDao.updateUser(updatedUser)

        // Then
        val actualUser = userDao.getUsersWithLevelsCompleted().first()
        assertEquals("titi", actualUser?.user?.userName)
    }

    @Test
    fun updateLevelCompleted_SetAValidLevelCompletedToUpdate_UpdatedLevelCompletedFromDB() =
        runTest {

            // Given
            val expectedLevelsCompleted = FakeUserModels.fakeLevelsCompletedEntity

            expectedLevelsCompleted.forEach {
                userDao.insertLevelCompleted(it)
            }

            // When
            val updatedLevelCompleted =
                FakeUserModels.fakeLevelsCompletedEntity[0].copy(starState = "THREE")
            userDao.updateLevelCompleted(updatedLevelCompleted)

            // Then
            val actualLevelCompleted = userDao.getLevelsCompleted().first()

            assertNotEquals("ONE", actualLevelCompleted[0].starState)
            assertEquals("THREE", actualLevelCompleted[0].starState)
        }

    @Test
    fun updateUserId_SetAValidUserIdToUpdate_UpdatedUserIdFromDB() = runTest {

        // Given
        val expectedUser = FakeUserModels.fakeUserEntity
        userDao.insertUser(expectedUser)

        // When
        userDao.updateUserId("123")

        // Then
        val actualUser = userDao.getUsersWithLevelsCompleted().first()?.user
        assertNotEquals("1", actualUser?.id)
        assertEquals("123", actualUser?.id)
    }

    @Test
    fun getUserOxygen_GetOxygenFromUser_ThenReturnOxygen() {
        runTest {
            val expectedUser = FakeUserModels.fakeUserEntity
            userDao.insertUser(expectedUser)

            val actualOxygen = userDao.getUserOxygen().first()

            assertEquals(100, actualOxygen)
        }
    }

    @Test
    fun updateOxygen_SetAValidOxygenToUpdate_ThenUpdatedUserOxygenFromDB() = runTest {

        // Given
        val expectedUser = FakeUserModels.fakeUserEntity
        userDao.insertUser(expectedUser)

        // When
        userDao.updateUserOxygen(200)

        // Then
        val actualOxygen = userDao.getUserOxygen().first()
        assertNotEquals(100, actualOxygen)
        assertEquals(200, actualOxygen)
    }
}