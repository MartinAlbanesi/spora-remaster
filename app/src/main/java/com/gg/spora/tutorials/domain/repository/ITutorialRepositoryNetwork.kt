package com.gg.spora.tutorials.domain.repository

import com.gg.spora.tutorials.domain.model.TutorialCompleted

interface ITutorialRepositoryNetwork {

    suspend fun insertAllTutorialsCompleted(userId: String, tutorialCompleted: List<TutorialCompleted>)

    suspend fun updateTutorialCompleted(userId: String, tutorialsCompleted: List<TutorialCompleted>)
}