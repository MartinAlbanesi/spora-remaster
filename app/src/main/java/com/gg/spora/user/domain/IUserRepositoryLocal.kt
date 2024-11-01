package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserRepositoryLocal {

    suspend fun setUserLocal(user: User)

    suspend fun updateUserLocal(user: User)

    suspend fun updateUserIdByUserName(userId: String, userName: String)

//    suspend fun deleteUserById(id: String)

    fun getUserByIdFlow(userId: String): Flow<User>
}