package com.gg.spora.stage.domain.mappers

import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.stage.data.local.models.StageLevelEntity
import com.gg.spora.stage.domain.functions.getPathLadderByStageType
import com.gg.spora.stage.domain.model.StageLevel

fun StageLevel.toStageLevelEntity() : StageLevelEntity {
    return StageLevelEntity(
        id = this.id,
        stageType = this.stageType.name,
        levelPreviewImage = this.levelPreviewImage,
        stageBackgroundImage = this.stageBackgroundImage,
    )
}

fun StageLevelEntity.toStageLevel() : StageLevel {
    return StageLevel(
        id = this.id,
        stageType = getStageTypeByName(this.stageType),
        levelPreviewImage = this.levelPreviewImage,
        stageBackgroundImage = this.stageBackgroundImage,
        pathLadder = getPathLadderByStageType(getStageTypeByName(this.stageType)),
    )
}