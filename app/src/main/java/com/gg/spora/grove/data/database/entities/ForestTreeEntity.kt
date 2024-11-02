package com.gg.spora.grove.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.TreeType
import java.time.LocalDateTime
import java.time.ZoneOffset

@Entity(tableName = "forest_trees")
data class ForestTreeEntity(
    @PrimaryKey(autoGenerate = true) val idForestTree: Int = 0,
    @ColumnInfo(name = "tree_type") val treeType: String,
    @ColumnInfo(name = "current_stage") val currentStage: String,
    @ColumnInfo(name = "planting_date") val plantingDate : Long,
    @ColumnInfo(name = "position") val position: Int
)

fun ForestTreeEntity.toForestTree(): ForestTree {
    return ForestTree(
        id = idForestTree,
        type = TreeType.valueOf(treeType), // Convert String to TreeType using valueOf
        currentStage = GrowthStage.valueOf(currentStage), // Assuming currentStage is already a String
        plantingDate = LocalDateTime.ofEpochSecond(plantingDate, 0, ZoneOffset.UTC), // Convert Long to LocalDateTime
        position = position
    )
}