package com.gg.spora.library.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.data.repository.InfoCardRepositoryLocal
import com.gg.spora.library.data.local.entity.InfoCardEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val infoCardRepositoryLocal: InfoCardRepositoryLocal,
    private val infoCardFakeRepository: FakeRepositoryInfoCard
) : ViewModel() {

    private val _infoCardEntityList = MutableStateFlow<List<InfoCardEntity>>(emptyList())
    val infoCardEntityList: StateFlow<List<InfoCardEntity>> = _infoCardEntityList

    init {
        viewModelScope.launch {

            if (infoCardRepositoryLocal.getAllInfoCards().isEmpty()) {
                infoCardFakeRepository.getAllInfoCards().forEach {
                    infoCardRepositoryLocal.insertInfoCard(it)
                }
                Log.d("LibraryViewModel", "Fake data inserted")
            }
            _infoCardEntityList.value = infoCardRepositoryLocal.getAllInfoCards()
        }
    }

    private fun deleteAllInfoCards() {
        _infoCardEntityList.value = emptyList()
    }

    private fun getInfoCardListByCategory(category: StageType): List<InfoCardEntity> {
        return _infoCardEntityList.value.filter { it.category == category }
    }

    fun getForestInfoCards(): List<InfoCardEntity> {
        return getInfoCardListByCategory(StageType.FOREST)
    }

    fun getRiverInfoCards(): List<InfoCardEntity> {
        return getInfoCardListByCategory(StageType.RIVER)
    }

    fun getDesertInfoCards(): List<InfoCardEntity> {
        return getInfoCardListByCategory(StageType.DESERT)
    }

    fun getAllInfoCards(): List<InfoCardEntity> {
        return _infoCardEntityList.value
    }

    fun unlockInfoCard(infoCardEntity: InfoCardEntity) {
        viewModelScope.launch {
            infoCardEntity.isUnlocked = true
            infoCardRepositoryLocal.updateInfoCard(infoCardEntity)
        }
    }

    private fun searchInfoCardById(id: Int): InfoCardEntity? {
        var auxInfoCardEntity: InfoCardEntity? = null

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