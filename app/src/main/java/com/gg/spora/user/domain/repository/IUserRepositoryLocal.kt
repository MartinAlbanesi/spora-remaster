package com.gg.spora.user.domain.repository

import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserRepositoryLocal {

    suspend fun setUserLocal(user: User)

    suspend fun updateUserWithLevelCompleted(user: User, levelCompleted: LevelCompleted)

    suspend fun updateUserId(userId: String)

//    suspend fun deleteUserById(id: String)

    fun getUser(): Flow<User>

//    suspend fun getCurrentUserFlow(): List<User>
}