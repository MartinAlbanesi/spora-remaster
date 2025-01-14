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
    private val groveRepository: IGroveRepository
) {
    suspend operator fun invoke(): Flow<List<SeedTree>> {
        val userFlow = flow {
            val userLocal = userRepositoryLocal.getUser().firstOrNull()
            val seedTreesFinally = userLocal?.seedTrees?.map { it.toSeedTree() } ?: emptyList()
            emit(seedTreesFinally)
        }

        val seedTreesLocalFlow = groveRepository.getSeedTreesListFromDatabase()

        // Combinamos ambos Flow
        return combine(userFlow, seedTreesLocalFlow) { seedTreesUser, seedTreesLocal ->
            // Unimos ambas listas y eliminamos duplicados según alguna propiedad
            (seedTreesUser + seedTreesLocal).distinctBy { it.type }
        }
    }
}
