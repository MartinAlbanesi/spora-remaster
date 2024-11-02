package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.user.domain.GetUserNetworkUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

/**
 * Caso de uso que devuelve los niveles de un tipo de escenario
 * con la información de si el usuario ha completado el nivel
 * y con cuantas estrellas lo ha completado.
 */
class GetLevelsUseCase @Inject constructor(
    private val stageRepositoryNetwork: IStageRepositoryNetwork,
    private val getUserNetworkUseCase: GetUserNetworkUseCase
) {
    operator fun invoke(stageType: StageType) : Flow<List<Level>> {

        val userLevelsCompletedFlow = getUserNetworkUseCase()
        val levelsFlow = stageRepositoryNetwork.getLevelsByStageType(stageType)

        val combineLevels = levelsFlow.combine(userLevelsCompletedFlow){ levels, user ->

            val levelsCompleted = user.levelsCompleted.filter { it.stageType == stageType }

            val levelsWithCompleted = levels.map { level ->
                val levelCompleted = levelsCompleted.find { it.levelId == level.id }
                if(levelCompleted != null){
                    level.copy(
                        starState = levelCompleted.starState,
                        isComplete = true
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