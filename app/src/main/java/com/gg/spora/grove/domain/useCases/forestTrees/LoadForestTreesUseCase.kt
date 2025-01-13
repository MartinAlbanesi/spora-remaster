package com.gg.spora.grove.domain.useCases.forestTrees

import com.gg.spora.grove.domain.interfaces.IForestTreeRepositoryLocal
import com.gg.spora.grove.domain.models.ForestTree
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for loading forest trees from the database.
 */
class LoadForestTreesUseCase @Inject constructor(
    private val forestTreeRepositoryLocal: IForestTreeRepositoryLocal,
//    private val userRepositoryLocal: UserRepositoryLocal
) {
    suspend operator fun invoke(): Flow<List<ForestTree?>> {
        return forestTreeRepositoryLocal.getForestTreesListFromDatabase()
    }
}
