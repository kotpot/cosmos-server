import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.plugin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.asciidoctor)
}

group = "org.kotpot"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

val snippetsDir by extra { file("build/generated-snippets") }

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.jackson)

    implementation(libs.kotlinx.coroutines.reactor)

    implementation(libs.springboot.redis)
    implementation(libs.springboot.webflux)

    implementation(libs.reactor.kotlin.extensions)

    implementation(libs.mysql.jconnector)

    developmentOnly(libs.springboot.devtools)
    testImplementation(libs.springboot.test)
    testImplementation(libs.springboot.restdocs.test)
    testImplementation(libs.reactor.test)
}

tasks {

    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            freeCompilerArgs += "-Xcontext-receivers"
            jvmTarget = "17"
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }

    test {
        outputs.dir(snippetsDir)
    }

    asciidoctor {
        inputs.dir(snippetsDir)
        dependsOn(test)
    }
}
