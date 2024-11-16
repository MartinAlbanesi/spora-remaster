package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.UUID

/**
 * Clase ForestTree que gestiona el crecimiento y la generación de oxígeno en un árbol del bosque
 * @param id Identificador único del árbol
 * @param type Tipo de árbol
 * @param plantingDate Fecha de plantación del árbol
 */

data class ForestTree(
    override val id: String = UUID.randomUUID().toString(),
    override val type: TreeType,
    var currentStage: GrowthStage = GrowthStage.SPROUT,
    val plantingDate: LocalDateTime = LocalDateTime.now(),
    var position: Int = 0,
    var hasReachedAdultStage: Boolean = false,
    var timesOxygenClaimed: Int = 0,
) : Tree(id, type)

fun ForestTree.toForestTreeEntity(): ForestTreeEntity {
    return ForestTreeEntity(
        idForestTree = id,
        treeType = type.name,
        currentStage = currentStage.toString(),
        plantingDate = plantingDate.toEpochSecond(ZoneOffset.UTC),
        position = position
    )
}
