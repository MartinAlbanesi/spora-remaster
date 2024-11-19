package com.gg.spora.tutorials.data


import androidx.compose.ui.geometry.Offset
import com.gg.spora.R
import com.gg.spora.core.utils.enums.ChampyStates
import com.gg.spora.core.utils.enums.MushyStates
import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.tutorials.domain.model.TutorialCompleted
import com.gg.spora.tutorials.domain.model.TutorialItem

object TutorialModels {

    val tutorialsCompleted = listOf(
        TutorialCompleted(Tutorials.HOME_TUTORIAL.id, false, Tutorials.HOME_TUTORIAL.tutorialName),
        TutorialCompleted(Tutorials.GROVE_TUTORIAL.id, false, Tutorials.GROVE_TUTORIAL.tutorialName),
        TutorialCompleted(Tutorials.LIBRARY_TUTORIAL.id, false, Tutorials.LIBRARY_TUTORIAL.tutorialName),
        TutorialCompleted(Tutorials.LIBRARY_ICON_TUTORIAL.id, false, Tutorials.LIBRARY_ICON_TUTORIAL.tutorialName),
        TutorialCompleted(Tutorials.GROVE_ICON_TUTORIAL.id, false, Tutorials.GROVE_ICON_TUTORIAL.tutorialName),
    )

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
    )

    val libraryIconTutorials = listOf(
        TutorialItem(
            "Ese es el diario ecológico, el Señor Mushy es quien lo escribe y revisa.",
            ChampyStates.SMILING.image
        ),
        TutorialItem(
            "¿Quién es el Señor Mushy?",
            ChampyStates.CURIOUS.image
        ),
        TutorialItem(
            "Es el hongo más sabio y viejo de la comunidad.",
            ChampyStates.NORMAL.image
        ),
        TutorialItem(
            "Se encarga de muchas cosas, pero la más importante es escribir el diario ecológico.",
            ChampyStates.NORMAL.image
        ),
        TutorialItem(
            "Te lo voy a presentar, ¡vamos!",
            ChampyStates.SMILING.image
        )
    )

    val groveIconTutorials = listOf(
        TutorialItem(
            "Oh, ¿tenés curiosidad por la Arboleda?",
            ChampyStates.CURIOUS.image
        ),
        TutorialItem(
            "Es un poco triste, los árboles que vivían ahí, ya no están.",
            ChampyStates.SAD.image
        ),
        TutorialItem(
            "Pero el Señor Mushy dice, que si la visitamos y cuidamos todos los días...",
            ChampyStates.NORMAL.image
        ),
        TutorialItem(
            "¡Volverán!",
            ChampyStates.GREETING.image
        ),
        TutorialItem(
            "¿Me ayudás a cuidarlos?",
            ChampyStates.CURIOUS.image
        ),
        TutorialItem(
            "¡Que bueno! Entonces, vamos que te muestro.",
            ChampyStates.GREETING.image
        ),
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
            ChampyStates.SMILING.image,
            secondaryImage = R.drawable.tutorial_seed,
            isSecondaryTalking = true
        ),
        TutorialItem(
            "Esa semilla, si la cuidamos muy bien, crecerá lentamente hasta ser un saludable árbol.",
            ChampyStates.GREETING.image,
            secondaryImage = R.drawable.tutorial_tree,
            isSecondaryTalking = true
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

    fun getLibraryTutorial(userName: String): List<TutorialItem>{
        val libraryTutorial = listOf(
            TutorialItem(
                "¿Dónde andará el Señor Mushy?",
                ChampyStates.CURIOUS.image
            ),
            TutorialItem(
                "¡Ahí está!",
                ChampyStates.GREETING.image,
                secondaryImage = MushyStates.IDLE.image,
                isSecondaryTalking = false,
            ),
            TutorialItem(
                "Oh... Champy y un amigo. ¿Qué los trae por acá?",
                ChampyStates.SMILING.image,
                isChampyTalking = false,
                secondaryImage = MushyStates.IDLE.image,
                isSecondaryTalking = true,
            ),
            TutorialItem(
                "¡Señor Mushy, él es $userName y nos va a ayudar con el bosque!",
                ChampyStates.GREETING.image,
                isChampyTalking = true,
                secondaryImage = MushyStates.IDLE.image,
                isSecondaryTalking = false,
            ),
            TutorialItem(
                "Por eso, quería que nos contara sobre el diario y su información.",
                ChampyStates.CURIOUS.image,
                isChampyTalking = true,
                secondaryImage = MushyStates.IDLE.image,
                isSecondaryTalking = false,
            ),
            TutorialItem(
                "De acuerdo... veamos",
                ChampyStates.CURIOUS.image,
                isChampyTalking = false,
                secondaryImage = MushyStates.SERIOUS.image,
                isSecondaryTalking = true,
            ),
            TutorialItem(
                "En la biblioteca encontrarás libros \n" +
                    "que contienen cartas heredadas \n" +
                    "de anteriores generaciones.",
                ChampyStates.CURIOUS.image,
                false,
                secondaryImage = MushyStates.IDLE.image,
                isSecondaryTalking = true,
            ),
            TutorialItem(
                "Con mucha información \n" +
                    "desde reciclaje, hasta energías\n" +
                    " renovables, todo se encuentra aquí.",
                ChampyStates.NORMAL.image,
                false,
                secondaryImage = MushyStates.IDLE.image,
                isSecondaryTalking = true,
            ),
            TutorialItem(
                "Así que, Champy, tú y $userName son libres de leer o consultarme lo que deseen.",
                ChampyStates.SMILING.image,
                isChampyTalking = false,
                secondaryImage = MushyStates.IDLE.image,
                isSecondaryTalking = true,
            ),
            TutorialItem(
                "¡Gracias, señor Mushy!\n" +
                    "¡Vamos $userName aprendamos de todo!",
                ChampyStates.SMILING.image,
                secondaryImage = MushyStates.IDLE.image,
            ),
            TutorialItem(
                "Nos vemos",
                ChampyStates.GREETING.image,
                secondaryImage = MushyStates.IDLE.image,
            ),
            TutorialItem(
                "Oh... Es bueno ver a las nuevas generaciones interesadas en aprender.",
                null,
                isChampyTalking = false,
                secondaryImage = MushyStates.IDLE.image,
                isSecondaryTalking = true,
            )
        )
        return libraryTutorial
    }

    fun getTutorial(tutorial: Tutorials, userName: String): List<TutorialItem> {
        return when(tutorial){
            Tutorials.HOME_TUTORIAL -> homeTutorials
            Tutorials.GROVE_TUTORIAL -> groveTutorials
            Tutorials.LIBRARY_TUTORIAL -> getLibraryTutorial(userName)
            Tutorials.LIBRARY_ICON_TUTORIAL -> libraryIconTutorials
            Tutorials.GROVE_ICON_TUTORIAL -> groveIconTutorials
        }
    }
}