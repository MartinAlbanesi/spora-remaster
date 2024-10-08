package com.gg.spora.core.utils

@Suppress("MagicNumber")
object SporaConstant {
    const val MAX_QUESTIONS = 5
    const val MAX_LIVES = 5
    const val MAX_STAR = 3

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

    val PATH_LADDER = listOf(
        -40, (-40), -10, 50
    )
}