package com.gg.spora.library.data.repository

import com.gg.spora.library.data.local.InfoCardDAO
import com.gg.spora.library.data.local.entity.InfoCardEntity
import javax.inject.Inject


/**
 * Local Repository for Infocards used in LibraryScreen.kt
 *
 */

class InfoCardRepositoryLocal @Inject constructor(
    private val infoCardDao: InfoCardDAO
) : IInfoCardRepositoryLocal {

    override suspend fun getAllInfoCards(): List<InfoCardEntity> {
        return infoCardDao.getAllInfoCards()
    }

    override suspend fun getInfoCardById(id: Int): InfoCardEntity? {
        return infoCardDao.getInfoCardById(id)
    }

    override suspend fun getInfoCardListByCategory(category: String): List<InfoCardEntity> {
        return infoCardDao.getInfoCardsByCategory(category)
    }

    override suspend fun insertInfoCard(infoCardEntity: InfoCardEntity) {
        infoCardDao.insertInfoCard(infoCardEntity)
    }

    override suspend fun insertInfoCardList(infoCardEntityList: List<InfoCardEntity>) {
        infoCardDao.insertInfoCardList(infoCardEntityList)
    }

    override suspend fun updateInfoCard(infoCardEntity: InfoCardEntity) {
        infoCardDao.updateInfoCard(infoCardEntity)
    }

    override suspend fun deleteInfoCard(infoCardEntity: InfoCardEntity) {
        infoCardDao.deleteInfoCard(infoCardEntity)
    }

    override suspend fun deleteAllInfoCards() {
        infoCardDao.deleteAllInfoCards()
    }

}
