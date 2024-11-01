package com.gg.spora.library.data.repository

import com.gg.spora.library.data.InfoCardDAO
import com.gg.spora.library.domain.InfoCard
import javax.inject.Inject


/**
 * Local Repository for Infocards used in LibraryScreen.kt
 *
 */
class InfoCardRepository @Inject constructor(private val infoCardDao: InfoCardDAO) {

    suspend fun getAllInfoCards(): List<InfoCard> {
        return infoCardDao.getAllInfoCards()
    }

    suspend fun getInfoCardById(id: Int): InfoCard? {
        return infoCardDao.getInfoCardById(id)
    }

    suspend fun getInfoCardListByCategory(category: String): List<InfoCard> {
        return infoCardDao.getInfoCardsByCategory(category)
    }

    suspend fun insertInfoCard(infoCard: InfoCard) {
        infoCardDao.insertInfoCard(infoCard)
    }

    suspend fun insertInfoCardList(infoCardList: List<InfoCard>) {
        infoCardDao.insertInfoCardList(infoCardList)
    }

    suspend fun updateInfoCard(infoCard: InfoCard) {
        infoCardDao.updateInfoCard(infoCard)
    }

    suspend fun deleteInfoCard(infoCard: InfoCard) {
        infoCardDao.deleteInfoCard(infoCard)
    }

    suspend fun deleteAllInfoCards() {
        infoCardDao.deleteAllInfoCards()
    }
}
