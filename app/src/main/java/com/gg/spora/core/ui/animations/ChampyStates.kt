package com.gg.spora.core.ui.animations

import com.gg.spora.R

enum class ChampyStates {

    SMILING,
    SAD,
    GREETING,
    DEFEATED,
    BLINK,
    CURIOUS;

    val image: Int
        get() = when (this) {
            SMILING -> R.drawable.champy_smiling_arms_body
            SAD -> R.drawable.champy_sad_arms_body
            GREETING -> R.drawable.champy_celebrating_left_arm_raised
            CURIOUS -> R.drawable.champy_curious_left_arm_in_the_cheek
            DEFEATED -> R.drawable.champy_defeated_arms_body
            BLINK -> R.drawable.champy_smiling_arms_to_the_body_blinking
        }
}