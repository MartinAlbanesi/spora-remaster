package com.gg.spora.core.utils.enums

import com.gg.spora.R

enum class ChampyStates {

    SMILING,
    SAD,
    GREETING,
    DEFEATED,
    BLINK,
    NORMAL,
    CURIOUS;

    val image: Int
        get() = when (this) {
            SMILING -> R.drawable.champy_sonriente_brazosalcuerpo
            SAD -> R.drawable.champy_triste_brazosalcuerpo
            GREETING -> R.drawable.champy_celebrando_brazo_levantado
            CURIOUS -> R.drawable.champy_curioso_brazo_izquierdo_en_la_mejilla
            DEFEATED -> R.drawable.champy_derrotado_brazosalcuerpo
            BLINK -> R.drawable.champy_sonriente_brazos_al_cuerpo_pestaneo
            NORMAL -> R.drawable.champy_serio_idle
        }
}