package com.gg.spora.library.data.network

import com.gg.spora.library.domain.model.InfoCard
import kotlinx.coroutines.flow.Flow

interface IInfoCardRepositoryNetwork {

    suspend fun getAllInfoCards(): Flow<List<InfoCard>>

    suspend fun getInfoCardById(id: String): Flow<InfoCard?>

    suspend fun getInfoCardListByCategory(category: String): Flow<List<InfoCard>>

    suspend fun insertInfoCard(infoCardEntity: InfoCard): String

    suspend fun updateInfoCardById(infoCardEntity: InfoCard)

    suspend fun deleteInfoCardById(infoCardEntity: InfoCard)

    suspend fun deleteAllInfoCards()
}