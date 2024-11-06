package com.gg.spora.library.domain.usecases

import android.util.Log
import com.gg.spora.core.data.INetworkConnectivityChecker
import com.gg.spora.core.utils.exceptions.NoInternetConnectionException
import com.gg.spora.library.data.network.IInfoCardRepositoryNetwork
import com.gg.spora.library.data.repository.IInfoCardRepositoryLocal
import com.gg.spora.library.domain.model.InfoCard
import javax.inject.Inject


/**
 * Use case for inserting a new info card into the database.
 *
 * @param infoCardRepositoryLocal The repository for local operations.
 * @param infoCardRepositoryNetwork The repository for network operations.
 * @param networkInfo The network connectivity checker.
 */

class InsertNewInfoCardUseCase @Inject constructor(
    private val infoCardRepositoryNetwork: IInfoCardRepositoryNetwork,
    private val infoCardRepositoryLocal: IInfoCardRepositoryLocal,
    private val networkInfo: INetworkConnectivityChecker
) {
    suspend operator fun invoke(infoCard: InfoCard) {

        try {
            networkInfo.performNetworkConnectivityCheck()
            Log.d("InsertNewInfoCardUseCase", "Internet connection available")

            infoCardRepositoryNetwork.insertInfoCard(infoCard)
            Log.d("InsertNewInfoCardUseCase", "InfoCard added successfully to Network")

        }catch (e: NoInternetConnectionException) {
            e.printStackTrace()
            Log.d("InsertNewInfoCardUseCase", e.message.toString())
        }
        infoCardRepositoryLocal.insertInfoCard(infoCard)
        Log.d("InsertNewInfoCardUseCase", "InfoCard added successfully to Local")
    }

}