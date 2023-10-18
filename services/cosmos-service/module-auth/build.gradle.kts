plugins {
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {

    implementation(libs.springboot.redis)
    implementation(libs.springboot.webflux)

    implementation(libs.reactor.kotlin.extensions)

    implementation(project(":lib-pb"))
}

tasks.test {
    useJUnitPlatform()
}