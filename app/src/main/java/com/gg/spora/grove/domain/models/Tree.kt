package com.gg.spora.grove.domain.models

/**
 * Data class representing a tree.
 * @param id The ID of the tree.
 * @param type The type of the tree.
 * @see TreeType
 * @see ForestTree
 * @see SeedTree
 */
open class Tree(
    open val id: String,
    open val type: TreeType
)
