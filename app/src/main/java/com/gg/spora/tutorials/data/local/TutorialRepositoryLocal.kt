package com.gg.spora.tutorials.data.local

import com.gg.spora.tutorials.data.local.entity.TutorialCompletedDao
import com.gg.spora.tutorials.domain.mapper.toTutorialCompleted
import com.gg.spora.tutorials.domain.mapper.toTutorialCompletedEntity
import com.gg.spora.tutorials.domain.model.TutorialCompleted
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import javax.inject.Inject

class TutorialRepositoryLocal @Inject constructor(
    private val tutorialDao: TutorialCompletedDao
): ITutorialRepositoryLocal {
    override suspend fun getAllTutorialsCompleted(): List<TutorialCompleted> {
        return tutorialDao.getAllTutorialsCompleted().map { it.toTutorialCompleted() }
    }

    override suspend fun getTutorialById(tutorialId: Int): TutorialCompleted {
        return tutorialDao.getTutorialById(tutorialId).toTutorialCompleted()
    }

    override suspend fun insertAllTutorialsCompleted(tutorialCompleted: List<TutorialCompleted>) {
        tutorialDao.insertAllTutorialsCompleted(tutorialCompleted.map { it.toTutorialCompletedEntity() })
    }

    override suspend fun updateTutorialCompleted(tutorialId: Int, isCompleted: Boolean) {
        tutorialDao.updateTutorialCompleted(tutorialId, isCompleted)
    }

}