import org.springframework.boot.gradle.tasks.bundling.BootJar
import java.util.*

plugins {
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.asciidoctor)
}

dependencies {
    implementation(libs.kotlin.reflect)

    implementation(libs.kotlinx.coroutines.reactor)

    implementation(libs.springboot.redis)

    implementation(libs.springboot.webflux)

    implementation(libs.reactor.kotlin.extensions)

    implementation(libs.mysql.jconnector)

    implementation(project(":module-auth"))

    val isMacOS = System.getProperty("os.name").startsWith("Mac OS")
    val architecture = System.getProperty("os.arch").lowercase(Locale.ENGLISH)
    if (isMacOS && architecture == "aarch64") {
        testImplementation("io.netty:netty-resolver-dns-native-macos:4.1.90.Final:osx-aarch_64")
    }

    developmentOnly(libs.springboot.devtools)

    testImplementation(libs.springboot.test)
    testImplementation(libs.springboot.restdocs.test)
    testImplementation(libs.reactor.test)

    implementation("org.slf4j:slf4j-api:2.0.9")
    // implementation("org.slf4j:slf4j-simple:2.0.9")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.21.0")

}

configurations {
    all {
        exclude(group = "ch.qos.logback", module = "logback-classic")
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
//        exclude(group = "org.apache.logging.log4j", module = "log4j-to-slf4j")
    }
}

val snippetsDir by extra { file("build/generated-snippets") }


springBoot {
    mainClass.value("org.kotpot.cosmos.CosmosServerApplicationKt")
}

tasks {

    withType<Test> {
        useJUnitPlatform()
    }

    withType<BootJar> {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }

    test {
        outputs.dir(snippetsDir)
    }

    asciidoctor {
        inputs.dir(snippetsDir)
        dependsOn(test)
    }
}
