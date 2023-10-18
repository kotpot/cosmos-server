
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

    developmentOnly(libs.springboot.devtools)

    testImplementation(libs.springboot.test)
    testImplementation(libs.springboot.restdocs.test)
    testImplementation(libs.reactor.test)
}


val snippetsDir by extra { file("build/generated-snippets") }

tasks {

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
