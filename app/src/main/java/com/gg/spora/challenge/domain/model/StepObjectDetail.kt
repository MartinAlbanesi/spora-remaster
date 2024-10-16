package com.gg.spora.challenge.domain.model

data class StepObjectDetail(
    val number : Int,
    val title : String,
    val description : String,
    val image : Int, //Puede cargarse aca o en otro lado, por ej en la vista.
    val isFirst : Boolean,
    val isLast : Boolean
)
