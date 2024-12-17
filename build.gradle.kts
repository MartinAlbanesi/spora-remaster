// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false

    //Dagger Hilt
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false

    // Kotlin Serialization
    alias(libs.plugins.kotlinSerialization) apply false

    // Detekt
    alias(libs.plugins.detekt)

    // Google Services
    alias(libs.plugins.googleServices) apply false

    // Firebase Crashlytics
    alias(libs.plugins.firebaseCrashlytics) apply false

    // Kover
    alias(libs.plugins.kover) apply false

}