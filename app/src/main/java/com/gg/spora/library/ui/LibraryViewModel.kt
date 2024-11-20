package com.gg.spora.library.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.domain.model.InfoCard
import com.gg.spora.library.domain.usecases.GetAllInfoCardsUseCase
import com.gg.spora.library.domain.usecases.GetInfoCardListByCategoryUseCase
import com.gg.spora.library.domain.usecases.InsertNewInfoCardUseCase
import com.gg.spora.library.domain.usecases.UpdateInfoCardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val getAllInfoCardsUseCase: GetAllInfoCardsUseCase,
    private val insertInfoCardUseCase: InsertNewInfoCardUseCase,
    private val updateInfoCardUseCase: UpdateInfoCardUseCase,
    private val getInfoCardListByCategoryUseCase: GetInfoCardListByCategoryUseCase
) : ViewModel() {

    private val _infoCardEntityList = MutableStateFlow<List<InfoCard>>(emptyList())
    val infoCardEntityList: StateFlow<List<InfoCard>> = _infoCardEntityList

    init {
        viewModelScope.launch {
            loadInfoCardList()
        }
    }

    private suspend fun loadInfoCardList() {

        val currentInfoCards = getAllInfoCardsUseCase.invoke().first()
        _infoCardEntityList.value = currentInfoCards

    }

    fun getInfoCardListByCategory(category: StageType) {
        viewModelScope.launch {
            _infoCardEntityList.value =
                getInfoCardListByCategoryUseCase.invoke(category.name).first()
        }
    }

fun insertNewInfoCard(infoCard: InfoCard) {
    viewModelScope.launch {
        insertInfoCardUseCase.invoke(infoCard)
        loadInfoCardList()
    }
}

fun updateInfoCard(infoCard: InfoCard) {
    viewModelScope.launch {
        updateInfoCardUseCase.invoke(infoCard)
        loadInfoCardList()
    }
}

}
