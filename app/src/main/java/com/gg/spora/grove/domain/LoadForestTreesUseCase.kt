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
        return groveRepository.getForestTreesListFromDatabase()
    }
}
