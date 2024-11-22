package com.gg.spora.grove.domain

import com.gg.spora.grove.data.network.models.SeedTreeNetwork
import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.mappers.toSeedTree
import com.gg.spora.grove.domain.mappers.toSeedTreeNetwork
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Use case for loading seed trees from the database.
 */
class LoadSeedTreesUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
) {
    suspend operator fun invoke(): Flow<List<SeedTree>> {
            val initialSeedTrees = listOf(
                SeedTree(type = TreeType.SECUOYA),
                SeedTree(type = TreeType.MANGROVE),
                SeedTree(type = TreeType.BAOBAB),
            )

        val userFlow = flow {
            val userLocal = userRepositoryLocal.getUser().firstOrNull()
            var seedTreesFinally : List<SeedTree> = emptyList()

            if (userLocal != null) {
                seedTreesFinally = userLocal.seedTrees.map { it.toSeedTree() } + initialSeedTrees
            }
            emit(seedTreesFinally)
        }

        return userFlow
    }
}