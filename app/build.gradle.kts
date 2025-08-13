// app/build.gradle.kts — 2025-08-12 01:20 PDT
// App module Gradle file: Material3 + Compose + Room + Navigation + Serialization + Biometric

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt") // For Room annotation processing
    id("org.jetbrains.kotlin.plugin.serialization") // For Kotlin Serialization support
}

android {
    namespace = "com.drware.todoplus.v1.startup"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.drware.todoplus.v1.startup"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Compose BOM for version alignment
    implementation(platform("androidx.compose:compose-bom:2025.07.00"))

    // Core Compose libraries
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Lifecycle ViewModel integration for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.2")

    // Kotlin Serialization JSON
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    // Activity Compose support
    implementation("androidx.activity:activity-compose:1.9.0")

    // Material Design Components (classic XML views)
    implementation("com.google.android.material:material:1.12.0")

    // Room database dependencies
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // AndroidX Biometric library
    implementation("androidx.biometric:biometric-ktx:1.4.0-alpha02")
}
