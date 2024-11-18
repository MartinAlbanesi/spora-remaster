package com.gg.spora.grove.domain

import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.Duration

@ExperimentalCoroutinesApi
class LoadSeedTreesUseCaseTest {

    private val groveRepository = mockk<GroveRepository>()
    private lateinit var loadSeedTreesUseCase: LoadSeedTreesUseCase

    @Before
    fun setup() {
        loadSeedTreesUseCase = LoadSeedTreesUseCase(groveRepository)
    }

    @Test
    fun `invoke should return seed trees from repository`() = runTest {
        // Given
        val expectedSeedTrees = listOf(
            SeedTree(type = TreeType.SECUOYA, timeToGenerateForestTree = Duration.ofSeconds(5)),
            SeedTree(type = TreeType.BAOBAB, timeToGenerateForestTree = Duration.ofSeconds(10))
        )
        coEvery { groveRepository.getSeedTreesListFromDatabase() } returns flowOf(expectedSeedTrees)

        // When
        val result = loadSeedTreesUseCase().first()

        // Then
        Assert.assertEquals(expectedSeedTrees, result)
    }
}