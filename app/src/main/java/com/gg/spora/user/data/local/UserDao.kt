package com.gg.spora.user.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.data.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Transaction
    @Query("SELECT * FROM user_entity")
    fun getUsers(): Flow<List<UserEntity>>


    @Query("SELECT * FROM level_completed_entity WHERE userId = :userId")
    fun getLevelsCompletedByUserId(userId: String): Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevelCompleted(levelsCompleted: LevelCompletedEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Delete
    suspend fun deleteLevelCompleted(levelsCompleted: LevelCompletedEntity)
}