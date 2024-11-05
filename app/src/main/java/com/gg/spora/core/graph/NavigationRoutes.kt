package com.gg.spora.core.graph

import kotlinx.serialization.Serializable

object NavigationRoutes {

    // Auth Graph ------------------------------------------------------

    @Serializable
    object AuthGraph

    @Serializable
    object Welcome

    @Serializable
    object SignUp

    @Serializable
    object RegisteredLogin

    // Home Graph ------------------------------------------------------

    @Serializable
    object HomeGraph

    @Serializable
    object Home

    @Serializable
    object Grove

    @Serializable
    object Ranking

    // Game Graph ------------------------------------------------------

    @Serializable
    object GameGraph

    @Serializable
    data class Stage(
        val stageType: String = "FOREST",
    )

    @Serializable
    data class QuizGame(
        val title: String,
        val quizCount: Int,
        val imageCount: Int,
        val relationsCount: Int,
        val levelId: String,
        val imageBackground: Int,
        val stageType: String,
        val oxygenRewards: List<Int>,
    )

    // Library Graph ------------------------------------------------------

    @Serializable
    object LibraryGraph

    @Serializable
    object Library

    @Serializable
    object LibraryForestInfo

    @Serializable
    object LibraryDesertInfo

    @Serializable
    object LibraryRiverInfo

    // Challenge Graph ------------------------------------------------------

    @Serializable
    data class Challenge(
        val stageId: String,
        var nameObject: String
    )

    @Serializable
    data class Camera (
        val stageId: String,
        val nameObject: String,
    )

}