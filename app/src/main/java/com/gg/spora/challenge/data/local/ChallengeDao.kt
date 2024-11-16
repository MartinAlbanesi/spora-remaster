package com.gg.spora.challenge.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gg.spora.challenge.domain.entities.ObjectDetailEntity
import com.gg.spora.challenge.domain.entities.StepObjectDetailEntity
import com.gg.spora.challenge.domain.model.ObjectDetail

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
            "WHERE name_object_detail = :nameObjectDetail")
    suspend fun setValidObjectDetailInDatabase(nameObjectDetail : String)

    @Query("SELECT COUNT(*) FROM object_detail " +
            "WHERE name_object_detail = :nameObjectDetail")
    suspend fun validateIfExistsObjectDetail(nameObjectDetail : String) : Int

    @Query("SELECT * FROM object_detail " +
            "WHERE name_object_detail = :nameObjectDetail")
    suspend fun getObjectDetailWithName(nameObjectDetail : String) : ObjectDetailEntity

    @Update
    suspend fun updateObjectDetail(objectDetail : ObjectDetail)
    //endregion

    //region StepObjectDetailEntity
    @Query("SELECT * FROM object_detail_step")
    suspend fun getAllStepsObjectDetail() : List<StepObjectDetailEntity>

    @Insert
    suspend fun insertStepObjetDetail(stepObjectDetail: StepObjectDetailEntity)

    @Query("SELECT ods.* FROM object_detail od JOIN object_detail_step ods " +
            "ON od.name_object_detail = ods.name_object_detail " +
            "WHERE od.name_object_detail = :nameObjectDetail")
    suspend fun getAllStepsObjectDetailWithName(nameObjectDetail : String) : List<StepObjectDetailEntity>

    @Query("SELECT COUNT(*) FROM object_detail od JOIN object_detail_step ods " +
            "ON od.name_object_detail = ods.name_object_detail " +
        "WHERE od.name_object_detail = :nameObjectDetail AND number_step = :stepNumber")
    suspend fun validateIfExistsStepsObjectDetail(nameObjectDetail : String, stepNumber : Int) : Int

    @Query("DELETE FROM object_detail_step")
    suspend fun deleteAllStepsObjectDetail()
    //endregion
}