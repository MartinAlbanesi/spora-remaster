package com.gg.spora.core.utils.enums

import com.gg.spora.R

enum class MushyStates {

    IDLE,
    SERIOUS;

    val image: Int
        get() = when (this) {
            IDLE -> R.drawable.mushy_idle
            SERIOUS -> R.drawable.mushy_serio
        }
}
