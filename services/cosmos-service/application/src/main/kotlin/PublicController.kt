package org.kotpot.cosmos

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kotpot.cosmos.ktor.server.plugins.KtorRouter
import org.springframework.stereotype.Controller

@Controller
class PublicRouter : KtorRouter {

    context(Route) override fun register() {
        hello()
    }

    context(Route)
    fun hello() = get("/hello") {
        call.respond("Hello Cosmos!")
    }
}