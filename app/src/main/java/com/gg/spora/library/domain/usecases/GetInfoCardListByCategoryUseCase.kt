package com.gg.spora.library.domain.usecases

import android.util.Log
import com.gg.spora.library.data.repository.IInfoCardRepositoryLocal
import com.gg.spora.library.domain.model.InfoCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * @param localRepository local repository for info cards
 */
class GetInfoCardListByCategoryUseCase @Inject constructor(
    private val localRepository: IInfoCardRepositoryLocal,
) {
    suspend fun invoke(category: String): Flow<List<InfoCard>> {
        val filterList = localRepository.getInfoCardListByCategory(category)
        Log.d(
            "GetInfoCardListByCategoryUseCase",
            "Categoria: $category, Cantidad de infocards: ${filterList.first().size}"
        )
        return filterList
    }
}