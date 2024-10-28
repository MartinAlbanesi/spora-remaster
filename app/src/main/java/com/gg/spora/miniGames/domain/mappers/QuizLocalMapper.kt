package com.gg.spora.miniGames.domain.mappers

import android.content.Context
import com.gg.spora.core.utils.functions.getTypeGameEnum
import com.gg.spora.core.utils.functions.getTypeQuestionEnum
import com.gg.spora.miniGames.data.local.model.AnswerLocal
import com.gg.spora.miniGames.data.local.model.QuestionLocal
import com.gg.spora.miniGames.domain.functions.getResourceImageFromString
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question

fun AnswerLocal.toAnswer() = Answer(
    id = id,
    answer = answer,
    isCorrect = isCorrect,
    typeGame = getTypeGameEnum(typeGame),
    typeQuestion = getTypeQuestionEnum(typeQuestion)
)

fun QuestionLocal.toQuestion(context: Context) = Question(
    id = id,
    question = question,
    answerId = answerId,
    answers = answersLocal.map { it.toAnswer() },
    typeGame = getTypeGameEnum(typeGame),
    typeQuestion = getTypeQuestionEnum(typeQuestion),
    image = getResourceImageFromString(context = context, resourcesString = image ?: "0")
)