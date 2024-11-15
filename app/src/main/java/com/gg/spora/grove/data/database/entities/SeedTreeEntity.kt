package com.gg.spora.grove.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType

@Entity(tableName = "seed_trees")
data class SeedTreeEntity(
    @PrimaryKey(autoGenerate = false) val idSeedTree: String,
    @ColumnInfo(name = "tree_type") val treeType: String,
    @ColumnInfo(name = "time_to_generate_forest_tree") val timeToGenerateForestTree: Long,
    @ColumnInfo(name = "amount_of_forest_trees_generated") var amountOfForestTreesGenerated: Int = 0,
)

fun SeedTreeEntity.toSeedTree(): SeedTree {
    return SeedTree(
        id = idSeedTree,
        type = TreeType.valueOf(treeType),
        timeToGenerateForestTree = timeToGenerateForestTree
    ).apply {
        amountOfForestTreesGenerated = 0
    }
}