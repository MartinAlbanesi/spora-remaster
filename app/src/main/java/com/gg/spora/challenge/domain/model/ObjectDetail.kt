package com.gg.spora.challenge.domain.model

data class ObjectDetail(
    val id : Int,
    val name : String,
    val steps : List<StepObjectDetail>,
    val description : String
)
