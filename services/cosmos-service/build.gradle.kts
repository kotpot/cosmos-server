import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.dsl.SpringBootExtension

plugins {
    `kotlin-dsl` apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency.management) apply false
    alias(wireLibs.plugins.wire) apply false
}

group = "org.kotpot"
version = "0.0.1-SNAPSHOT"

val sharePlugins: LibrariesForLibs.PluginAccessors = libs.plugins
repositories {
    mavenCentral()
}

val springSubModels = with(projects) {
    listOf(libPb, libKtor, moduleAuth)
}.map { it.name }

subprojects {

    apply(plugin = sharePlugins.kotlin.jvm.get().pluginId)

    if (name in springSubModels) {

        apply(plugin = sharePlugins.kotlin.spring.get().pluginId)
        apply(plugin = sharePlugins.spring.boot.get().pluginId)
        apply(plugin = sharePlugins.spring.dependency.management.get().pluginId)

        val springBootExt = extensions.getByType<SpringBootExtension>()
        springBootExt.apply {
            mainClass.value("org.kotpot.cosmos.CosmosServerApplicationKt")
        }
    }

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