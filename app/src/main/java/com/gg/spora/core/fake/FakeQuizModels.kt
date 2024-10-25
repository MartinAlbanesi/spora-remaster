package com.gg.spora.core.fake

import com.gg.spora.R
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.data.local.model.AnswerLocal
import com.gg.spora.miniGames.data.local.model.QuestionLocal
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question

object FakeQuizModels {

    val fakeLocalAnswers = listOf(
        AnswerLocal(
            answer = "Reciclar",
            id = "10",
            typeQuestion = listOf(TypeQuestion.MARTIN.name, TypeQuestion.RELATIONS_QUESTION.name),
            typeGame = TypeGame.QUIZ.name,
            isCorrect = true
        ),
        AnswerLocal(
            answer = "Realizar",
            id = "11",
            typeQuestion = listOf(TypeQuestion.MARTIN.name, TypeQuestion.RECYCLE.name),
            typeGame = TypeGame.QUIZ.name,
            isCorrect = false
        ),
        AnswerLocal(
            answer = "Recolectar",
            id = "12",
            typeQuestion = listOf(TypeQuestion.MARTIN.name),
            typeGame = TypeGame.QUIZ.name,
            isCorrect = false
        ),
        AnswerLocal(
            answer = "Respetar",
            id = "13",
            typeQuestion = listOf(TypeQuestion.MARTIN.name),
            typeGame = TypeGame.QUIZ.name,
            isCorrect = false
        ),
    )

    val fakeLocalQuestions = listOf(
        QuestionLocal(
            id = "1",
            question = "¿Cuál de estas acciones pertenece a la regla de las 3 erres de la sostenibilidad?",
            answersLocal = listOf(fakeLocalAnswers[1], fakeLocalAnswers[2], fakeLocalAnswers[3]),
            answerId = fakeLocalAnswers[0].id,
            typeGame = TypeGame.QUIZ.name,
            typeQuestion = listOf(TypeQuestion.MARTIN.name),
            image = null
        )
    )


    val fakeAnswers = listOf(

        // ----------------------- QUIZ -----------------------
        Answer(
            answer = "Aire",
            id = "0",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Smog",
            id = "1",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Agua",
            id = "2",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Compost",
            id = "3",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Desecho",
            id = "4",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Contaminación del aire",
            id = "5",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Recursos naturales",
            id = "6",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Ecosistema",
            id = "7",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Ambiente",
            id = "8",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Reforestación",
            id = "9",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        ),

        // Pregunta 1
        Answer(
            answer = "Reciclar",
            id = "10",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Realizar",
            id = "11",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Recolectar",
            id = "12",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Respetar",
            id = "13",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        // Pregunta 2
        Answer(
            answer = "Rojo",
            id = "14",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Blanco",
            id = "15",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Celeste",
            id = "16",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Violeta",
            id = "17",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        // Pregunta 3
        Answer(
            answer = "Pilas y desechos peligrosos",
            id = "18",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Aceites e insecticidas",
            id = "19",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Desechos orgánicos",
            id = "20",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Plásticos y envases metálicos",
            id = "21",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        // Pregunta 4
        Answer(
            answer = "700 años",
            id = "22",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "80 años",
            id = "23",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "120 años",
            id = "24",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "300 años",
            id = "25",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        // Pregunta 5 y 6
        Answer(
            answer = "Amarillo",
            id = "26",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Verde",
            id = "27",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Azul",
            id = "28",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Naranja",
            id = "29",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        // Pregunta 7
        Answer(
            answer = "Espejos rotos",
            id = "30",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Frascos de mermelada vacíos",
            id = "31",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Botellas de vidrio",
            id = "32",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Tarros de vidrio",
            id = "33",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        // Pregunta 8
        Answer(
            answer = "En un punto limpio",
            id = "34",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Contenedor gris",
            id = "35",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Contenedor de desechos generales",
            id = "36",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Contenedor azul",
            id = "37",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        // Pregunta 9
        Answer(
            answer = "Reforestando",
            id = "38",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Usando menos papel",
            id = "39",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Plantando flores",
            id = "40",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Prohibiendo la madera",
            id = "41",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        // Pregunta 10
        Answer(
            answer = "Una forma de niebla en ciudades",
            id = "42",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Una mezcla de polvo y humo",
            id = "43",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Un tipo de aire fresco",
            id = "44",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),
        Answer(
            answer = "Vapor de agua en el ambiente",
            id = "45",
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        ),

        // ----------------------- QUIZ_IMAGE -----------------------

        Answer(
            answer = "Símbolo de Reciclaje",
            id = "46",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Calentamiento Global",
            id = "47",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Deforestación",
            id = "48",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Smog",
            id = "49",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Contaminación del aire",
            id = "50",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Energia Eólica",
            id = "51",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Desechos Electrónicos",
            id = "52",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE

        ),
        Answer(
            answer = "Agujero de Ozono",
            id = "53",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Residuo Tóxico",
            id = "54",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Panel Solar",
            id = "55",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        ),
        Answer(
            answer = "Contaminación por plásticos",
            id = "56",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Gases de efecto invernadero",
            id = "57",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Derrame de petróleo",
            id = "58",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Separación de residuos para reciclaje",
            id = "59",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Reforestación",
            id = "60",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Menos huella de carbono al usar energía limpia",
            id = "61",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Incendio forestal",
            id = "62",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Contaminación del agua",
            id = "63",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Desertificación",
            id = "64",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "No emite gases contaminantes",
            id = "65",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Compostaje",
            id = "66",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Agricultura urbana",
            id = "67",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Purifican el aire",
            id = "68",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Polinización de plantas",
            id = "69",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Bajo consumo de energía",
            id = "70",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Generan menos residuos",
            id = "71",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Facilita el reciclaje",
            id = "72",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Protege el suelo y el agua",
            id = "73",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            answer = "Ahorra energía",
            id = "74",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
        ),

        // ----------------------- RELATIONS -----------------------

        Answer(
            answer = "Reciclable",
            id = "75",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Answer(
            answer = "Plástico",
            id = "76",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Answer(
            answer = "Contaminante",
            id = "77",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Answer(
            answer = "Biodegradable",
            id = "78",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "No reciclable",
            id = "79",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Orgánico",
            id = "80",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Papel",
            id = "81",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Madera",
            id = "82",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Vidrio",
            id = "83",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Gasolina",
            id = "84",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Plástico",
            id = "85",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Arena",
            id = "86",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),

        Answer(
            answer = "Plantación",
            id = "87",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Fuegos",
            id = "88",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Bosques",
            id = "89",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Ladrillos",
            id = "90",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Semillas",
            id = "91",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Asfalto",
            id = "92",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),

        Answer(
            answer = "Humo",
            id = "93",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Flores",
            id = "94",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Gases",
            id = "95",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Animales",
            id = "96",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Fábricas",
            id = "97",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Rocas",
            id = "98",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),

        Answer(
            answer = "Calor",
            id = "99",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Compostaje",
            id = "100",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Sequía",
            id = "101",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Smog",
            id = "102",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Cenizas",
            id = "103",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Contaminación",
            id = "104",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),

        Answer(
            answer = "Cambio climático",
            id = "105",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Reciclaje",
            id = "106",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Hielo derretido",
            id = "107",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Tierra fértil",
            id = "108",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "CO₂",
            id = "109",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Oxígeno",
            id = "110",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),

        Answer(
            answer = "Animales",
            id = "111",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Metales",
            id = "112",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Ecosistema",
            id = "113",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Carreteras",
            id = "114",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Especies",
            id = "115",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Petróleo",
            id = "116",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),

        Answer(
            answer = "Sol",
            id = "117",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Viento",
            id = "118",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Paneles",
            id = "119",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Carbón",
            id = "120",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Electricidad",
            id = "121",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        Answer(
            answer = "Recursos naturales",
            id = "122",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        ),
        )

    // Wea
    val fakeQuizQuestions = listOf(

        // ----------------------- QUIZ -----------------------

        Question(
            id = "1",
            question = "¿Cuál de estas acciones pertenece a la regla de las 3 erres de la sostenibilidad?",
            answers = listOf(fakeAnswers[11], fakeAnswers[12], fakeAnswers[13]),
            answerId = fakeAnswers[10].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "2",
            question = "¿Cuál de estos colores pertenece a un contenedor de reciclaje?",
            answers = listOf(fakeAnswers[15], fakeAnswers[16], fakeAnswers[17]),
            answerId = fakeAnswers[14].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "3",
            question = "¿Para qué se utiliza el contenedor rojo?",
            answers = listOf(fakeAnswers[19], fakeAnswers[20], fakeAnswers[21]),
            answerId = fakeAnswers[18].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "4",
            question = "¿Cuánto tarda, como promedio, en degradarse una botella de plástico?",
            answers = listOf(fakeAnswers[23], fakeAnswers[24], fakeAnswers[25]),
            answerId = fakeAnswers[22].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "5",
            question = "¿A qué contenedor deberías tirar los bricks?",
            answers = listOf(fakeAnswers[27], fakeAnswers[28], fakeAnswers[29]),
            answerId = fakeAnswers[26].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "6",
            question = "¿A qué contenedor deberías tirar las latas?",
            answers = listOf(fakeAnswers[27], fakeAnswers[28], fakeAnswers[29]),
            answerId = fakeAnswers[26].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "7",
            question = "¿Cuál de estos objetos no deben tirarse en el contenedor de vidrio?",
            answers = listOf(fakeAnswers[31], fakeAnswers[32], fakeAnswers[33]),
            answerId = fakeAnswers[30].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "8",
            question = "¿Dónde debes depositar los residuos eléctricos y electrónicos cuando ya no son útiles?",
            answers = listOf(fakeAnswers[35], fakeAnswers[36], fakeAnswers[37]),
            answerId = fakeAnswers[34].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "9",
            question = "¿Cómo podemos solucionar la deforestación?",
            answers = listOf(fakeAnswers[39], fakeAnswers[40], fakeAnswers[41]),
            answerId = fakeAnswers[38].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "10",
            question = "¿Qué es el smog?",
            answers = listOf(fakeAnswers[43], fakeAnswers[44], fakeAnswers[45]),
            answerId = fakeAnswers[42].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),

        // ----------------------- QUIZ_IMAGE -----------------------

        Question(
            id = "46",
            question = "¿Qué representa la imagen?",
            answers = fakeAnswers.filter { fake -> fake.id != "46" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[46].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.recycling_symbol
        ),
        Question(
            id = "47",
            question = "¿Qué representa la imagen?",
            answers = fakeAnswers.filter { fake -> fake.id != "47" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[47].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.global_warming
        ),
        Question(
            id = "48",
            question = "¿Qué pasó en el bosque?",
            answers = fakeAnswers.filter { fake -> fake.id != "48" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[48].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.deforestation
        ),
        Question(
            id = "49",
            question = "¿Qué produce el humo?",
            answers = fakeAnswers.filter { fake -> fake.id != "49" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[49].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.smog
        ),
        Question(
            id = "50",
            question = "¿Qué está pasando en la imagen?",
            answers = fakeAnswers.filter { fake -> fake.id != "50" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[50].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.air_pollution
        ),
        Question(
            id = "51",
            question = "¿Qué tipo de energía es?",
            answers = fakeAnswers.filter { fake -> fake.id != "51" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[51].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.wind_turbine
        ),
        Question(
            id = "52",
            question = "¿Qué tipo de desecho es?",
            answers = fakeAnswers.filter { fake -> fake.id != "52" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[52].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.electronic_waste
        ),
        Question(
            id = "53",
            question = "¿Qué representa la imagen?",
            answers = fakeAnswers.filter { fake -> fake.id != "53" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[53].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.ozone_hole
        ),
        Question(
            id = "54",
            question = "¿Qué tipo de residuo es?",
            answers = fakeAnswers.filter { fake -> fake.id != "54" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[54].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.toxic_waste
        ),
        Question(
            id = "55",
            question = "¿Qué es el objeto de la imagen?",
            answers = fakeAnswers.filter { fake -> fake.id != "55" && fake.typeGame == TypeGame.QUIZ_IMAGE  }.shuffled().take(3),
            answerId = fakeAnswers[55].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.solar_panel
        ),
        Question(
            id = "56",
            question = "¿Qué problema afecta a este río?",
            answers = fakeAnswers.filter { fake -> fake.id != "56" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[56].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.plastic_pollution
        ),
        Question(
            id = "57",
            question = "¿Cómo se llama este tipo de emisión de gas?",
            answers = fakeAnswers.filter { fake -> fake.id != "57" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[57].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.car_polluting
        ),
        Question(
            id = "58",
            question = "¿Qué tipo de desastre ambiental es este?",
            answers = fakeAnswers.filter { fake -> fake.id != "58" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[58].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.oil_spill
        ),
        Question(
            id = "59",
            question = "¿Qué práctica está realizando esta persona?",
            answers = fakeAnswers.filter { fake -> fake.id != "59" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[59].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.waste_separation
        ),
        Question(
            id = "60",
            question = "¿Qué práctica está realizando esta persona?",
            answers = fakeAnswers.filter { fake -> fake.id != "60" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[60].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.reforesting
        ),
        Question(
            id = "61",
            question = "¿Qué hace el tren eléctrico para ayudar al medio ambiente?",
            answers = fakeAnswers.filter { fake -> fake.id != "61" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[61].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.electric_train
        ),
        Question(
            id = "62",
            question = "¿Qué desastre natural ocurrió aquí?",
            answers = fakeAnswers.filter { fake -> fake.id != "62" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[62].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.burned_forest
        ),
        Question(
            id = "63",
            question = "¿Qué pudo haber causado esto?",
            answers = fakeAnswers.filter { fake -> fake.id != "63" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[63].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.polluted_lake
        ),
        Question(
            id = "64",
            question = "¿Qué fenómeno ambiental representa esta imagen?",
            answers = fakeAnswers.filter { fake -> fake.id != "64" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[64].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.desertification
        ),
        Question(
            id = "65",
            question = "¿Por qué es mejor utilizar un auto eléctrico?",
            answers = fakeAnswers.filter { fake -> fake.id != "65" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[65].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.electric_car
        ),
        Question(
            id = "66",
            question = "¿Qué se hace con los residuos en este contenedor?",
            answers = fakeAnswers.filter { fake -> fake.id != "66" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[66].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.composting
        ),
        Question(
            id = "67",
            question = "¿Qué práctica está representada en la imagen?",
            answers = fakeAnswers.filter { fake -> fake.id != "67" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[67].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.urban_agriculture
        ),
        Question(
            id = "68",
            question = "¿Qué beneficio brindan los árboles al medio ambiente?",
            answers = fakeAnswers.filter { fake -> fake.id != "68" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[68].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.tree_giving_oxygen
        ),
        Question(
            id = "69",
            question = "¿Cuál es el papel de los insectos en este ecosistema?",
            answers = fakeAnswers.filter { fake -> fake.id != "69" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[69].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.pollination
        ),
        Question(
            id = "70",
            question = "¿Qué indica la etiqueta de eficiencia energética?",
            answers = fakeAnswers.filter { fake -> fake.id != "70" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[70].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.energy_efficiency
        ),
        Question(
            id = "71",
            question = "¿Por qué es mejor usar bolsas reutilizables que de plástico?",
            answers = fakeAnswers.filter { fake -> fake.id != "71" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            answerId = fakeAnswers[71].id,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE,
            image = R.drawable.cloth_bag
        ),

        // ----------------------- RELATIONS -----------------------
        Question(
            id = "72",
            question = "Botella",
            answers = listOf(fakeAnswers[75], fakeAnswers[76], fakeAnswers[77], fakeAnswers[78], fakeAnswers[79], fakeAnswers[80]).shuffled(),
            answerId = "${fakeAnswers[75].id},${fakeAnswers[76].id},${fakeAnswers[77].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "73",
            question = "Reciclaje",
            answers = listOf(fakeAnswers[81], fakeAnswers[82], fakeAnswers[83], fakeAnswers[84], fakeAnswers[85], fakeAnswers[86]).shuffled(),
            answerId = "${fakeAnswers[81].id},${fakeAnswers[83].id},${fakeAnswers[85].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "75",
            question = "Reforestación",
            answers = listOf(fakeAnswers[87], fakeAnswers[88], fakeAnswers[89], fakeAnswers[90], fakeAnswers[91], fakeAnswers[92]).shuffled(),
            answerId = "${fakeAnswers[87].id},${fakeAnswers[89].id},${fakeAnswers[91].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "76",
            question = "Contaminación del aire",
            answers = listOf(fakeAnswers[93], fakeAnswers[94], fakeAnswers[95], fakeAnswers[96], fakeAnswers[97], fakeAnswers[98]).shuffled(),
            answerId = "${fakeAnswers[93].id},${fakeAnswers[95].id},${fakeAnswers[97].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "77",
            question = "Incendios forestales",
            answers = listOf(fakeAnswers[99], fakeAnswers[100], fakeAnswers[101], fakeAnswers[102], fakeAnswers[103], fakeAnswers[104]).shuffled(),
            answerId = "${fakeAnswers[99].id},${fakeAnswers[101].id},${fakeAnswers[103].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),

        Question(
            id = "78",
            question = "Calentamiento global",
            answers = listOf(fakeAnswers[105], fakeAnswers[106], fakeAnswers[107], fakeAnswers[108], fakeAnswers[109], fakeAnswers[110]).shuffled(),
            answerId = "${fakeAnswers[105].id},${fakeAnswers[107].id},${fakeAnswers[109].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),


        Question(
            id = "79",
            question = "Fauna",
            answers = listOf(fakeAnswers[111], fakeAnswers[112], fakeAnswers[113], fakeAnswers[114], fakeAnswers[115], fakeAnswers[116]).shuffled(),
            answerId = "${fakeAnswers[111].id},${fakeAnswers[113].id},${fakeAnswers[115].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),

        Question(
            id = "80",
            question = "Energía solar",
            answers = listOf(fakeAnswers[117], fakeAnswers[118], fakeAnswers[119], fakeAnswers[120], fakeAnswers[121], fakeAnswers[122]).shuffled(),
            answerId = "${fakeAnswers[117].id},${fakeAnswers[119].id},${fakeAnswers[121].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
    )

    val fakeQuestionRelations = listOf(
        Question(
            id = "73",
            question = "Botella",
            answers = listOf(fakeAnswers[72], fakeAnswers[73], fakeAnswers[74], fakeAnswers[75], fakeAnswers[76], fakeAnswers[77]).shuffled(),
            answerId = "${fakeAnswers[72].id},${fakeAnswers[74].id},${fakeAnswers[76].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "74",
            question = "Wea",
            answers = listOf(fakeAnswers[72], fakeAnswers[73], fakeAnswers[74], fakeAnswers[75], fakeAnswers[76], fakeAnswers[77]).shuffled(),
            answerId = "${fakeAnswers[72].id},${fakeAnswers[74].id},${fakeAnswers[76].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "75",
            question = "Lala",
            answers = listOf(fakeAnswers[72], fakeAnswers[73], fakeAnswers[74], fakeAnswers[75], fakeAnswers[76], fakeAnswers[77]).shuffled(),
            answerId = "${fakeAnswers[72].id},${fakeAnswers[74].id},${fakeAnswers[76].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "76",
            question = "Pepe",
            answers = listOf(fakeAnswers[72], fakeAnswers[73], fakeAnswers[74], fakeAnswers[75], fakeAnswers[76], fakeAnswers[77]).shuffled(),
            answerId = "${fakeAnswers[72].id},${fakeAnswers[74].id},${fakeAnswers[76].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "77",
            question = "Titi",
            answers = listOf(fakeAnswers[72], fakeAnswers[73], fakeAnswers[74], fakeAnswers[75], fakeAnswers[76], fakeAnswers[77]).shuffled(),
            answerId = "${fakeAnswers[72].id},${fakeAnswers[74].id},${fakeAnswers[76].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
    )

    val fakeQuestionQuizTypeMartin = listOf(
        Question(
            id = "1",
            question = "¿Cuál de estas acciones pertenece a la regla de las 3 erres de la sostenibilidad?",
            answers = listOf(fakeAnswers[11], fakeAnswers[12], fakeAnswers[13]),
            answerId = fakeAnswers[10].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "2",
            question = "¿Cuál de estos colores pertenece a un contenedor de reciclaje?",
            answers = listOf(fakeAnswers[15], fakeAnswers[16], fakeAnswers[17]),
            answerId = fakeAnswers[14].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "3",
            question = "¿Para qué se utiliza el contenedor rojo?",
            answers = listOf(fakeAnswers[19], fakeAnswers[20], fakeAnswers[21]),
            answerId = fakeAnswers[18].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "4",
            question = "¿Cuánto tarda, como promedio, en degradarse una botella de plástico?",
            answers = listOf(fakeAnswers[23], fakeAnswers[24], fakeAnswers[25]),
            answerId = fakeAnswers[22].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "5",
            question = "¿A qué contenedor deberías tirar los tetra briks?",
            answers = listOf(fakeAnswers[27], fakeAnswers[28], fakeAnswers[29]),
            answerId = fakeAnswers[26].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "6",
            question = "¿A qué contenedor deberías tirar las latas?",
            answers = listOf(fakeAnswers[27], fakeAnswers[28], fakeAnswers[29]),
            answerId = fakeAnswers[26].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "7",
            question = "¿Cuál de estos objetos no deben tirarse en el contenedor de vidrio?",
            answers = listOf(fakeAnswers[31], fakeAnswers[32], fakeAnswers[33]),
            answerId = fakeAnswers[30].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "8",
            question = "¿Dónde debes depositar los residuos eléctricos y electrónicos cuando ya no son útiles?",
            answers = listOf(fakeAnswers[35], fakeAnswers[36], fakeAnswers[37]),
            answerId = fakeAnswers[34].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "9",
            question = "¿Cómo podemos solucionar la deforestación?",
            answers = listOf(fakeAnswers[39], fakeAnswers[40], fakeAnswers[41]),
            answerId = fakeAnswers[38].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
        Question(
            id = "10",
            question = "¿Qué es el smog?",
            answers = listOf(fakeAnswers[43], fakeAnswers[44], fakeAnswers[45]),
            answerId = fakeAnswers[42].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.MARTIN)
        ),
    )
}
