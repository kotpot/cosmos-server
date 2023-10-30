package org.kotpot.cosmos.ktor.server.plugins

import io.ktor.server.application.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
sealed class KtorPlugin {

    @Autowired
    protected lateinit var context: ApplicationContext


    @Autowired
    protected lateinit var env: Environment

    context(Application) abstract fun install()

}