package com.gg.spora.core.graph

import kotlinx.serialization.Serializable

object NavigationRoutes {

    @Serializable
    object Home

    @Serializable
    object ForestStage

    @Serializable
    data class QuizGame(
        val title: String
    )

    @Serializable
    object Welcome

    @Serializable
    object Grove

    @Serializable
    object Ranking

    @Serializable
    object Challenge

    @Serializable
    data class QuizImage(
        val title: String
    )

    @Serializable
    object Camera {
        const val route = "camera/{nameObject}"
        fun createRoute(nameObject: String) = "camera/$nameObject"
    }

    @Serializable
    data class RelationsGame(
        val title: String
    )

}