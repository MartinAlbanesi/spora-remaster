package com.gg.spora.challenge.data.repositories

import com.gg.spora.challenge.data.local.ChallengeDao
import com.gg.spora.challenge.domain.entities.toObjectDetail
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail
import javax.inject.Inject

class ChallengeRepository  @Inject constructor(private val challengeDao: ChallengeDao) {

    //region ObjectDetailEntity

    suspend fun getAllObjectsDetail(): List<ObjectDetail> {
        val objectDetailEntities = challengeDao.getAllObjectsDetail()
        return objectDetailEntities.map { it.toObjectDetail() }
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

    suspend fun insertStepsObjectDetail(listStepObjectDetail: List<StepObjectDetail>){
        for(step in listStepObjectDetail){
            if(challengeDao.validateIfExistsStepsObjectDetail(step.nameObjectDetail!!, step.numberStep) == 0)
                challengeDao.insertStepObjetDetail(step.toStepObjectDetailEntity())
        }
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
