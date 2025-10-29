package com.gg.spora.core.graph

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
object NavigationRoutes {

    // Auth Graph ------------------------------------------------------

    @Serializable
    object AuthGraph

    @Serializable
    object Welcome

    @Serializable
    data class SignUp(
        val userName: String
    )

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

    @Serializable
    object ProfileScreen

    @Serializable
    data class CreateProfileScreen(
        val userName: String
    )

    @Serializable
    object ChampyChat

    // Game Graph ------------------------------------------------------

    @Serializable
    object GameGraph

    @Serializable
    data class Stage(
        val stageType: String,
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


    // Profile Graph ------------------------------------------------------

    @Serializable
    object SettingGraph

    @Serializable
    object SettingScreen

    @Serializable
    object EditProfileScreen

    @Serializable
    object SupportScreen

    @Serializable
    object NotificationScreen
}