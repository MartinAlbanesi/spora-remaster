package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case to get local user If the user does not exist, null will be returned
 * @return Flow<User?>
 */
class GetUserLocalUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    operator fun invoke(): Flow<User?> {
        return userRepositoryLocal.getUser()
    }
}