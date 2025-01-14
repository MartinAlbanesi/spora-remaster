package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.mappers.toSeedTreeNetwork
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case for inserting a seed tree.
 */
class InsertSeedTreeUseCase @Inject constructor(private val groveRepository: IGroveRepository,
                                                  private val userRepositoryLocal: IUserRepositoryLocal,
                                                  private val userRepositoryNetwork: IUserRepositoryNetwork,
                                                  private val getUserAuthUseCase: GetUserAuthUseCase,
                                                  private val loadSeedTreesUseCase: LoadSeedTreesUseCase)
{
    suspend operator fun invoke(seedTree: SeedTree) {

        if(getUserAuthUseCase() != null) {

            val userLocal = userRepositoryLocal.getUser().first()!!
            val updateSeedTrees = loadSeedTreesUseCase().first()
            val newSeedTrees = updateSeedTrees.map { it.toSeedTreeNetwork() } + seedTree.toSeedTreeNetwork()

            val userUpdated = userLocal.copy(
                seedTrees = newSeedTrees
            )
            userRepositoryNetwork.updateUserById(userUpdated, userLocal.id)
        }

        groveRepository.insertSeedTree(seedTree)
    }
}