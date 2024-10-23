package com.gg.spora.grove.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.grove.domain.models.TreeType
import java.time.Duration
import java.util.UUID

@Entity(tableName = "seed_trees")
data class SeedTreeEntity(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id_seed_tree") val idSeedTree: UUID,
    @ColumnInfo(name = "tree_type") val treeType: TreeType,
    @ColumnInfo(name = "next_forest_tree_available_time") val nextForestTreeAvailableTime: Long,
    @ColumnInfo(name = "time_to_generate_forest_tree") val timeToGenerateForestTree: Duration,
    @ColumnInfo(name = "amountOfForestTreesGenerated") var amountOfForestTreesGenerated: Int,
)