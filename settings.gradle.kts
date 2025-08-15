// [2025-08-15 17:34] settings.gradle.kts - Kotlin DSL version

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TodoPlus_v1_Startup"
include(":app")

// EOF
