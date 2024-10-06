package com.gg.spora.grove.data.models

import java.util.UUID

/**
 * Clase Tree que representa un árbol del bosque
 * @param id Identificador único del árbol
 * @param type Tipo de árbol
 */
open class Tree(
    open val id: UUID,
    open val type: TreeType
)
