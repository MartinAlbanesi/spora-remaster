package com.gg.spora.library.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.local.entity.InfoCardEntity
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.data.repository.InfoCardRepositoryLocal
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.library.domain.model.InfoCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val infoCardRepositoryLocal: InfoCardRepositoryLocal,
    private val infoCardFakeRepository: FakeRepositoryInfoCard,
) : ViewModel() {

    private val _infoCardEntityList = MutableStateFlow<List<InfoCard>>(emptyList())
    val infoCardEntityList: StateFlow<List<InfoCard>> = _infoCardEntityList

    init {
        viewModelScope.launch {
            loadInfoCardList()
        }
    }

    private suspend fun loadInfoCardList() {
        val currentInfoCards = infoCardRepositoryLocal.getAllInfoCards().first() // Get initial data
        _infoCardEntityList.value = currentInfoCards

        if (currentInfoCards.isEmpty()) {
            infoCardFakeRepository.getAllInfoCards().forEach {
                infoCardRepositoryLocal.insertInfoCard(it.toInfoCard())
            }
            Log.d("LibraryViewModel", "Fake data inserted")
            // Refresh the list after inserting fake data
            _infoCardEntityList.value = infoCardRepositoryLocal.getAllInfoCards().first()
        }
    }

    fun getInfoCardListByCategory(category: StageType) {
        viewModelScope.launch {
            infoCardRepositoryLocal.getInfoCardListByCategory(category.name).collect {
                _infoCardEntityList.value = it
            }
        }
    }

    fun unlockInfoCard(infoCardEntity: InfoCardEntity) {
        viewModelScope.launch {
            infoCardEntity.isUnlocked = true
            infoCardRepositoryLocal.updateInfoCard(infoCardEntity.toInfoCard())
        }
    }

    private fun searchInfoCardById(id: Int): InfoCard? {
        var auxInfoCardEntity: InfoCard? = null

        try {
            viewModelScope.launch {
                auxInfoCardEntity = infoCardRepositoryLocal.getInfoCardById(id)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return auxInfoCardEntity
    }
}