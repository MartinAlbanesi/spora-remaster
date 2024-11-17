package com.gg.spora.user.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.functions.getTotalOxygenFromStars
import com.gg.spora.stage.domain.functions.updateOxygenReward
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case to update the user's levels and oxygen
 * @param levelId: String
 * @param starState: StarState
 * @param stageType: StageType
 * @param oxygenRewards: List<Int>
 */
class UpdateUserLevelsAndOxygenUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val getUserAuthUseCase: GetUserAuthUseCase
) {
    suspend operator fun invoke(
        levelId: String,
        starState: StarState,
        stageType: StageType,
        oxygenRewards: List<Int>
    ) {

        var totalOxygenList: List<Int> = emptyList()
        var totalOxygen = 0

        val userLocal = userRepositoryLocal.getUser().first()!!

        val currentUserLevelCompleted = userLocal.levelsCompleted.find { it.levelId == levelId }

        currentUserLevelCompleted?.let {

            if(currentUserLevelCompleted.starState.starCount >= starState.starCount) {
                return
            }
            totalOxygenList = updateOxygenReward(currentUserLevelCompleted.starState, oxygenRewards)

            println("totalOxygenList 1: $totalOxygenList")

            totalOxygen = getTotalOxygenFromStars(starState, totalOxygenList)

            println("totalOxygen 1: $totalOxygen")

        }

        println("totalOxygenList 2: $totalOxygenList")
        println("totalOxygen 2: $totalOxygen")

        if (totalOxygenList.isEmpty()) {
            totalOxygenList = oxygenRewards
            totalOxygen = getTotalOxygenFromStars(starState, totalOxygenList)
        }

        println("totalOxygenList 3: $totalOxygenList")
        println("totalOxygen 3: $totalOxygen")

        val levelCompleted = LevelCompleted(
            levelId = levelId,
            stageType = stageType,
            starState = starState
        )

        val userLevelCompleted = userLocal.levelsCompleted.map{
            if(it.levelId == levelCompleted.levelId) {
                levelCompleted
            } else {
                it
            }
        }

        val userUpdated = userLocal.copy(
            oxygen = userLocal.oxygen + totalOxygen,
            levelsCompleted = userLevelCompleted
        )

        if(getUserAuthUseCase() != null) {
            userRepositoryNetwork.updateUserById(userUpdated, userLocal.id)
        }

        userRepositoryLocal.updateUserWithLevelCompleted(userUpdated, levelCompleted)


    }
}