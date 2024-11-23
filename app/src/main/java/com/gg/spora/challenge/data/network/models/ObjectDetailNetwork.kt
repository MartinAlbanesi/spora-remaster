package com.gg.spora.challenge.data.network.models

import com.gg.spora.challenge.domain.model.StepObjectDetail

data class ObjectDetailNetwork(
    var nameObjectDetail : String?,
    val description : String?,
    var isValidate : Boolean,
    var stepsObjectDetail : List<StepObjectDetail> = mutableListOf()
)