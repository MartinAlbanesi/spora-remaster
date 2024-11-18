package com.gg.spora.grove.domain

import com.gg.spora.grove.data.local.GroveRepository
import com.gg.spora.grove.domain.models.ForestTree
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
import java.time.LocalDateTime

@ExperimentalCoroutinesApi
class LoadForestTreesUseCaseTest {

    private val groveRepository = mockk<GroveRepository>()
    private lateinit var loadForestTreesUseCase: LoadForestTreesUseCase

    @Before
    fun setup() {
        loadForestTreesUseCase = LoadForestTreesUseCase(groveRepository)
    }

    @Test
    fun `invoke should return forest trees from repository`() = runTest {
        // Given
        val expectedForestTrees = listOf(
            ForestTree(type = TreeType.SECUOYA, plantingDate = LocalDateTime.now()),
            ForestTree(type = TreeType.BAOBAB, plantingDate = LocalDateTime.now())
        )
        coEvery { groveRepository.getForestTreesListFromDatabase() } returns flowOf(expectedForestTrees)

        // When
        val result = loadForestTreesUseCase().first()

        // Then
        Assert.assertEquals(expectedForestTrees, result)
    }
}