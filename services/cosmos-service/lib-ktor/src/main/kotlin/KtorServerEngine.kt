package org.kotpot.cosmos.ktor.server

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.kotpot.cosmos.ktor.server.plugins.RoutePlugin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(KtorServerProperties::class)
class KtorServerEngine(
    private val context: ApplicationContext,
    private val properties: KtorServerProperties
) {

    @Bean
    fun engine(): ApplicationEngine {

        // configs
        val port = properties.port

        // ktor
        val plugins = context.getBeansOfType(RoutePlugin::class.java).values

        return embeddedServer(
            Netty, port = port
        ) {
            plugins.forEach{ it.install() }
        }.start(wait = true)
    }

}