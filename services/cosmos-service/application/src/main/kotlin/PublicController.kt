package org.kotpot.cosmos

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kotpot.cosmos.ktor.server.plugins.KtorRouter
import org.springframework.stereotype.Controller

@Controller
class PublicRouter : KtorRouter {

    override val routes = setOf(
        ::check
    )

    context(Route)
    fun check() = get("/check") {
        call.respond("Hello")
    }
}