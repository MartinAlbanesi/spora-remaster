package com.gg.spora.core.fake

import com.gg.spora.R
import com.gg.spora.minigameQuizImage.domain.model.model.AnswerImage
import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage

object FakeQuizImageModels {

    val fakeImageAnswers = listOf(
        AnswerImage(
            answer = "Símbolo de Reciclaje",
            id = "1",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.simbolo_reciclaje
        ),
        AnswerImage(
            answer = "Calentamiento Global",
            id = "2",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.calentamiento_global
        ),
        AnswerImage(
            answer = "Deforestación",
            id = "3",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.deforestacion
        ),
        AnswerImage(
            answer = "Smog",
            id = "4",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.smog
        ),
        AnswerImage(
            answer = "Contaminación",
            id = "5",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.contaminacion
        ),
        AnswerImage(
            answer = "Energia Eólica",
            id = "6",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.recurso_viento
        ),
        AnswerImage(
            answer = "Desechos Electrónicos",
            id = "7",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.desechos_electronicos

        ),
        AnswerImage(
            answer = "Agujero de Ozono",
            id = "8",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.agujero_ozono
        ),
        AnswerImage(
            answer = "Residuo Tóxico",
            id = "9",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.residuo_toxico
        ),
        AnswerImage(
            answer = "Panel Solar",
            id = "10",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.panel_solar

        ),
    )

    val fakeImageQuestions = listOf(
        QuestionImage(
            id = "1",
            question = "¿Qué representa la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "1" }.take(3),
            answer = fakeImageAnswers[0],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.simbolo_reciclaje
        ),
        QuestionImage(
            id = "2",
            question = "¿Qué representa la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "2" }.take(3),
            answer = fakeImageAnswers[1],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.calentamiento_global
        ),
        QuestionImage(
            id = "3",
            question = "¿Qué pasó en el bosque?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "3" }.take(3),
            answer = fakeImageAnswers[2],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.deforestacion
        ),
        QuestionImage(
            id = "4",
            question = "¿Qué produce el humo?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "4" }.take(3),
            answer = fakeImageAnswers[3],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.smog
        ),
        QuestionImage(
            id = "5",
            question = "¿Qué está pasando en la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "5" }.take(3),
            answer = fakeImageAnswers[4],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.contaminacion
        ),
        QuestionImage(
            id = "6",
            question = "¿Qué tipo de energía es?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "6" }.take(3),
            answer = fakeImageAnswers[5],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.recurso_viento
        ),
        QuestionImage(
            id = "7",
            question = "¿Qué tipo de desecho es?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "7" }.take(3),
            answer = fakeImageAnswers[6],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.desechos_electronicos
        ),
        QuestionImage(
            id = "8",
            question = "¿Qué representa la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "8" }.take(3),
            answer = fakeImageAnswers[7],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.agujero_ozono
        ),
        QuestionImage(
            id = "9",
            question = "¿Qué tipo de residuo es?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "9" }.take(3),
            answer = fakeImageAnswers[8],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.residuo_toxico
        ),
        QuestionImage(
            id = "10",
            question = "¿Qué es el objeto de la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "10" }.take(3),
            answer = fakeImageAnswers[9],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.panel_solar
        ),

        )
}
