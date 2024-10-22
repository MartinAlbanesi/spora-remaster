package com.gg.spora.grove.data.models

import java.util.UUID

/**
 * Clase Seed que representa una semilla del bosque, con el mismo tipo de árbol semillero de donde se generó
 */
data class Seed(
    val id: UUID = UUID.randomUUID(),
    val type: TreeType
)