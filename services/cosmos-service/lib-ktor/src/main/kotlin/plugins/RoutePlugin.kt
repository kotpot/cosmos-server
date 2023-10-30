package org.kotpot.cosmos.ktor.server.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*
import org.springframework.stereotype.Component


interface KtorRouter {
    fun Route.register()
}

@Component
class RoutePlugin : KtorPlugin() {

    context(Application) override fun install() {

        routing {
            route(properties.path) {
                register()
            }
        }
    }

    private fun Route.register() {
        val routers = context.getBeansOfType(KtorRouter::class.java).values
        for (router in routers) {
            router.apply { register() }
        }
    }
}