package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.quiz.domain.model.Answer
import com.gg.spora.quiz.domain.model.Question

object FakeQuizModels {

    val fakeAnswers = listOf(
        Answer(
            answer = "Aire",
            id = "0",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Smog",
            id = "1",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Agua",
            id = "2",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Compost",
            id = "3",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Desecho",
            id = "4",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Contaminación",
            id = "5",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Recursos naturales",
            id = "6",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Ecosistema",
            id = "7",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Ambiente",
            id = "8",
            type = TypeQuestion.RECYCLE
        ),
        Answer(
            answer = "Reforestación",
            id = "9",
            type = TypeQuestion.RECYCLE
        ),
        // Pregunta 1
        Answer(
            answer = "Reciclar",
            id = "10",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Realizar",
            id = "11",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Recolectar",
            id = "12",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Respetar",
            id = "13",
            type = TypeQuestion.MARTIN
        ),
        // Pregunta 2
        Answer(
            answer = "Rojo",
            id = "14",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Blanco",
            id = "15",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Celeste",
            id = "16",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Violeta",
            id = "17",
            type = TypeQuestion.MARTIN
        ),
        // Pregunta 3
        Answer(
            answer = "Pilas y desechos peligrosos",
            id = "18",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Aceites e insecticidas",
            id = "19",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Desechos orgánicos",
            id = "20",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Plásticos y envases metálicos",
            id = "21",
            type = TypeQuestion.MARTIN
        ),
        // Pregunta 4
        Answer(
            answer = "700 años",
            id = "22",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "80 años",
            id = "23",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "120 años",
            id = "24",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "300 años",
            id = "25",
            type = TypeQuestion.MARTIN
        ),
        // Pregunta 5 y 6
        Answer(
            answer = "Amarillo",
            id = "26",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Verde",
            id = "27",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Azul",
            id = "28",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Naranja",
            id = "29",
            type = TypeQuestion.MARTIN
        ),
        // Pregunta 7
        Answer(
            answer = "Espejos rotos",
            id = "30",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Frascos de mermelada vacíos",
            id = "31",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Botellas de vidrio",
            id = "32",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Tarros de vidrio",
            id = "33",
            type = TypeQuestion.MARTIN
        ),
        // Pregunta 8
        Answer(
            answer = "En un punto limpio",
            id = "34",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Contenedor gris",
            id = "35",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Contenedor de desechos generales",
            id = "36",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Contenedor azul",
            id = "37",
            type = TypeQuestion.MARTIN
        ),
        // Pregunta 9
        Answer(
            answer = "Reforestando",
            id = "38",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Usando menos papel",
            id = "39",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Plantando flores",
            id = "40",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Prohibiendo la madera",
            id = "41",
            type = TypeQuestion.MARTIN
        ),
        // Pregunta 10
        Answer(
            answer = "Una forma de niebla en ciudades",
            id = "42",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Una mezcla de polvo y humo",
            id = "43",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Un tipo de aire fresco",
            id = "44",
            type = TypeQuestion.MARTIN
        ),
        Answer(
            answer = "Vapor de agua en el ambiente",
            id = "45",
            type = TypeQuestion.MARTIN
        ),
    )

    val fakeQuestions = listOf(
        Question(
            id = "1",
            question = "¿Cuál de estas acciones pertenece a la regla de las 3 erres de la sostenibilidad?",
            answers = listOf(fakeAnswers[11], fakeAnswers[12], fakeAnswers[13]),
            answerId = fakeAnswers[10].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "2",
            question = "¿Cuál de estos colores pertenece a un contenedor de reciclaje?",
            answers = listOf(fakeAnswers[15], fakeAnswers[16], fakeAnswers[17]),
            answerId = fakeAnswers[14].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "3",
            question = "¿Para qué se utiliza el contenedor rojo?",
            answers = listOf(fakeAnswers[19], fakeAnswers[20], fakeAnswers[21]),
            answerId = fakeAnswers[18].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "4",
            question = "¿Cuánto tarda, como promedio, en degradarse una botella de plástico?",
            answers = listOf(fakeAnswers[23], fakeAnswers[24], fakeAnswers[25]),
            answerId = fakeAnswers[22].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "5",
            question = "¿A qué contenedor deberías tirar los bricks?",
            answers = listOf(fakeAnswers[27], fakeAnswers[28], fakeAnswers[29]),
            answerId = fakeAnswers[26].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "6",
            question = "¿A qué contenedor deberías tirar las latas?",
            answers = listOf(fakeAnswers[27], fakeAnswers[28], fakeAnswers[29]),
            answerId = fakeAnswers[26].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "7",
            question = "¿Cuál de estos objetos no deben tirarse en el contenedor de vidrio?",
            answers = listOf(fakeAnswers[31], fakeAnswers[32], fakeAnswers[33]),
            answerId = fakeAnswers[30].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "8",
            question = "¿Dónde debes depositar los residuos eléctricos y electrónicos cuando ya no son útiles?",
            answers = listOf(fakeAnswers[35], fakeAnswers[36], fakeAnswers[37]),
            answerId = fakeAnswers[34].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "9",
            question = "¿Cómo podemos solucionar la deforestación?",
            answers = listOf(fakeAnswers[39], fakeAnswers[40], fakeAnswers[41]),
            answerId = fakeAnswers[38].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
        Question(
            id = "10",
            question = "¿Qué es el esmog?",
            answers = listOf(fakeAnswers[43], fakeAnswers[44], fakeAnswers[45]),
            answerId = fakeAnswers[42].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = TypeQuestion.MARTIN
        ),
    )
}