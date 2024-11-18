package com.gg.spora.tutorials.data.network

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.core.utils.enums.CollectionsDataBase
import com.gg.spora.tutorials.data.TutorialModels.tutorialsCompleted
import com.gg.spora.tutorials.domain.model.TutorialCompleted
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryNetwork
import javax.inject.Inject

class TutorialRepositoryNetwork @Inject constructor(
    private val firestoreService: FirestoreService
): ITutorialRepositoryNetwork {
    override suspend fun insertAllTutorialsCompleted(
        userId: String,
        tutorialCompleted: List<TutorialCompleted>
    ) {
        firestoreService.updateFieldInDocument(
            collection = CollectionsDataBase.USERS,
            id = userId,
            "tutorialsCompleted",
            tutorialsCompleted
        )
    }

    override suspend fun updateTutorialCompleted(
        userId: String,
        tutorialsCompleted: List<TutorialCompleted>
    ) {
        firestoreService.updateFieldInDocument(
            collection = CollectionsDataBase.USERS,
            id = userId,
            "tutorialsCompleted",
            tutorialsCompleted
        )
    }

}