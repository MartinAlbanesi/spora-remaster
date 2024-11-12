package com.gg.spora.challenge.domain.mappers

import com.gg.spora.challenge.domain.entities.ObjectDetailEntity
import com.gg.spora.challenge.domain.model.ObjectDetail

fun ObjectDetailEntity.toObjectDetail() : ObjectDetail{
    return ObjectDetail(
        nameObjectDetail = nameObjectDetail,
        description = description,
        isValidate = isValidate)
}


fun ObjectDetail.toObjectDetailEntity() : ObjectDetailEntity{
    return ObjectDetailEntity(
        nameObjectDetail = nameObjectDetail!!,
        description = description,
        isValidate = isValidate)
}