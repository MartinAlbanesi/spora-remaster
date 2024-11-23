package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.UUID

/**
 * Data class representing a seed tree.
 * @param id The ID of the tree.
 * @param type The type of the tree.
 * @param timeToGenerateForestTree The time to generate forest trees.
 * @param expectedTimeToGenerateForestTree The expected time to generate forest trees.
 * @param amountOfForestTreesGenerated The amount of forest trees generated.
 * @see Tree
 * @see TreeType
 * @see SeedTreeEntity
 */
data class SeedTree(
    override val id: String = UUID.randomUUID().toString(),
    override val type: TreeType,
    val timeToGenerateForestTree: Long = 5000L,
    val expectedTimeToGenerateForestTree: Long = ( LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + timeToGenerateForestTree),
    var amountOfForestTreesGenerated: Int = 0,
) : Tree(id, type)