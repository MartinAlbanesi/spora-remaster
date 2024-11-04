package com.gg.spora.user.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@Suppress("ForbiddenComment")
class UpdateUserLevelsAndOxygenUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val getUserAuthUseCase: GetUserAuthUseCase
) {
    suspend operator fun invoke(
        levelId: String,
        starState: StarState,
        stageType: StageType,
        oxygen: Int
    ) {
        val userLocal = userRepositoryLocal.getUser().first()!!

        val levelCompleted = LevelCompleted(
            levelId = levelId,
            stageType = stageType,
            starState = starState
        )

        val userLevelCompleted = userLocal.levelsCompleted.toMutableSet()
        userLevelCompleted.add(levelCompleted)

        val userUpdated = userLocal.copy(
            oxygen =+ oxygen,
            levelsCompleted = userLevelCompleted.toList()
        )

        if(getUserAuthUseCase() != null) {
            // TODO: Arreglar el problema que se guarda mal el StarState.
            userRepositoryNetwork.updateUserById(userUpdated, userLocal.id)
        }

        userRepositoryLocal.updateUserWithLevelCompleted(userUpdated, levelCompleted)


    }
}