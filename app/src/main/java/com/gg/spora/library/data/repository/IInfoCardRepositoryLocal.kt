package com.gg.spora.library.data.repository

import com.gg.spora.library.data.local.entity.InfoCardEntity

interface IInfoCardRepositoryLocal {

    suspend fun getAllInfoCards(): List<InfoCardEntity>

    suspend fun getInfoCardById(id: Int): InfoCardEntity?

    suspend fun getInfoCardListByCategory(category: String): List<InfoCardEntity>

    suspend fun insertInfoCard(infoCardEntity: InfoCardEntity)

    suspend fun insertInfoCardList(infoCardEntityList: List<InfoCardEntity>)

    suspend fun updateInfoCard(infoCardEntity: InfoCardEntity)

    suspend fun deleteInfoCard(infoCardEntity: InfoCardEntity)

    suspend fun deleteAllInfoCards()
}