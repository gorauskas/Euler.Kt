@file:Suppress("UnstableApiUsage")
import org.gradle.api.internal.FeaturePreviews.Feature.TYPESAFE_PROJECT_ACCESSORS

rootProject.name = "EulerKt"

enableFeaturePreview(TYPESAFE_PROJECT_ACCESSORS.name)

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}
