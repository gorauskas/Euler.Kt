import com.adarshr.gradle.testlogger.TestLoggerExtension
import com.adarshr.gradle.testlogger.theme.ThemeType
import kotlinx.kover.api.DefaultIntellijEngine
import kotlinx.kover.api.KoverMergedConfig
import kotlinx.kover.api.KoverProjectConfig
import kotlinx.kover.api.KoverTaskExtension
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm")
    id("com.adarshr.test-logger")
    id("org.jetbrains.kotlinx.kover")
}

configure<KoverProjectConfig> {
    isDisabled.set(false)
    engine.set(DefaultIntellijEngine)
}

configure<KoverMergedConfig> {
    enable() // create Kover merged report tasks from this project and subprojects with enabled Kover plugin
}

tasks.withType<Test> {
    extensions.configure(KoverTaskExtension::class) {
        isDisabled.set(false)
        includes.addAll("com.gorauskas.*")
    }
}

configure<TestLoggerExtension> {
    theme = ThemeType.MOCHA
    showExceptions = true
    showStackTraces = true
    showCauses = true
    slowThreshold = 3000
    showSummary = true
    showSimpleNames = false
    showPassed = true
    showSkipped = true
    showFailed = true
    showOnlySlow = false
    showStandardStreams = true
    showPassedStandardStreams = true
    showSkippedStandardStreams = true
    showFailedStandardStreams = true
    logLevel = LogLevel.LIFECYCLE
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = 1
    maxHeapSize = "2048m"
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("passed", "skipped", "failed", "standardOut", "standardError")
    }
}
