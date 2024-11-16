package com.gg.spora.challenge.domain.interfaces

import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail

interface IChallengeRepositoryLocal {


    suspend fun getAllObjectsDetail(): List<ObjectDetail>

    suspend fun setObjectDetail(objectDetail: ObjectDetail)

    suspend fun getObjectDetailWithName(nameObjectDetail: String) : ObjectDetail

    suspend fun deleteAllObjectsDetail()

    suspend fun setValidObjectDetailInDatabase(nameObjectDetail: String)

    suspend fun getAllStepsObjectDetail(): List<StepObjectDetail>

    suspend fun insertStepsObjectDetail(listStepObjectDetail: List<StepObjectDetail>)

    suspend fun insertStepObjectDetail(stepObjectDetail: StepObjectDetail)

    suspend fun getAllStepsObjectDetailWithName(nameObjectDetail: String): List<StepObjectDetail>

    suspend fun deleteAllStepsObjectDetail()
}