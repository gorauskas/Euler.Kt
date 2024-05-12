import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension

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

logger.lifecycle("> Using JDK toolchain version: ${java.toolchain.languageVersion.get()}")
logger.lifecycle("> Using Kotlin version: ${extensions.findByType<KotlinTopLevelExtension>()?.coreLibrariesVersion}")

repositories {
    gradlePluginPortal()
    mavenCentral()
}

tasks {
    jar {
        archiveBaseName.set("euler")
        manifest {
            attributes["Main-Class"] = "com.gorauskas.euler.AppKt"
        }
    }
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
