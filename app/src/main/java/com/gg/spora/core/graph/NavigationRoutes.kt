package com.gg.spora.core.graph

import kotlinx.serialization.Serializable

object NavigationRoutes {


    @Serializable
    object Home

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
    object Welcome

    @Serializable
    object SignUp

    @Serializable
    object RegisteredLogin

    @Serializable
    object Grove

    @Serializable
    data class Challenge(
        val stageId: String,
    )

    @Serializable
    object Camera {
        const val route = "camera/{nameObject}"
        fun createRoute(nameObject: String) = "camera/$nameObject"
    }

}