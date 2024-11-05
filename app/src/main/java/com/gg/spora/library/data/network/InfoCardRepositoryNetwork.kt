package com.gg.spora.library.data.network

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.core.utils.enums.CollectionsDataBase
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.library.domain.model.InfoCard
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class InfoCardRepositoryNetwork @Inject constructor(
    private val firestoreService: FirestoreService
) : IInfoCardRepositoryNetwork {
    private val firestore = firestoreService.getFirestore()


    override suspend fun getAllInfoCards(): Flow<List<InfoCard>> {
        return firestore
            .collection(CollectionsDataBase.INFO_CARDS)
            .snapshots()
            .map {
                it.toObjects(InfoCardNetwork::class.java)
                    .map { infoCard -> infoCard.toInfoCard() }
            }
    }

    override suspend fun getInfoCardById(id: Int): Flow<InfoCard?> {
        return firestore.collection(CollectionsDataBase.INFO_CARDS)
            .whereEqualTo("id", id)
            .snapshots()
            .map {
                it.toObjects(InfoCardNetwork::class.java)
                    .first()
                    .toInfoCard()
            }
    }

    override suspend fun getInfoCardListByCategory(category: String): Flow<List<InfoCard>> {
        return firestore.collection(CollectionsDataBase.INFO_CARDS)
            .whereEqualTo("category", category)
            .snapshots()
            .map {
                it.toObjects(InfoCardNetwork::class.java)
                    .map { infoCard ->
                        infoCard.toInfoCard()
                    }
            }
    }

    override suspend fun insertInfoCard(infoCardEntity: InfoCard): String {
        return firestoreService.setNewDocument(CollectionsDataBase.INFO_CARDS, infoCardEntity)
    }


    override suspend fun updateInfoCardById(infoCardEntity: InfoCard) {
        firestoreService.updateDocument(
            CollectionsDataBase.INFO_CARDS,
            infoCardEntity,
            infoCardEntity.id.toString()
        )
    }

    override suspend fun deleteInfoCardById(infoCardEntity: InfoCard) {
        firestoreService.deleteDocumentById(
            CollectionsDataBase.INFO_CARDS,
            infoCardEntity.id.toString()
        )
    }

    override suspend fun deleteAllInfoCards() {
        TODO("Not yet implemented")
    }
}