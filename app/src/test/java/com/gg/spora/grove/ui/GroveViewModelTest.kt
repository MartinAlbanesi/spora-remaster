package com.gg.spora.grove.ui

/*

@ExperimentalCoroutinesApi
class GroveViewModelTest {

    private lateinit var viewModel: GroveViewModel
    private lateinit var loadSeedTreesUseCase: LoadSeedTreesUseCase
    private lateinit var loadForestTreesUseCase: LoadForestTreesUseCase
    private lateinit var saveSeedTreesUseCase: SaveSeedTreesUseCase
    private lateinit var saveForestTreesUseCase: SaveForestTreesUseCase
    private lateinit var getForestTreeByIdUseCase: GetForestTreeByIdUseCase
    private lateinit var insertForestTreeUseCase: InsertForestTreeUseCase

    @Before
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher())

        // Mock use cases
        loadSeedTreesUseCase = mockk()
        loadForestTreesUseCase = mockk()
        saveSeedTreesUseCase = mockk()
        saveForestTreesUseCase = mockk()
        getForestTreeByIdUseCase = mockk()
        insertForestTreeUseCase = mockk()

        // Mock use case behaviors (if needed)
        coEvery { loadSeedTreesUseCase() } returns flowOf(emptyList())
        coEvery { loadForestTreesUseCase() } returns flowOf(emptyList())
        coEvery { saveSeedTreesUseCase(any<List<SeedTree>>()) } just runs
        coEvery { saveForestTreesUseCase(any<List<ForestTree?>>()) } just runs
        coEvery { getForestTreeByIdUseCase(any<Int>()) } returns flowOf(
            ForestTree(
                type = TreeType.SECUOYA,
                plantingDate = LocalDateTime.now()
            )
        )
        coEvery { insertForestTreeUseCase(any<ForestTree>()) } just runs


        // Create ViewModel instance
        viewModel = GroveViewModel(
            loadSeedTreesUseCase,
            saveSeedTreesUseCase,
            loadForestTreesUseCase,
            saveForestTreesUseCase,
            getForestTreeByIdUseCase,
            insertForestTreeUseCase,
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Resetea el dispatcher a su estado original
    }

    @Test
    fun `initSeedTrees should save initial seed trees if empty`() = runTest {
        // Given
        coEvery { loadSeedTreesUseCase() } returns flowOf(emptyList())
        coEvery { saveSeedTreesUseCase(any<List<SeedTree>>()) } just runs

        // Set _seedTrees.value to empty list
        viewModel.setSeedTrees(emptyList()) // Add this line

        // When
        viewModel.initSeedTrees()

        // Advance virtual time to allow delay to complete
        advanceUntilIdle()

        // Then
        coVerify { saveSeedTreesUseCase(any<List<SeedTree>>()) }
    }

    @Test
    fun `initForestTrees should save initial forest trees if empty`() = runTest {
        // Given
        coEvery { loadForestTreesUseCase() } returns flowOf(emptyList())
        coEvery { saveForestTreesUseCase(any<List<ForestTree?>>()) } just runs

        // When
        viewModel.initForestTrees()

        // Then
        coVerify { saveForestTreesUseCase(any<List<ForestTree?>>()) }
    }

    @Test
    fun `getSeedTrees should update seed trees state flow`() = runTest {
        // Given
        val expectedSeedTrees = listOf(
            SeedTree(type = TreeType.SECUOYA, timeToGenerateForestTree = Duration.ofSeconds(5))
        )
        coEvery { loadSeedTreesUseCase() } returns flowOf(expectedSeedTrees)

        // When
        viewModel.getSeedTrees()

        // Then
        Assert.assertEquals(expectedSeedTrees, viewModel.seedTrees.value)
    }

    @Test
    fun `getForestTrees should update forest trees state flow`() = runTest {
        // Given
        val expectedForestTrees = listOf(
            ForestTree(type = TreeType.SECUOYA, plantingDate = LocalDateTime.now())
        )
        coEvery { loadForestTreesUseCase() } returns flowOf(expectedForestTrees)

        // When
        viewModel.getForestTrees()

        // Then
        Assert.assertEquals(expectedForestTrees, viewModel.forestTrees.value)
    }
}

 */