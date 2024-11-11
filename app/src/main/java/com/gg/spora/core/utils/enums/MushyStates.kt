package com.gg.spora.core.utils.enums

import androidx.annotation.DrawableRes
import com.gg.spora.R

enum class MushyStates(
    @DrawableRes val image: Int,
) {
    IDLE(R.drawable.mushy_idle),
    SERIOUS(R.drawable.mushy_serio);
}
