package com.gg.spora.forestStage.domain.mappers

import com.gg.spora.forestStage.data.local.models.StageLevelEntity
import com.gg.spora.forestStage.domain.model.StageLevel

fun StageLevel.toStageLevelEntity() : StageLevelEntity {
    return StageLevelEntity(
        id = this.id,
        stageType = this.stageType.name,
        levelPreviewImage = this.levelPreviewImage,
        stageBackgroundImage = this.stageBackgroundImage,
    )
}