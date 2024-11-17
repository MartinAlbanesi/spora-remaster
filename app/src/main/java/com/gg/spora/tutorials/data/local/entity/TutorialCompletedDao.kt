package com.gg.spora.tutorials.data.local.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gg.spora.tutorials.data.local.TutorialCompletedEntity

@Dao
interface TutorialCompletedDao {

    @Query("SELECT * FROM tutorial_completed")
    suspend fun getAllTutorialsCompleted(): List<TutorialCompletedEntity>

    @Query("SELECT * FROM tutorial_completed WHERE tutorial_id = :tutorialId")
    suspend fun getTutorialById(tutorialId: Int): TutorialCompletedEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTutorialCompleted(tutorialCompletedEntity: TutorialCompletedEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTutorialsCompleted(tutorialCompletedEntity: List<TutorialCompletedEntity>)

    @Query("UPDATE tutorial_completed SET is_completed = :isCompleted WHERE tutorial_id = :tutorialId")
    suspend fun updateTutorialCompleted(tutorialId: Int, isCompleted: Boolean)
}