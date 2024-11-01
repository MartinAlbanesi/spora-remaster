package com.gg.spora.library.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.data.repository.InfoCardRepository
import com.gg.spora.library.domain.InfoCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val infoCardRepository: InfoCardRepository,
    private val infoCardFakeRepository: FakeRepositoryInfoCard
) : ViewModel() {

    private val _infoCardList = MutableStateFlow<List<InfoCard>>(emptyList())
    val infoCardList: StateFlow<List<InfoCard>> = _infoCardList

    init {
        viewModelScope.launch {
            if (infoCardRepository.getAllInfoCards().isEmpty()) {
                infoCardFakeRepository.getAllInfoCards().forEach {
                    infoCardRepository.insertInfoCard(it)
                }
            }
            _infoCardList.value = infoCardRepository.getAllInfoCards()
        }
    }

    private fun deleteAllInfoCards() {
        _infoCardList.value = emptyList()
    }

    private fun getInfoCardListByCategory(category: TypeStage): List<InfoCard> {
        return _infoCardList.value.filter { it.category == category }
    }

    fun getForestInfoCards(): List<InfoCard> {
        return getInfoCardListByCategory(TypeStage.FOREST)
    }

    fun getRiverInfoCards(): List<InfoCard> {
        return getInfoCardListByCategory(TypeStage.RIVER)
    }

    fun getDesertInfoCards(): List<InfoCard> {
        return getInfoCardListByCategory(TypeStage.DESERT)
    }

    fun getAllInfoCards(): List<InfoCard> {
        return _infoCardList.value
    }

    fun UnlockInfoCard(infoCard: InfoCard) {
        viewModelScope.launch {
            infoCardRepository.updateInfoCard(infoCard)
        }
    }

    private fun SearchInfoCardById(id: Int): InfoCard? {
        var auxInfoCard: InfoCard? = null

        try {
            viewModelScope.launch {
                auxInfoCard = infoCardRepository.getInfoCardById(id)
            }
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return auxInfoCard
    }
}