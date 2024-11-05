package com.gg.spora.stage.data.network

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.core.utils.enums.CollectionsDataBase
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.stage.data.network.models.LevelNetwork
import com.gg.spora.stage.domain.IStageRepositoryNetwork
import com.gg.spora.stage.domain.mappers.toLevel
import com.gg.spora.stage.domain.model.Level
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StageRepositoryNetwork @Inject constructor(
    firestoreService: FirestoreService
) : IStageRepositoryNetwork {

    private val firestore = firestoreService.getFirestore()

    override fun getLevelsByStageType(stageType: StageType): Flow<List<Level>> {
        return firestore
            .collection(CollectionsDataBase.LEVELS)
            .whereEqualTo("stageType", stageType.name)
            .snapshots()
            .map {
                it.toObjects(LevelNetwork::class.java)
                    .map { level -> level.toLevel() }
            }
    }

}