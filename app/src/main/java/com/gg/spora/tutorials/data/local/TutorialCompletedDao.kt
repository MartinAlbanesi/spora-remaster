package com.gg.spora.tutorials.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TutorialCompletedDao {

    @Query("SELECT * FROM tutorial_completed")
    suspend fun getAllTutorialsCompleted(): List<TutorialCompletedEntity>

    @Query("SELECT * FROM tutorial_completed WHERE tutorial_id = :tutorialId")
    suspend fun getTutorialById(tutorialId: Int): TutorialCompletedEntity

    @Insert
    suspend fun insertTutorialCompleted(tutorialCompletedEntity: TutorialCompletedEntity)

    @Insert
    suspend fun insertAllTutorialsCompleted(tutorialCompletedEntity: List<TutorialCompletedEntity>)

    @Update
    suspend fun updateTutorialCompleted(tutorialCompletedEntity: TutorialCompletedEntity)
}