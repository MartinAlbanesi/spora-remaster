package com.gg.spora.core.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavBackStackEntry


fun screenFadeWithSlideInToLeft(scope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    return scope.run {
        fadeIn(
            animationSpec = tween(
                250, easing = FastOutLinearInEasing
            )
        ) +
                slideIntoContainer(
                    animationSpec = tween(250, easing = FastOutLinearInEasing),
                    towards = AnimatedContentTransitionScope.SlideDirection.Up
                )
    }
}

fun screenFadeWithSlideOutToRight(scope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    return scope.run {
        fadeOut(
            animationSpec = tween(
                250, easing = FastOutLinearInEasing
            )
        ) +
                slideOutOfContainer(
                    animationSpec = tween(250, easing = FastOutLinearInEasing),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                )
    }
}
