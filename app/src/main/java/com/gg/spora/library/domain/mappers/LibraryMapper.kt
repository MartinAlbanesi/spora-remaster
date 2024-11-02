package com.gg.spora.library.domain.mappers

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.local.entity.InfoCardEntity
import com.gg.spora.library.data.network.InfoCardNetwork
import com.gg.spora.library.domain.model.InfoCard

fun InfoCardNetwork.toInfoCard() = InfoCard(
    id = id ?: 0,
    title = title ?: "",
    info = info ?: "",
    image = image ?: 0,
    isUnlocked = isUnlocked == false,
    category = (category ?: StageType.FOREST) as StageType
)

fun InfoCard.toInfoCardEntity() = InfoCardEntity(
    id = id,
    title = title,
    info = info,
    image = image,
    isUnlocked = isUnlocked,
    category = category,
)