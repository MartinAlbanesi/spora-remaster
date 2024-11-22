package com.gg.spora.grove.domain

import android.util.Log
import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GroveUseCasesTest {

    @RelaxedMockK
    private lateinit var groveRepository: IGroveRepository

    @RelaxedMockK
    private lateinit var userRepositoryLocal: IUserRepositoryLocal

    @RelaxedMockK
    private lateinit var userRepositoryNetwork: IUserRepositoryNetwork

    // Use case instances
    private lateinit var getUserAuthUseCase: GetUserAuthUseCase
    private lateinit var deleteForestTreeByIdUseCase: DeleteForestTreeByIdUseCase
    private lateinit var deleteSeedTreeByIdUseCase: DeleteSeedTreeByIdUseCase
    private lateinit var getCooldownDataByIdUseCase: GetCooldownDataByIdUseCase
    private lateinit var insertCooldownDataUseCase: InsertCooldownDataUseCase
    private lateinit var insertForestTreeUseCase: InsertForestTreeUseCase
    private lateinit var loadForestTreesUseCase: LoadForestTreesUseCase
    private lateinit var loadSeedTreesUseCase: LoadSeedTreesUseCase
    private lateinit var saveSeedTreesUseCase: SaveSeedTreesUseCase
    private lateinit var updateForestTreeGrowthStageByIdUseCase: UpdateForestTreeGrowthStageByIdUseCase
    private lateinit var currentAuth: FirebaseAuth
    private lateinit var mockFirebaseUser: FirebaseUser

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        // Mock Log.i() globally
        mockkStatic(Log::class)
        every { Log.i(any(), any()) } returns 0

        currentAuth = mockk<FirebaseAuth>()
        mockFirebaseUser = mockk<FirebaseUser>()
        deleteForestTreeByIdUseCase = DeleteForestTreeByIdUseCase(groveRepository)
        deleteSeedTreeByIdUseCase = DeleteSeedTreeByIdUseCase(groveRepository)
        getCooldownDataByIdUseCase = GetCooldownDataByIdUseCase(groveRepository)
        insertCooldownDataUseCase = InsertCooldownDataUseCase(groveRepository)
        loadForestTreesUseCase = LoadForestTreesUseCase(groveRepository)
        getUserAuthUseCase = GetUserAuthUseCase(currentAuth)
        insertForestTreeUseCase = InsertForestTreeUseCase(
            groveRepository,
            userRepositoryLocal,
            userRepositoryNetwork,
            getUserAuthUseCase,
            loadForestTreesUseCase
        )
        loadSeedTreesUseCase = LoadSeedTreesUseCase(groveRepository)
        saveSeedTreesUseCase = SaveSeedTreesUseCase(groveRepository)
        updateForestTreeGrowthStageByIdUseCase =
            UpdateForestTreeGrowthStageByIdUseCase(groveRepository)
        coEvery { getUserAuthUseCase() } returns mockk<FirebaseUser>()

        coEvery { currentAuth.currentUser } returns mockk<FirebaseUser>()
        every { mockFirebaseUser.email } returns "test@example.com"
        every { (getUserAuthUseCase() as FirebaseUser).email } returns "test@example.com"
        coEvery { currentAuth.currentUser } returns mockFirebaseUser
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

        // Mock GetUserAuthUseCase
        val mockFirebaseUser = mockk<FirebaseUser>()
        every { mockFirebaseUser.email } returns "test@example.com"
        coEvery { getUserAuthUseCase() } returns mockFirebaseUser

        // Mock LoadForestTreesUseCase
        coEvery { loadForestTreesUseCase() } returns flowOf(emptyList<ForestTree>())

        insertForestTreeUseCase(forestTree)

        // Verify that insertForestTree was called on the repository
        coVerify { groveRepository.insertForestTree(forestTree) }
    }

    @Test
    fun `LoadForestTreesUseCase should call getForestTreesListFromDatabase on repository`() =
        runTest {
            val forestTrees = listOf<ForestTree?>(null)
            coEvery { groveRepository.getForestTreesListFromDatabase() } returns flowOf(
                forestTrees
            )
            val result = loadForestTreesUseCase().first()
            Assert.assertEquals(forestTrees, result)
        }

    @Test
    fun `LoadSeedTreesUseCase should call getSeedTreesListFromDatabase on repository`() =
        runTest {
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
    fun `UpdateForestTreeGrowthStageByIdUseCase should call updateForestTreeGrowthStage on repository`() =
        runTest {
            val forestTree = ForestTree(id = "1", type = TreeType.SECUOYA)
            updateForestTreeGrowthStageByIdUseCase(forestTree)
            coVerify { groveRepository.updateForestTreeGrowthStage(forestTree) }
        }
}
