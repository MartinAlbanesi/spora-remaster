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
}