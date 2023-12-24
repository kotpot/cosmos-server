plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "cosmos-service"

include("lib-ktor")
include("application")
include("module-auth")
include("lib-pb")
