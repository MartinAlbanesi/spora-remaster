package com.gg.spora.library.data.repository

import com.gg.spora.library.domain.model.InfoCard
import kotlinx.coroutines.flow.Flow

interface IInfoCardRepositoryLocal {

    suspend fun getAllInfoCards(): Flow<List<InfoCard>>

    suspend fun getInfoCardById(id: Int): InfoCard?

    suspend fun getInfoCardListByCategory(category: String): Flow<List<InfoCard>>

    suspend fun insertInfoCard(infoCardEntity: InfoCard)

    suspend fun insertInfoCardList(infoCardEntityList: List<InfoCard>)

    suspend fun updateInfoCard(infoCardEntity: InfoCard)

    suspend fun deleteInfoCard(infoCardEntity: InfoCard)

    suspend fun deleteAllInfoCards()
}