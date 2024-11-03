package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Caso de uso para obtener el usuario local
 * Si el usuario no existe, se devolverá null
 */
class GetUserLocalUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal
) {
    operator fun invoke(): Flow<User?> {
        return userRepositoryLocal.getUser()
    }
}