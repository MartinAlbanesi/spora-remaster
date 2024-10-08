package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.QuestionType
import com.gg.spora.quiz.domain.model.Answer
import com.gg.spora.quiz.domain.model.Question

object FakeQuizModels {

    val fakeAnswers = listOf(
        Answer(
            answer = "Aire",
            id = "1",
            type = QuestionType.QUIZ,
        ),
        Answer(
            answer = "Smog",
            id = "2",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Agua",
            id = "3",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Compost",
            id = "4",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Desecho",
            id = "5",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Contaminación",
            id = "6",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Recursos naturales",
            id = "7",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Ecosistema",
            id = "8",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Ambiente",
            id = "9",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Reforestación",
            id = "10",
            type = QuestionType.QUIZ
        ),
    )

    val fakeQuestions = listOf(
        Question(
            id = "1",
            question = "Mezcla de gases que necesitamos para vivir",
            answers = fakeAnswers.filter { fake -> fake.id != "1" }.take(3),
            answer = fakeAnswers[0],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "2",
            question = "Aire color gris que contiene una gran cantidad de contaminantes",
            answers = fakeAnswers.filter { fake -> fake.id != "2" }.take(3),
            answer = fakeAnswers[1],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "3",
            question = "Es esencial para la vida. Aunque hay mucha en el planeta, solo una pequeña parte es apta para beber y usar",
            answers = fakeAnswers.filter { fake -> fake.id != "3" }.take(3),
            answer = fakeAnswers[2],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "4",
            question = "Abono orgánico 100% natural, de color café oscuro, rico en nutrientes, no afecta al ambiente, se usa como tierra y abono para las plantas",
            answers = fakeAnswers.filter { fake -> fake.id != "4" }.take(3),
            answer = fakeAnswers[3],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "5",
            question = "Todo aquello que ya no usamos y tiramos",
            answers = fakeAnswers.filter { fake -> fake.id != "5" }.take(3),
            answer = fakeAnswers[4],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "6",
            question = "Tirar basura en el suelo o verter sustancias dañinas en el agua o el piso",
            answers = fakeAnswers.filter { fake -> fake.id != "6" }.take(3),
            answer = fakeAnswers[5],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "7",
            question = "Cosas de la naturaleza que usamos, como agua, árboles y minerales, para vivir y ayudar a nuestra comunidad.",
            answers = fakeAnswers.filter { fake -> fake.id != "7" }.take(3),
            answer = fakeAnswers[6],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "8",
            question = "Lugar donde conviven seres vivos, como plantas y animales, junto con cosas sin vida, como el agua y la tierra",
            answers = fakeAnswers.filter { fake -> fake.id != "8" }.take(3),
            answer = fakeAnswers[7],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "9",
            question = "Espacio que nos rodea, donde se desarrolla la vida",
            answers = fakeAnswers.filter { fake -> fake.id != "9" }.take(3),
            answer = fakeAnswers[8],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "10",
            question = "Plantar árboles en lugares donde antes había bosques que fueron talados",
            answers = fakeAnswers.filter { fake -> fake.id != "10" }.take(3),
            answer = fakeAnswers[9],
            type = QuestionType.QUIZ
        ),
    )
}