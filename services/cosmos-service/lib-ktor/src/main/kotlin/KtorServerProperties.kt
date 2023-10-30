package org.kotpot.cosmos.ktor.server

import org.springframework.boot.context.properties.ConfigurationProperties
@ConfigurationProperties(prefix = "ktor.server", ignoreUnknownFields = true)
class KtorServerProperties {

    var port: Int = 8080

    var path: String = ""
}