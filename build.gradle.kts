import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.adarshr.test-logger") version "3.2.0"
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
    id("idea")
    id("java")
    application
}

group = "com.gorauskas"
version = "1.2.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", "1.7.10")
    implementation("org.jetbrains.kotlin", "kotlin-stdlib", "1.7.10")
    implementation("com.github.ajalt.clikt", "clikt", "3.5.0")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core-jvm", "1.6.4")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-reactor", "1.6.4")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8", "1.6.4")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-test", "1.6.4")
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.9.0")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.9.0")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.9.0")
    detektPlugins("io.gitlab.arturbosch.detekt", "detekt-formatting", "1.21.0")
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
    toolVersion = "1.21.0"
    config = files("${rootDir.path}/detekt.yml")
    source = files("src/main/kotlin", "src/test/kotlin")
}
