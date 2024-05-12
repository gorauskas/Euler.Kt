import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.autonomousapps.dependency-analysis")
    id("com.github.ben-manes.versions")
    id("org.owasp.dependencycheck")
}

// https://github.com/ben-manes/gradle-versions-plugin/discussions/482
// https://app.shortcut.com/figure/story/113449/identifying-outdated-dependencies-inter-repository
tasks {
    named<DependencyUpdatesTask>("dependencyUpdates").configure {
        revision = "release"
        // reject all non stable versions
        rejectVersionIf {
            isNonStable(candidate.version)
        }
        // disallow release candidates as upgradable versions from stable versions
        rejectVersionIf {
            isStable(currentVersion) && isNonStable(candidate.version)
        }
    }
}

dependencyCheck {
    failOnError = true
    analyzers.experimentalEnabled = false
    analyzers.assemblyEnabled = false
    analyzers.msbuildEnabled = false
    analyzers.nuspecEnabled = false
    analyzers.nugetconfEnabled = false
    analyzers.pyPackageEnabled = false
    analyzers.pyDistributionEnabled = false
    analyzers.rubygemsEnabled = false
}

fun isNonStable(version: String): Boolean {
    val containsStableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val simpleSemverRegex = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)".toRegex()
    val isStable = containsStableKeyword || simpleSemverRegex.matches(version)
        && !listOf("alpha", "beta", "rc").any { version.lowercase().contains(it) } && !version.contains("M")
    return isStable.not()
}

fun isStable(version: String): Boolean = !isNonStable(version)
