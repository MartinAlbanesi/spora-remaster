package com.gg.spora.library.domain.usecases

import com.gg.spora.library.data.network.IInfoCardRepositoryNetwork
import com.gg.spora.library.data.repository.IInfoCardRepositoryLocal
import com.gg.spora.library.domain.model.InfoCard
import javax.inject.Inject

class UpdateInfoCardUseCase @Inject constructor(
    private val infoCardRepositoryNetwork: IInfoCardRepositoryNetwork,
    private val infoCardRepositoryLocal: IInfoCardRepositoryLocal
) {
    suspend operator fun invoke(infoCard: InfoCard) {
        infoCardRepositoryNetwork.updateInfoCardById(infoCard)
        infoCardRepositoryLocal.updateInfoCard(infoCard)
    }

}