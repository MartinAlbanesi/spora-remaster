package com.gg.spora.user.data.local

import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.user.domain.models.User
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
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
    fun `getUserByIdFlow - Cuando se llama al método getUserByIdFlow, entonces se debe retornar un Flow de User`() = runTest{

        // Given
        val userId = "1"

        coEvery { userDao.getUsersWithLevelsCompleted() } returns flowOf(listOf(FakeUserModels.fakeUserWithLevelsCompletedEntity))

        // When
        var result : User? = null
        userRepositoryLocal.getUserByIdFlow(userId).collect {
            result = it
        }

        // Then
        Assert.assertEquals(result, FakeUserModels.fakeUsers.first())
    }
}