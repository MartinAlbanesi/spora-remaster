package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.TypeQuestion

fun getTypeQuestionEnum(typeQuestion: List<String>) : List<TypeQuestion>{
    val listTypeQuestion = mutableListOf<TypeQuestion>()
    typeQuestion.forEach {
        when (it) {
            "RECYCLE" -> listTypeQuestion.add(TypeQuestion.RECYCLE)
            "MARTIN" -> listTypeQuestion.add(TypeQuestion.MARTIN)
            "RELATIONS_QUESTION" -> listTypeQuestion.add(TypeQuestion.RELATIONS_QUESTION)
        }
    }
    return listTypeQuestion

}