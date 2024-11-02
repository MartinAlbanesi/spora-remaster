package com.gg.spora.grove.domain.models

import com.gg.spora.R

/**
 * Enum TreeType que representa los diferentes tipos de árboles del bosque
 * @param oxygenPerDay Cantidad de oxígeno generado por cada árbol del tipo en un día
 */
enum class TreeType(val oxygenPerDay: Int) {
    SECUOYA(3),
    PINE(5),
    MANGROVE(10),
    BAOBAB(15),
    NONE(0);

    /**
     * Retorna la imagen correspondiente al tipo de árbol
     */
    val imageResource: Int
        get() = when (this) {
            MANGROVE -> R.drawable.mangrove_tree
            SECUOYA -> R.drawable.mother_tree_back
            BAOBAB -> R.drawable.baobab_tree
            PINE -> R.drawable.pine_tree
            NONE -> R.drawable.empty_tree_spot
        }
}