package com.gg.spora.challenge.data.repositories

import com.gg.spora.challenge.data.dao.ChallengeDao
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail

class ChallengeRepository(private val challengeDao: ChallengeDao) {

    //region ObjectDetailEntity

    suspend fun getAllObjectsDetail(): List<ObjectDetail> {
        val objectDetailEntities = challengeDao.getAllObjectsDetail()
        return ObjectDetail.objectsDetailEntityToModels(objectDetailEntities)
    }

    suspend fun insertObjectDetail(objectDetail: ObjectDetail) {
        challengeDao.insertObjetDetail(objectDetail.toObjectDetailEntity())
    }

    suspend fun deleteAllObjectsDetail() {
        challengeDao.deleteAllObjectsDetail()
    }

    suspend fun updateObjectDetailWithId(idObjectDetail: Int) {
        challengeDao.updateObjectDetailWithId(idObjectDetail)
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

    suspend fun getAllStepsObjectDetailWithId(idObjectDetail: Int): List<StepObjectDetail> {
        val stepsEntities = challengeDao.getAllStepsObjectDetailWithId(idObjectDetail)
        return StepObjectDetail.objectsDetailEntityToModels(stepsEntities)
    }

    suspend fun deleteAllStepsObjectDetail() {
        challengeDao.deleteAllStepsObjectDetail()
    }

    //endregion
}
