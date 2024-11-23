package com.gg.spora.user.domain

import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UpdateUserOxygenUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val getUserNetworkUseCase: GetUserNetworkUseCase,
    private val getUserAuthUseCase: GetUserAuthUseCase,
) {
    suspend operator fun invoke(oxygen: Int) {

        val userOxygen = userRepositoryLocal.getUserOxygen().first()
        userRepositoryLocal.updateUserOxygen(oxygen + userOxygen)

        if (getUserAuthUseCase() != null) {
            userRepositoryNetwork.updateUserOxygen(oxygen + userOxygen, getUserNetworkUseCase().first().id)
        }


    }
}