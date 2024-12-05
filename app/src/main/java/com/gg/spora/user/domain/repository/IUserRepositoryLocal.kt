package com.gg.spora.user.domain.repository

import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserRepositoryLocal {

    fun getUser(): Flow<User?>
    suspend fun getAllObjectsDetailsValidate(): List<ObjectDetail>
    suspend fun getUserOxygen(): Flow<Int>

    suspend fun setUserLocal(user: User)
    suspend fun setLevelsCompleted(levelsCompleted: List<LevelCompletedEntity>)

    suspend fun updateUserWithLevelCompleted(user: User, levelCompleted: LevelCompleted)
    suspend fun updateUserWithChallengeObjectCompleted(user: User, objectDetail: ObjectDetail)
    suspend fun updateUserIdAndEmail(userId: String, email: String)
    suspend fun updateUserOxygen(oxygen: Int)
    suspend fun updateLevelCompleted(levelCompleted: LevelCompletedEntity)
    suspend fun updateUserName(userName: String)
    suspend fun updateUserImage(userImage: String)
    suspend fun updateResetDailyMission(resetDailyMission: Long)

    suspend fun deleteUser()
    suspend fun deleteLevelsCompleted()



}