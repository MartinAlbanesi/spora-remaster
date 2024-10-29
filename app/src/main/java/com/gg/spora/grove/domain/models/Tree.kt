package com.gg.spora.grove.domain.models

/**
 * Clase Tree que representa un árbol del bosque
 * @param id Identificador único del árbol
 * @param type Tipo de árbol
 */
open class Tree(
    open val id: Int,
    open val type: TreeType
)
