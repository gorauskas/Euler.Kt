import com.gradle.scan.agent.serialization.scan.serializer.kryo.it

plugins {
    // id("local.build-conventions")
    idea
    java
    application
    kotlin("jvm") version libs.versions.kotlin.lang.get()
    id("local.build-conventions")
    id("local.code-analysis")
    id("local.dependency-analysis")
    id("local.testing")
}

group = "com.gorauskas"
version = "1.2.0"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    listOf(
        libs.kotlin.stdlib.core,
        libs.kotlin.stdlib.jdk8,
        libs.kotlinx.coroutines.core.jvm,
        libs.kotlinx.coroutines.jdk8,
        libs.kotlinx.coroutines.reactor,
        libs.kotlinx.coroutines.test,
        libs.clikt,
    ).forEach {
        implementation(it)
    }

    listOf(
        libs.junit.jupiter.core,
        libs.junit.jupiter.api,
        libs.junit.jupiter.engine,
    ).forEach {
        testImplementation(it)
    }

    detektPlugins(libs.detekt.formatting)
}
