package com.gg.spora.core.graph

import kotlinx.serialization.Serializable

object NavigationRoutes {

    @Serializable
    object Home

    @Serializable
    data class ForestStage(
        val oxygen: Int,
//        val background: Int,
    )

    @Serializable
    object QuizGame

    @Serializable
    object Welcome

    @Serializable
    object Grove

    @Serializable
    object Challenge

    @Serializable
    object QuizImage

    @Serializable
    object Camera {
        const val route = "camera/{nameObject}"
        fun createRoute(nameObject: String) = "camera/$nameObject"
    }

    @Serializable
    object RelationsGame

}