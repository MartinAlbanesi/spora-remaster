package com.gg.spora.challenge.domain.model

import com.gg.spora.challenge.domain.entities.ObjectDetailEntity

data class ObjectDetail(
    var nameObjectDetail : String?,
    val description : String?,
    var isValidate : Boolean,
    var stepsObjectDetail : List<StepObjectDetail> = mutableListOf()
){
    companion object{
        private fun entityToObjectDetailModel(objectDetailEntity: ObjectDetailEntity) : ObjectDetail {
            return ObjectDetail(
                nameObjectDetail =  objectDetailEntity.nameObjectDetail,
                description = objectDetailEntity.description,
                isValidate = objectDetailEntity.isValidate,
            )
        }

        fun objectsDetailEntityToModels(objectDetailEntities : List<ObjectDetailEntity>) : List<ObjectDetail>{

            val listObjectDetails = mutableListOf<ObjectDetail>()

            for(entity in objectDetailEntities){
                listObjectDetails.add(entityToObjectDetailModel(entity))
            }

            return listObjectDetails
        }
    }

    fun toObjectDetailEntity(): ObjectDetailEntity {
        return ObjectDetailEntity(
            nameObjectDetail =  nameObjectDetail!!,
            description = description,
            isValidate = isValidate
        )
    }
}
