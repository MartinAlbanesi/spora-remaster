package com.gg.spora.grove.domain

import android.util.Log
import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree

class SaveForestTreesUseCase(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(forestTrees: List<ForestTree?>) {
        Log.i("GroveViewModel", "USE CASE Saving forest trees")
        groveRepository.saveForestTrees(forestTrees)
    }
}