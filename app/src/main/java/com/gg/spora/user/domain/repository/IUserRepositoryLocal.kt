package com.gg.spora.user.domain.repository

import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserRepositoryLocal {

    suspend fun setUserLocal(user: User)

    suspend fun setLevelsCompleted(levelsCompleted: List<LevelCompletedEntity>)

    suspend fun updateUserWithLevelCompleted(user: User, levelCompleted: LevelCompleted)

    suspend fun updateUserId(userId: String)

    fun getUser(): Flow<User?>

    suspend fun getUserOxygen(): Flow<Int>

    suspend fun updateUserOxygen(oxygen: Int)

    suspend fun updateLevelCompleted(levelCompleted: LevelCompletedEntity)

    suspend fun deleteUser()

    suspend fun deleteLevelsCompleted()
}