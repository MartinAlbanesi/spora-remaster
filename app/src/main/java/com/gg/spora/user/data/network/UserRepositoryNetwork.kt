package com.gg.spora.user.data.network

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.core.utils.enums.CollectionsDataBase
import com.gg.spora.user.data.network.models.UserNetwork
import com.gg.spora.user.domain.mappers.toUser
import com.gg.spora.user.domain.models.User
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryNetwork @Inject constructor(
    private val firestoreService: FirestoreService
) : IUserRepositoryNetwork {
    private val firestore = firestoreService.getFirestore()

    override suspend fun setUser(user: User) : String {
        return firestoreService.setNewDocument(CollectionsDataBase.USERS, user)
    }

    override suspend fun updateUserById(user: User, id: String) {
        firestoreService.updateDocument(CollectionsDataBase.USERS, user, id)
    }

    override suspend fun deleteUserById(id: String) {
        firestoreService.deleteDocumentById(CollectionsDataBase.USERS, id)
    }

    override fun getUserByEmailFlow(email: String): Flow<User> {
        return firestore
            .collection(CollectionsDataBase.USERS)
            .whereEqualTo("email", email)
            .snapshots()
            .map {
                it.toObjects(UserNetwork::class.java)
                    .first()
                    .toUser()
            }
    }

    override fun getAllUser(): Flow<List<User>> {
        return firestore
            .collection(CollectionsDataBase.USERS)
            .whereGreaterThan("oxygen", 1)
            .orderBy("oxygen", Query.Direction.DESCENDING)
            .limit(15)
            .snapshots()
            .map { querySnapshot ->
                querySnapshot.toObjects(UserNetwork::class.java)
                    .map { userNetwork -> userNetwork.toUser() }
            }
    }

    override suspend fun updateUserOxygen(
        oxygen: Int,
        userId: String
    ) {
        firestoreService.updateFieldInDocument(
            collection = CollectionsDataBase.USERS,
            id = userId,
            field = "oxygen",
            value = oxygen
        )
    }

    override suspend fun updateUserData(user: User) {
        firestoreService.updateDocument(
            collection = CollectionsDataBase.USERS,
            document = user,
            id = user.id
        )
    }

    override suspend fun getUserByEmail(email: String): User? {
        val ref = firestore
            .collection(CollectionsDataBase.USERS)
            .whereEqualTo("email", email)
        val result = ref.get().await().documents.firstOrNull() ?: return null
        return result.toObject(UserNetwork::class.java)?.toUser()
    }
}