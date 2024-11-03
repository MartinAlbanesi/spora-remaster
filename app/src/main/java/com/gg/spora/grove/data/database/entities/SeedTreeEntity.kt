package com.gg.spora.grove.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import java.time.Duration

@Entity(tableName = "seed_trees")
data class SeedTreeEntity(
    @PrimaryKey(autoGenerate = true) val idSeedTree: Int = 0,
    @ColumnInfo(name = "tree_type") val treeType: String,
    @ColumnInfo(name = "time_to_generate_forest_tree") val timeToGenerateForestTree: Long,
    @ColumnInfo(name = "next_forest_tree_available_time") val nextForestTreeAvailableTime: Long = 0,
    @ColumnInfo(name = "amount_of_forest_trees_generated") var amountOfForestTreesGenerated: Int = 0,
)

fun SeedTreeEntity.toSeedTree(): SeedTree {
    return SeedTree(
        id = idSeedTree,
        type = TreeType.valueOf(treeType),
        timeToGenerateForestTree = Duration.ofMillis(timeToGenerateForestTree)
    ).apply {
        amountOfForestTreesGenerated = 444
        nextForestTreeAvailableTime = 555L
    }
}