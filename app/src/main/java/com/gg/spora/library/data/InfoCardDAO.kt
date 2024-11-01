package com.gg.spora.library.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gg.spora.library.domain.InfoCard

@Dao
interface InfoCardDAO {

    @Query("SELECT * FROM info_cards")
    suspend fun getAllInfoCards(): List<InfoCard>

    @Query("SELECT * FROM info_cards WHERE id = :id")
    suspend fun getInfoCardById(id: Int): InfoCard?


    @Query("SELECT * FROM info_cards WHERE category = :category")
    suspend fun getInfoCardsByCategory(category: String): List<InfoCard>

    @Insert
    suspend fun insertInfoCard(infoCard: InfoCard)

    @Insert
    fun insertInfoCardList(infoCards: List<InfoCard>)

    @Update
    suspend fun updateInfoCard(infoCard: InfoCard)

    @Delete
    suspend fun deleteInfoCard(infoCard: InfoCard)

    @Query("DELETE FROM info_cards")
    suspend fun deleteAllInfoCards()


}