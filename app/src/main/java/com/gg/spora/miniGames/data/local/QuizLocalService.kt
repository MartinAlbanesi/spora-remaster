package com.gg.spora.miniGames.data.local

import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.miniGames.data.local.model.AnswerLocal
import com.gg.spora.miniGames.data.local.model.QuestionLocal
import com.google.gson.Gson
import readJsonFile
import javax.inject.Inject

class QuizLocalService @Inject constructor(){

    fun getLocalQuestions(): List<QuestionLocal> {
        val questionsJson = readJsonFile(SporaConstant.QUESTIONS_FILE_PATH)
        val questionsLocal = Gson().fromJson(questionsJson, Array<QuestionLocal>::class.java).toList()
        return questionsLocal
    }

    fun getLocalAnswers(): List<AnswerLocal> {
        val answersJson = readJsonFile(SporaConstant.ANSWERS_FILE_PATH)
        val answersLocal = Gson().fromJson(answersJson, Array<AnswerLocal>::class.java).toList()
        return answersLocal
    }
}