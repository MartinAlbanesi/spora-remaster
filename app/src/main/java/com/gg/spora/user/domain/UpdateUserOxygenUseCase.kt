package com.gg.spora.user.domain

import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import javax.inject.Inject

class UpdateUserOxygenUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    suspend operator fun invoke(oxygen: Int) {
        userRepositoryLocal.updateUserOxygen(oxygen)
    }
}