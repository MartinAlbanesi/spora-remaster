package com.gg.spora.minigameQuizImage.domain.model

import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Question
import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage
import javax.inject.Inject

class GetRamdonQuestionImage  @Inject constructor(
    private val quizImageLocalRepository: IQuizImageLocalRepository
){
    operator fun invoke(count: Int, type: TypeQuestion): List<Question> {
//        val randomQuestions = quizImageLocalRepository
//            .getRandomQuestionsImage(count, type)
//            .map { question ->
//                val answer = quizLocalRepository.getAnswerById(question.answerId)
//                val newQuestion = question.copy(
//                    answers = (question.answers + question.answer).shuffled()
//                )
//                newQuestion
//            }
        return emptyList()//randomQuestions
    }
}
