package com.gg.spora.challenge.domain.model

import com.gg.spora.challenge.domain.entities.StepObjectDetailEntity

data class StepObjectDetail(
    val idObjectDetail : Int,
    val numberStep : Int,
    val nameObjectDetail : String?,
    val description : String?,
    val isFirst : Boolean = false,
    val isLast : Boolean = false
){

    companion object{
        private fun entityToStepObjectDetailModel(stepObjectDetailEntity: StepObjectDetailEntity) : StepObjectDetail {
            return StepObjectDetail(
                idObjectDetail = stepObjectDetailEntity.idObjectDetail,
                numberStep =  stepObjectDetailEntity.numberStep,
                nameObjectDetail = stepObjectDetailEntity.nameObjectDetail,
                description = stepObjectDetailEntity.description,
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
            idObjectDetail = idObjectDetail,
            numberStep =  numberStep,
            nameObjectDetail = nameObjectDetail,
            description = description,
        )
    }

}