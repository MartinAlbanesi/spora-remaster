package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import javax.inject.Inject

class SetNewUserUseCase @Inject constructor(
    private var userRepository: IUserRepositoryNetwork
) {
    suspend operator fun invoke(email: String, userName: String) {
        val user = User(
            id = "",
            userName = userName,
            email = email,
            oxygen = 0,
            levelsCompleted = emptyList()
        )
        userRepository.setUser(user)
    }
}