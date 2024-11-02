package com.gg.spora.grove.domain

import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.domain.models.ForestTree
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
import java.time.LocalDateTime

@ExperimentalCoroutinesApi
class SaveForestTreesUseCaseTest {

    private val groveRepository = mockk<GroveRepository>()
    private lateinit var saveForestTreesUseCase: SaveForestTreesUseCase

    @Before
    fun setup() {
        saveForestTreesUseCase = SaveForestTreesUseCase(groveRepository)
    }

    @Test
    fun `invoke should save forest trees to repository`() = runTest {
        // Given
        val forestTrees = listOf(
            ForestTree(type = TreeType.SECUOYA, plantingDate = LocalDateTime.now()),
            ForestTree(type = TreeType.BAOBAB, plantingDate = LocalDateTime.now())
        )
        coEvery { groveRepository.saveForestTrees(forestTrees) } just runs

        // When
        saveForestTreesUseCase(forestTrees)

        // Then
        coVerify { groveRepository.saveForestTrees(forestTrees) }
    }
}