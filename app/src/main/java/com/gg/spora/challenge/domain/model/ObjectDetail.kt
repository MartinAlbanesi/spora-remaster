package com.gg.spora.challenge.domain.model

import com.gg.spora.challenge.domain.entities.ObjectDetailEntity

data class ObjectDetail(
    val idObjectDetail : Int,
    val nameObjectDetail : String?,
    val description : String?,
    val isValidate : Boolean
){
    companion object{
        private fun entityToObjectDetailModel(objectDetailEntity: ObjectDetailEntity) : ObjectDetail {
            return ObjectDetail(
                idObjectDetail = objectDetailEntity.idObjectDetail,
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
            idObjectDetail = idObjectDetail,
            nameObjectDetail =  nameObjectDetail,
            description = description,
            isValidate = isValidate
        )
    }
}
