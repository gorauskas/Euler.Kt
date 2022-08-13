import kotlin.math.max

plugins {
    kotlin("jvm") version Versions.kotlin
    id("com.adarshr.test-logger") version Versions.testLogger
    id("io.gitlab.arturbosch.detekt") version Versions.detekt
    id("idea")
    id("java")
    application
}

group "com.gorauskas"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", Versions.kotlin)
    implementation("org.jetbrains.kotlin", "kotlin-stdlib", Versions.kotlin)
    implementation("com.github.ajalt.clikt", "clikt", Versions.clikt)
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core-jvm", Versions.kotlinCoroutines)
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-reactor", Versions.kotlinCoroutines)
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8", Versions.kotlinCoroutines)
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-test", Versions.kotlinCoroutines)
    testImplementation("org.junit.jupiter", "junit-jupiter", Versions.junit)
    testImplementation("org.junit.jupiter", "junit-jupiter-api", Versions.junit)
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", Versions.junit)
    detektPlugins("io.gitlab.arturbosch.detekt", "detekt-formatting", Versions.detekt)
}

sourceSets {
    main{
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

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

detekt {
    toolVersion = Versions.detekt
    config = files("${rootDir.path}/detekt.yml")
    source = files("src/main/kotlin", "src/test/kotlin")
}
