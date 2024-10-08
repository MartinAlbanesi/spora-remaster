package com.gg.spora.core.graph

import kotlinx.serialization.Serializable

sealed class NavigationRoutes {

    @Serializable
    object Home

    @Serializable
    data class ForestStage(
        val oxygen: Int,
//        val background: Int,
    )

    @Serializable
    data class QuizGame(
        val title: String
    ): NavigationRoutes()

    @Serializable
    object Welcome

    @Serializable
    object Grove

    @Serializable
    data class Challenge(
        val title: String
    ): NavigationRoutes()

    @Serializable
    data class QuizImage(
        val title: String
    ): NavigationRoutes()

    @Serializable
    data class RelationsGame(
        val title: String
    ): NavigationRoutes()


}