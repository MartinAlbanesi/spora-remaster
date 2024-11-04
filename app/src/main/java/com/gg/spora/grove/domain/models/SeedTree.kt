package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Clase SeedTree que representa un árbol semillero del bosque, capaz de generar semillas a un tiempo determinado
 * @param id Identificador único del árbol semillero
 * @param type Tipo de árbol
 * @param timeToGenerateForestTree Tiempo en milisegundos para generar un árbol del bosque
 */
data class SeedTree(
    override val id: Int = 0,
    override val type: TreeType,
    val timeToGenerateForestTree: Long = 5000L,
    val expectedTimeToGenerateForestTree: Long = ( LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + timeToGenerateForestTree),
    var amountOfForestTreesGenerated: Int = 0,
//    var nextForestTreeAvailableTime: Long = 0L
) : Tree(id, type)

fun SeedTree.toSeedTreeEntity(): SeedTreeEntity {
    return SeedTreeEntity(
        idSeedTree = id,
        treeType = type.name,
        timeToGenerateForestTree = timeToGenerateForestTree,
        amountOfForestTreesGenerated = amountOfForestTreesGenerated,
    )
}