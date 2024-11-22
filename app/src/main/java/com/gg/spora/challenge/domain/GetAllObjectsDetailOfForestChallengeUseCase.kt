package com.gg.spora.challenge.domain

import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryLocal
import com.gg.spora.challenge.domain.model.ObjectDetail
import javax.inject.Inject

class GetAllObjectsDetailOfForestChallengeUseCase @Inject constructor(
    private val challengeRepositoryLocal: IChallengeRepositoryLocal,
) {
    suspend operator fun invoke() : List<ObjectDetail> {
        return challengeRepositoryLocal.getAllObjectsDetail()
    }
}