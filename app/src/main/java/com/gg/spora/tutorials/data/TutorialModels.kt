package com.gg.spora.tutorials.data

import com.gg.spora.core.utils.enums.ChampyStates
import com.gg.spora.tutorials.model.Tutorial

object TutorialModels {

    val name = "Titi"

    val initialTutorial = listOf<Tutorial>(
        Tutorial(
            "Este es mi hogar, el Árbol Madre. Acá vive mi familia “Pestalotiopsis microspora”",
            ChampyStates.SMILING
        ),
        Tutorial(
            "Nos encargamos de limpiar los residuos del bosque y cuidar a los árboles que nos rodean.",
            ChampyStates.NORMAL
        ),
        Tutorial(
            "Pero últimamente, estamos agotados debido a la contaminación que causan los humanos que viven fuera del bosque.",
            ChampyStates.ANGRY
        ),
        Tutorial(
            "¡Es por eso que necesitamos de tu ayuda! Para que el bosque sobreviva, debemos aprender a cuidar el medioambiente.",
            ChampyStates.GREETING
        )

    )
    val homeTutorials = listOf<Tutorial>(
        Tutorial(
            "Acá vas a poder ver la cantidad de árboles que están bajo nuestro cuidado.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "Estos árboles nos darán un poco de su oxígeno todos los días.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "El oxígeno nos ayudará a entender cuánto hemos avanzado.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "Al principio, tendremos poquito pero cuanto más ayudemos al bosque y juguemos...",
            ChampyStates.NORMAL
        ),
        Tutorial(
            "¡Más vamos a tener!",
            ChampyStates.GREETING
        ),
        Tutorial(
            "Oh, ¿tenés curiosidad por la Arboleda?",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "Es un poco triste, los árboles que vivían ahí, ya no están.",
            ChampyStates.SAD
        ),
        Tutorial(
            "Pero el Señor Mushy dice, que si la visitamos y cuidamos todos los días...",
            ChampyStates.NORMAL
        ),
        Tutorial(
            "¡Volverán!",
            ChampyStates.GREETING
        ),
        Tutorial(
            "¿Me ayudás a cuidarlos?",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "¡Que bueno! Entonces, vamos que te muestro.",
            ChampyStates.GREETING
        ),
        Tutorial(
            "Ese es el diario ecológico, el Señor Mushy es quien lo escribe y revisa.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "¿Quién es el Señor Mushy?",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "Es el hongo más sabio y viejo de la comunidad.",
            ChampyStates.NORMAL
        ),
        Tutorial(
            "Se encarga de muchas cosas, pero la más importante es escribir el diario ecológico.",
            ChampyStates.NORMAL
        ),
        Tutorial(
            "Te lo voy a presentar, ¡vamos!",
            ChampyStates.SMILING
        )
    )

    val groveTutorials = listOf<Tutorial>(
        Tutorial(
            "¡Llegamos! Esta es la Arboleda.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "O lo era...",
            ChampyStates.SAD
        ),
        Tutorial(
            "Bueno... voy a explicarte cómo funciona, es bastante simple.",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "El Árbol Madre nos va a dar cada cierto tiempo una semilla, que vamos a poder plantar.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "Esa semilla, si la cuidamos muy bien, crecerá lentamente hasta ser un saludable árbol.",
            ChampyStates.GREETING
        ),
        Tutorial(
            "El árbol nos dará un poco de su oxígeno diariamente como agradecimiento.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "Pero esa no es la única manera de conseguir oxígeno, según el Señor Mushy.",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "Habrá que preguntarle más tarde.",
            ChampyStates.SMILING
        )
    )

    val ecodiarioTutorial = listOf<Tutorial>(
        Tutorial(
            "¿Dónde andará el Señor Mushy?",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "¡Ahí está!",
            ChampyStates.GREETING
        ),
        Tutorial(
            "Oh... Champy y un amigo. ¿Qué los trae por aquí?",
            ChampyStates.SMILING
        ),
        Tutorial(
            "¡Señor Mushy, él es $name y nos va a ayudar con el bosque!",
            ChampyStates.GREETING
        ),
        Tutorial(
            "Por eso, quería que nos contara sobre el diario y su información.",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "De acuerdo... veamos",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "El diario es un antiguo libro que contiene aprendizajes heredados de anteriores generaciones.",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "Desde reciclaje, hasta energías renovables, todo se encuentra aquí.",
            ChampyStates.NORMAL
        ),
        Tutorial(
            "Así que, Champy, tú y $name son libres de leer o consultarme lo que deseen.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "¡Gracias, señor Mushy! La próxima vez, vamos a preguntarle muchas cosas.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "Nos vemos, señor Mushy.",
            ChampyStates.GREETING
        ),
        Tutorial(
            "Oh... Es bueno ver a las nuevas generaciones interesadas en aprender.",
            ChampyStates.SMILING
        )
    )

    val bottleChallengeTutorial = listOf<Tutorial>(
        Tutorial(
            "¡Wow! Encontraste una botella, voy a contarte un poco sobre ella.",
            ChampyStates.SMILING
        ),
        Tutorial(
            "Las botellas de plástico se pueden encontrar en muchos lugares y son fáciles de reciclar",
            ChampyStates.SMILING
        ),
        Tutorial(
            "Al ser de una importancia ecológica alta, es necesario aprender a reciclarlas.",
            ChampyStates.CURIOUS
        ),
        Tutorial(
            "Así que, aprendamos juntos sobre cómo reciclar este tipo de objetos.",
            ChampyStates.GREETING
        ),
    )
}