package com.gg.spora.grove.domain

import com.gg.spora.grove.data.network.models.ForestTreeNetwork
import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.mappers.toForestTreeNetwork
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case for inserting a forest tree.
 */
class InsertForestTreeUseCase @Inject constructor(private val groveRepository: IGroveRepository,
                                                  private val userRepositoryLocal: IUserRepositoryLocal,
                                                  private val userRepositoryNetwork: IUserRepositoryNetwork,
                                                  private val getUserAuthUseCase: GetUserAuthUseCase,
                                                  private val loadForestTreesUseCase : LoadForestTreesUseCase
) {
    suspend operator fun invoke(forestTree: ForestTree) {

        if(getUserAuthUseCase() != null) {

            val userLocal = userRepositoryLocal.getUser().first()!!
            var updateForestTrees = mutableListOf<ForestTree>()

            loadForestTreesUseCase().collect{ forestTrees ->

                updateForestTrees = forestTrees as MutableList<ForestTree>
            }

            updateForestTrees.add(forestTree)

            val userUpdated = userLocal.copy(
                forestTrees = updateForestTrees
            )
            userRepositoryNetwork.updateUserById(userUpdated, userLocal.id)
        }

        groveRepository.insertForestTree(forestTree)
    }
}