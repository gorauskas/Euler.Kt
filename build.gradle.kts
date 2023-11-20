import io.gitlab.arturbosch.detekt.Detekt

plugins {
    idea
    java
    application
    kotlin("jvm") version libs.versions.kotlin.lang.get()
    alias(libs.plugins.test.logger)
    alias(libs.plugins.detekt)
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

sourceSets {
    main {
        java {
            srcDirs("$projectDir/src/main/kotlin/")
        }
    }
    test {
        java {
            srcDirs("$projectDir/src/test/kotlin/")
        }
    }
}

tasks {
    jar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        archiveBaseName.set("euler")
        manifest {
            attributes["Main-Class"] = "com.gorauskas.euler.AppKt"
        }
        from(sourceSets.main.get().output)
        dependsOn(configurations.runtimeClasspath)
        from({
            configurations.runtimeClasspath.get().map {
                if (it.isDirectory)
                    it
                else
                    zipTree(it)
            }
        })
    }
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "17"
}

tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "17"
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<Detekt>().configureEach {
    reports {
        xml.required.set(true)
        html.required.set(true)
        txt.required.set(false)
        sarif.required.set(false)
        md.required.set(false)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

detekt {
    allRules = true
    parallel = true
    buildUponDefaultConfig = true
    toolVersion = libs.versions.detekt.get()
    config.from(files("${rootDir.path}/detekt.yml"))
    source.from(files("src/main/kotlin", "src/test/kotlin"))
}
