package com.gg.spora.user.domain

import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import javax.inject.Inject


class UpdateUserImageUseCase @Inject constructor(private val userRepositoryLocal: IUserRepositoryLocal) {
    suspend operator fun invoke(image: String) {
        userRepositoryLocal.updateUserImage(image)
    }
}