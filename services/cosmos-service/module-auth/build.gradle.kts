plugins {
    alias(libs.plugins.kotlin.plugin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

dependencies {

    implementation(libs.springboot.redis)
    implementation(libs.springboot.webflux)

    implementation(libs.reactor.kotlin.extensions)
}

tasks.test {
    useJUnitPlatform()
}