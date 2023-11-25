import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.spotless.LineEnding
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

plugins {
    id("io.gitlab.arturbosch.detekt")
    id("com.diffplug.spotless")
}

// DETEKT

tasks.withType<Detekt>().configureEach {
    reports {
        xml.required.set(true)
        html.required.set(true)
        txt.required.set(false)
        sarif.required.set(false)
        md.required.set(false)
    }
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "17"
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = "17"
}

detekt {
    allRules = true
    parallel = true
    buildUponDefaultConfig = true
    config.from(files("${rootDir.path}/detekt.yml"))
    source.from(files("src/main/kotlin", "src/test/kotlin"))
}

// KTLINT

configure<SpotlessExtension> {
    val disabledRules = mapOf(
        "ktlint_standard_filename" to "disabled",
        "ktlint_standard_annotation" to "disabled",
        "ktlint_standard_discouraged-comment-location" to "disabled"
    )

    lineEndings = LineEnding.PLATFORM_NATIVE

    kotlin {
        // ignore anything that is generated since those can't be fixed, e.g. protobuf files
        targetExclude("**/generated/**")

        // configure ktlint
        ktlint().editorConfigOverride(disabledRules)
    }

    kotlinGradle {
        // configure ktlint
        ktlint().editorConfigOverride(disabledRules)
    }
}

// Registers "lint" task runs "spotlessCheck"
tasks.register("lint") {
    group = "verification"
    description = "Lint all code using configured linters. Runs 'spotlessCheck' "
    dependsOn(
        tasks.named("spotlessCheck"),
    )
}

// Registers "ktlint" task runs "spotlessKotlinCheck" and "spotlessKotlinGradleCheck"
tasks.register("ktlint") {
    group = "verification"
    description = "Lint Kotlin code. Runs 'spotlessKotlinCheck' and 'spotlessKotlinGradleCheck'"
    dependsOn(
        tasks.named("spotlessKotlinCheck"),
        tasks.named("spotlessKotlinGradleCheck"),
    )
}

// Registers "fmt" task runs "spotlessApply"
tasks.register("fmt") {
    group = "verification"
    description = "Format all code using configured formatters. Runs 'spotlessApply' "
    dependsOn(
        tasks.named("spotlessApply"),
    )
}

// Registers "ktlintFormat" task runs "spotlessKotlinApply" and "spotlessKotlinGradleApply"
tasks.register("ktlintFormat") {
    group = "verification"
    description = "Format Kotlin code. Runs 'spotlessKotlinApply' and 'spotlessKotlinGradleApply'"
    dependsOn(
        tasks.named("spotlessKotlinApply"),
        tasks.named("spotlessKotlinGradleApply"),
    )
}

// ---------- Check Configurations ---------- //

tasks.check {
    dependsOn(tasks.named("detekt"))
}
