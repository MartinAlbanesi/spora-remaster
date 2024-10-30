package com.gg.spora.user.data.network.models

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.core.utils.enums.CollectionsDataBase
import com.gg.spora.user.domain.models.User
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryNetwork @Inject constructor(
    private val firestoreService: FirestoreService
){
    private val firestore = firestoreService.getFirestore()

    suspend fun setUser(user: UserNetwork) : String {
        return firestoreService.setNewDocument(user, "users")
    }

    suspend fun updateUserById(user: UserNetwork, id: String) {
        firestoreService.updateDocument("users", user, id)
    }

    suspend fun deleteUserById(id: String) {
        firestoreService.deleteDocumentById("users", id)
    }

    fun getUserByEmailFlow(email: String): Flow<User> {
        return firestore
            .collection(CollectionsDataBase.USERS)
            .whereEqualTo("email", email)
            .snapshots()
            .map {
                it.toObjects(User::class.java).first()
            }
    }
}