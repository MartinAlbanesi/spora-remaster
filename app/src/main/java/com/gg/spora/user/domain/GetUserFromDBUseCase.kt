package com.gg.spora.user.domain

import com.gg.spora.user.data.network.UserRepositoryNetwork
import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserFromDBUseCase @Inject constructor(
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val userRepositoryNetwork: UserRepositoryNetwork
) {
    operator fun invoke(): Flow<User> {
        val user = getCurrentUserUseCase()
        return userRepositoryNetwork.getUserByEmailFlow(user?.email ?: "")
    }
}