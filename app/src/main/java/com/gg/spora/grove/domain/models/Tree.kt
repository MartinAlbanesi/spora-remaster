package com.gg.spora.grove.domain.models

// Clase padre Árbol (se mantiene igual)
open class Arbol(val id: Int, val tipo: TipoArbol) {
    fun obtenerTipo(): TipoArbol {
        return tipo
    }
}