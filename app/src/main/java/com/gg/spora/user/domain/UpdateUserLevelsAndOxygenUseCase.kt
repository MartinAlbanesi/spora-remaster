package com.gg.spora.user.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UpdateUserLevelsAndOxygenUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val getUserAuthUseCase: GetUserAuthUseCase
) {
    suspend operator fun invoke(
        userId: String,
        levelId: String,
        starState: StarState,
        stageType: StageType,
        oxygen: Int
    ) {
        val userLocal = userRepositoryLocal.getUser().first()

        val levelCompleted = LevelCompleted(
            levelId = levelId,
            stageType = stageType,
            starState = starState
        )

        val userUpdated = userLocal!!.copy(
            oxygen =+ oxygen,
            levelsCompleted = userLocal.levelsCompleted.toMutableList().apply {
                add(levelCompleted)
            }
        )

        userRepositoryLocal.updateUserWithLevelCompleted(userUpdated, levelCompleted)

        if(getUserAuthUseCase() != null) {
            userRepositoryNetwork.updateUserById(userUpdated, userId)
        }
    }
}