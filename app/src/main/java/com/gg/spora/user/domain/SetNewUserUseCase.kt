package com.gg.spora.user.domain

import com.gg.spora.R
import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SetNewUserUseCase @Inject constructor(
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    suspend operator fun invoke(email: String?, userName: String) {

        if (email == null) {
            val user = User(
                id = "1",
                userName = userName,
                email = "",
                oxygen = 0,
                levelsCompleted = emptyList(),
                treesCount = 0,
                userImage = R.drawable.spora_face_splash,
                weeklyOxygen = 0
            )
            userRepositoryLocal.setUserLocal(user)
            return
        }

        val userLocal = userRepositoryLocal.getUser().first()

        if (userLocal != null) {
            userRepositoryNetwork.setUser(userLocal)
        } else {

            val user = User(
                id = "",
                userName = userName,
                email = email,
                oxygen = 0,
                levelsCompleted = emptyList(),
                treesCount = 0,
                userImage = R.drawable.spora_face_splash,
                weeklyOxygen = 0
            )
            val userId = userRepositoryNetwork.setUser(user)
            userRepositoryLocal.setUserLocal(user)
            userRepositoryLocal.updateUserId(userId)
        }

    }
}