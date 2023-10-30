plugins {
}

group = "org.kotpot.cosmos"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.springboot)
    api(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
}