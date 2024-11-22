package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case to return a firebase user from the network
 * @return Flow<User>
 */
class GetUserNetworkUseCase @Inject constructor(
    private val getUserAuthUseCase: GetUserAuthUseCase,
    private val userRepositoryNetwork: IUserRepositoryNetwork
) {
    operator fun invoke(): Flow<User> {
        val user = getUserAuthUseCase()
        return userRepositoryNetwork.getUserByEmailFlow(user?.email ?: "")
    }
}