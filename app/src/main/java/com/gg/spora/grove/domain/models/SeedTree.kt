package com.gg.spora.grove.domain.models

import android.os.Build
import androidx.annotation.RequiresApi
import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import java.time.Duration

/**
 * Clase SeedTree que representa un árbol semillero del bosque, capaz de generar semillas a un tiempo determinado
 * @param id Identificador único del árbol semillero
 * @param type Tipo de árbol
 * @param timeToGenerateForestTree Tiempo en milisegundos para generar un árbol del bosque
 */
data class SeedTree(
    override val id: Int = 0,
    override val type: TreeType,
    val timeToGenerateForestTree: Duration,
    var amountOfForestTreesGenerated: Int = 0,
    var nextForestTreeAvailableTime: Long = 0L
) : Tree(id, type) {

    // Verifica si es posible generar una semilla
    fun isForestTreeAvailable(): Boolean {
        return System.currentTimeMillis() >= nextForestTreeAvailableTime
    }

    // Genera una semilla si es posible, y retorna la semilla generada o null si no es posible generar una semilla
    @RequiresApi(Build.VERSION_CODES.O)
    fun generateForestTree(): ForestTree? {
        nextForestTreeAvailableTime = System.currentTimeMillis() + timeToGenerateForestTree.toMillis()
        amountOfForestTreesGenerated++
        return ForestTree(type = type)
    }
}

fun SeedTree.toSeedTreeEntity(): SeedTreeEntity {
    return SeedTreeEntity(
        idSeedTree = id,
        treeType = type.name,
        timeToGenerateForestTree = timeToGenerateForestTree.toMillis(),
        amountOfForestTreesGenerated = amountOfForestTreesGenerated,
        nextForestTreeAvailableTime = nextForestTreeAvailableTime
    )
}