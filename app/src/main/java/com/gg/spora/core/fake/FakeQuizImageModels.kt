package com.gg.spora.core.fake

import com.gg.spora.R
import com.gg.spora.minigameQuizImage.domain.model.model.AnswerImage
import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage

object FakeQuizImageModels {

    val fakeImageAnswers = listOf(
        AnswerImage(
            answer = "Simbolo Reciclaje",
            id = "1",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.simbolo_reciclaje
        ),
        AnswerImage(
            answer = "Caalentamiento Global",
            id = "2",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.calentamiento_global
        ),
        AnswerImage(
            answer = "Deforestacion",
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
            answer = "Contaminacion",
            id = "5",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.contaminacion
        ),
        AnswerImage(
            answer = "Energia Eolica",
            id = "6",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.recurso_viento
        ),
        AnswerImage(
            answer = "Desechos Electronicos",
            id = "7",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.desechos_electronicos

        ),
    )

    val fakeImageQuestions = listOf(
        QuestionImage(
            id = "1",
            question = "Que representa la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "1" }.take(3),
            answer = fakeImageAnswers[0],
            type = ImageQuestionType.RECYCLINGIMAGE
        ),
        QuestionImage(
            id = "2",
            question = "Que representa la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "2" }.take(3),
            answer = fakeImageAnswers[1],
            type = ImageQuestionType.RECYCLINGIMAGE
        ),
        QuestionImage(
            id = "3",
            question = "Que paso en el bosque?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "3" }.take(3),
            answer = fakeImageAnswers[2],
            type = ImageQuestionType.RECYCLINGIMAGE
        ),
        QuestionImage(
            id = "4",
            question = "Que produce el humo?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "4" }.take(3),
            answer = fakeImageAnswers[3],
            type = ImageQuestionType.RECYCLINGIMAGE
        ),
        QuestionImage(
            id = "5",
            question = "Que esta pasando en la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "5" }.take(3),
            answer = fakeImageAnswers[4],
            type = ImageQuestionType.RECYCLINGIMAGE
        ),
        QuestionImage(
            id = "6",
            question = "Que tipo de energia es?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "6" }.take(3),
            answer = fakeImageAnswers[5],
            type = ImageQuestionType.RECYCLINGIMAGE
        ),
        QuestionImage(
            id = "7",
            question = "Que tipo de desecho es?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "7" }.take(3),
            answer = fakeImageAnswers[6],
            type = ImageQuestionType.RECYCLINGIMAGE
        ),

    )
}
