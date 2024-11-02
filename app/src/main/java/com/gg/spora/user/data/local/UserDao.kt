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
    @Query("SELECT * FROM user_entity LIMIT 1")
    fun getUsersWithLevelsCompleted(): Flow<UserWithLevelsCompletedEntity?>

//    @Query("SELECT * FROM user_entity LIMIT 1")
//    fun getUser(): Flow<UserEntity>

    @Query("SELECT oxygen FROM user_entity")
    fun getUserOxygen(): Flow<Int>

    @Query("SELECT * FROM level_completed_entity")
    fun getLevelsCompleted(): Flow<List<LevelCompletedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevelCompleted(levelsCompleted: LevelCompletedEntity)

//    @Delete
//    suspend fun deleteUser(user: UserEntity)
//
//    @Query("DELETE FROM user_entity WHERE id = :userId")
//    suspend fun deleteUserById(userId: String)

//    @Delete
//    suspend fun deleteLevelCompleted(levelsCompleted: LevelCompletedEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Query("update user_entity set id = :userId")
    suspend fun updateUserId(userId: String)

    @Query("update user_entity set oxygen = :oxygen")
    suspend fun updateOxygen(oxygen: Int)

    @Update
    suspend fun updateLevelCompleted(levelsCompleted: LevelCompletedEntity)
}