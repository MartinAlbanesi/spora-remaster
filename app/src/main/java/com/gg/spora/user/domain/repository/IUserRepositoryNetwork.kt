package com.gg.spora.user.domain.repository

import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserRepositoryNetwork {

    suspend fun setUser(user: User) : String

    suspend fun updateUserById(user: User, id: String)

    suspend fun deleteUserById(id: String)

    fun getUserByEmailFlow(email: String): Flow<User>

    fun getAllUser(): Flow<List<User>>

    suspend fun updateUserOxygen(oxygen: Int, userId: String)

    suspend fun updateUserData(user: User)
}