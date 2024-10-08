package com.gg.spora.quiz.domain

import com.gg.spora.core.utils.enums.QuestionType
import com.gg.spora.quiz.domain.model.Question

/**
 * Local repository for quiz questions
 */
interface IQuizLocalRepository {

    fun getRandomQuestions(count: Int, type: QuestionType): List<Question>

}