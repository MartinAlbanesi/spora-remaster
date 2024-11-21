package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question
import kotlin.collections.listOf

@Suppress("LargeClass")
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
            "1", "Plástico", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "2", "Restos de comida", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "3", "Pañales", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "4", "Ropa usada", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "5", "Usar más el auto", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "6", "Comer solo comida rápida", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "7", "Caminar o usar bicicleta", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "8", "Comprar más cosas nuevas", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "9", "Plástico", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "10", "Vidrio", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "11", "Papel", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "12", "Aluminio", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "13", "Oxígeno", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "14", "Nitrógeno", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "15", "Dióxido de carbono", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "16", "Helio", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "17", "Lavar el auto todos los dias", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "18",
            "Cerrar la canilla al cepillarse los dientes",
            true,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "19", "Usar más agua en la ducha", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "20", "Lavar la ropa a mano", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "21", "Frutas", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "22", "Hojas secas", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "23", "Bolsas de plástico", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "24", "Flores", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "25", "Gatos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "26", "Perros", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "27", "Peces", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "28", "Conejos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "29", "Carbón", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "30", "Petróleo", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "31", "Energía solar", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "32", "Gas natural", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "33", "Tirarla a la basura", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "34", "Donarla o reciclarla", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "35", "Quemarla", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "36", "Guardarla sin usar", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "37", "Usar bolsas de tela", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "38",
            "Comprar productos empaquetados",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "39",
            "Elegir envases de un solo uso",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "40", "Comer con platos desechables", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "41", "Electricidad", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "42", "Petróleo", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "43", "Agua", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "44", "Carbono", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "45", "Aumenta la humedad", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "46", "Genera más oxígeno", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "47", "Elimina la contaminación", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "48", "Reduce el calor del invierno", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "49", "Aumento de lluvias", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "50", "Sequias", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "51", "Aumento del alimento", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "52",
            "Disminución del nivel del mar",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "53", "Energía solar", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "54", "Gas natural", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "55", "Gasolina", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "56", "Biocombustible", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "57", "Panda", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "58", "Oso polar", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "59", "Elefante", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "60", "Águila", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "61", "Reutilizar/Manualidades", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "62", "Desecharla", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "63", "Quemarla", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "64", "Enterrarlo", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "65", "Reciclarla", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "66", "Romperla", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "67", "Enterrarla", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "68", "Quemarla", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "69", "Aumenta la erosión", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "70",
            "Disminuye la calidad del aire",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "71", "Más sombra/oxígeno", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "72", "Reduce el espacio de juego", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "73", "De vidrio reutilizable", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "74", "De plástico", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "75", "Bolsa de plástico", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "76", "Bolsa de papel", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "77", "Cáscara de banana", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "78", "Bolsa de plástico", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "79", "Papel de oficina", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "80", "Tela de algodón", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "81", "Gas natural", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "82", "Petróleo", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "83", "Agua", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "84", "Electricidad", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "85", "Emisiones de CO2", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "86", "Descomposición de alimentos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "87", "Cosecha de plantas", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "88", "Construcción de casas", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "89", "Evitar tirar basura", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "90", "Usar detergentes fuertes", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "91", "Lavar ropa", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "92", "Quemar desechos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "93", "Reciclarlos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "94", "Desecharlos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "95", "Guardarlos y no usarlos", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "96", "Tirarlos en la calle", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "97", "Plástico", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "98", "Hojas secas", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "99", "Papel usado", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "100", "Cáscaras de frutas", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "101", "Energía eólica", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "102", "Gas natural", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "103", "Carbón", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "104", "Petróleo", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "105", "Plantar arboles", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "106", "Usar cárbon al cocinar", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "107", "Encender más luces", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "108", "Usar más plástico", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "109", "Usar bombillas LED", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "110", "Usar más plástico", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "111", "Comprar electrodomésticos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "112", "Cocinar con carbón", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "113", "Mejora la calidad del agua", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "114", "Afectan a los seres vivos", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "115",
            "Aumentan la cantidad de plantas",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "116", "Crean más oxígeno", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "117", "Disminuye la contaminación", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "118", "Aumenta la contaminación", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "119", "Reduce el uso de agua", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "120", "Se pierde energía", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "121", "Huracán", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "122", "Tormenta de nieve", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "123",
            "Deshielo de un glaciar",
            true,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "124", "Volcán en erupción", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "125", "Panel solar", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "126", "Petróleo", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "127", "Gas natural", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "128", "Carbón", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "129",
            "Usar transporte público",
            true,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "130", "Viajar en avión", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "131", "Conducir un coche", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "132", "Comprar ropa", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "133", "Papel reciclado", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "134", "Basura orgánica", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "135", "Latas de aluminio", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "136", "Contenedor de vidrio", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "137", "Paneles solares", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "138", "Petróleo", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "139", "Gas natural", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "140", "Carbón", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "141",
            "Usar aspersores de jardín",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "142", "Lavar el auto", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "143",
            "Recolectar agua de lluvia",
            true,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "144", "Regar el cesped", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "145",
            "Contaminación en el aire",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "146",
            "Contaminación lumínica",
            true,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "147",
            "Contaminación del agua",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "148",
            "Contaminación acústica",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "149", "Selva tropical", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "150", "Desierto árido", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "151", "Tundra", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "152", "Sabana africana", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "153", "Oso polar", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "154", "Tigre de bengala", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "155", "Elefante africano", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "156", "Lobo gris", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "157", "Deshechar plásticos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "158",
            "Recolección de basura plástica",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "159", "Pesca industrial", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "160",
            "Instalación de rompeolas",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "161",
            "Agricultura de monocultivo",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "162", "Agricultura vertical", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "163", "Uso de pesticidas", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "164",
            "Agricultura de tala y quema",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "165", "Incendios forestales", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "166",
            "Huracanes más intensos",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "167", "Erosión del suelo", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "168", "Desertificación", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "169", "Selva amazónica", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "170", "Desierto del Sahara", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "171", "Tundra ártica", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "172", "Sabana africana", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "173", "Bosques", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "174", "Ríos", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "175", "Petróleo", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "176", "Minerales", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "177", "Riego por aspersión", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "178", "Riego por goteo", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "179",
            "Uso de agua reciclada",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "180",
            "Limpieza de pozos de agua",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "181", "Oso gris", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "182", "Ballena azul", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "183", "Rinoceronte negro", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "184", "Tucan", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "185", "Parque en la ciudad", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "186",
            "Rascacielos de oficinas",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "187", "Estación de metro", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "188",
            "Calle con tráfico pesado",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "189", "Energía eólica", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "190", "Energía de biomasa", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "191", "Energía nuclear", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "192", "Energía hidráulica", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "193",
            "Construcción de represas",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "194", "Pesca industrial", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "195",
            "Extracción de petróleo",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "196",
            "Construcción de viviendas",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "197", "Inundación", true, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "198", "Erupción volcánica", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "199",
            "Deslizamiento de tierra",
            false,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "200", "Tormenta de nieve", false, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        )
    )


    val newFakeQuizQuestions = listOf(
        Question(
            id = "1",
            question = "¿Cuál de estos materiales es reciclable?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[1],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "2",
            question = "¿Qué debemos hacer para reducir nuestra huella de carbono?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[7],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "3",
            question = "¿Cuál de estos materiales es biodegradable?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[10],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "4",
            question = "¿Qué gas atrapa el calor en la atmósfera y contribuye al cambio climático?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[14],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "5",
            question = "¿Cuál es una buena práctica para ahorrar agua?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[16],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "6",
            question = "¿Cuál de estos objetos no debería tirarse en el suelo?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[24],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "7",
            question = "¿Qué animal se ve afectado por la contaminación del océano?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[27],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "8",
            question = "¿Cuál es una fuente de energía renovable",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[31],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "9",
            question = "¿Qué podemos hacer con la ropa que ya no usamos?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[34],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "10",
            question = "¿Qué podemos hacer para reducir el uso de plástico?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[37],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "11",
            question = "¿Qué recurso natural ahorramos al apagar las luces cuando no son necesarias?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[41],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "12",
            question = "¿Cuál es un beneficio de plantar árboles en las ciudades?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[46],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "13",
            question = "¿Cuál de estos es un problema causado por el cambio climático?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[50],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "14",
            question = "¿Qué tipo de energía no contamina el aire cuando se usa?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[53],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "15",
            question = "¿Cuál de estos animales está en peligro debido a la deforestación de los bosques tropicales?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[57],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "16",
            question = "¿Qué podemos hacer con una botella de plástico vacía en casa para ayudar al medio ambiente?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[61],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "17",
            question = "¿Qué debemos hacer con una botella de vidrio usada en lugar de tirarla a la basura?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[65],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "18",
            question = "¿Qué efecto tiene plantar más árboles en las ciudades?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[71],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "19",
            question = "¿Qué tipo de envases es mejor para el medio ambiente al hacer compras?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[73],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "20",
            question = "¿Cuál de estos productos tarda más en descomponerse si se deja en la naturaleza?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[75],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "21",
            question = "¿Qué recurso natural podemos ayudar a conservar al reparar fugas de agua en casa rápidamente?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[83],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "22",
            question = "¿Cuál es una de las principales fuentes de contaminación del aire?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[85],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "23",
            question = "¿Qué acción ayuda a reducir la contaminación del agua?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[89],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "24",
            question = "¿Qué debemos hacer con los residuos electrónicos, como celulares viejos?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[93],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "25",
            question = "¿Cuál de estos productos causa mayor contaminación si se quema al aire libre?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[97],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "26",
            question = "¿Cuál es una forma de energía que no emite gases contaminantes?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[101],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "27",
            question = "¿Qué acción contribuye a reducir la contaminación del aire en las ciudades?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[105],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "28",
            question = "¿Cuál es una forma de reducir la huella de carbono en los hogares?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[109],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "29",
            question = "¿Qué efecto tienen los productos químicos en el ecosistema de un lago?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[114],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "30",
            question = "¿Qué se logra al reducir el consumo de electricidad en los hogares?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[117],
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "111",
            question = "¿Qué está representado en esta imagen como ejemplo de cambio climático?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[123],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F1_quiz_image.png?alt=media&token=2189b80d-2532-46ba-8720-f9a4fbf6d09d"
        ),
        Question(
            id = "112",
            question = "¿Cuál de estos es un ejemplo de energía renovable en la imagen?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[125],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F2_quiz_image.png?alt=media&token=453fbd0e-cb79-4399-9dfa-eb10063e5d75"
        ),
        Question(
            id = "113",
            question = "¿Qué acción está representada en la imagen para reducir la huella de carbono?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[129],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F3_quiz_image.png?alt=media&token=eddcba94-0c69-4972-aea9-fb932bb5ada9"
        ),
        Question(
            id = "114",
            question = "¿Qué está representado en esta imagen como ejemplo de reciclaje?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[133],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F4_quiz_image.png?alt=media&token=8a0cd511-61b2-49be-8e60-0ed0e9fb07e5"
        ),
        Question(
            id = "115",
            question = "¿Qué está representado en esta imagen como ejemplo de energía renovable?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[137],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F5_quiz_image.png?alt=media&token=4488cb59-d06b-4498-915c-81c05c8baada"
        ),
        Question(
            id = "116",
            question = "¿Qué práctica se ilustra en la imagen como una forma de ahorro de agua?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[143],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F6_quiz_image.png?alt=media&token=236709ad-e6e7-48ed-b659-8ca39c22b86f"
        ),
        Question(
            id = "117",
            question = "¿Qué tipo de contaminación está ilustrado en esta imagen?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[148],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F7_quiz_image.png?alt=media&token=8fdcb32e-866a-43fe-8e45-8a2948a509b7"
        ),
        Question(
            id = "118",
            question = "¿Qué ecosistema está representado en esta imagen y que es crucial para la biodiversidad?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[149],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F8_quiz_image.png?alt=media&token=2b1e4980-dde7-4c7a-ab98-a1ec7b395ffc"
        ),
        Question(
            id = "119",
            question = "¿Qué animal en extinción vive en este ambiente?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[153],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F9_quiz_image.png?alt=media&token=a4084616-01e7-488e-9391-fed7844cdd96"
        ),
        Question(
            id = "1110",
            question = "¿Qué acción representa esta imagen en la lucha contra la contaminación de los océanos?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[158],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F10_quiz_image.png?alt=media&token=652021df-ae3c-4d4c-a551-7d8fc0aa7567"
        ),
        Question(
            id = "1111",
            question = "¿Qué método agrícola está representado en la imagen para reducir el impacto ambiental?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[162],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F11_quiz_image.png?alt=media&token=e23d9e0e-bdb3-4709-8718-29b5073c82c1"
        ),
        Question(
            id = "1112",
            question = "¿Qué fenómeno ambiental está ilustrado en esta imagen como un impacto del cambio climático?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[166],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F12_quiz_image.png?alt=media&token=a8ffbbf7-9a23-406a-96f0-fc6ff53bc861"
        ),
        Question(
            id = "1113",
            question = "¿Qué ecosistema se muestra en la imagen y es crucial para el equilibrio climático global?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[171],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F13_quiz_image.png?alt=media&token=cadd73f2-c3ce-42d4-ba6c-2812bc77a5e7"
        ),
        Question(
            id = "1114",
            question = "¿Qué recurso natural está en riesgo, según lo ilustrado en esta imagen?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[172],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F14_quiz_image.png?alt=media&token=fe98c17f-1acf-4d91-a262-e589d4d849e8"
        ),
        Question(
            id = "1115",
            question = "¿Qué medida de conservación de agua está representada en esta imagen?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[178],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F15_quiz_image.png?alt=media&token=18f6f299-f9c0-44bb-a27e-84af05468c1e"
        ),
        Question(
            id = "1116",
            question = "¿Qué animal vive en esta zona del África y está en peligro de extinción?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[183],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F16_quiz_image.png?alt=media&token=3101ed4f-91a4-495f-8b6d-8097a8c57cfb"
        ),
        Question(
            id = "1117",
            question = "¿Qué tipo de paisaje urbano está representado en la imagen como ejemplo de infraestructura verde?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[185],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F17_quiz_image.png?alt=media&token=e0e30775-6cde-40e8-9192-31cce05dd8ea"
        ),
        Question(
            id = "1118",
            question = "¿Qué tipo de energía renovable se muestra en esta imagen como alternativa a los combustibles fósiles?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[192],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F18_quiz_image.png?alt=media&token=e77a97b7-a26d-4390-960a-048f20503537"
        ),
        Question(
            id = "1119",
            question = "¿Qué actividad humana que afecta los ecosistemas costeros está representada en la imagen?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[194],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F19_quiz_image.png?alt=media&token=f4c523bd-4600-4f4f-926d-6453fff0950d"
        ),
        Question(
            id = "1120",
            question = "¿Qué evento extremo relacionado con el cambio climático se muestra en la imagen, afectando cada vez más regiones?",
            answers = newFakeAnswers,
            correctAnswer = newFakeAnswers[197],
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F20_quiz_image.png?alt=media&token=52cddaaf-c18f-4d87-ae89-68c1bdc76999"
        ),
    )

}
