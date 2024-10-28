package com.gg.spora.core.utils.functions

import com.gg.spora.R
import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.core.utils.enums.StarState

fun getStarsImages(
    starsState: StarState
):List<Int>{
    val localStars : MutableList<Int> = mutableListOf()

    for (i in 1..MAX_STAR) {
        if (i <= starsState.starCount) {
            localStars.add(R.drawable.star)
        } else {
            localStars.add(R.drawable.gray_star)
        }
    }

    return localStars
}