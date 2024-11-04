// RankingViewModel.kt
package com.gg.spora.ranking.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class RankingItem(
    val username: String,
    val userImageResId: Int,
    val treesCount: Int,
    val o2Count: Int
)

class RankingViewModel : ViewModel() {

    private val _rankingItems = MutableStateFlow<List<RankingItem>>(emptyList())
    val rankingItems: StateFlow<List<RankingItem>> = _rankingItems

    init {
        loadRankingData()
    }

    private fun loadRankingData() {
        viewModelScope.launch {
            // Simulate loading data from a repository or network
            val items = listOf(
                RankingItem("User1", R.drawable.user_image, 42, 100),
                RankingItem("User2", R.drawable.user_image, 35, 90),
                RankingItem("User3", R.drawable.user_image, 89, 1300),
                RankingItem("User4", R.drawable.user_image, 35, 90),
                RankingItem("User5", R.drawable.user_image, 35, 90),
                RankingItem("User6", R.drawable.user_image, 35, 90),
                // Add more items as needed
            )
            _rankingItems.value = sortRankingItemsByO2Count(items)
        }
    }

    private fun sortRankingItemsByO2Count(items: List<RankingItem>): List<RankingItem> {
        return items.sortedByDescending { it.o2Count }
    }
}
