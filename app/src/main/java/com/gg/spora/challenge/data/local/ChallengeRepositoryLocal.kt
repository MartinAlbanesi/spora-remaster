package com.gg.spora.challenge.data.local

import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryLocal
import com.gg.spora.challenge.domain.mappers.toObjectDetail
import com.gg.spora.challenge.domain.mappers.toObjectDetailEntity
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail
import javax.inject.Inject

class ChallengeRepositoryLocal  @Inject
constructor(private val challengeDao: ChallengeDao) : IChallengeRepositoryLocal{

    //region ObjectDetailEntity

    override suspend fun getAllObjectsDetail(): List<ObjectDetail> {
        val objectDetailEntities = challengeDao.getAllObjectsDetail()
        return objectDetailEntities.map { it.toObjectDetail() }
    }

    override suspend fun insertObjectDetail(objectDetail: ObjectDetail) {
        if(challengeDao.validateIfExistsObjectDetail(objectDetail.nameObjectDetail!!) == 0)
            challengeDao.insertObjetDetail(objectDetail.toObjectDetailEntity())
    }


    override suspend fun getObjectDetailWithName(nameObjectDetail: String) : ObjectDetail {
        return challengeDao.getObjectDetailWithName(nameObjectDetail).toObjectDetail()
    }

    override suspend fun deleteAllObjectsDetail() {
        challengeDao.deleteAllObjectsDetail()
    }

    override suspend fun setValidObjectDetailInDatabase(nameObjectDetail: String) {
        challengeDao.setValidObjectDetailInDatabase(nameObjectDetail)
    }

    //endregion

    //region StepObjectDetail
    override suspend fun getAllStepsObjectDetail(): List<StepObjectDetail> {
        val stepObjectDetailEntities = challengeDao.getAllStepsObjectDetail()
        return StepObjectDetail.objectsDetailEntityToModels(stepObjectDetailEntities)
    }

    override suspend fun insertStepsObjectDetail(listStepObjectDetail: List<StepObjectDetail>){
        for(step in listStepObjectDetail){
            if(challengeDao.validateIfExistsStepsObjectDetail(step.nameObjectDetail!!, step.numberStep) == 0)
                challengeDao.insertStepObjetDetail(step.toStepObjectDetailEntity())
        }
    }

    override suspend fun insertStepObjectDetail(stepObjectDetail: StepObjectDetail) {
        challengeDao.insertStepObjetDetail(stepObjectDetail.toStepObjectDetailEntity())
    }

    override suspend fun getAllStepsObjectDetailWithName(nameObjectDetail: String): List<StepObjectDetail> {
        val stepsEntities = challengeDao.getAllStepsObjectDetailWithName(nameObjectDetail)
        return StepObjectDetail.objectsDetailEntityToModels(stepsEntities)
    }

    override suspend fun deleteAllStepsObjectDetail() {
        challengeDao.deleteAllStepsObjectDetail()
    }

    //endregion
}
