package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.IStageRepositoryNetwork
import com.gg.spora.forestStage.data.network.models.StageRepositoryNetwork
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.user.domain.GetUserFromDBUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetLevelsUseCase @Inject constructor(
    private val stageRepositoryNetwork: IStageRepositoryNetwork,
    private val getUserFromDBUseCase: GetUserFromDBUseCase
) {
    operator fun invoke(stageType: StageType) : Flow<List<Level>> {

        val userLevelsCompletedFlow = getUserFromDBUseCase()
        val levelsFlow = stageRepositoryNetwork.getLevelsByStageType(stageType)

        val combineLevels = levelsFlow.combine(userLevelsCompletedFlow){ levels, user ->

            val levelsCompleted = user.levelsCompleted.filter { it.stageType == stageType }

            val levelsWithCompleted = levels.map { level ->
                val levelCompleted = levelsCompleted.find { it.levelId == level.id }
                if(levelCompleted != null){
                    level.copy(
                        starState = levelCompleted.starState,
                    )
                } else {
                    level
                }
            }
            levelsWithCompleted
        }

        return combineLevels
    }
}