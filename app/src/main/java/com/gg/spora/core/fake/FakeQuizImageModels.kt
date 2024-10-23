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
        AnswerImage(
            answer = "Contaminación por plásticos",
            id = "11",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.rio_contaminado

        ),
        AnswerImage(
            answer = "Gases de efecto invernadero",
            id = "12",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.auto_contaminando

        ),
        AnswerImage(
            answer = "Derrame de petróleo",
            id = "13",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.derrame_petroleo

        ),
        AnswerImage(
            answer = "Separación de residuos para reciclaje",
            id = "14",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.separacion_residuos

        ),
        AnswerImage(
            answer = "Reforestación",
            id = "15",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.plantar_arboles

        ),
        AnswerImage(
            answer = "Menos huella de carbono al usar energía limpia",
            id = "16",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.tren_electrico

        ),
        AnswerImage(
            answer = "Incendio forestal",
            id = "17",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.bosque_quemado

        ),
        AnswerImage(
            answer = "Contaminación del agua",
            id = "18",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.lago_contaminado

        ),
        AnswerImage(
            answer = "Desertificación",
            id = "19",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.desertificacion

        ),
        AnswerImage(
            answer = "No emite gases contaminantes",
            id = "20",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.auto_electrico

        ),
        AnswerImage(
            answer = "Compostaje",
            id = "21",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.compose

        ),
        AnswerImage(
            answer = "Agricultura urbana",
            id = "22",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.agricultura_urbana

        ),
        AnswerImage(
            answer = "Purifican el aire",
            id = "23",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.arbol

        ),
        AnswerImage(
            answer = "Polinización de plantas",
            id = "24",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.polinizacion

        ),
        AnswerImage(
            answer = "Bajo consumo de energía",
            id = "25",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.eficiencia

        ),
        AnswerImage(
            answer = "Generan menos residuos",
            id = "26",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.bolsa_tela

        ),
        AnswerImage(
            answer = "Facilita el reciclaje",
            id = "27",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.tachos_reciclado

        ),
        AnswerImage(
            answer = "Protege el suelo y el agua",
            id = "28",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.sin_pesticidas

        ),
        AnswerImage(
            answer = "Ahorra energía",
            id = "29",
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.apague_la_luz

        ),
    )


    val fakeImageQuestions = listOf(
        QuestionImage(
            id = "1",
            question = "¿Qué representa la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "1" }.shuffled().take(3),
            answer = fakeImageAnswers[0],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.simbolo_reciclaje
        ),
        QuestionImage(
            id = "2",
            question = "¿Qué representa la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "2" }.shuffled().take(3),
            answer = fakeImageAnswers[1],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.calentamiento_global
        ),
        QuestionImage(
            id = "3",
            question = "¿Qué pasó en el bosque?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "3" }.shuffled().take(3),
            answer = fakeImageAnswers[2],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.deforestacion
        ),
        QuestionImage(
            id = "4",
            question = "¿Qué produce el humo?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "4" }.shuffled().take(3),
            answer = fakeImageAnswers[3],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.smog
        ),
        QuestionImage(
            id = "5",
            question = "¿Qué está pasando en la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "5" }.shuffled().take(3),
            answer = fakeImageAnswers[4],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.contaminacion
        ),
        QuestionImage(
            id = "6",
            question = "¿Qué tipo de energía es?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "6" }.shuffled().take(3),
            answer = fakeImageAnswers[5],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.recurso_viento
        ),
        QuestionImage(
            id = "7",
            question = "¿Qué tipo de desecho es?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "7" }.shuffled().take(3),
            answer = fakeImageAnswers[6],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.desechos_electronicos
        ),
        QuestionImage(
            id = "8",
            question = "¿Qué representa la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "8" }.shuffled().take(3),
            answer = fakeImageAnswers[7],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.agujero_ozono
        ),
        QuestionImage(
            id = "9",
            question = "¿Qué tipo de residuo es?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "9" }.shuffled().take(3),
            answer = fakeImageAnswers[8],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.residuo_toxico
        ),
        QuestionImage(
            id = "10",
            question = "¿Qué es el objeto de la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "10" }.shuffled().take(3),
            answer = fakeImageAnswers[9],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.panel_solar
        ),
        QuestionImage(
            id = "11",
            question = "¿Qué problema afecta a este río?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "11" }.shuffled().take(3),
            answer = fakeImageAnswers[10],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.rio_contaminado
        ),
        QuestionImage(
            id = "12",
            question = "¿Cómo se llama este tipo de emisión de gas?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "12" }.shuffled().take(3),
            answer = fakeImageAnswers[11],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.auto_contaminando
        ),
        QuestionImage(
            id = "13",
            question = "¿Qué tipo de desastre ambiental es este?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "13" }.shuffled().take(3),
            answer = fakeImageAnswers[12],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.derrame_petroleo
        ),
        QuestionImage(
            id = "14",
            question = "¿Qué práctica está realizando esta persona?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "14" }.shuffled().take(3),
            answer = fakeImageAnswers[13],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.separacion_residuos
        ),
        QuestionImage(
            id = "15",
            question = "¿Qué práctica está realizando esta persona?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "15" }.shuffled().take(3),
            answer = fakeImageAnswers[14],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.plantar_arboles
        ),
        QuestionImage(
            id = "16",
            question = "¿Qué hace el tren electrico para ayudar al medio ambiente?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "16" }.shuffled().take(3),
            answer = fakeImageAnswers[15],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.tren_electrico
        ),
        QuestionImage(
            id = "17",
            question = "¿Qué desastre natural ocurrió aquí?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "17" }.shuffled().take(3),
            answer = fakeImageAnswers[16],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.bosque_quemado
        ),
        QuestionImage(
            id = "18",
            question = "¿Qué pudo haber causado esto?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "18" }.shuffled().take(3),
            answer = fakeImageAnswers[17],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.lago_contaminado
        ),
        QuestionImage(
            id = "19",
            question = "¿Qué fenómeno ambiental representa esta imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "19" }.shuffled().take(3),
            answer = fakeImageAnswers[18],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.desertificacion
        ),
        QuestionImage(
            id = "20",
            question = "¿Por qué es mejor utilizar un auto eléctrico?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "20" }.shuffled().take(3),
            answer = fakeImageAnswers[19],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.auto_electrico
        ),
        QuestionImage(
            id = "21",
            question = "¿Qué se hace con los residuos en este contenedor?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "21" }.shuffled().take(3),
            answer = fakeImageAnswers[20],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.compose
        ),
        QuestionImage(
            id = "22",
            question = "¿Qué práctica está representada en la imagen?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "22" }.shuffled().take(3),
            answer = fakeImageAnswers[21],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.agricultura_urbana
        ),
        QuestionImage(
            id = "23",
            question = "¿Qué beneficio brindan los árboles al medio ambiente?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "23" }.shuffled().take(3),
            answer = fakeImageAnswers[22],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.arbol
        ),
        QuestionImage(
            id = "24",
            question = "¿Cuál es el papel de los insectos en este ecosistema?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "24" }.shuffled().take(3),
            answer = fakeImageAnswers[23],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.polinizacion
        ),
        QuestionImage(
            id = "25",
            question = "¿Qué indica la etiqueta de eficiencia energética?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "25" }.shuffled().take(3),
            answer = fakeImageAnswers[24],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.eficiencia
        ),
        QuestionImage(
            id = "26",
            question = "¿Por qué es mejor usar bolsas reutilizables que de plástico?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "26" }.shuffled().take(3),
            answer = fakeImageAnswers[25],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.bolsa_tela
        ),
        QuestionImage(
            id = "27",
            question = "¿Por qué es importante separar los residuos?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "27" }.shuffled().take(3),
            answer = fakeImageAnswers[26],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.tachos_reciclado
        ),
        QuestionImage(
            id = "28",
            question = "¿Qué ventaja tiene cultivar sin pesticidas?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "28" }.shuffled().take(3),
            answer = fakeImageAnswers[27],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.sin_pesticidas
        ),
        QuestionImage(
            id = "29",
            question = "¿Por qué es importante apagar la luz cuando no se usa?",
            answers = fakeImageAnswers.filter { fake -> fake.id != "29" }.shuffled().take(3),
            answer = fakeImageAnswers[28],
            type = ImageQuestionType.RECYCLINGIMAGE,
            imageResId = R.drawable.apague_la_luz
        ),
    )
}
