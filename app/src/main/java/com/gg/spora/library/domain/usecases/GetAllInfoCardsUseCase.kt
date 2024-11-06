package com.gg.spora.library.domain.usecases

import android.util.Log
import com.gg.spora.core.data.INetworkConnectivityChecker
import com.gg.spora.core.utils.exceptions.NoInternetConnectionException
import com.gg.spora.library.data.network.IInfoCardRepositoryNetwork
import com.gg.spora.library.data.repository.IInfoCardRepositoryLocal
import com.gg.spora.library.domain.model.InfoCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * @param localRepository local repository for operations
 * @param networkRepository network repository for operations
 * @param networkInfo network connectivity checker
 */
class GetAllInfoCardsUseCase @Inject constructor(
    private val localRepository: IInfoCardRepositoryLocal,
    private val networkRepository: IInfoCardRepositoryNetwork,
    private val networkInfo: INetworkConnectivityChecker
) {

    suspend operator fun invoke(): Flow<List<InfoCard>> {

        var infoCardList: Flow<List<InfoCard>>

        try {
            networkInfo.performNetworkConnectivityCheck()
            Log.d("GetAllInfoCardsUseCase", "Internet connection available")


            updateLocalData(networkRepository.getAllInfoCards().first())
            Log.d("GetAllInfoCardsUseCase", "Local data updated")

            infoCardList = localRepository.getAllInfoCards()
            Log.d("GetAllInfoCardsUseCase", "Local data adquired")

        } catch (e: NoInternetConnectionException) {

            e.printStackTrace()
            Log.d("GetAllInfoCardsUseCase", e.message.toString())

            if (localRepository.getAllInfoCards().first().isNotEmpty()) {
                infoCardList = localRepository.getAllInfoCards()
                Log.d("GetAllInfoCardsUseCase", "Local data adquired")
            } else {
                infoCardList = emptyFlow()
                Log.d("GetAllInfoCardsUseCase", "No data available")
            }
        }
        return infoCardList
    }

    private suspend fun updateLocalData(infoCardList: List<InfoCard>) {

        localRepository.deleteAllInfoCards()
        infoCardList.forEach {
            localRepository.insertInfoCard(it)
        }
    }

}
