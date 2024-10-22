package com.gg.spora.grove.data

import com.gg.spora.grove.data.models.ForestTree
import com.gg.spora.grove.data.models.SeedTree
import com.gg.spora.grove.data.models.TreeType
import kotlinx.coroutines.flow.Flow

interface IGroveRepository {
    fun getSeedTrees(): Flow<List<SeedTree>>
    fun getForestTrees(): Flow<List<List<ForestTree?>>>
    fun plantForestTree(type: TreeType): ForestTree?
    suspend fun collectOxygen(): Int
}