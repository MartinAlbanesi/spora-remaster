package com.gg.spora.user.domain

import com.gg.spora.user.domain.mappers.toLevelCompletedEntity
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case to update the user's local data from the network
 * @param email: String
 */
class UpdateUserLocalDataFromNetworkUseCase @Inject constructor(
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    suspend operator fun invoke(
        email: String
    ) {
        val user = userRepositoryNetwork.getUserByEmailFlow(email).first()
        userRepositoryLocal.setUserLocal(user)
        userRepositoryLocal.setLevelsCompleted(user.levelsCompleted.map { it.toLevelCompletedEntity(user.id) })
    }
}