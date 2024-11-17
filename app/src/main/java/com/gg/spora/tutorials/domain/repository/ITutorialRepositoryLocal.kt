package com.gg.spora.tutorials.domain.repository

import com.gg.spora.tutorials.data.local.TutorialCompletedEntity
import com.gg.spora.tutorials.domain.model.TutorialCompleted

interface ITutorialRepositoryLocal {

    suspend fun getAllTutorialsCompleted(): List<TutorialCompleted>

    suspend fun getTutorialById(tutorialId: Int): TutorialCompleted

    suspend fun insertAllTutorialsCompleted(tutorialCompleted: List<TutorialCompleted>)

    suspend fun updateTutorialCompleted(tutorialId: Int, isCompleted: Boolean)
}