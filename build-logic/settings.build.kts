rootProject.name = "build-logic"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("buildLibs") {
            from(files("gradle/buildlibs.versions.toml"))
        }
    }
}

include("build-conventions")
