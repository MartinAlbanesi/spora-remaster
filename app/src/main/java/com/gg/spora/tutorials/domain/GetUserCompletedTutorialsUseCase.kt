package com.gg.spora.tutorials.domain

import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import javax.inject.Inject

class GetUserCompletedTutorialsUseCase @Inject constructor(
    private val tutorialRepositoryLocal: ITutorialRepositoryLocal
) {
    operator fun invoke() {

    }
}