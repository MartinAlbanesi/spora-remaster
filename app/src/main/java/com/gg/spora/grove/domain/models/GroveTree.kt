package com.gg.spora.grove.domain.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime

// Clase ÁrbolDelBosque que gestiona el crecimiento y la generación de oxígeno
class ArbolDelBosque(id: Int, tipo: TipoArbol) : Arbol(id, tipo) {
    @RequiresApi(Build.VERSION_CODES.O)
    private val fechaPlantacion: LocalDateTime = LocalDateTime.now()
    var oxigenoAcumulado: Int = 0
    var etapaActual: EtapaCrecimiento = EtapaCrecimiento.BROTE

    // Calcula la etapa de crecimiento en función del tiempo pasado
    @RequiresApi(Build.VERSION_CODES.O)
    fun actualizarEtapaDeCrecimiento() {
        val diasPasados = Duration.between(fechaPlantacion, LocalDateTime.now()).toDays().toInt()
        etapaActual = when {
            diasPasados < 5 -> EtapaCrecimiento.BROTE
            diasPasados in 5..9 -> EtapaCrecimiento.ARBOL_MEDIANO
            else -> EtapaCrecimiento.ARBOL_ADULTO
        }
    }

    // Calcula el oxígeno generado solo si el árbol está en la etapa de Árbol Adulto
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcularOxigenoGenerado(): Int {
        actualizarEtapaDeCrecimiento()
        return if (etapaActual == EtapaCrecimiento.ARBOL_ADULTO) {
            val diasPasados = Duration.between(fechaPlantacion, LocalDateTime.now()).toDays().toInt()
            oxigenoAcumulado = diasPasados * tipo.oxigenoPorDia
            oxigenoAcumulado
        } else {
            0 // No genera oxígeno hasta ser un árbol adulto
        }
    }

    // Recolecta el oxígeno acumulado solo si el árbol es adulto
    @RequiresApi(Build.VERSION_CODES.O)
    fun recolectarOxigeno(): Int {
        val oxigeno = calcularOxigenoGenerado()
        oxigenoAcumulado = 0
        return oxigeno
    }
}