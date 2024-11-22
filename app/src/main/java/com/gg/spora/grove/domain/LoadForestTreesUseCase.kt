package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.mappers.toForestTree
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.user.data.local.UserRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

/**
 * Use case for loading forest trees from the database.
 */
class LoadForestTreesUseCase @Inject constructor(
    private val groveRepository: IGroveRepository,
    private val userRepositoryLocal: UserRepositoryLocal
) {
    suspend operator fun invoke(): Flow<List<ForestTree?>> {
        val userFlow = flow {
            val userLocal = userRepositoryLocal.getUser().firstOrNull()
            emit(userLocal?.forestTrees ?: emptyList())
        }
        return userFlow.map { forestTreeEntities ->
            val forestTrees = MutableList<ForestTree?>(50) { null } // Creates a list of 50 null elements
            forestTreeEntities.forEach { entity ->
                forestTrees[entity.position] = entity.toForestTree() // Places the forest tree in the list
            }
            forestTrees // Returns the list of forest trees with forest trees and null elements
        }
        /*
        return combine(
            groveRepository.getForestTreesListFromDatabase(),
            userFlow
        ) { forestTreeLocal, forestTreeUser ->
            val userMap = forestTreeUser.associateBy { it.position }

            forestTreeLocal.map { localTree ->
                localTree?.let { userMap[it.position] } ?: localTree
            }
        }*/
    }
}
