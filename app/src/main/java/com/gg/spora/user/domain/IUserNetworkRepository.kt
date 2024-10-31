package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserNetworkRepository {

    suspend fun setUser(user: User) : String

    suspend fun updateUserById(user: User, id: String)

    suspend fun deleteUserById(id: String)

    fun getUserByEmailFlow(email: String): Flow<User>
}