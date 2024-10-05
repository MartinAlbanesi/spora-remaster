package com.gg.spora.grove.domain.models

import android.os.Build
import androidx.annotation.RequiresApi

class Bosque {
    val arboles = mutableListOf<ArbolDelBosque>()
    var oxigenoTotal: Int = 0

    // Planta una semilla y agrega el árbol al bosque
    fun plantarSemilla(semilla: Semilla) {
        val arbol = ArbolDelBosque(arboles.size + 1, semilla.tipo)
        arboles.add(arbol)
    }

    // Recolecta oxígeno de todos los árboles adultos
    @RequiresApi(Build.VERSION_CODES.O)
    fun recolectarOxigeno(): Int {
        var oxigeno = 0
        for (arbol in arboles) {
            oxigeno += arbol.recolectarOxigeno()
        }
        oxigenoTotal += oxigeno
        return oxigeno
    }
}