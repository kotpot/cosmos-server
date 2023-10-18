import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl` apply false
}

group = "org.kotpot"
version = "0.0.1-SNAPSHOT"

val sharePlugins = libs.plugins

repositories {
    mavenCentral()
}

subprojects {

    if (name == "lib-pb") return@subprojects

    apply(plugin = sharePlugins.kotlin.jvm.get().pluginId)

    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            freeCompilerArgs += "-Xcontext-receivers"
            jvmTarget = "17"
        }
    }
}