package com.gg.spora.tutorials.domain.mapper

import com.gg.spora.tutorials.data.local.TutorialCompletedEntity
import com.gg.spora.tutorials.domain.model.TutorialCompleted

fun TutorialCompleted.toTutorialCompletedEntity() : TutorialCompletedEntity{
    return TutorialCompletedEntity(
        tutorialId = tutorialId,
        isCompleted = isCompleted,
        tutorialName = tutorialName
    )
}

fun TutorialCompletedEntity.toTutorialCompleted() : TutorialCompleted{
    return TutorialCompleted(
        tutorialId = tutorialId,
        isCompleted = isCompleted,
        tutorialName = tutorialName
    )
}