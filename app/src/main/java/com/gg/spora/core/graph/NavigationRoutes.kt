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

    // Game Graph ------------------------------------------------------

    @Serializable
    object GameGraph

    @Serializable
    data class Stage(
        val stageId: String = "1",
    )

    @Serializable
    data class QuizGame(
        val title: String,
        val quizCount: Int,
        val imageCount: Int,
        val relationsCount: Int,
        val levelId: String,
        val imageBackground: Int,
        val stageId: String,
    )


    @Serializable
    data class Challenge(
        val stageId: String,
        val nameObject: String
    )

    @Serializable
    data class Camera (
        val stageId: String,
        val nameObject: String,
    )

}