package com.gg.spora.grove.domain

import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.time.Duration


@ExperimentalCoroutinesApi
class SaveSeedTreesUseCaseTest {

    private val groveRepository = mockk<GroveRepository>()
    private lateinit var saveSeedTreesUseCase: SaveSeedTreesUseCase

    @Before
    fun setup() {
        saveSeedTreesUseCase = SaveSeedTreesUseCase(groveRepository)
    }

    @Test
    fun `invoke should save seed trees to repository`() = runTest {
        // Given
        val seedTrees = listOf(
            SeedTree(type = TreeType.SECUOYA, timeToGenerateForestTree = Duration.ofSeconds(5)),
            SeedTree(type = TreeType.BAOBAB, timeToGenerateForestTree = Duration.ofSeconds(10))
        )
        coEvery { groveRepository.insertSeedTreesList(seedTrees) } just runs

        // When
        saveSeedTreesUseCase(seedTrees)

        // Then
        coVerify { groveRepository.insertSeedTreesList(seedTrees) }
    }
}