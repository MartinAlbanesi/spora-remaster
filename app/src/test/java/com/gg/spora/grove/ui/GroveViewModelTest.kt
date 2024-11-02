package com.gg.spora.grove.ui

/*
@ExperimentalCoroutinesApi
class GroveViewModelTest {

    private lateinit var viewModel: GroveViewModel
    private lateinit var plantSeedUseCase: PlantSeedUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())

        // Mockear las dependencias usando MockK
        val getSeedTreesUseCase = mockk<GetSeedTreesUseCase>()
        val getForestTreesUseCase = mockk<GetForestTreesUseCase>()
        plantSeedUseCase = mockk<PlantSeedUseCase>()

        // Mockea el comportamiento de GetSeedTreesUseCase
        every { getSeedTreesUseCase() } returns flowOf(emptyList<SeedTree>())

        // Mockea el comportamiento de GetForestTreesUseCase
        every { getForestTreesUseCase() } returns flowOf(emptyList<List<ForestTree?>>())

        // Mockea el comportamiento de PlantSeedUseCase
        every { plantSeedUseCase(any<TreeType>() as TreeType) } answers {
            if (firstArg<TreeType>() == TreeType.SECUOYA) {
                ForestTree(type = TreeType.SECUOYA, currentStage = GrowthStage.SPROUT)
            } else {
                ForestTree(
                    type = firstArg<TreeType>(),
                    currentStage = GrowthStage.SPROUT
                )
            }
        }

        // Crea la instancia del ViewModel
        viewModel = GroveViewModel(getSeedTreesUseCase, getForestTreesUseCase, plantSeedUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Resetea el dispatcher a su estado original
    }

    @Test
    fun `updateTree should update growth stage of existing tree`() = runTest {
        // Arrange
        val tree1 = ForestTree(type = TreeType.BAOBAB, currentStage = GrowthStage.SPROUT)
        val tree2 = ForestTree(type = TreeType.SECUOYA, currentStage = GrowthStage.MEDIUM)
        val initialForest = listOf(listOf(tree1), listOf(tree2))
        viewModel.setInitialForest(initialForest)

        val updatedTree =
            tree1.copy(currentStage = GrowthStage.ADULT)

        // Act
        viewModel.updateTree(updatedTree)

        // Assert
        val expectedForest = listOf(listOf(updatedTree), listOf(tree2))
        Assert.assertEquals(expectedForest, viewModel.forestTrees.value)
    }

    @Test
    fun `plantSeedInForest should plant a seed and update forestTree`() = runTest {
        // Arrange
        val seedTree = SeedTree(type = TreeType.SECUOYA, timeToGenerateForestTree = Duration.ofSeconds(1))
        val plantedTree = ForestTree(type = TreeType.SECUOYA, currentStage = GrowthStage.SPROUT)
        every { plantSeedUseCase(any<TreeType>() as TreeType) } answers {
            if (firstArg<TreeType>() == TreeType.SECUOYA) {
                plantedTree
            } else {
                ForestTree(type = firstArg<TreeType>(), currentStage = GrowthStage.SPROUT)
            }
        }

        // Act
        viewModel.plantSeedInForest(Tree.type)

        // Espera a que terminen las corrutinas
        advanceUntilIdle()

        // Assert
        Assert.assertEquals(plantedTree, viewModel.forestTree.value)
    }
}
 */