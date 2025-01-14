package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import javax.inject.Inject

/**
 * Use case for saving seed trees to the database.
 */
class SaveSeedTreesUseCase @Inject constructor(private val groveRepository: IGroveRepository)
{
    suspend operator fun invoke(seedTrees: List<SeedTree>) {
        groveRepository.insertSeedTreesList(seedTrees)
    }
}