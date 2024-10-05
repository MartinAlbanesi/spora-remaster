package com.gg.spora.grove.domain.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime

class ArbolSemillero(id: Int, tipo: TipoArbol, private val tiempoParaGenerarSemilla: Duration) : Arbol(id, tipo) {
    var cantidadSemillasGeneradas: Int = 0
    @RequiresApi(Build.VERSION_CODES.O)
    var ultimaGeneracionSemilla: LocalDateTime = LocalDateTime.now()

    // Genera una semilla del tipo específico
    @RequiresApi(Build.VERSION_CODES.O)
    fun generarSemilla(): Semilla? {
        val tiempoActual = LocalDateTime.now()
        if (Duration.between(ultimaGeneracionSemilla, tiempoActual) >= tiempoParaGenerarSemilla) {
            ultimaGeneracionSemilla = tiempoActual
            cantidadSemillasGeneradas++
            return Semilla(tipo)
        }
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun obtenerProximaSemillaEn(): Duration {
        val tiempoRestante = Duration.between(LocalDateTime.now(), ultimaGeneracionSemilla.plus(tiempoParaGenerarSemilla))
        return tiempoRestante
    }
}