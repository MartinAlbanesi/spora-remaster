package com.gg.spora.grove.data

import com.gg.spora.grove.data.models.ForestTree
import com.gg.spora.grove.data.models.Seed
import com.gg.spora.grove.data.models.SeedTree
import kotlinx.coroutines.flow.Flow

interface IGroveRepository {
    fun getSeedTrees(): Flow<List<SeedTree>>
    fun getForestTrees(): Flow<List<List<ForestTree?>>>
    suspend fun plantSeed(seed: Seed): ForestTree?
    suspend fun collectOxygen(): Int
}