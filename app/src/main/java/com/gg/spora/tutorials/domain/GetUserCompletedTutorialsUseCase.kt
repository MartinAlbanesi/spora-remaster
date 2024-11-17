package com.gg.spora.tutorials.domain

import com.gg.spora.tutorials.domain.model.TutorialCompleted
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import javax.inject.Inject

class GetUserCompletedTutorialsUseCase @Inject constructor(
    private val tutorialRepositoryLocal: ITutorialRepositoryLocal
) {
    suspend operator fun invoke(): List<TutorialCompleted> {
        return tutorialRepositoryLocal.getAllTutorialsCompleted()
    }
}