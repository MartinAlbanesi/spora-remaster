package com.gg.spora.grove.domain.models

import com.gg.spora.R

/**
 * Enum representing the types of trees.
 * @param oxygenAmount The amount of oxygen given by the tree.
 */
enum class TreeType(val oxygenAmount: Int) {
    SECUOYA(3),
    PINE(5),
    MANGROVE(10),
    BAOBAB(15);

    // Extension property to get the image resource for the tree type
    val imageResource: Int
        get() = when (this) {
            MANGROVE -> R.drawable.mangrove_tree
            SECUOYA -> R.drawable.mother_tree_back
            BAOBAB -> R.drawable.baobab_tree
            PINE -> R.drawable.pine_tree
        }
}