package com.gg.spora.library.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gg.spora.library.data.local.entity.InfoCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InfoCardDAO {

    @Query("SELECT * FROM info_cards")
    fun getAllInfoCards(): Flow<List<InfoCardEntity>>

    @Query("SELECT * FROM info_cards WHERE id = :id")
    suspend fun getInfoCardById(id: String): InfoCardEntity?

    @Query("SELECT * FROM info_cards WHERE category = :category")
    fun getInfoCardsByCategory(category: String): Flow<List<InfoCardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInfoCard(infoCardEntity: InfoCardEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInfoCardList(infoCardEntities: List<InfoCardEntity>)

    @Update
    suspend fun updateInfoCard(infoCardEntity: InfoCardEntity)

    @Delete
    suspend fun deleteInfoCard(infoCardEntity: InfoCardEntity)

    @Query("DELETE FROM info_cards")
    suspend fun deleteAllInfoCards()


}