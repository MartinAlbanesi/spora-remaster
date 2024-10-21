package com.gg.spora.miniGames.data.local

import android.content.Context
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.data.local.model.AnswerLocal
import com.gg.spora.miniGames.data.local.model.QuestionLocal
import com.gg.spora.miniGames.domain.IQuizLocalRepository
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import readJsonFile
import javax.inject.Inject

class QuizLocalRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : IQuizLocalRepository {

    private val questionsJson = readJsonFile(SporaConstant.QUESTIONS_FILE_PATH)
    val questionsLocal = Gson().fromJson(questionsJson, Array<QuestionLocal>::class.java).toList()

    private val answersJson = readJsonFile(SporaConstant.ANSWERS_FILE_PATH)
    val answersLocal = Gson().fromJson(answersJson, Array<AnswerLocal>::class.java).toList()

    override fun getRandomQuestions(
        count: Int,
        typeQuestion: TypeQuestion,
        typeGame: TypeGame
    ): List<Question> {
        TODO("Not yet implemented")
    }

    override fun getQuestionById(id: String): Question {
        TODO("Not yet implemented")
    }

    override fun getRandomAnswers(count: Int, type: TypeGame): List<Answer> {
        TODO("Not yet implemented")
    }

    override fun getAnswerById(id: String): Answer {
        TODO("Not yet implemented")
    }
}