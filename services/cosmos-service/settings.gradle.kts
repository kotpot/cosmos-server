dependencyResolutionManagement {
    versionCatalogs {
        create("wireLibs") {
            from(files("krpc-wire-plugin/gradle/libs.versions.toml"))
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "cosmos-service"

// gradle feature
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include("lib-ktor")
include("application")
include("module-auth")
include("lib-pb")


includeBuild("krpc-wire-plugin") {
    dependencySubstitution {
        substitute(module("org.szkug.krpc:wire-schema")).using(project(":wire-schema"))
    }
}