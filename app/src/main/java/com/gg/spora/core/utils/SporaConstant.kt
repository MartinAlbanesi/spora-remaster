package com.gg.spora.core.utils

@Suppress("MagicNumber")
object SporaConstant {
    const val MAX_QUESTIONS = 8
    const val MAX_LIVES = 5
    const val MAX_STAR = 3

    const val MAX_LEVELS = 4
    const val MAX_STAGES_LEVEL = 2

    /**
     key = rotate, value = offset
     */
    val ROTATE_ITEMS_REWARDS = mapOf(
        -25f to 0,
        0f to (-16),
        25f to 0
    )

    val ROTATE_ITEMS_LEVEL_PREVIEW = mapOf(
        -25f to 0,
        0f to (10),
        25f to 0
    )

    val PATH_LADDER_EXPO = listOf(
        Pair(0,200), Pair(0,200), Pair(0,0), Pair(0,0)
    )

    val PATH_LADDER = listOf(
        Pair(-40,0), Pair(-40,0), Pair(-10,0), Pair(50,0), Pair(50,0)
    )

    val CHAMPY_CONGRATULATING_YOU_LIST = listOf(
        "Felicitaciones",
        "¡Bien hecho!",
        "¡Excelente!",
        "¡Muy bien!",
        "¡Genial!",
        "¡Fantástico!",
    )

    val CHAMPY_RANDOM_QUOTE = listOf(
        "Acortá las duchas para ahorrar agua",
        "Apagá los electrodomésticos que no uses en el momento",
        "Apagá las luces cuando no las estés usando",
        "Cerrá bien la canilla luego de usarla para no desperdiciar agua",
        "Caminá o usa una bici para reducir la contaminación",
        "Aprovechá a hacer compost para ayudar a cuidar el suelo",
        "Reutilizá los objetos de plástico que no uses para hacer manualidades",
        "Revisá que los paquetes tengan el símbolo de reciclaje antes de reciclarlos",
        "No tires basura al suelo, depositala en el contenedor adecuado",
        "Reciclar una lata ahorra energía para 3 horas de TV",
        "Un árbol absorbe 22 kg de dióxido de carbono al año",
        "Los bosques son hogar del 80% de las especies terrestres",
        "Las abejas polinizan el 70% de lo que comemos",
        "Aprender del ambiente te hace un héroe",
        "Los bosques enfrían el aire como 10 aires acondicionados",
        "Las bolsas de plástico tardan 700 años en descomponerse",
        "Los paneles solares usan energía del sol",
        "Los molinos de viento usan la fuerza del viento para crear energía",
        "Las aves, como los loros, siembran árboles con semillas",
        "Se tira un camión de plástico al mar cada minuto",
        "Comprar frutas locales cuida el planeta",
        "Las flores atraen insectos buenos como abejas",
        "Las hormigas limpian el bosque",
        "Jugar afuera ahorra electricidad y es divertido",
    )
    const val ANSWERS_FILE_PATH = "src/main/res/raw/answers.json"

    val BANNED_WORDS = listOf(
        "puta",
        "culo",
        "ass",
        "puto",
        "caca",
        "pis",
        "nigga",
        "mierda",
        "tonto",
        "tonta",
        "idiota",
        "pendejo",
        "pendeja",
        "bitch",
        "negro",
        "judio",
        "judia",
        "negra",
        "gay",
        "maricon",
        "maricona",
        "lesbiana",
        "burro",
        "nazi",
        "slut",
        "sexo",
        "porno",
        "pito",
        "pene",
        "vagina",
        "concha",
        "asshole",
        "tarado",
        "tarada"
    )
}