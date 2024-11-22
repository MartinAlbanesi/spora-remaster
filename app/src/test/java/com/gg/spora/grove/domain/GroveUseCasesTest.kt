package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GroveUseCasesTest {

    @RelaxedMockK
    private lateinit var groveRepository: IGroveRepository

    // Use case instances
    private lateinit var deleteForestTreeByIdUseCase: DeleteForestTreeByIdUseCase
    private lateinit var deleteSeedTreeByIdUseCase: DeleteSeedTreeByIdUseCase
    private lateinit var getCooldownDataByIdUseCase: GetCooldownDataByIdUseCase
    private lateinit var insertCooldownDataUseCase: InsertCooldownDataUseCase
    private lateinit var insertForestTreeUseCase: InsertForestTreeUseCase
    private lateinit var loadForestTreesUseCase: LoadForestTreesUseCase
    private lateinit var loadSeedTreesUseCase: LoadSeedTreesUseCase
    private lateinit var saveSeedTreesUseCase: SaveSeedTreesUseCase
    private lateinit var updateForestTreeGrowthStageByIdUseCase: UpdateForestTreeGrowthStageByIdUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        deleteForestTreeByIdUseCase = DeleteForestTreeByIdUseCase(groveRepository)
        deleteSeedTreeByIdUseCase = DeleteSeedTreeByIdUseCase(groveRepository)
        getCooldownDataByIdUseCase = GetCooldownDataByIdUseCase(groveRepository)
        insertCooldownDataUseCase = InsertCooldownDataUseCase(groveRepository)
        insertForestTreeUseCase = InsertForestTreeUseCase(groveRepository)
        loadForestTreesUseCase = LoadForestTreesUseCase(groveRepository)
        loadSeedTreesUseCase = LoadSeedTreesUseCase(groveRepository)
        saveSeedTreesUseCase = SaveSeedTreesUseCase(groveRepository)
        updateForestTreeGrowthStageByIdUseCase = UpdateForestTreeGrowthStageByIdUseCase(groveRepository)
    }

    @Test
    fun `DeleteForestTreeByIdUseCase should call deleteForestTreeById on repository`() = runTest {
        val treeId = "1"
        deleteForestTreeByIdUseCase(treeId)
        coVerify { groveRepository.deleteForestTreeById(treeId) }
    }

    @Test
    fun `DeleteSeedTreeByIdUseCase should call deleteSeedTreeById on repository`() = runTest {
        val treeId = "1"
        deleteSeedTreeByIdUseCase(treeId)
        coVerify { groveRepository.deleteSeedTreeById(treeId) }
    }

    @Test
    fun `GetCooldownDataByIdUseCase should call getCooldownData on repository`() = runTest {
        val treeId = "1"
        val cooldownData = CooldownData(treeId)
        coEvery { groveRepository.getCooldownData(treeId) } returns flowOf(cooldownData)
        val result = getCooldownDataByIdUseCase(treeId).first()
        Assert.assertEquals(cooldownData, result)
    }

    @Test
    fun `InsertCooldownDataUseCase should call insertCooldownData on repository`() = runTest {
        val cooldownData = CooldownData("1")
        insertCooldownDataUseCase(cooldownData)
        coVerify { groveRepository.insertCooldownData(cooldownData) }
    }

    @Test
    fun `InsertForestTreeUseCase should call insertForestTree on repository`() = runTest {
        val forestTree = ForestTree(id = "1", type = TreeType.SECUOYA)
        insertForestTreeUseCase(forestTree)
        coVerify { groveRepository.insertForestTree(forestTree) }
    }

    @Test
    fun `LoadForestTreesUseCase should call getForestTreesListFromDatabase on repository`() = runTest {
        val forestTrees = listOf<ForestTree?>(null)
        coEvery { groveRepository.getForestTreesListFromDatabase() } returns flowOf(forestTrees)
        val result = loadForestTreesUseCase().first()
        Assert.assertEquals(forestTrees, result)
    }

    @Test
    fun `LoadSeedTreesUseCase should call getSeedTreesListFromDatabase on repository`() = runTest {
        val seedTrees = listOf(SeedTree(id = "1", type = TreeType.SECUOYA))
        coEvery { groveRepository.getSeedTreesListFromDatabase() } returns flowOf(seedTrees)
        val result = loadSeedTreesUseCase().first()
        Assert.assertEquals(seedTrees, result)
    }

    @Test
    fun `SaveSeedTreesUseCase should call insertSeedTreesList on repository`() = runTest {
        val seedTrees = listOf(SeedTree(id = "1", type = TreeType.SECUOYA))
        saveSeedTreesUseCase(seedTrees)
        coVerify { groveRepository.insertSeedTreesList(seedTrees) }
    }

    @Test
    fun `UpdateForestTreeGrowthStageByIdUseCase should call updateForestTreeGrowthStage on repository`() = runTest {
        val forestTree = ForestTree(id = "1", type = TreeType.SECUOYA)
        updateForestTreeGrowthStageByIdUseCase(forestTree)
        coVerify { groveRepository.updateForestTreeGrowthStage(forestTree) }
    }
}