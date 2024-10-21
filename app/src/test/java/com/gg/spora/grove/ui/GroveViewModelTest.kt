package com.gg.spora.grove.ui

import com.gg.spora.grove.data.models.ForestTree
import com.gg.spora.grove.data.models.GrowthStage
import com.gg.spora.grove.data.models.Seed
import com.gg.spora.grove.data.models.SeedTree
import com.gg.spora.grove.data.models.TreeType
import com.gg.spora.grove.domain.models.GetForestTreesUseCase
import com.gg.spora.grove.domain.models.GetSeedTreesUseCase
import com.gg.spora.grove.domain.models.PlantSeedUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GroveViewModelTest {

    private lateinit var viewModel: GroveViewModel
    private lateinit var plantSeedUseCase: PlantSeedUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())

        // Mock dependencies using MockK
        val getSeedTreesUseCase = mockk<GetSeedTreesUseCase>()
        val getForestTreesUseCase = mockk<GetForestTreesUseCase>()
        plantSeedUseCase = mockk<PlantSeedUseCase>()

        // Mock the behavior of GetSeedTreesUseCase
        every { getSeedTreesUseCase() } returns flowOf(emptyList<SeedTree>())

        // Mock the behavior of GetForestTreesUseCase
        every { getForestTreesUseCase() } returns flowOf(emptyList<List<ForestTree?>>())

        // Mock the behavior of plantSeedUseCase
        every { plantSeedUseCase(any<Seed>() as Seed) } answers {
            if (firstArg<Seed>().type == TreeType.SECUOYA) {
                ForestTree(type = TreeType.SECUOYA, currentStage = GrowthStage.SPROUT)
            } else {
                ForestTree(
                    type = firstArg<Seed>().type,
                    currentStage = GrowthStage.SPROUT
                ) // Return a default ForestTree
            }
        }

        // Create ViewModel instance
        viewModel = GroveViewModel(getSeedTreesUseCase, getForestTreesUseCase, plantSeedUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset main dispatcher after tests
    }

    @Test
    fun `updateTree should update growth stage of existing tree`() = runTest {
        // Arrange
        val tree1 = ForestTree(type = TreeType.BAOBAB, currentStage = GrowthStage.SPROUT)
        val tree2 = ForestTree(type = TreeType.SECUOYA, currentStage = GrowthStage.MEDIUM)
        val initialForest = listOf(listOf(tree1), listOf(tree2))
        viewModel.setInitialForest(initialForest)

        val updatedTree =
            tree1.copy(currentStage = GrowthStage.ADULT) // Use copy to create updated tree

        // Act
        viewModel.updateTree(updatedTree)

        // Assert
        val expectedForest = listOf(listOf(updatedTree), listOf(tree2))
        Assert.assertEquals(expectedForest, viewModel.forestTrees.value)
    }

    @Test
    fun `plantSeedInForest should plant a seed and update forestTree`() = runTest {
        // Arrange
        val seed = Seed(type = TreeType.SECUOYA)
        val plantedTree = ForestTree(type = TreeType.SECUOYA, currentStage = GrowthStage.SPROUT)
        every { plantSeedUseCase(any<Seed>() as Seed) } answers {
            if (firstArg<Seed>().type == TreeType.SECUOYA) {
                plantedTree
            } else {
                ForestTree(type = firstArg<Seed>().type, currentStage = GrowthStage.SPROUT)
            }
        }

        // Act
        viewModel.plantSeedInForest(seed)

        // Wait for coroutines to complete
        advanceUntilIdle() // Add this line

        // Assert
        Assert.assertEquals(plantedTree, viewModel.forestTree.value)
    }
}