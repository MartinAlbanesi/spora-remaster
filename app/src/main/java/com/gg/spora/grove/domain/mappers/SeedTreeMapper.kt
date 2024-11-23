package com.gg.spora.grove.domain.mappers

import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import com.gg.spora.grove.data.network.models.SeedTreeNetwork
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType

fun SeedTreeNetwork.toSeedTree() : SeedTree {
    return SeedTree(
        id = id ?: "",
        type = TreeType.valueOf(treeType.toString()),
        timeToGenerateForestTree = timeToGenerateForestTree ?: 0L,
        expectedTimeToGenerateForestTree = expectedTimeToGenerateForestTree ?: 0L,
        amountOfForestTreesGenerated = amountOfForestTreesGenerated ?: 0
    )
}

fun SeedTree.toSeedTreeNetwork() : SeedTreeNetwork {
    return SeedTreeNetwork(
        id = id,
        treeType = type.name,
        timeToGenerateForestTree = timeToGenerateForestTree,
        expectedTimeToGenerateForestTree = expectedTimeToGenerateForestTree,
        amountOfForestTreesGenerated = amountOfForestTreesGenerated
    )
}

// Extension function mapper to convert SeedTree to SeedTreeEntity
fun SeedTree.toSeedTreeEntity(): SeedTreeEntity {
    return SeedTreeEntity(
        idSeedTree = id,
        treeType = type.name,
        timeToGenerateForestTree = timeToGenerateForestTree,
        amountOfForestTreesGenerated = amountOfForestTreesGenerated,
    )
}

// Extension function mapper to convert ForestTreeEntity to ForestTree
fun SeedTreeEntity.toSeedTree(): SeedTree {
    return SeedTree(
        id = idSeedTree,
        type = TreeType.valueOf(treeType),
        timeToGenerateForestTree = timeToGenerateForestTree,
        amountOfForestTreesGenerated = amountOfForestTreesGenerated,
    )
}