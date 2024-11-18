package com.gg.spora.tutorials.domain

import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryNetwork
import com.gg.spora.user.domain.GetUserAuthUseCase
import javax.inject.Inject

/**
 * Update tutorial completed use case in local and network (if user is authenticated)
 * @param userId user id
 * @param tutorialId tutorial id
 * @param isCompleted is tutorial completed
 */
class UpdateTutorialCompletedUseCase @Inject constructor(
    private val getUserAuthUseCase: GetUserAuthUseCase,
    private val tutorialRepositoryLocal: ITutorialRepositoryLocal,
    private val tutorialRepositoryNetwork: ITutorialRepositoryNetwork
) {
    suspend operator fun invoke(
        userId: String,
        tutorialId: Int,
        isCompleted: Boolean
    ) {
        tutorialRepositoryLocal.updateTutorialCompleted(tutorialId, isCompleted)

        getUserAuthUseCase()?.let {

            val tutorialsCompleted = tutorialRepositoryLocal.getAllTutorialsCompleted()

            tutorialRepositoryNetwork.updateTutorialCompleted(userId, tutorialsCompleted)
        }
    }
}