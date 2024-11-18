package com.gg.spora.grove.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.TreeType
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Entity for forest trees.
 * @param idForestTree The ID of the forest tree.
 * @param treeType The type of the forest tree.
 * @param currentStage The current stage of the forest tree.
 * @param plantingDate The date when the forest tree was planted.
 * @param position The position of the forest tree.
 */
@Entity(tableName = "forest_trees")
data class ForestTreeEntity(
    @PrimaryKey(autoGenerate = false) val idForestTree: String,
    @ColumnInfo(name = "tree_type") val treeType: String,
    @ColumnInfo(name = "current_stage") val currentStage: String,
    @ColumnInfo(name = "planting_date") val plantingDate: Long,
    @ColumnInfo(name = "position") val position: Int
)

// Extension function mapper to convert ForestTreeEntity to ForestTree
fun ForestTreeEntity.toForestTree(): ForestTree {
    return ForestTree(
        id = idForestTree,
        type = TreeType.valueOf(treeType),
        currentStage = GrowthStage.valueOf(currentStage),
        plantingDate = LocalDateTime.ofEpochSecond(plantingDate, 0, ZoneOffset.UTC),
        position = position
    )
}