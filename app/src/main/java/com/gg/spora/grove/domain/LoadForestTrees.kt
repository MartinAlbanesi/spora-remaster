package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree

class LoadForestTrees(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): MutableList<ForestTree?> {
        val forestTreesList = mutableListOf<ForestTree?>()
        groveRepository.loadForestTreesFromDatabase().collect { forestTrees ->
            forestTrees.forEach { forestTrees ->
                forestTreesList.add(forestTrees)
            }
        }
        return forestTreesList
    }

}