package com.gg.spora.challenge.data.network

import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryNetwork
import com.gg.spora.core.firebase.FirestoreService
import javax.inject.Inject

class ChallengeRepositoryNetwork @Inject constructor(firestoreService: FirestoreService) : IChallengeRepositoryNetwork{
    private val firestore = firestoreService.getFirestore()

}