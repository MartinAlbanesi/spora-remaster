package com.gg.spora.core.utils.enums

import androidx.annotation.DrawableRes
import com.gg.spora.R

enum class ChampyStates(
    @DrawableRes val image: Int,
) {
    SMILING (R.drawable.champy_smiling_arms_body),
    SAD(R.drawable.champy_sad_arms_body),
    EXCITED(R.drawable.champy_celebrating_left_arm_raised),
    DEFEATED(R.drawable.champy_defeated_arms_body),
    HAPPY(R.drawable.champy_smiling_arms_to_the_body_blinking),
    SERIOUS(R.drawable.champy_serious_idle),
    ANGRY(R.drawable.champy_angry_up_arms),
    CURIOUS(R.drawable.champy_curious_left_arm_in_the_cheek)
}