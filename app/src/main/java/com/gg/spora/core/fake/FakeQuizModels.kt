package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.QuestionType
import com.gg.spora.quiz.domain.model.Answer
import com.gg.spora.quiz.domain.model.Question

object FakeQuizModels {

    val fakeAnswers = listOf(
        Answer(
            answer = "Paris",
            id = "1",
            type = QuestionType.RECYCLING,
        ),
        Answer(
            answer = "Madrid",
            id = "2",
            type = QuestionType.RECYCLING
        ),
        Answer(
            answer = "Berlin",
            id = "3",
            type = QuestionType.RECYCLING
        ),
        Answer(
            answer = "Rome",
            id = "4",
            type = QuestionType.RECYCLING
        ),
        Answer(
            answer = "Lisbon",
            id = "5",
            type = QuestionType.RECYCLING
        ),
        Answer(
            answer = "Athens",
            id = "6",
            type = QuestionType.RECYCLING
        ),
        Answer(
            answer = "Stockholm",
            id = "7",
            type = QuestionType.RECYCLING
        ),
        Answer(
            answer = "Oslo",
            id = "8",
            type = QuestionType.RECYCLING
        ),
        Answer(
            answer = "Helsinki",
            id = "9",
            type = QuestionType.RECYCLING
        ),
        Answer(
            answer = "Copenhagen",
            id = "10",
            type = QuestionType.RECYCLING
        ),
    )

    val fakeQuestions = listOf(
        Question(
            id = "1",
            question = "What is the capital of France?",
            answers = fakeAnswers.filter { fake -> fake.id != "1" }.take(3),
            answer = fakeAnswers[0],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "2",
            question = "What is the capital of Spain?",
            answers = fakeAnswers.filter { fake -> fake.id != "2" }.take(3),
            answer = fakeAnswers[1],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "3",
            question = "What is the capital of Germany?",
            answers = fakeAnswers.filter { fake -> fake.id != "3" }.take(3),
            answer = fakeAnswers[2],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "4",
            question = "What is the capital of Italy?",
            answers = fakeAnswers.filter { fake -> fake.id != "4" }.take(3),
            answer = fakeAnswers[3],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "5",
            question = "What is the capital of Portugal?",
            answers = fakeAnswers.filter { fake -> fake.id != "5" }.take(3),
            answer = fakeAnswers[4],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "6",
            question = "What is the capital of Greece?",
            answers = fakeAnswers.filter { fake -> fake.id != "6" }.take(3),
            answer = fakeAnswers[5],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "7",
            question = "What is the capital of Sweden?",
            answers = fakeAnswers.filter { fake -> fake.id != "7" }.take(3),
            answer = fakeAnswers[6],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "8",
            question = "What is the capital of Norway?",
            answers = fakeAnswers.filter { fake -> fake.id != "8" }.take(3),
            answer = fakeAnswers[7],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "9",
            question = "What is the capital of Finland?",
            answers = fakeAnswers.filter { fake -> fake.id != "9" }.take(3),
            answer = fakeAnswers[8],
            type = QuestionType.RECYCLING
        ),
        Question(
            id = "10",
            question = "What is the capital of Denmark?",
            answers = fakeAnswers.filter { fake -> fake.id != "10" }.take(3),
            answer = fakeAnswers[9],
            type = QuestionType.RECYCLING
        ),
    )
}