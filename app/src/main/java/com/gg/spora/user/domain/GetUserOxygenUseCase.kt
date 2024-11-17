package com.gg.spora.user.domain

import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserOxygenUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
) {
    suspend operator fun invoke(): Flow<Int> {
        return userRepositoryLocal.getUserOxygen()
    }
}