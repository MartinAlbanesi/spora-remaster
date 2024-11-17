package com.gg.spora.user.domain

import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import javax.inject.Inject

class GetAllObjectsDetailForUserLocalUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    suspend operator fun invoke() : List<ObjectDetail>{
        val objectDetailsLocal = userRepositoryLocal.getAllObjectsDetailsValidate()
        return objectDetailsLocal
    }
}