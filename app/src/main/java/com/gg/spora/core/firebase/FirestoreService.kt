package com.gg.spora.core.firebase

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreService @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    suspend fun setNewDocument(
        collection: String,
        document: Any,
    ) : String {

        var id : String?

        val reference = firestore.collection(collection)

        reference.add(document).await().apply {
            id = this.id
            this.update("id", this.id)
        }

        return id!!
    }

    suspend fun updateDocument(collection: String, document: Any, id: String) {
        val reference = firestore.collection(collection).document(id)
        reference.set(document).await()
    }

    suspend fun deleteDocumentById(collection: String, id: String) {
        val reference = firestore.collection(collection).document(id)
        reference.delete().await()
    }

    fun getFirestore() : FirebaseFirestore {
        return firestore
    }
}