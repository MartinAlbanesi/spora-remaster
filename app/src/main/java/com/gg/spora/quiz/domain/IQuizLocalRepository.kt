package com.gg.spora.quiz.domain

import com.gg.spora.quiz.domain.model.Question
import com.gg.spora.quiz.domain.model.QuestionType

/**
 * Local repository for quiz questions
 */
interface IQuizLocalRepository {

    fun getRandomQuestions(count: Int, type: QuestionType): List<Question>

}