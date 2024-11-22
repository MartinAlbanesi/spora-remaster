plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)

    //Dagger Hilt
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)

    // Kotlin Serialization
    alias(libs.plugins.kotlinSerialization)

    // Detekt
    alias(libs.plugins.detekt)

    // Google Services
    alias(libs.plugins.googleServices)

    id("com.google.firebase.crashlytics")

    // Kover
    alias(libs.plugins.kover)
}

android {
    namespace = "com.gg.spora"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.gg.spora"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        mlModelBinding = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    androidResources {
        noCompress += "tflite"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging{
        resources {
            resources.excludes.add("META-INF/LICENSE.md")
            resources.excludes.add("META-INF/LICENSE-notice.md")
        }
    }
    kover {
        reports {
            filters {
                excludes {
                    annotatedBy(
                        "androidx.compose.runtime.Composable",
                        "dagger.internal.DaggerGenerated",
                        "dagger.hilt.android.AndroidEntryPoint",
                        "javax.annotation.processing.Generated"
                    )
                    classes(
                        "dagger.hilt.internal.aggregatedroot.codegen.*",
                        "hilt_aggregated_deps.*",
                        "*ComposableSingletons*",
                        "*_HiltModules*",
                        "*_Impl*",
                        "*Hilt_*",
                        "*BuildConfig",
                        ".*_Factory.*",
                    )
                    packages(
                        "com.gg.spora.core"
                    )
                }
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    testImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Dagger Hilt
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    //Kotlin Serialization
    implementation(libs.kotlinx.serialization.json)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.cloud.messaging)

    //CameraX
    implementation(libs.camerax.core)
    implementation(libs.camerax.lifecycle)
    implementation(libs.camerax.video)
    implementation(libs.camerax.camera2)
    implementation(libs.camerax.extensions)
    implementation(libs.camera.view)

    //TensorFlow
    implementation(libs.tensorflow.gpu)
    implementation(libs.tensorflow.select)
    implementation(libs.tensorflow.support)
    implementation(libs.tensorflow.android)
    implementation(libs.tensorflow.metadata)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    testImplementation(libs.room.testing)
    ksp(libs.room.compiler)

    // Lottie
    implementation(libs.lottie.compose)

    // Splash Screen
    implementation(libs.androidx.core.splashscreen)

    // Coil
    implementation(libs.coil.compose)

    // kotlin corrutines
    testImplementation (libs.kotlinx.coroutines.test)

    // Mockk
    testImplementation (libs.mockk)
    androidTestImplementation (libs.mockk.android)
    androidTestImplementation (libs.mockk.agent)

    // Constraint Layout Compose
    implementation(libs.constraint.layout.compose)

    // Gson
    implementation (libs.converter.gson)

    // Material extend icons
    implementation(libs.androidx.material.icons.extended)

    //Google auth
    //implementation(libs.google.auth)
    implementation("com.google.android.gms:play-services-auth:20.6.0")

}