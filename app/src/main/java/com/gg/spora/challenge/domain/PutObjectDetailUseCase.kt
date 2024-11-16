package com.gg.spora.challenge.domain

import com.gg.spora.R
import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryLocal
import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryNetwork
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail
import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PutObjectDetailUseCase @Inject constructor(
    private val challengeRepositoryNetwork: IChallengeRepositoryNetwork,
    private val challengeRepositoryLocal: IChallengeRepositoryLocal
) {
    suspend operator fun invoke(nameObject: String) {


        val objectDetailLocal = challengeRepositoryLocal.getObjectDetailWithName(nameObject)

        if (objectDetailLocal != null) {
            challengeRepositoryNetwork.setObjectDetail(objectDetailLocal)
        } else {
/*
            val user = User(
                id = "",
                userName = userName,
                email = email,
                oxygen = 0,
                levelsCompleted = emptyList(),
                treesCount = 0,
                userImage = R.drawable.spora_face_splash,
                objectsScanned = emptyList()
            )
            val userId = userRepositoryNetwork.setUser(user)
            userRepositoryLocal.setUserLocal(user)
            userRepositoryLocal.updateUserId(userId)
            */
        }

    }
}