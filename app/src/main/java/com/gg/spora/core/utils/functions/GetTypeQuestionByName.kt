package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.TypeQuestion

fun getTypeQuestionByName(typeQuestion: String): TypeQuestion {
    return when (typeQuestion) {
        "RECYCLE" -> TypeQuestion.RECYCLE
        "RELATIONS_QUESTION" -> TypeQuestion.RELATIONS_QUESTION
        else -> TypeQuestion.RECYCLE
    }
}