package com.gg.spora.library.domain.mappers

import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.library.data.local.entity.InfoCardEntity
import com.gg.spora.library.data.network.InfoCardNetwork
import com.gg.spora.library.domain.model.InfoCard

fun InfoCardNetwork.toInfoCard() = InfoCard(
    id = id ?: "",
    title = title ?: "",
    info = info ?: "",
    image = image ?: "",
    isUnlocked = isUnlocked,
    category = getStageTypeByName(category ?: "")
)

fun InfoCard.toInfoCardEntity() = InfoCardEntity(
    id = id,
    title = title,
    info = info,
    image = image,
    isUnlocked = isUnlocked,
    category = category,
)

fun InfoCardEntity.toInfoCard() = InfoCard(
    id = id,
    title = title,
    info = info,
    image = image,
    isUnlocked = isUnlocked,
    category = category
)