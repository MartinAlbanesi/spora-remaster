package com.gg.spora.user.domain

import com.gg.spora.core.fake.FakeUserModels
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetUserLocalUseCaseTest{

    private lateinit var getUserLocalUseCase: GetUserLocalUseCase

    @RelaxedMockK
    lateinit var userRepositoryLocal: IUserRepositoryLocal

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getUserLocalUseCase = GetUserLocalUseCase(userRepositoryLocal)
    }

    @Test
    fun `invoke - When User Not Exist In DB - Then Return Null`() = runTest {
        // Given
         coEvery { userRepositoryLocal.getUser() } returns flowOf(null)

        // When
        val actual = getUserLocalUseCase().first()

        // Then
        assertEquals(null, actual)
    }

    @Test
    fun `invoke - When User Exist In DB - Then Return User`() = runTest {
        // Given
        val user = FakeUserModels.fakeUsers.first()

        coEvery { userRepositoryLocal.getUser() } returns flowOf(user)

        // When
        val actual = getUserLocalUseCase().first()

        // Then
        assertEquals(user, actual)
    }
}