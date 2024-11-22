package com.gg.spora.grove.domain.mappers

import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import com.gg.spora.grove.data.network.models.ForestTreeNetwork
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.TreeType
import java.time.LocalDateTime
import java.time.ZoneOffset

fun ForestTreeNetwork.toForestTree() : ForestTree{
    return ForestTree(
        id = id,
        type = TreeType.valueOf(treeType),
        currentStage = currentStage,
        plantingDate = plantingDate,
        position = position,
        timesOxygenClaimed = timesOxygenClaimed,
        hasReachedAdultStage = hasReachedAdultStage
    )
}

fun ForestTree.toForestTreeNetwork() : ForestTreeNetwork{
    return ForestTreeNetwork(
        id = id,
        treeType = type.name,
        currentStage = currentStage,
        plantingDate = plantingDate,
        position = position,
        timesOxygenClaimed = timesOxygenClaimed,
        hasReachedAdultStage = hasReachedAdultStage
    )
}

fun ForestTree.toForestTreeEntity(): ForestTreeEntity {
    return ForestTreeEntity(
        idForestTree = id,
        treeType = type.name,
        currentStage = currentStage.toString(),
        plantingDate = plantingDate.toEpochSecond(ZoneOffset.UTC),
        position = position,
        timesOxygenClaimed = timesOxygenClaimed
    )
}

// Extension function mapper to convert ForestTreeEntity to ForestTree
fun ForestTreeEntity.toForestTree(): ForestTree {
    return ForestTree(
        id = idForestTree,
        type = TreeType.valueOf(treeType),
        currentStage = GrowthStage.valueOf(currentStage),
        plantingDate = LocalDateTime.ofEpochSecond(plantingDate, 0, ZoneOffset.UTC),
        position = position,
        timesOxygenClaimed = timesOxygenClaimed
    )
}

fun List<ForestTreeEntity>.toForestList() : List<ForestTree>{
    return map { it.toForestTree() }
}
