package com.gg.spora.user.domain

import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetAllObjectsDetailForUserUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    suspend operator fun invoke() : List<ObjectDetail>{

        val userLocal = userRepositoryLocal.getUser().first()!!
        return userLocal.objectsScanned
    }
}