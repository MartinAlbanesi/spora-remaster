package com.gg.spora.user.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.data.local.entities.UserEntity
import com.gg.spora.user.data.local.entities.UserWithLevelsCompletedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Transaction
    @Query("SELECT * FROM user_entity")
    fun getUsersWithLevelsCompleted(): Flow<List<UserWithLevelsCompletedEntity>>

    @Query("SELECT * FROM user_entity WHERE id = :userId")
    fun getUser(userId: String): Flow<UserEntity>


    @Query("SELECT * FROM level_completed_entity WHERE userId = :userId")
    fun getLevelsCompletedByUserId(userId: String): Flow<List<LevelCompletedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevelCompleted(levelsCompleted: LevelCompletedEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Delete
    suspend fun deleteLevelCompleted(levelsCompleted: LevelCompletedEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Update
    suspend fun updateLevelCompleted(levelsCompleted: LevelCompletedEntity)
}