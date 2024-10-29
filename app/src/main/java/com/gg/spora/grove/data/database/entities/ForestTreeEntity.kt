package com.gg.spora.grove.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.TreeType
import java.time.LocalDateTime

@Entity(tableName = "forest_trees")
data class ForestTreeEntity(
    @PrimaryKey(autoGenerate = true) val idForestTree: Int = 0,
    @ColumnInfo(name = "tree_type") val treeType: TreeType,
    @ColumnInfo(name = "current_stage") val currentStage: GrowthStage,
    @ColumnInfo(name = "planting_date") val plantingDate : LocalDateTime
)