package com.gg.spora.user.domain

import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryLocal
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetAllObjectsDetailForUserUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val challengeRepositoryLocal: IChallengeRepositoryLocal
) {
    suspend operator fun invoke() : List<ObjectDetail>{

        val userLocal = userRepositoryLocal.getUser().first()!!
        val objectDetailLocal = challengeRepositoryLocal.getAllObjectsDetail()

        return (userLocal.objectsScanned + objectDetailLocal)
            .distinctBy { it.nameObjectDetail }
    }
}