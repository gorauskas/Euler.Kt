import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

val javaVersion = 17
val kotlinVersion = KotlinVersion.KOTLIN_1_9

configure<KotlinJvmProjectExtension> {
    jvmToolchain(javaVersion)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
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
    compileKotlin {
        kotlinOptions.jvmTarget = javaVersion.toString()
        compilerOptions {
            freeCompilerArgs.addAll("-Xjsr305=strict", "-opt-in=kotlin.RequiresOptIn")
            languageVersion.set(kotlinVersion)
            apiVersion.set(kotlinVersion)
            jvmTarget.set(JvmTarget.fromTarget(javaVersion.toString()))
        }
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = javaVersion.toString()
    }
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
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true
    }
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
    resolutionStrategy.cacheDynamicVersionsFor(0, TimeUnit.SECONDS)
}

// Align kotlin version with the version used in the kotlin jvm plugin,
// except for detekt since it requires a specific kotlin version
configurations.matching { it.name != "detekt" }.configureEach {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin") {
            useVersion("1.9.21")
        }
    }
}
