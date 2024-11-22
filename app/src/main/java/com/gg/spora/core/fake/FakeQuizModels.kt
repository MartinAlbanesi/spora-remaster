package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question
import kotlin.collections.listOf

@Suppress("LargeClass", "LongParameterList")
object FakeQuizModels {

    /* val fakeLocalAnswers = listOf(
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
     )*/


    // ----------------------- NEW QUIZ -----------------------

    val newFakeAnswers = listOf(
        Answer(
            "1", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "2", "Restos de comida", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "3", "Pañales", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "4", "Ropa usada", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "5", "Usar más el auto", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "6", "Comer solo comida rápida", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "7", "Caminar o usar bicicleta", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "8", "Comprar más cosas nuevas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "9", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "10", "Vidrio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "11", "Papel", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "12", "Aluminio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "13", "Oxígeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "14", "Nitrógeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "15", "Dióxido de carbono", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "16", "Helio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "17", "Lavar el auto todos los dias", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "18",
            "Cerrar la canilla al cepillarse los dientes",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "19", "Usar más agua en la ducha", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "20", "Lavar la ropa a mano", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "21", "Frutas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "22", "Hojas secas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "23", "Bolsas de plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "24", "Flores", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "25", "Gatos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "26", "Perros", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "27", "Peces", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "28", "Conejos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "29", "Carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "30", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "31", "Energía solar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "32", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "33", "Tirarla a la basura", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "34", "Donarla o reciclarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "35", "Quemarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "36", "Guardarla sin usar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "37", "Usar bolsas de tela", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "38",
            "Comprar productos empaquetados",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "39",
            "Elegir envases de un solo uso",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "40", "Comer con platos desechables", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "41", "Electricidad", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "42", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "43", "Agua", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "44", "Carbono", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "45", "Aumenta la humedad", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "46", "Genera más oxígeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "47", "Elimina la contaminación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "48", "Reduce el calor del invierno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "49", "Aumento de lluvias", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "50", "Sequias", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "51", "Aumento del alimento", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "52",
            "Disminución del nivel del mar",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "53", "Energía solar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "54", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "55", "Gasolina", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "56", "Biocombustible", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "57", "Panda", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "58", "Oso polar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "59", "Elefante", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "60", "Águila", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "61", "Reutilizar/Manualidades", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "62", "Desecharla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "63", "Quemarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "64", "Enterrarlo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "65", "Reciclarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "66", "Romperla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "67", "Enterrarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "68", "Quemarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "69", "Aumenta la erosión", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "70",
            "Disminuye la calidad del aire",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "71", "Más sombra/oxígeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "72", "Reduce el espacio de juego", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "73", "De vidrio reutilizable", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "74", "De plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "75", "Bolsa de plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "76", "Bolsa de papel", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "77", "Cáscara de banana", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "78", "Bolsa de plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "79", "Papel de oficina", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "80", "Tela de algodón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "81", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "82", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "83", "Agua", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "84", "Electricidad", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "85", "Emisiones de CO2", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "86", "Descomposición de alimentos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "87", "Cosecha de plantas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "88", "Construcción de casas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "89", "Evitar tirar basura", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "90", "Usar detergentes fuertes", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "91", "Lavar ropa", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "92", "Quemar desechos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "93", "Reciclarlos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "94", "Desecharlos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "95", "Guardarlos y no usarlos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "96", "Tirarlos en la calle", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "97", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "98", "Hojas secas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "99", "Papel usado", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "100", "Cáscaras de frutas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "101", "Energía eólica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "102", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "103", "Carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "104", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "105", "Plantar arboles", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "106", "Usar cárbon al cocinar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "107", "Encender más luces", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "108", "Usar más plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "109", "Usar bombillas LED", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "110", "Usar más plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "111", "Comprar electrodomésticos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "112", "Cocinar con carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "113", "Mejora la calidad del agua", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "114", "Afectan a los seres vivos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "115",
            "Aumentan la cantidad de plantas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "116", "Crean más oxígeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "117", "Disminuye la contaminación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "118", "Aumenta la contaminación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "119", "Reduce el uso de agua", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "120", "Se pierde energía", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "121", "Huracán", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "122", "Tormenta de nieve", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "123",
            "Deshielo de un glaciar",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "124", "Volcán en erupción", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "125", "Panel solar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "126", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "127", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "128", "Carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "129",
            "Usar transporte público",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "130", "Viajar en avión", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "131", "Conducir un coche", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "132", "Comprar ropa", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "133", "Papel reciclado", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "134", "Basura orgánica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "135", "Latas de aluminio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "136", "Contenedor de vidrio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "137", "Paneles solares", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "138", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "139", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "140", "Carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "141",
            "Usar aspersores de jardín",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "142", "Lavar el auto", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "143",
            "Recolectar agua de lluvia",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "144", "Regar el cesped", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "145",
            "Contaminación en el aire",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "146",
            "Contaminación lumínica",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "147",
            "Contaminación del agua",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "148",
            "Contaminación acústica",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "149", "Selva tropical", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "150", "Desierto árido", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "151", "Tundra", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "152", "Sabana africana", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "153", "Oso polar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "154", "Tigre de bengala", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "155", "Elefante africano", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "156", "Lobo gris", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "157", "Deshechar plásticos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "158",
            "Recolección de basura plástica",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "159", "Pesca industrial", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "160",
            "Instalación de rompeolas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "161",
            "Agricultura de monocultivo",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "162", "Agricultura vertical", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "163", "Uso de pesticidas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "164",
            "Agricultura de tala y quema",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "165", "Incendios forestales", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "166",
            "Huracanes más intensos",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "167", "Erosión del suelo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "168", "Desertificación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "169", "Selva amazónica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "170", "Desierto del Sahara", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "171", "Tundra ártica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "172", "Sabana africana", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "173", "Bosques", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "174", "Ríos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "175", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "176", "Minerales", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "177", "Riego por aspersión", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "178", "Riego por goteo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "179",
            "Uso de agua reciclada",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "180",
            "Limpieza de pozos de agua",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "181", "Oso gris", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "182", "Ballena azul", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "183", "Rinoceronte negro", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "184", "Tucan", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "185", "Parque en la ciudad", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "186",
            "Rascacielos de oficinas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "187", "Estación de metro", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "188",
            "Calle con tráfico pesado",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "189", "Energía eólica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "190", "Energía de biomasa", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "191", "Energía nuclear", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "192", "Energía hidráulica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "193",
            "Construcción de represas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "194", "Pesca industrial", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "195",
            "Extracción de petróleo",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "196",
            "Construcción de viviendas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "197", "Inundación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "198", "Erupción volcánica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "199",
            "Deslizamiento de tierra",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "200", "Tormenta de nieve", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "201", "Energía solar", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "202", "Energía eólica", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "203", "Hidroeléctrica", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "204", "Carbón", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "205", "Gas natural", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "206", "Petróleo", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "207", "Smog", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "208", "Derrames de petróleo", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "209", "Residuos plásticos", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "210", "Energía eólica", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "211", "Reforestación", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "212", "Paneles solares", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "213", "Derretimiento de glaciares", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "214", "Subida del nivel del mar", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "215", "Sequías extremas", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "216", "Reciclaje", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "217", "Conservación de energía", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "218", "Jardines verticales", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "219", "Deforestación", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "220", "Especies en peligro", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "221", "Ecosistemas marinos", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "222", "Carreteras", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "223", "Minas de carbón", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "224", "Zonas urbanas", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "225", "Reutilización", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "226", "Reciclaje", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "227", "Reducción de residuos", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "228", "Producción masiva", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "229", "Desechos industriales", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "230", "Consumo desmedido", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "231", "Rotación de cultivos", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "232", "Uso de pesticidas", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "233", "Conservación del suelo", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "234", "Monocultivo", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "235", "Compostaje", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "236", "Deforestación", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "237", "Uso de energía limpia", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "238", "Reforestación", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "239", "Reciclaje", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "240", "Uso de carbón", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "241", "Desperdicio de alimentos", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "242", "Tala masiva", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "243", "Sol", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "244", "Viento", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "245", "Agua", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "246", "Gas natural", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "247", "Petróleo", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "248", "Carbón", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "249", "Emisiones de vehículos", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "250", "Fábricas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "251", "Quema de basura", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "252", "Paneles solares", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "253", "Turbinas eólicas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "254", "Cultivo orgánico", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "255", "Carbón", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "256", "Petróleo", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "257", "Gas natural", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "258", "Viento", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "259", "Sol", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "260", "Agua", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "261", "Papel", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "262", "Vidrio", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "263", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "264", "Comida", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "265", "Hojas secas", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "266", "Piedras", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "267", "Derrames de petróleo", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "268", "Pesticidas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "269", "Plásticos", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "270", "Peces", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "271", "Algas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "272", "Rocas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "273", "CO2", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "274", "Metano", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "275", "Óxido nitroso", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "276", "Oxígeno", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "277", "Hidrógeno", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "278", "Nitrógeno", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "279", "Cáscaras de frutas", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "280", "Papel", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "281", "Madera", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "282", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "283", "Metal", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "284", "Vidrio", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
    )


    val newFakeQuizQuestions = listOf(
        Question(
            id = "1",
            question = "¿Cuál de estos materiales es reciclable?",
            answers = newFakeAnswers.filter { fake -> fake.id != "1" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[0].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "2",
            question = "¿Qué debemos hacer para reducir nuestra huella de carbono?",
            answers = newFakeAnswers.filter { fake -> fake.id != "7" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[6].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "3",
            question = "¿Cuál de estos materiales es biodegradable?",
            answers = newFakeAnswers.filter { fake -> fake.id != "10" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[9].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "4",
            question = "¿Qué gas atrapa el calor en la atmósfera y contribuye al cambio climático?",
            answers = newFakeAnswers.filter { fake -> fake.id != "14" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[13].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "5",
            question = "¿Cuál es una buena práctica para ahorrar agua?",
            answers = newFakeAnswers.filter { fake -> fake.id != "16" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[15].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "6",
            question = "¿Cuál de estos objetos no debería tirarse en el suelo?",
            answers = newFakeAnswers.filter { fake -> fake.id != "24" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[23].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "7",
            question = "¿Qué animal se ve afectado por la contaminación del océano?",
            answers = newFakeAnswers.filter { fake -> fake.id != "27" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[26].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "8",
            question = "¿Cuál es una fuente de energía renovable",
            answers = newFakeAnswers.filter { fake -> fake.id != "31" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[30].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "9",
            question = "¿Qué podemos hacer con la ropa que ya no usamos?",
            answers = newFakeAnswers.filter { fake -> fake.id != "34" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[33].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "10",
            question = "¿Qué podemos hacer para reducir el uso de plástico?",
            answers = newFakeAnswers.filter { fake -> fake.id != "37" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[36].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "11",
            question = "¿Qué recurso natural ahorramos al apagar las luces cuando no son necesarias?",
            answers = newFakeAnswers.filter { fake -> fake.id != "41" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[40].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "12",
            question = "¿Cuál es un beneficio de plantar árboles en las ciudades?",
            answers = newFakeAnswers.filter { fake -> fake.id != "46" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[45].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "13",
            question = "¿Cuál de estos es un problema causado por el cambio climático?",
            answers = newFakeAnswers.filter { fake -> fake.id != "50" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[49].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "14",
            question = "¿Qué tipo de energía no contamina el aire cuando se usa?",
            answers = newFakeAnswers.filter { fake -> fake.id != "53" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[52].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "15",
            question = "¿Cuál de estos animales está en peligro debido a la deforestación de los bosques tropicales?",
            answers = newFakeAnswers.filter { fake -> fake.id != "57" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[56].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "16",
            question = "¿Qué podemos hacer con una botella de plástico vacía en casa para ayudar al medio ambiente?",
            answers = newFakeAnswers.filter { fake -> fake.id != "61" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[60].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "17",
            question = "¿Qué debemos hacer con una botella de vidrio usada en lugar de tirarla a la basura?",
            answers = newFakeAnswers.filter { fake -> fake.id != "65" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[64].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "18",
            question = "¿Qué efecto tiene plantar más árboles en las ciudades?",
            answers = newFakeAnswers.filter { fake -> fake.id != "71" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[70].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "19",
            question = "¿Qué tipo de envases es mejor para el medio ambiente al hacer compras?",
            answers = newFakeAnswers.filter { fake -> fake.id != "73" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[72].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "20",
            question = "¿Cuál de estos productos tarda más en descomponerse si se deja en la naturaleza?",
            answers = newFakeAnswers.filter { fake -> fake.id != "75" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[74].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "21",
            question = "¿Qué recurso natural podemos ayudar a conservar al reparar fugas de agua en casa rápidamente?",
            answers = newFakeAnswers.filter { fake -> fake.id != "83" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[82].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "22",
            question = "¿Cuál es una de las principales fuentes de contaminación del aire?",
            answers = newFakeAnswers.filter { fake -> fake.id != "85" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[84].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "23",
            question = "¿Qué acción ayuda a reducir la contaminación del agua?",
            answers = newFakeAnswers.filter { fake -> fake.id != "89" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[88].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "24",
            question = "¿Qué debemos hacer con los residuos electrónicos, como celulares viejos?",
            answers = newFakeAnswers.filter { fake -> fake.id != "93" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[92].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "25",
            question = "¿Cuál de estos productos causa mayor contaminación si se quema al aire libre?",
            answers = newFakeAnswers.filter { fake -> fake.id != "97" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[96].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "26",
            question = "¿Cuál es una forma de energía que no emite gases contaminantes?",
            answers = newFakeAnswers.filter { fake -> fake.id != "101" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[100].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "27",
            question = "¿Qué acción contribuye a reducir la contaminación del aire en las ciudades?",
            answers = newFakeAnswers.filter { fake -> fake.id != "105" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[104].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "28",
            question = "¿Cuál es una forma de reducir la huella de carbono en los hogares?",
            answers = newFakeAnswers.filter { fake -> fake.id != "109" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[108].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "29",
            question = "¿Qué efecto tienen los productos químicos en el ecosistema de un lago?",
            answers = newFakeAnswers.filter { fake -> fake.id != "114" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[113].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "30",
            question = "¿Qué se logra al reducir el consumo de electricidad en los hogares?",
            answers = newFakeAnswers.filter { fake -> fake.id != "117" && fake.typeGame == TypeGame.QUIZ }.shuffled().take(3),
            correctAnswer = newFakeAnswers[116].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "111",
            question = "¿Qué está representado en esta imagen como ejemplo de cambio climático?",
            answers = newFakeAnswers.filter { fake -> fake.id != "123" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[122].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F1_quiz_image.png?alt=media&token=2189b80d-2532-46ba-8720-f9a4fbf6d09d"
        ),
        Question(
            id = "112",
            question = "¿Cuál de estos es un ejemplo de energía renovable en la imagen?",
            answers = newFakeAnswers.filter { fake -> fake.id != "125" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[124].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F2_quiz_image.png?alt=media&token=453fbd0e-cb79-4399-9dfa-eb10063e5d75"
        ),
        Question(
            id = "113",
            question = "¿Qué acción está representada en la imagen para reducir la huella de carbono?",
            answers = newFakeAnswers.filter { fake -> fake.id != "129" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[128].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F3_quiz_image.png?alt=media&token=eddcba94-0c69-4972-aea9-fb932bb5ada9"
        ),
        Question(
            id = "114",
            question = "¿Qué está representado en esta imagen como ejemplo de reciclaje?",
            answers = newFakeAnswers.filter { fake -> fake.id != "133" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[132].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F4_quiz_image.png?alt=media&token=8a0cd511-61b2-49be-8e60-0ed0e9fb07e5"
        ),
        Question(
            id = "115",
            question = "¿Qué está representado en esta imagen como ejemplo de energía renovable?",
            answers = newFakeAnswers.filter { fake -> fake.id != "137" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[136].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F5_quiz_image.png?alt=media&token=4488cb59-d06b-4498-915c-81c05c8baada"
        ),
        Question(
            id = "116",
            question = "¿Qué práctica se ilustra en la imagen como una forma de ahorro de agua?",
            answers = newFakeAnswers.filter { fake -> fake.id != "143" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[142].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F6_quiz_image.png?alt=media&token=236709ad-e6e7-48ed-b659-8ca39c22b86f"
        ),
        Question(
            id = "117",
            question = "¿Qué tipo de contaminación está ilustrado en esta imagen?",
            answers = newFakeAnswers.filter { fake -> fake.id != "148" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[147].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F7_quiz_image.png?alt=media&token=8fdcb32e-866a-43fe-8e45-8a2948a509b7"
        ),
        Question(
            id = "118",
            question = "¿Qué ecosistema está representado en esta imagen y que es crucial para la biodiversidad?",
            answers = newFakeAnswers.filter { fake -> fake.id != "149" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[148].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F8_quiz_image.png?alt=media&token=2b1e4980-dde7-4c7a-ab98-a1ec7b395ffc"
        ),
        Question(
            id = "119",
            question = "¿Qué animal en extinción vive en este ambiente?",
            answers = newFakeAnswers.filter { fake -> fake.id != "153" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[152].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F9_quiz_image.png?alt=media&token=a4084616-01e7-488e-9391-fed7844cdd96"
        ),
        Question(
            id = "1110",
            question = "¿Qué acción representa esta imagen en la lucha contra la contaminación de los océanos?",
            answers = newFakeAnswers.filter { fake -> fake.id != "158" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[157].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F10_quiz_image.png?alt=media&token=652021df-ae3c-4d4c-a551-7d8fc0aa7567"
        ),
        Question(
            id = "1111",
            question = "¿Qué método agrícola está representado en la imagen para reducir el impacto ambiental?",
            answers = newFakeAnswers.filter { fake -> fake.id != "162" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[161].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F11_quiz_image.png?alt=media&token=e23d9e0e-bdb3-4709-8718-29b5073c82c1"
        ),
        Question(
            id = "1112",
            question = "¿Qué fenómeno ambiental está ilustrado en esta imagen como un impacto del cambio climático?",
            answers = newFakeAnswers.filter { fake -> fake.id != "166" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[165].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F12_quiz_image.png?alt=media&token=a8ffbbf7-9a23-406a-96f0-fc6ff53bc861"
        ),
        Question(
            id = "1113",
            question = "¿Qué ecosistema se muestra en la imagen y es crucial para el equilibrio climático global?",
            answers = newFakeAnswers.filter { fake -> fake.id != "171" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[170].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F13_quiz_image.png?alt=media&token=cadd73f2-c3ce-42d4-ba6c-2812bc77a5e7"
        ),
        Question(
            id = "1114",
            question = "¿Qué recurso natural está en riesgo, según lo ilustrado en esta imagen?",
            answers = newFakeAnswers.filter { fake -> fake.id != "172" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[171].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F14_quiz_image.png?alt=media&token=fe98c17f-1acf-4d91-a262-e589d4d849e8"
        ),
        Question(
            id = "1115",
            question = "¿Qué medida de conservación de agua está representada en esta imagen?",
            answers = newFakeAnswers.filter { fake -> fake.id != "178" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[177].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F15_quiz_image.png?alt=media&token=18f6f299-f9c0-44bb-a27e-84af05468c1e"
        ),
        Question(
            id = "1116",
            question = "¿Qué animal vive en esta zona del África y está en peligro de extinción?",
            answers = newFakeAnswers.filter { fake -> fake.id != "183" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[182].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F16_quiz_image.png?alt=media&token=3101ed4f-91a4-495f-8b6d-8097a8c57cfb"
        ),
        Question(
            id = "1117",
            question = "¿Qué tipo de paisaje urbano está representado en la imagen como ejemplo de infraestructura verde?",
            answers = newFakeAnswers.filter { fake -> fake.id != "185" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[184].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F17_quiz_image.png?alt=media&token=e0e30775-6cde-40e8-9192-31cce05dd8ea"
        ),
        Question(
            id = "1118",
            question = "¿Qué tipo de energía renovable se muestra en esta imagen como alternativa a los combustibles fósiles?",
            answers = newFakeAnswers.filter { fake -> fake.id != "192" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[191].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F18_quiz_image.png?alt=media&token=e77a97b7-a26d-4390-960a-048f20503537"
        ),
        Question(
            id = "1119",
            question = "¿Qué actividad humana que afecta los ecosistemas costeros está representada en la imagen?",
            answers = newFakeAnswers.filter { fake -> fake.id != "194" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[193].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F19_quiz_image.png?alt=media&token=f4c523bd-4600-4f4f-926d-6453fff0950d"
        ),
        Question(
            id = "1120",
            question = "¿Qué evento extremo relacionado con el cambio climático se muestra en la imagen, afectando cada vez más regiones?",
            answers = newFakeAnswers.filter { fake -> fake.id != "197" && fake.typeGame == TypeGame.QUIZ_IMAGE }.shuffled().take(3),
            correctAnswer = newFakeAnswers[196].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F20_quiz_image.png?alt=media&token=52cddaaf-c18f-4d87-ae89-68c1bdc76999"
        ),
        //---------------------------RELATION QUESTION-------------------------------
        Question(
            id = "1121",
            question = "Energías Renovables",
            answers = listOf(newFakeAnswers[200], newFakeAnswers[201], newFakeAnswers[202], newFakeAnswers[203], newFakeAnswers[205], newFakeAnswers[205]).shuffled(),
            correctAnswer = "${newFakeAnswers[200].id},${newFakeAnswers[201].id},${newFakeAnswers[202].id}",
            typeQuestion = listOf(TypeQuestion.ENERGY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1122",
            question = "Contaminación",
            answers = listOf(newFakeAnswers[206], newFakeAnswers[207], newFakeAnswers[208], newFakeAnswers[209], newFakeAnswers[210], newFakeAnswers[211]).shuffled(),
            correctAnswer = "${newFakeAnswers[206].id},${newFakeAnswers[207].id},${newFakeAnswers[208].id}",
            typeQuestion = listOf(TypeQuestion.CONTAMINATION),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1123",
            question = "Cambio climático",
            answers = listOf(newFakeAnswers[212], newFakeAnswers[213], newFakeAnswers[214], newFakeAnswers[215], newFakeAnswers[216], newFakeAnswers[217]).shuffled(),
            correctAnswer = "${newFakeAnswers[212].id},${newFakeAnswers[213].id},${newFakeAnswers[214].id}",
            typeQuestion = listOf(TypeQuestion.CLIMATE_CHANGE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1124",
            question = "Biodiversidad",
            answers = listOf(newFakeAnswers[218], newFakeAnswers[219], newFakeAnswers[220], newFakeAnswers[221], newFakeAnswers[222], newFakeAnswers[223]).shuffled(),
            correctAnswer = "${newFakeAnswers[218].id},${newFakeAnswers[219].id},${newFakeAnswers[220].id}",
            typeQuestion = listOf(TypeQuestion.BIODIVERSITY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1125",
            question = "Economía circular",
            answers = listOf(newFakeAnswers[224], newFakeAnswers[225], newFakeAnswers[226], newFakeAnswers[227], newFakeAnswers[228], newFakeAnswers[229]).shuffled(),
            correctAnswer = "${newFakeAnswers[224].id},${newFakeAnswers[225].id},${newFakeAnswers[226].id}",
            typeQuestion = listOf(TypeQuestion.SUSTENTABILITY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1126",
            question = "Agricultura sustentable",
            answers = listOf(newFakeAnswers[230], newFakeAnswers[231], newFakeAnswers[232], newFakeAnswers[233], newFakeAnswers[234], newFakeAnswers[235]).shuffled(),
            correctAnswer = "${newFakeAnswers[230].id},${newFakeAnswers[232].id},${newFakeAnswers[234].id}",
            typeQuestion = listOf(TypeQuestion.SUSTENTABILITY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1127",
            question = "Reduccion Calentamiento global",
            answers = listOf(newFakeAnswers[236], newFakeAnswers[237], newFakeAnswers[238], newFakeAnswers[239], newFakeAnswers[240], newFakeAnswers[241]).shuffled(),
            correctAnswer = "${newFakeAnswers[236].id},${newFakeAnswers[237].id},${newFakeAnswers[238].id}",
            typeQuestion = listOf(TypeQuestion.CLIMATE_CHANGE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1128",
            question = "Recursos renovables",
            answers = listOf(newFakeAnswers[242], newFakeAnswers[243], newFakeAnswers[244], newFakeAnswers[245], newFakeAnswers[246], newFakeAnswers[247]).shuffled(),
            correctAnswer = "${newFakeAnswers[242].id},${newFakeAnswers[243].id},${newFakeAnswers[244].id}",
            typeQuestion = listOf(TypeQuestion.ENERGY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1129",
            question = "Contaminación del aire",
            answers = listOf(newFakeAnswers[248], newFakeAnswers[249], newFakeAnswers[250], newFakeAnswers[251], newFakeAnswers[252], newFakeAnswers[253]).shuffled(),
            correctAnswer = "${newFakeAnswers[248].id},${newFakeAnswers[249].id},${newFakeAnswers[250].id}",
            typeQuestion = listOf(TypeQuestion.CONTAMINATION),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1130",
            question = "Energía no renovable",
            answers = listOf(newFakeAnswers[254], newFakeAnswers[255], newFakeAnswers[256], newFakeAnswers[257], newFakeAnswers[258], newFakeAnswers[259]).shuffled(),
            correctAnswer = "${newFakeAnswers[254].id},${newFakeAnswers[255].id},${newFakeAnswers[256].id}",
            typeQuestion = listOf(TypeQuestion.ENERGY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1131",
            question = "Residuos reciclables",
            answers = listOf(newFakeAnswers[260], newFakeAnswers[261], newFakeAnswers[262], newFakeAnswers[263], newFakeAnswers[264], newFakeAnswers[265]).shuffled(),
            correctAnswer = "${newFakeAnswers[260].id},${newFakeAnswers[261].id},${newFakeAnswers[262].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1132",
            question = "Contaminación del agua",
            answers = listOf(newFakeAnswers[266], newFakeAnswers[267], newFakeAnswers[268], newFakeAnswers[269], newFakeAnswers[270], newFakeAnswers[271]).shuffled(),
            correctAnswer = "${newFakeAnswers[266].id},${newFakeAnswers[267].id},${newFakeAnswers[268].id}",
            typeQuestion = listOf(TypeQuestion.CONTAMINATION),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1133",
            question = "Gases de efecto invernadero",
            answers = listOf(newFakeAnswers[272], newFakeAnswers[273], newFakeAnswers[274], newFakeAnswers[275], newFakeAnswers[276], newFakeAnswers[277]).shuffled(),
            correctAnswer = "${newFakeAnswers[272].id},${newFakeAnswers[273].id},${newFakeAnswers[274].id}",
            typeQuestion = listOf(TypeQuestion.CLIMATE_CHANGE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1134",
            question = "Materiales biodegradables",
            answers = listOf(newFakeAnswers[278], newFakeAnswers[279], newFakeAnswers[280], newFakeAnswers[281], newFakeAnswers[282], newFakeAnswers[283]).shuffled(),
            correctAnswer = "${newFakeAnswers[278].id},${newFakeAnswers[279].id},${newFakeAnswers[280].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
    )

}
