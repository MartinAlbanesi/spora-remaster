package com.gg.spora.core.domain

import com.gg.spora.core.firebase.RemoteConfigService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CanAccessToAppUseCaseTest{

    private lateinit var canAccessToAppUseCase: CanAccessToAppUseCase

    @RelaxedMockK
    private lateinit var getCurrentVersionUseCase: GetCurrentVersionUseCase

    @RelaxedMockK
    private lateinit var remoteConfigService: RemoteConfigService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        canAccessToAppUseCase = CanAccessToAppUseCase(getCurrentVersionUseCase, remoteConfigService)
    }

    @Test
    fun `invoke - When AppVer is greater than MinVer - Then return true`() = runTest{
        // Given
        val appVer = listOf<Byte>(2, 0, 0)
        val minVer = listOf<Byte>(1, 1, 0)

        // When

        coEvery { getCurrentVersionUseCase.invoke() } returns appVer
        coEvery { remoteConfigService.getMinVersion() } returns minVer

        val actual = canAccessToAppUseCase()

        // Then
        assertEquals(true, actual)
    }

    @Test
    fun `invoke - When AppVer is equal to MinVer - Then return true`() = runTest{
        // Given
        val appVer = listOf<Byte>(1, 0, 0)
        val minVer = listOf<Byte>(1, 0, 0)

        // When

        coEvery { getCurrentVersionUseCase.invoke() } returns appVer
        coEvery { remoteConfigService.getMinVersion() } returns minVer

        val actual = canAccessToAppUseCase()

        // Then
        assertEquals(true, actual)
    }

    @Test
    fun `invoke - When AppVer is less than MinVer - Then return false`() = runTest{
        // Given
        val appVer = listOf<Byte>(1, 0, 1)
        val minVer = listOf<Byte>(1, 0, 3)

        // When

        coEvery { getCurrentVersionUseCase.invoke() } returns appVer
        coEvery { remoteConfigService.getMinVersion() } returns minVer

        val actual = canAccessToAppUseCase()

        // Then
        assertEquals(false, actual)
    }
}