plugins {
    alias(libs.plugins.kotlin.serialization)
}

dependencies {

    implementation(libs.kotlin.reflect)
    implementation(libs.springboot.redis)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client.jackson)
    implementation(libs.ktor.client.cio)

}

springBoot {
    mainClass.value("org.kotpot.cosmos.CosmosServerApplicationKt")
}

tasks.test {
    useJUnitPlatform()
}