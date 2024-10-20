package com.gg.spora.challenge.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gg.spora.challenge.domain.entities.ObjectDetailEntity
import com.gg.spora.challenge.domain.entities.StepObjectDetailEntity

@Dao
interface ChallengeDao {

    //region ObjectDetailEntity
    @Query("SELECT * FROM object_detail")
    suspend fun getAllObjectsDetail() : List<ObjectDetailEntity>

    @Insert
    suspend fun insertObjetDetail(objectDetailEntity: ObjectDetailEntity)

    @Query("DELETE FROM object_detail")
    suspend fun deleteAllObjectsDetail()

    @Query(
        "UPDATE object_detail SET is_validate = 1 " +
            "WHERE id_object_detail = :idObjectDetail")
    suspend fun setValidObjectDetailInDatabase(idObjectDetail : Int)
    //endregion

    //region StepObjectDetailEntity
    @Query("SELECT * FROM object_detail_step")
    suspend fun getAllStepsObjectDetail() : List<StepObjectDetailEntity>

    @Insert
    suspend fun insertStepObjetDetail(stepObjectDetail: StepObjectDetailEntity)

    @Query("SELECT ods.* FROM object_detail od JOIN object_detail_step ods " +
            "ON od.id_object_detail = ods.id_object_detail" +
            " WHERE id_object_detail = :idObjectDetail")
    suspend fun getAllStepsObjectDetailWithId(idObjectDetail : Int) : List<StepObjectDetailEntity>

    @Query("DELETE FROM object_detail_step")
    suspend fun deleteAllStepsObjectDetail()
    //endregion
}