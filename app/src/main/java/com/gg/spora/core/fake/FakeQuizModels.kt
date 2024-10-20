package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.QuestionType
import com.gg.spora.quiz.domain.model.Answer
import com.gg.spora.quiz.domain.model.Question

object FakeQuizModels {

    val fakeAnswers = listOf(
        Answer(
            answer = "Aire",
            id = "0",
            type = QuestionType.QUIZ,
        ),
        Answer(
            answer = "Smog",
            id = "1",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Agua",
            id = "2",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Compost",
            id = "3",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Desecho",
            id = "4",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Contaminación",
            id = "5",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Recursos naturales",
            id = "6",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Ecosistema",
            id = "7",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Ambiente",
            id = "8",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Reforestación",
            id = "9",
            type = QuestionType.QUIZ
        ),
        // Pregunta 1
        Answer(
            answer = "Reciclar",
            id = "10",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Realizar",
            id = "11",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Recolectar",
            id = "12",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Respetar",
            id = "13",
            type = QuestionType.QUIZ
        ),
        // Pregunta 2
        Answer(
            answer = "Rojo",
            id = "14",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Blanco",
            id = "15",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Celeste",
            id = "16",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Violeta",
            id = "17",
            type = QuestionType.QUIZ
        ),
        // Pregunta 3
        Answer(
            answer = "Pilas y desechos peligrosos",
            id = "18",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Aceites e insecticidas",
            id = "19",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Desechos orgánicos",
            id = "20",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Plásticos y envases metálicos",
            id = "21",
            type = QuestionType.QUIZ
        ),
        // Pregunta 4
        Answer(
            answer = "700 años",
            id = "22",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "80 años",
            id = "23",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "120 años",
            id = "24",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "300 años",
            id = "25",
            type = QuestionType.QUIZ
        ),
        // Pregunta 5 y 6
        Answer(
            answer = "Amarillo",
            id = "26",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Verde",
            id = "27",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Azul",
            id = "28",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Naranja",
            id = "29",
            type = QuestionType.QUIZ
        ),
        // Pregunta 7
        Answer(
            answer = "Espejos rotos",
            id = "30",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Frascos de mermelada vacíos",
            id = "31",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Botellas de vidrio",
            id = "32",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Tarros de vidrio",
            id = "33",
            type = QuestionType.QUIZ
        ),
        // Pregunta 8
        Answer(
            answer = "En un punto limpio",
            id = "34",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Contenedor gris",
            id = "35",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Contenedor de desechos generales",
            id = "36",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Contenedor azul",
            id = "37",
            type = QuestionType.QUIZ
        ),
        // Pregunta 9
        Answer(
            answer = "Reforestando",
            id = "38",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Usando menos papel",
            id = "39",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Plantando flores",
            id = "40",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Prohibiendo la madera",
            id = "41",
            type = QuestionType.QUIZ
        ),
        // Pregunta 10
        Answer(
            answer = "Una forma de niebla en ciudades",
            id = "42",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Una mezcla de polvo y humo",
            id = "43",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Un tipo de aire fresco",
            id = "44",
            type = QuestionType.QUIZ
        ),
        Answer(
            answer = "Vapor de agua en el ambiente",
            id = "45",
            type = QuestionType.QUIZ
        ),
    )

    val fakeQuestions = listOf(
        Question(
            id = "1",
            question = "¿Cuál de estas acciones pertenece a la regla de las 3 erres de la sostenibilidad?",//"Mezcla de gases que necesitamos para vivir",
            answers = listOf(fakeAnswers[11], fakeAnswers[12], fakeAnswers[13]),// fakeAnswers.filter { fake -> fake.id != "1" }.take(3),
            answer = fakeAnswers[10],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "2",
            question = "¿Cuál de estos colores pertenece a un contenedor de reciclaje?",
            answers = listOf(fakeAnswers[15], fakeAnswers[16], fakeAnswers[17]),// fakeAnswers.filter { fake -> fake.id != "2" }.take(3),
            answer = fakeAnswers[14],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "3",
            question = "¿Para qué se utiliza el contenedor rojo?",
            answers = listOf(fakeAnswers[19], fakeAnswers[20], fakeAnswers[21]),//fakeAnswers.filter { fake -> fake.id != "3" }.take(3),
            answer = fakeAnswers[18],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "4",
            question = "¿Cuánto tarda, como promedio, en degradarse una botella de plástico?",
            answers = listOf(fakeAnswers[23], fakeAnswers[24], fakeAnswers[25]),// fakeAnswers.filter { fake -> fake.id != "4" }.take(3),
            answer = fakeAnswers[22],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "5",
            question = "¿A qué contenedor deberías tirar los bricks?",
            answers = listOf(fakeAnswers[27], fakeAnswers[28], fakeAnswers[29]), // fakeAnswers.filter { fake -> fake.id != "5" }.take(3),
            answer = fakeAnswers[26],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "6",
            question = "¿A qué contenedor deberías tirar las latas?",
            answers = listOf(fakeAnswers[27], fakeAnswers[28], fakeAnswers[29]),// fakeAnswers.filter { fake -> fake.id != "6" }.take(3),
            answer = fakeAnswers[26],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "7",
            question = "¿Cuál de estos objetos no deben tirarse en el contenedor de vidrio?",
            answers = listOf(fakeAnswers[31], fakeAnswers[32], fakeAnswers[33]),// fakeAnswers.filter { fake -> fake.id != "7" }.take(3),
            answer = fakeAnswers[30],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "8",
            question = "¿Dónde debes depositar los residuos eléctricos y electrónicos cuando ya no son útiles?",
            answers = listOf(fakeAnswers[35], fakeAnswers[36], fakeAnswers[37]), // fakeAnswers.filter { fake -> fake.id != "8" }.take(3),
            answer = fakeAnswers[34],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "9",
            question = "¿Cómo podemos solucionar la deforestación?",
            answers = listOf(fakeAnswers[39], fakeAnswers[40], fakeAnswers[41]),// fakeAnswers.filter { fake -> fake.id != "9" }.take(3),
            answer = fakeAnswers[38],
            type = QuestionType.QUIZ
        ),
        Question(
            id = "10",
            question = "¿Qué es el esmog?",
            answers = listOf(fakeAnswers[43], fakeAnswers[44], fakeAnswers[45]),// fakeAnswers.filter { fake -> fake.id != "10" }.take(3),
            answer = fakeAnswers[42],
            type = QuestionType.QUIZ
        ),
    )
}