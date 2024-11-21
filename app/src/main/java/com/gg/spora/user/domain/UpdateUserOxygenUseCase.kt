package com.gg.spora.user.domain

import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UpdateUserOxygenUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    suspend operator fun invoke(oxygen: Int) {

        val userOxygen = userRepositoryLocal.getUserOxygen().first()

        userRepositoryLocal.updateUserOxygen(oxygen + userOxygen)
    }
}