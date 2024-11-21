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
        Pair(-40,0), Pair(-30,0), Pair(30,0), Pair(50,0)
    )

    const val QUESTIONS_FILE_PATH = "src/main/res/raw/questions.json"

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