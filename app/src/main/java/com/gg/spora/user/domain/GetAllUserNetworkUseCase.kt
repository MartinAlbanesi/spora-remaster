package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllUserNetworkUseCase @Inject constructor(
    private val userRepositoryNetwork: IUserRepositoryNetwork
) {
    operator fun invoke(): Flow<List<User>> {
        return userRepositoryNetwork.getAllUser()
    }
}