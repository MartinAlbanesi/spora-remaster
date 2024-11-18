package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit
import java.util.UUID

/**
 * Data class representing a forest tree.
 * @param id The ID of the tree.
 * @param type The type of the tree.
 * @param currentStage The current growth stage of the tree.
 * @param plantingDate The date the tree was planted.
 * @param position The position of the tree on the forest.
 * @param hasReachedAdultStage Whether the tree has reached the adult stage.
 * @param timesOxygenClaimed The number of times the tree has claimed oxygen.
 * @see Tree
 * @see ForestTreeEntity
 * @see GrowthStage
 * @see TreeType
 */
data class ForestTree(
    override val id: String = UUID.randomUUID().toString(),
    override val type: TreeType,
    var currentStage: GrowthStage = GrowthStage.SPROUT,
    val plantingDate: LocalDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
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
