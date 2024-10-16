package com.gg.spora.core.fake

import com.gg.spora.R
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question

object FakeQuizImageModels {

//    val fakeImageAnswers = listOf(
//        Answer(
//            answer = "Símbolo de Reciclaje",
//            id = "1",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.simbolo_reciclaje
//        ),
//        Answer(
//            answer = "Calentamiento Global",
//            id = "2",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.calentamiento_global
//        ),
//        Answer(
//            answer = "Deforestación",
//            id = "3",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.deforestacion
//        ),
//        Answer(
//            answer = "Smog",
//            id = "4",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.smog
//        ),
//        Answer(
//            answer = "Contaminación",
//            id = "5",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.contaminacion
//        ),
//        Answer(
//            answer = "Energia Eólica",
//            id = "6",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.recurso_viento
//        ),
//        Answer(
//            answer = "Desechos Electrónicos",
//            id = "7",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.desechos_electronicos
//
//        ),
//        Answer(
//            answer = "Agujero de Ozono",
//            id = "8",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.agujero_ozono
//        ),
//        Answer(
//            answer = "Residuo Tóxico",
//            id = "9",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.residuo_toxico
//        ),
//        Answer(
//            answer = "Panel Solar",
//            id = "10",
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE
////            imageResId = R.drawable.panel_solar
//
//        ),
//    )

//    val fakeImageQuestions = listOf(
//        Question(
//            id = "1",
//            question = "¿Qué representa la imagen?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "1" }.take(3),
//            answerId = fakeImageAnswers[0].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.simbolo_reciclaje
//        ),
//        Question(
//            id = "2",
//            question = "¿Qué representa la imagen?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "2" }.take(3),
//            answerId = fakeImageAnswers[1].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.calentamiento_global
//        ),
//        Question(
//            id = "3",
//            question = "¿Qué pasó en el bosque?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "3" }.take(3),
//            answerId = fakeImageAnswers[2].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.deforestacion
//        ),
//        Question(
//            id = "4",
//            question = "¿Qué produce el humo?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "4" }.take(3),
//            answerId = fakeImageAnswers[3].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.smog
//        ),
//        Question(
//            id = "5",
//            question = "¿Qué está pasando en la imagen?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "5" }.take(3),
//            answerId = fakeImageAnswers[4].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.contaminacion
//        ),
//        Question(
//            id = "6",
//            question = "¿Qué tipo de energía es?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "6" }.take(3),
//            answerId = fakeImageAnswers[5].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.recurso_viento
//        ),
//        Question(
//            id = "7",
//            question = "¿Qué tipo de desecho es?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "7" }.take(3),
//            answerId = fakeImageAnswers[6].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.desechos_electronicos
//        ),
//        Question(
//            id = "8",
//            question = "¿Qué representa la imagen?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "8" }.take(3),
//            answerId = fakeImageAnswers[7].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.agujero_ozono
//        ),
//        Question(
//            id = "9",
//            question = "¿Qué tipo de residuo es?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "9" }.take(3),
//            answerId = fakeImageAnswers[8].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.residuo_toxico
//        ),
//        Question(
//            id = "10",
//            question = "¿Qué es el objeto de la imagen?",
//            answers = fakeImageAnswers.filter { fake -> fake.id != "10" }.take(3),
//            answerId = fakeImageAnswers[9].id,
//            typeQuestion = TypeQuestion.RECYCLE,
//            typeGame = TypeGame.QUIZ_IMAGE,
//            image = R.drawable.panel_solar
//        ),
//
//        )
}
