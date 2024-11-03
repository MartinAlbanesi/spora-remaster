package com.gg.spora.challenge.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.gg.spora.challenge.data.dao.ChallengeDao
import com.gg.spora.challenge.domain.entities.toObjectDetail
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail
import javax.inject.Inject

class ChallengeRepository  @Inject constructor(private val challengeDao: ChallengeDao) {

    //region ObjectDetailEntity

    fun getAllObjectsDetail(): LiveData<List<ObjectDetail>> {
        val objectDetailEntities = challengeDao.getAllObjectsDetail()
        return objectDetailEntities.map { listObjects -> listObjects.map { it.toObjectDetail() } }
        //return ObjectDetail.objectsDetailEntityToModels(objectDetailEntities)
    }

    suspend fun insertObjectDetail(objectDetail: ObjectDetail) {
        if(challengeDao.validateIfExistsObjectDetail(objectDetail.nameObjectDetail!!) == 0)
            challengeDao.insertObjetDetail(objectDetail.toObjectDetailEntity())
    }


    suspend fun getObjectDetailWithName(nameObjectDetail: String) :  ObjectDetail{
        return challengeDao.getObjectDetailWithName(nameObjectDetail).toObjectDetail()
    }

    suspend fun deleteAllObjectsDetail() {
        challengeDao.deleteAllObjectsDetail()
    }

    suspend fun setValidObjectDetailInDatabase(nameObjectDetail: String) {
        challengeDao.setValidObjectDetailInDatabase(nameObjectDetail)
    }

    //endregion

    //region StepObjectDetail
    suspend fun getAllStepsObjectDetail(): List<StepObjectDetail> {
        val stepObjectDetailEntities = challengeDao.getAllStepsObjectDetail()
        return StepObjectDetail.objectsDetailEntityToModels(stepObjectDetailEntities)
    }

    suspend fun insertStepObjectDetail(stepObjectDetail: StepObjectDetail) {
        challengeDao.insertStepObjetDetail(stepObjectDetail.toStepObjectDetailEntity())
    }

    suspend fun getAllStepsObjectDetailWithName(nameObjectDetail: String): List<StepObjectDetail> {
        val stepsEntities = challengeDao.getAllStepsObjectDetailWithName(nameObjectDetail)
        return StepObjectDetail.objectsDetailEntityToModels(stepsEntities)
    }

    suspend fun deleteAllStepsObjectDetail() {
        challengeDao.deleteAllStepsObjectDetail()
    }

    //endregion
}
