package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import javax.inject.Inject

class SetNewUserUseCase @Inject constructor(
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    suspend operator fun invoke(email: String, userName: String) {

        val userLocal = userRepositoryLocal.getCurrentUserFlow()

        if(userLocal.isNotEmpty()) {
            userRepositoryNetwork.setUser(userLocal.first())
        }else{
            val user = User(
                id = "",
                userName = userName,
                email = email?: "",
                oxygen = 0,
                levelsCompleted = emptyList()
            )
            userRepositoryLocal.setUserLocal(user)
            userRepositoryNetwork.setUser(user)
        }
    }
}