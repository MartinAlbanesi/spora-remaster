package com.gg.spora.user.domain

import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import javax.inject.Inject

class UpdateUserNameUseCase @Inject constructor(private val userRepositoryLocal: IUserRepositoryLocal) {
    suspend operator fun invoke(username: String) {
        userRepositoryLocal.updateUserName(username)

    }
}