package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import javax.inject.Inject

class GetUserLocalUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    suspend operator fun invoke(): List<User> {
        return userRepositoryLocal.getCurrentUserFlow()
    }
}