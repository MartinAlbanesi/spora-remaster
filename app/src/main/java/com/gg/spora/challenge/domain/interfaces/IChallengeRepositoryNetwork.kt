package com.gg.spora.challenge.domain.interfaces

import com.gg.spora.challenge.domain.model.ObjectDetail


interface IChallengeRepositoryNetwork {

    fun getObjectsDetailByUser(userId : String)
    suspend fun setObjectDetail(objectDetail: ObjectDetail) : String
}