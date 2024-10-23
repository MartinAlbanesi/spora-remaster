package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.TypeGame

fun getTypeGameEnum(typeGame: String) = when (typeGame) {
    "QUIZ" -> TypeGame.QUIZ
    "QUIZ_IMAGE" -> TypeGame.QUIZ_IMAGE
    "RELATIONS" -> TypeGame.RELATIONS
    else -> TypeGame.QUIZ
}