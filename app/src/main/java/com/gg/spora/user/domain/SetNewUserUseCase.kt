package com.gg.spora.user.domain

import com.gg.spora.tutorials.data.TutorialModels
import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject


/**
 * Use case that creates a new user locally and remotely.
 * If the email is null, it is created only locally.
 * If the email is not null, it is created locally and remotely. And the id of the
 * local user is changed to that of the remote one.
 * @param email? email del usuario
 * @param userName nombre del usuario
 */
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
                seedTrees = emptyList(),
                forestTrees = emptyList(),
                userImage = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_smile.png?alt=media&token=332929a3-a86a-4a8c-834e-28bccc40fe36",
                weeklyOxygen = 0,
                tutorialsCompleted = TutorialModels.tutorialsCompleted,
                objectsScanned = emptyList()
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
                seedTrees = emptyList(),
                forestTrees = emptyList(),
                userImage = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_smile.png?alt=media&token=332929a3-a86a-4a8c-834e-28bccc40fe36",
                weeklyOxygen = 0,
                tutorialsCompleted = TutorialModels.tutorialsCompleted,
                objectsScanned = emptyList()
            )
            val userId = userRepositoryNetwork.setUser(user)
            userRepositoryLocal.setUserLocal(user)
            userRepositoryLocal.updateUserId(userId)
        }

    }
}