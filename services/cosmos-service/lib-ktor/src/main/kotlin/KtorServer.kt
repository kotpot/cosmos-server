package org.kotpot.cosmos.ktor.server

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.kotpot.cosmos.ktor.server.plugins.RoutePlugin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class KtorServer {

    @Autowired
    private lateinit var context: ApplicationContext

    @Autowired
    private lateinit var env: Environment

    @Bean
    fun engine(): ApplicationEngine {

        // configs
        val port = env.getProperty("server.port", Int::class.java, 8080)

        val plugins = context.getBeansOfType(RoutePlugin::class.java).values

        return embeddedServer(
            Netty, port = port
        ) {
            plugins.forEach{ it.install() }
        }.start(wait = true)
    }

}