package com.gg.spora.miniGames.domain.functions

import com.gg.spora.R

fun getChampyImageMiniGame(isCorrect: Boolean?): Int {
    return when (isCorrect) {
        true -> R.drawable.champy_celebrating_raised_arms_without_shadow
        false -> R.drawable.champy_sad_arms_body
        else -> R.drawable.champy_curious_left_arm_in_the_cheek
    }
}