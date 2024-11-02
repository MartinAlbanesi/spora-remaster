package com.gg.spora.user.data.local

import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.user.domain.mappers.toLevelCompleted
import com.gg.spora.user.domain.mappers.toLevelCompletedEntity
import com.gg.spora.user.domain.models.User
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserRepositoryLocalTest {

    private lateinit var userRepositoryLocal: UserRepositoryLocal

    @RelaxedMockK
    private lateinit var userDao: UserDao

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        userRepositoryLocal = UserRepositoryLocal(userDao)
    }

    @Test
    fun `getUser - Cuando se llama al método getUserByIdFlow, entonces se debe retornar un Flow de User`() = runTest{

        // Given
        val expected = "test"
        coEvery { userDao.getUsersWithLevelsCompleted() } returns flowOf(listOf(FakeUserModels.fakeUserWithLevelsCompletedEntity))

        // When
        var result : User? = null
        userRepositoryLocal.getUser().collect {
            result = it
        }

        // Then
        Assert.assertEquals(result, FakeUserModels.fakeUsers.first())
        Assert.assertEquals(expected, result?.userName)
    }

    @Test
    fun `updateUserWithLevelCompleted - When new levelCompleted is added, Then insert user in local`() = runTest {

        // Given
        val user = FakeUserModels.fakeUsers.first()
        val levelCompleted = FakeUserModels.fakeLevelsCompleted.first().toLevelCompletedEntity(user.id).copy(
            levelId = "22"
        )

        coEvery { userDao.updateUser(any()) } returns Unit
        coEvery { userDao.getLevelsCompleted() } returns flowOf(FakeUserModels.fakeLevelsCompletedEntity)
        coEvery { userDao.updateLevelCompleted(any()) } returns Unit
        coEvery { userDao.insertLevelCompleted(any()) } returns Unit

        // When
        userRepositoryLocal.updateUserWithLevelCompleted(user, levelCompleted.toLevelCompleted())

        coVerify(exactly = 1) { userDao.updateUser(any()) }
        coVerify(exactly = 1) { userDao.getLevelsCompleted() }
        coVerify(exactly = 0) { userDao.updateLevelCompleted(any()) }
        coVerify(exactly = 1) { userDao.insertLevelCompleted(any()) }
    }

    @Test
    fun `updateUserWithLevelCompleted - When levelCompleted added Exist, Then update user in local`() = runTest {

        // Given
        val user = FakeUserModels.fakeUsers.first()
        val levelCompleted = FakeUserModels.fakeLevelsCompleted.first().toLevelCompletedEntity(user.id)

        coEvery { userDao.updateUser(any()) } returns Unit
        coEvery { userDao.getLevelsCompleted() } returns flowOf(FakeUserModels.fakeLevelsCompletedEntity)
        coEvery { userDao.updateLevelCompleted(any()) } returns Unit
        coEvery { userDao.insertLevelCompleted(any()) } returns Unit

        // When
        userRepositoryLocal.updateUserWithLevelCompleted(user, levelCompleted.toLevelCompleted())

        coVerify(exactly = 1) { userDao.updateUser(any()) }
        coVerify(exactly = 1) { userDao.getLevelsCompleted() }
        coVerify(exactly = 1) { userDao.updateLevelCompleted(any()) }
        coVerify(exactly = 0) { userDao.insertLevelCompleted(any()) }
    }
}