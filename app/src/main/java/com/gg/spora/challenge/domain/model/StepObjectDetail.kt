package com.gg.spora.challenge.domain.model

import com.gg.spora.challenge.domain.entities.StepObjectDetailEntity

data class StepObjectDetail(
    val numberStep : Int,
    val nameObjectDetail : String?,
    val titleStep : String?,
    val description : String?,
    val isFirst : Boolean,
    val isLast : Boolean
){

    companion object{
        private fun entityToStepObjectDetailModel(stepObjectDetailEntity: StepObjectDetailEntity) : StepObjectDetail {
            return StepObjectDetail(
                numberStep =  stepObjectDetailEntity.numberStep,
                nameObjectDetail = stepObjectDetailEntity.nameObjectDetail,
                description = stepObjectDetailEntity.description,
                titleStep = stepObjectDetailEntity.titleStep,
                isFirst =  stepObjectDetailEntity.isFirst,
                isLast = stepObjectDetailEntity.isLast
            )
        }

        fun objectsDetailEntityToModels(stepsObjectDetailEntities : List<StepObjectDetailEntity>) : List<StepObjectDetail>{

            val listStepsObjectDetails = mutableListOf<StepObjectDetail>()

            for(entity in stepsObjectDetailEntities){
                listStepsObjectDetails.add(entityToStepObjectDetailModel(entity))
            }

            return listStepsObjectDetails
        }
    }

    fun toStepObjectDetailEntity(): StepObjectDetailEntity {
        return StepObjectDetailEntity(
            numberStep =  numberStep,
            nameObjectDetail = nameObjectDetail!!,
            description = description,
            titleStep = titleStep,
            isFirst = isFirst,
            isLast = isLast
        )
    }

}