// settings.gradle.kts — 2025-08-10 21:40 PDT
// Settings file including pluginManagement and dependencyResolutionManagement blocks

rootProject.name = "TodoPlus_v1_Startup"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")

// EOF
