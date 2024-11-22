package com.gg.spora.grove.domain

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
class InsertForestTreeUseCase @Inject constructor(
    private val groveRepository: IGroveRepository,
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val getUserAuthUseCase: GetUserAuthUseCase,
    private val loadForestTreesExistsUseCase: LoadForestTreesExistsUseCase
) {
    suspend operator fun invoke(forestTree: ForestTree) {

        if (getUserAuthUseCase() != null) {

            val userLocal = userRepositoryLocal.getUser().first()!!
            val updateForestTrees = loadForestTreesExistsUseCase().first()

            val newForestTrees = updateForestTrees + forestTree

            val userUpdated = userLocal.copy(
                forestTrees = newForestTrees.map { it.toForestTreeNetwork() }
            )
            userRepositoryNetwork.updateUserById(userUpdated, userLocal.id)
        }

        groveRepository.insertForestTree(forestTree)
    }
}
