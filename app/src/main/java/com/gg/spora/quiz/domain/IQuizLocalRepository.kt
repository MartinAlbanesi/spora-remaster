package com.gg.spora.quiz.domain

import com.gg.spora.core.fake.FakeQuizModels
import javax.inject.Inject

/**
 * Local repository for quiz questions
 */
interface IQuizLocalRepository {

    fun getRandomQuestions(count: Int, type: QuestionType): List<Question>

//    fun getRandomQuestion(type: QuestionType): Question
//
//    fun getQuestionById(id: String, type: QuestionType): Question
//
//    fun getRandomAnswer(
//        count: Int,
//        type: QuestionType,
//        answerQuestion: String
//    ): List<Answer>
//
//    fun getAnswerById(id: String, type: QuestionType): Answer

}

class FakeQuizLocalRepository @Inject constructor(

): IQuizLocalRepository{

    private val fakeModelsQuiz = FakeQuizModels.fakeQuestions

    override fun getRandomQuestions(count: Int, type: QuestionType): List<Question> {
        val randomQuestions = fakeModelsQuiz.filter { it.type == type }.shuffled().take(count)
        return randomQuestions
    }

//    override fun getRandomQuestion(type: QuestionType): Question{
//        val randomQuestion = fakeModelsQuiz.filter { it.type == type }.random()
//        return randomQuestion
//    }
//
//    override fun getQuestionById(id: String, type: QuestionType): Question {
//        val fakeAnswer = getAnswerById(id, type)
//
//        val fakeAnswers = getRandomAnswer(3, type, id)
//
//        val fakeAnswersForQuestion = fakeAnswers + fakeAnswer
//
//        val fakeQuestion = Question(
//            id = fakeAnswer.id,
//            question = "What is the capital of Spain?",
//            answers = fakeAnswersForQuestion.shuffled(),
//            answer = fakeAnswer,
//            type = type
//        )
//
//        return fakeQuestion
//    }
//
//    override fun getRandomAnswer(
//        count: Int,
//        type: QuestionType,
//        answerQuestion: String
//    ): List<Answer> {
//        return FakeQuizModels.fakeAnswers
//            .filter {
//                it.type == type && it.id != answerQuestion
//            }
//            .shuffled()
//            .take(count)
//    }
//
//    override fun getAnswerById(id: String, type: QuestionType): Answer {
//        return FakeQuizModels.fakeAnswers.first { it.id == id }
//    }
}