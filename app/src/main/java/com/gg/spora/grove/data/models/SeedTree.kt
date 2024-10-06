package com.gg.spora.grove.data.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.util.UUID

/**
 * Clase SeedTree que representa un árbol semillero del bosque, capaz de generar semillas a un tiempo determinado
 * @param id Identificador único del árbol semillero
 * @param type Tipo de árbol
 * @param timeToGenerateSeed Tiempo en milisegundos para generar una semilla
 */
data class SeedTree(
    override val id: UUID = UUID.randomUUID(),
    override val type: TreeType,
    private val timeToGenerateSeed: Duration
) : Tree(id, type) {

    var amountOfSeedsGenerated: Int = 0
    var nextSeedAvailableTime: Long = 0L

    // Verifica si es posible generar una semilla
    fun isSeedAvailable(): Boolean {
        return System.currentTimeMillis() >= nextSeedAvailableTime
    }

    // Genera una semilla si es posible, y retorna la semilla generada o null si no es posible generar una semilla
    @RequiresApi(Build.VERSION_CODES.O)
    fun generateSeed(): Seed? {
        if (isSeedAvailable()) {
            nextSeedAvailableTime = System.currentTimeMillis() + timeToGenerateSeed.toMillis()
            amountOfSeedsGenerated++
            return Seed(type)
        }
        return null
    }
}
