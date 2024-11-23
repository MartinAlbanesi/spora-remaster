package com.gg.spora.tutorials.domain.mapper

import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.tutorials.data.local.TutorialCompletedEntity
import com.gg.spora.tutorials.domain.model.TutorialCompleted
import com.gg.spora.user.data.network.models.TutorialCompletedNetwork

fun TutorialCompleted.toTutorialCompletedEntity() : TutorialCompletedEntity{
    return TutorialCompletedEntity(
        tutorialId = tutorialId,
        completed = completed,
        tutorialName = tutorialName
    )
}

fun TutorialCompletedEntity.toTutorialCompleted() : TutorialCompleted{
    return TutorialCompleted(
        tutorialId = tutorialId,
        completed = completed,
        tutorialName = tutorialName
    )
}

fun TutorialCompletedNetwork.toTutorialCompleted() : TutorialCompleted{
    return TutorialCompleted(
        tutorialId = tutorialId ?: Tutorials.HOME_TUTORIAL.id,
        completed = completed ?: false,
        tutorialName = tutorialName ?: Tutorials.HOME_TUTORIAL.tutorialName
    )
}