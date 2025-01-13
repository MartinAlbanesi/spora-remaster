package com.gg.spora.grove.domain.useCases.forestTrees

import com.gg.spora.grove.domain.interfaces.IForestTreeRepositoryLocal
import com.gg.spora.grove.domain.models.ForestTree
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadForestTreesExistsUseCase @Inject constructor(
    private val forestTreeRepositoryLocal: IForestTreeRepositoryLocal
) {
    suspend operator fun invoke(): Flow<List<ForestTree>> {
        return forestTreeRepositoryLocal.getForestTreesExistsFromDatabase()
    }
}