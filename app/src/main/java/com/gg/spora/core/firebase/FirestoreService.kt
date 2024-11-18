package com.gg.spora.core.firebase

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * Clase que se encarga de realizar operaciones "basicas" en la base de datos de Firestore
 */
class FirestoreService @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    /**
     * Guarda un nuevo documento en una colección
     * @param collection Nombre de la colección
     * @param document Clase del documento a guardar
     * @return El id del documento guardado
     */
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

    /**
     * Obtiene todos los documentos de una colección
     * @param collection Nombre de la colección
     * @param document Clase del documento a obtener
     * @id Id del documento
     */
    suspend fun updateDocument(collection: String, document: Any, id: String) {
        val reference = firestore.collection(collection).document(id)
        reference.set(document).await()
    }

    /**
     * Borra un documento de una colección por su id
     * @param collection Nombre de la colección
     * @param id Id del documento a borrar
     */
    suspend fun deleteDocumentById(collection: String, id: String) {
        val reference = firestore.collection(collection).document(id)
        reference.delete().await()
    }

    suspend fun updateFieldInDocument(collection: String, id: String, field: String, value: Any) {
        val reference = firestore.collection(collection).document(id)
        reference.update(field, value).await()
    }

    fun getFirestore() : FirebaseFirestore {
        return firestore
    }
}