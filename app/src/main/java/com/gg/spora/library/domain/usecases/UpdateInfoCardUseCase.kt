package com.gg.spora.library.domain.usecases

import android.util.Log
import com.gg.spora.core.data.INetworkConnectivityChecker
import com.gg.spora.core.utils.exceptions.NoInternetConnectionException
import com.gg.spora.library.data.network.IInfoCardRepositoryNetwork
import com.gg.spora.library.data.repository.IInfoCardRepositoryLocal
import com.gg.spora.library.domain.model.InfoCard
import javax.inject.Inject

/**
 * @param infoCardRepositoryNetwork repository for network operations
 * @param infoCardRepositoryLocal repository for local operations
 * @param networkInfo network connectivity checker
 */

class UpdateInfoCardUseCase @Inject constructor(
    private val infoCardRepositoryNetwork: IInfoCardRepositoryNetwork,
    private val infoCardRepositoryLocal: IInfoCardRepositoryLocal,
    private val networkInfo: INetworkConnectivityChecker
) {
    suspend operator fun invoke(infoCard: InfoCard) {

        try {
            networkInfo.performNetworkConnectivityCheck()
            Log.d("UpdateInfoCardUseCase", "Internet connection available")

            infoCardRepositoryNetwork.updateInfoCardById(infoCard)
            Log.d("UpdateInfoCardUseCase", "Network InfoCard updated successfully")

        }catch (e: NoInternetConnectionException){
            Log.e("UpdateInfoCardUseCase", e.message.toString())
        }
        infoCardRepositoryLocal.updateInfoCard(infoCard)
        Log.d("UpdateInfoCardUseCase", "Local InfoCard updated successfully")
    }

}