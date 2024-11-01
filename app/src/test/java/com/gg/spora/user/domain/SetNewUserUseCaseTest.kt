package com.gg.spora.user.domain

import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SetNewUserUseCaseTest{

    private lateinit var setNewUserUseCase: SetNewUserUseCase

    @RelaxedMockK
    lateinit var userRepositoryNetwork: IUserRepositoryNetwork

    @RelaxedMockK
    lateinit var userRepositoryLocal: IUserRepositoryLocal

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        setNewUserUseCase = SetNewUserUseCase(userRepositoryNetwork, userRepositoryLocal)
    }

    @Test
    fun `invoke - When DB is empty - Then Save User Data in local and network`() = runTest {
        // Given
        val email = ""
        val userName = "titi"

        coEvery { userRepositoryLocal.getCurrentUserFlow() } returns emptyList()
        coEvery { userRepositoryLocal.setUserLocal(any()) } returns Unit
        coEvery { userRepositoryNetwork.setUser(any()) } returns ""

        // When
        setNewUserUseCase(email, userName)

        // Then
        coVerify(exactly = 1) { userRepositoryLocal.getCurrentUserFlow() }
        coVerify(exactly = 1) { userRepositoryLocal.setUserLocal(any()) }
        coVerify(exactly = 1) { userRepositoryNetwork.setUser(any()) }
    }

    @Test
    fun `invoke - When DB is not empty - Then Save User Data just in network`() = runTest {
        // Given
        val email = ""
        val userName = "titi"

        coEvery { userRepositoryLocal.getCurrentUserFlow() } returns listOf(mockk())
        coEvery { userRepositoryLocal.setUserLocal(any()) } returns Unit
        coEvery { userRepositoryNetwork.setUser(any()) } returns ""

        // When
        setNewUserUseCase(email, userName)

        // Then
        coVerify(exactly = 1) { userRepositoryLocal.getCurrentUserFlow() }
        coVerify(exactly = 1) { userRepositoryNetwork.setUser(any()) }
        coVerify(exactly = 0) { userRepositoryLocal.setUserLocal(any()) }
    }
}