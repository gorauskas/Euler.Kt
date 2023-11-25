plugins {
    // id("com.adarshr.test-logger")
    // id("org.jetbrains.kotlinx.kover")
}

tasks.withType<Test>().configureEach {
    maxParallelForks = 1
    useJUnitPlatform()
    testLogging {
        setExceptionFormat("full")
        events("passed", "skipped", "failed", "standardOut", "standardError")
    }
}

//testlogger {
//    theme 'mocha' // project level
//    showExceptions true
//    showStackTraces true
//    showFullStackTraces true
//    showCauses true
//    slowThreshold 3000
//    showSummary true
//    showSimpleNames false
//    showPassed true
//    showSkipped true
//    showFailed true
//    showOnlySlow false
//    showStandardStreams true
//    showPassedStandardStreams true
//    showSkippedStandardStreams true
//    showFailedStandardStreams true
//    logLevel 'lifecycle'
//}

//kover {
//    enabled = true
//    includes.addAll(listOf("com.gorauskas.euler.*"))
//}
