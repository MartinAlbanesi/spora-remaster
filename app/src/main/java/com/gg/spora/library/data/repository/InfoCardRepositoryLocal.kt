package com.gg.spora.library.data.repository

import com.gg.spora.library.data.local.InfoCardDAO
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.library.domain.mappers.toInfoCardEntity
import com.gg.spora.library.domain.model.InfoCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * Local Repository for Infocards used in LibraryScreen.kt
 *
 */

class InfoCardRepositoryLocal @Inject constructor(
    private val infoCardDao: InfoCardDAO
) : IInfoCardRepositoryLocal {

    override suspend fun getAllInfoCards(): Flow<List<InfoCard>> {
        return infoCardDao.getAllInfoCards().map { it.map { it.toInfoCard() } }
    }

    override suspend fun getInfoCardById(id: Int): InfoCard? {
        return infoCardDao.getInfoCardById(id)?.toInfoCard()
    }

    override suspend fun getInfoCardListByCategory(category: String): Flow<List<InfoCard>> {
        return infoCardDao.getInfoCardsByCategory(category).map { it.map { it.toInfoCard() } }
    }

    override suspend fun insertInfoCard(infoCardEntity: InfoCard) {
        infoCardDao.insertInfoCard(infoCardEntity.toInfoCardEntity())
    }

    override suspend fun insertInfoCardList(infoCardEntityList: List<InfoCard>) {
        infoCardDao.insertInfoCardList(infoCardEntityList.map { it.toInfoCardEntity() })
    }

    override suspend fun updateInfoCard(infoCardEntity: InfoCard) {
        infoCardDao.updateInfoCard(infoCardEntity.toInfoCardEntity())
    }

    override suspend fun deleteInfoCard(infoCardEntity: InfoCard) {
        infoCardDao.deleteInfoCard(infoCardEntity.toInfoCardEntity())
    }

    override suspend fun deleteAllInfoCards() {
        infoCardDao.deleteAllInfoCards()
    }

}
