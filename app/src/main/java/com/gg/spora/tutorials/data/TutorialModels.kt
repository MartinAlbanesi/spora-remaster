package com.gg.spora.tutorials.data


import androidx.compose.ui.geometry.Offset
import com.gg.spora.core.utils.enums.ChampyStates
import com.gg.spora.tutorials.model.TutorialItem

object TutorialModels {

    private const val NAME = "Titi"

    val homeTutorials = listOf(
        TutorialItem(
            text = "Este es mi hogar, el Árbol Madre. Acá vive mi familia “Pestalotiopsis microspora”",
            champyImageState = ChampyStates.SMILING.image
        ),
        TutorialItem(
            "Nos encargamos de limpiar los residuos del bosque y cuidar a los árboles que nos rodean.",
            ChampyStates.NORMAL.image
        ),
        TutorialItem(
            "Pero últimamente, estamos agotados debido a la contaminación que causan los humanos que viven fuera del bosque.",
            ChampyStates.ANGRY.image
        ),
        TutorialItem(
            "¡Es por eso que necesitamos de tu ayuda! Para que el bosque sobreviva, debemos aprender a cuidar el medioambiente.",
            ChampyStates.GREETING.image
        ),
        TutorialItem(
            "Vamos a empezar viendo lo básico, ¿te parece?",
            ChampyStates.BLINK.image
        ),
        TutorialItem(
            "Acá vas a poder ver la cantidad de árboles que están bajo nuestro cuidado.",
            ChampyStates.SMILING.image,
            focusItem = Offset(0.3f, 0.05f)
        ),
        TutorialItem(
            "Estos árboles nos darán un poco de su oxígeno todos los días.",
            ChampyStates.SMILING.image,
            focusItem = Offset(0.3f, 0.05f)
        ),
        TutorialItem(
            "El oxígeno nos ayudará a entender cuánto hemos avanzado.",
            ChampyStates.SMILING.image,
            focusItem = Offset(0.7f, 0.05f)
        ),
        TutorialItem(
            "Al principio, tendremos poquito pero cuanto más ayudemos al bosque y juguemos...",
            ChampyStates.NORMAL.image,
            focusItem = Offset(0.7f, 0.05f)
        ),
        TutorialItem(
            "¡Más vamos a tener!",
            ChampyStates.GREETING.image
        ),
//        TutorialItem(
//            "Oh, ¿tenés curiosidad por la Arboleda?",
//            ChampyStates.CURIOUS.image
//        ),
//        TutorialItem(
//            "Es un poco triste, los árboles que vivían ahí, ya no están.",
//            ChampyStates.SAD.image
//        ),
//        TutorialItem(
//            "Pero el Señor Mushy dice, que si la visitamos y cuidamos todos los días...",
//            ChampyStates.NORMAL.image
//        ),
//        TutorialItem(
//            "¡Volverán!",
//            ChampyStates.GREETING.image
//        ),
//        TutorialItem(
//            "¿Me ayudás a cuidarlos?",
//            ChampyStates.CURIOUS.image
//        ),
//        TutorialItem(
//            "¡Que bueno! Entonces, vamos que te muestro.",
//            ChampyStates.GREETING.image
//        ),
//        TutorialItem(
//            "Ese es el diario ecológico, el Señor Mushy es quien lo escribe y revisa.",
//            ChampyStates.SMILING.image
//        ),
//        TutorialItem(
//            "¿Quién es el Señor Mushy?",
//            ChampyStates.CURIOUS.image
//        ),
//        TutorialItem(
//            "Es el hongo más sabio y viejo de la comunidad.",
//            ChampyStates.NORMAL.image
//        ),
//        TutorialItem(
//            "Se encarga de muchas cosas, pero la más importante es escribir el diario ecológico.",
//            ChampyStates.NORMAL.image
//        ),
//        TutorialItem(
//            "Te lo voy a presentar, ¡vamos!",
//            ChampyStates.SMILING.image
//        )
    )

    val groveTutorials = listOf(
        TutorialItem(
            "¡Llegamos! Esta es la Arboleda.",
            ChampyStates.SMILING.image
        ),
        TutorialItem(
            "O lo era...",
            ChampyStates.SAD.image
        ),
        TutorialItem(
            "Bueno... voy a explicarte cómo funciona, es bastante simple.",
            ChampyStates.CURIOUS.image
        ),
        TutorialItem(
            "El Árbol Madre nos va a dar cada cierto tiempo una semilla, que vamos a poder plantar.",
            ChampyStates.SMILING.image
        ),
        TutorialItem(
            "Esa semilla, si la cuidamos muy bien, crecerá lentamente hasta ser un saludable árbol.",
            ChampyStates.GREETING.image
        ),
        TutorialItem(
            "El árbol nos dará un poco de su oxígeno diariamente como agradecimiento.",
            ChampyStates.SMILING.image
        ),
        TutorialItem(
            "Pero esa no es la única manera de conseguir oxígeno, según el Señor Mushy.",
            ChampyStates.CURIOUS.image
        ),
        TutorialItem(
            "Habrá que preguntarle más tarde.",
            ChampyStates.SMILING.image
        )
    )

    val ecodiarioTutorial = listOf(
        TutorialItem(
            "¿Dónde andará el Señor Mushy?",
            ChampyStates.CURIOUS.image
        ),
        TutorialItem(
            "¡Ahí está!",
            ChampyStates.GREETING.image
        ),
        TutorialItem(
            "Oh... Champy y un amigo. ¿Qué los trae por aquí?",
            ChampyStates.SMILING.image,
            false,
        ),
        TutorialItem(
            "¡Señor Mushy, él es $NAME y nos va a ayudar con el bosque!",
            ChampyStates.GREETING.image
        ),
        TutorialItem(
            "Por eso, quería que nos contara sobre el diario y su información.",
            ChampyStates.CURIOUS.image
        ),
        TutorialItem(
            "De acuerdo... veamos",
            ChampyStates.CURIOUS.image,
            false,
        ),
        TutorialItem(
            "El diario es un antiguo libro que contiene aprendizajes heredados de anteriores generaciones.",
            ChampyStates.CURIOUS.image,
            false,
        ),
        TutorialItem(
            "Desde reciclaje, hasta energías renovables, todo se encuentra aquí.",
            ChampyStates.NORMAL.image,
            false,
        ),
        TutorialItem(
            "Así que, Champy, tú y $NAME son libres de leer o consultarme lo que deseen.",
            ChampyStates.SMILING.image,
            false,
        ),
        TutorialItem(
            "¡Gracias, señor Mushy! La próxima vez, vamos a preguntarle muchas cosas.",
            ChampyStates.SMILING.image
        ),
        TutorialItem(
            "Nos vemos, señor Mushy.",
            ChampyStates.GREETING.image
        ),
        TutorialItem(
            "Oh... Es bueno ver a las nuevas generaciones interesadas en aprender.",
            ChampyStates.SMILING.image,
            false,
        )
    )

    val bottleChallengeTutorial = listOf(
        TutorialItem(
            "¡Wow! Encontraste una botella, voy a contarte un poco sobre ella.",
            ChampyStates.SMILING.image
        ),
        TutorialItem(
            "Las botellas de plástico se pueden encontrar en muchos lugares y son fáciles de reciclar",
            ChampyStates.SMILING.image
        ),
        TutorialItem(
            "Al ser de una importancia ecológica alta, es necesario aprender a reciclarlas.",
            ChampyStates.CURIOUS.image
        ),
        TutorialItem(
            "Así que, aprendamos juntos sobre cómo reciclar este tipo de objetos.",
            ChampyStates.GREETING.image
        ),
    )
}