package com.gg.spora.challenge.data.network

import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryNetwork
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.core.firebase.FirestoreService
import javax.inject.Inject

class ChallengeRepositoryNetwork @Inject constructor(firestoreService: FirestoreService) : IChallengeRepositoryNetwork{
//    private val firestore = firestoreService.getFirestore()

    override fun getObjectsDetailByUser(userId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun setObjectDetail(objectDetail: ObjectDetail): String {
        TODO("Not yet implemented")
    }


}