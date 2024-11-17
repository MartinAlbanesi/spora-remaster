package com.gg.spora.user.domain

import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getTotalOxygenFromStars
import com.gg.spora.stage.domain.functions.updateOxygenReward
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UpdateObjectDetailChallengeUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val getUserAuthUseCase: GetUserAuthUseCase
) {
    suspend operator fun invoke(
        nameObjectDetail: String
    ) {

        val userLocal = userRepositoryLocal.getUser().first()!!

        //Los params descriptrion e isvalidate no van
        val objectDetail = ObjectDetail(
            nameObjectDetail = nameObjectDetail,
            description = "",
            isValidate = true
        )

        val userObjectsScanned = userLocal.objectsScanned.map{
            if(it.nameObjectDetail == objectDetail.nameObjectDetail) {
                objectDetail
            } else {
                it
            }
        }

        val userUpdated = userLocal.copy(
            objectsScanned = userObjectsScanned
        )

        if(getUserAuthUseCase() != null) {
            userRepositoryNetwork.updateUserById(userUpdated, userLocal.id)
        }

        userRepositoryLocal.updateUserWithChallengeObjectCompleted(userUpdated, objectDetail)


    }
}