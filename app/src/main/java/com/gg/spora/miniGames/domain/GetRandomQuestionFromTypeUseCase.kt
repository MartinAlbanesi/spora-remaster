package com.gg.spora.miniGames.domain

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.exception.QuestionNotFoundException
import com.gg.spora.miniGames.domain.model.Question
import javax.inject.Inject

class GetRandomQuestionFromTypeUseCase @Inject constructor(
    private val quizLocalRepository: IQuizLocalRepository
) {
    operator fun invoke(count : Int, typeQuestion: List<TypeQuestion>, typeGame: TypeGame, ): List<Question> {


//        val questions : MutableSet<Question> = mutableSetOf()
//
//        do {
//            if(typeGame == TypeGame.RELATIONS) {
//                val randomQuestions = quizLocalRepository
//                    .getRandomQuestions(count, typeQuestion, typeGame)
////                return randomQuestions
//                questions.addAll(randomQuestions)
//            }else{
//                val randomAnswer = quizLocalRepository.getRandomAnswers(1, typeQuestion, typeGame).first()
//                val randomAnswers = quizLocalRepository
//                    .getRandomAnswers(count, typeQuestion, typeGame)
//                    .filter { it.id != randomAnswer.id }
//
//                val questionWithAnswerId = quizLocalRepository
//                    .getQuestionById(randomAnswer.id)
//
//                if(questionWithAnswerId == null) {
//                    throw QuestionNotFoundException()
//                }
//
//                val newQuestion = questionWithAnswerId.copy(
//                    answers = (questionWithAnswerId.answers + randomAnswers).shuffled()
//                )
//                questions.add(newQuestion)
//            }
//        } while (questions.size < count)
//
//        return questions.toList()

//        val randomAnswer = quizLocalRepository.getRandomAnswers(1, typeQuestion, typeGame).first()
//        val randomAnswers = quizLocalRepository
//            .getRandomAnswers(count, typeQuestion, typeGame)
//            .filter { it.id != randomAnswer.id }
//
//        val questionWithAnswerId = quizLocalRepository
//            .getQuestionById(randomAnswer.id)
//
//        if(questionWithAnswerId == null) {
//            throw QuestionNotFoundException()
//        }
//
//
//        val newQuestion = questionWithAnswerId.copy(
//            answers = (questionWithAnswerId.answers + randomAnswers).shuffled()
//        )
//        return listOf(newQuestion)



        val randomQuestions = quizLocalRepository
            .getRandomQuestions(count, typeQuestion,typeGame)
            .map { question ->
                if(typeGame.typeNumber == 2) {
                    return@map question
                }
                val answer = quizLocalRepository.getAnswerById(question.answerId)
                val newQuestion = question.copy(
                    answers = (question.answers + answer!!).shuffled()
                )
                newQuestion
            }

        return randomQuestions
    }
}